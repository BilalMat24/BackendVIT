package com.example.engine.ControlloImmagini;

import java.io.File;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import com.example.engine.Immagine.Immagine;
import com.example.engine.Webcam.Webcam;
import org.springframework.stereotype.Service;
import com.example.engine.Immagine.ImmagineRepository;
import org.springframework.web.reactive.function.client.WebClient;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@Service   
/**
 * classe che serve per controllare le immagini in modo che se ne arriva una nuova allora viene
 * aggiunta alla coda
 */
public class ControlloreImmagini extends Thread{

    private final String oldFormat = "yyyyMMddHHmmss"; //per parsing delle immagini
    private final String url = "http://Pythonapi:8000/"; //indirizzo del container di python, che viene risolto dal dns di docker
    WebClient.Builder builder = WebClient.builder(); //per le richieste http a python
    private final ImmagineRepository immagineRepository;
    public ControlloreImmagini(ImmagineRepository immagineRepository){
        this.immagineRepository = immagineRepository;
    }
    private List<WebcamInfo> webcams;

    @Override
    public void run() {

        /////////////
        // startup //
        /////////////

        //trovo tutte le webcam salvate nel db (recupera tutte le webcam e ne crea una lista di oggetti WebcamInfo)
        List<Webcam> tmp = this.immagineRepository.findAllWebcam();
        webcams = new ArrayList<>(tmp.size());
        for(Webcam webcam : tmp){
            LocalDateTime data;
            boolean oggi = false;
            try{
                data = this.immagineRepository.findLastTimestamp(webcam.getId()).get();
                System.out.println("Last timestamp cam "+webcam.getId()+ " " + data.toString());
                //controllo se la data ha una cartella di riferimento che esiste, se non la ha allora la data diventa quella di oggi
                if(!(new File("/nuovaImmagini/"+data.getYear()+"/"+(data.getMonthValue() < 10 ? "0"+data.getMonthValue(): data.getMonthValue())+"/"+(data.getDayOfMonth()<10 ? "0"+data.getDayOfMonth() : data.getDayOfMonth())).exists())){
                    System.out.println("non esiste la cartella");
                    data = LocalDateTime.now();
                    webcams.add(new WebcamInfo(webcam.getId(),data.getYear(),data.getMonthValue(),data.getDayOfMonth(),0,0,0,getLastImmagineElaborata(webcam.getId())));
                }else{
                    //aggiungo le info della fotocamera alla lista
                    webcams.add(new WebcamInfo(webcam.getId(),data.getYear(),data.getMonthValue(),data.getDayOfMonth(),data.getHour(),data.getMinute(),data.getSecond(),getLastImmagineElaborata(webcam.getId())));
                }
            }catch(Exception e){
                //se la data non esiste nel db allora viene istanziata a oggi
                data = LocalDateTime.now();
                webcams.add(new WebcamInfo(webcam.getId(),data.getYear(),data.getMonthValue(),data.getDayOfMonth(),0,0,0,getLastImmagineElaborata(webcam.getId())));
            }

        }

        //controllo se esiste la directory per i predict, altrimenti la creo
        File predict = new File("/output/predict");
        if(!predict.exists()){
            predict.mkdir();
        }

        //controllo se le webcam hanno una directory per le pridiction delle immagini, altrimenti le creo
        //for(WebcamInfo webcaminfo : webcams){
        //    File camPredict = new File(predict,webcaminfo.getId().toString());
        //    if(!camPredict.exists()){
        //        camPredict.mkdir();
        //    }
        //}

        ////////////////////
        // infinite cycle //
        ////////////////////

        while(true){
            for(WebcamInfo webcamInfo : webcams){
                //se l'index è -1 vuol dire che hanno un formato errato
               if(webcamInfo.getIndex()!=-1){
                   //prendo il folder del giorno della fotocamera sulla quale sto lavorando
                   File folder = webcamInfo.getCurrentCartella();
                   //se l'ultimo index è diverso dalla lunghezza dell array allora è arrivata un altra immagine
                   if(webcamInfo.getIndex() != folder.listFiles().length-1){
                       //per ogni immagine nuova che è arrivata, chiamo l'api di python che la elabora
                       for (int i = webcamInfo.getIndex(); i < folder.listFiles().length; i++) {
                           File immagine = folder.listFiles()[i];
                           System.out.println("immagine da processare: "+immagine.getName());
                           builder.build().get().uri(url + ("?path=" + webcamInfo.getCurrentCartella() + "/" + immagine.getName())).retrieve().bodyToMono(RispostaElaborazione.class).timeout(Duration.ofMinutes(3L)).subscribe((response) -> {
                               immagineRepository.save(new Immagine(response.getAuto(), response.getCamion(), response.getMoto(), getLocalDateTimeFromString(getDateTime(immagine), oldFormat), immagineRepository.getWebcamFromId(webcamInfo.getId()).get()));
                               //prendo l'ultima immagine elaborata della webcaminfo e la elimino e setto la variabile alla nuova immagine elaborata(uso immagine.getName())
                               deleteOldImmagineElaborata(webcamInfo); //se è null non elimina niente
                               webcamInfo.setLastImmagineElaborata(immagine.getName());
                           });
                           //aggiorno l'index dell ultima foto procesata
                           webcamInfo.setIndex(webcamInfo.getIndex()+1);
                       }
                   } else {
                       if(webcamInfo.checkFolders()){
                           //se non ce nessuna immagine nuova controllo se è cambiato giorno
                           System.out.println("cambio folder");
                           webcamInfo.setIndex(0);
                       }
                   }
               }
            }
        }
    }

    /**
     * ritorna la data e l'ora dell'immagine
     * @param file l'immagine di cui si vuole la data e l'ora
     * @return la data e l'ora dell'immagine
     */
    private String getDateTime(File file){
        String data = file.getName().split("_")[1];
        return data;
    }

    /**
     * ritorna l'id della fotocamera a partire dalla cartella
     * @param folder la cartella da cui prendere l'id
     * @return l'id della fotocamera a partire dalla cartella
     */
    private Long getCamId(File folder){
        String tmp = folder.getName().split("cam")[1];
        return Long.parseLong(tmp.split(".jpg")[0]);
    }

    /**
     * ritorna un oggetto LocalDateTime a partire da una stringa
     * @param date la stringa da convertire
     * @return un oggetto LocalDateTime a partire da una stringa
     */
    private java.time.LocalDateTime getLocalDateTimeFromString(String date, String format){
        return java.time.LocalDateTime.parse(date, DateTimeFormatter.ofPattern(format));
    }

    public boolean needsToBeProcessed(File file,ArrayList<String> codaImmagini, String path){

        if(codaImmagini.contains(path)){
            return false;
        }

        try {
            if (!(this.immagineRepository.hasSaved(getLocalDateTimeFromString(getDateTime(file), oldFormat), getCamId(file)).isEmpty())) {
                return false;
            }
        } catch(Exception e){
            return false; //se l'immagine ha il formato sbagliato
        }

        return true;
    }

    private String getLastImmagineElaborata(Long id){
        File outputFolder = new File("/output/predict");
        for(File immagine : outputFolder.listFiles()){
            if(getCamId(immagine).equals(id)){
                return immagine.getName();
            }
        }
        return null;
    }

    private void deleteOldImmagineElaborata(WebcamInfo webcaminfo){
        File oldImmagine = new File("/output/predict/"+webcaminfo.getLastImmagineElaborata());
        if(oldImmagine.exists()){
            oldImmagine.delete();
        }
    }

}
