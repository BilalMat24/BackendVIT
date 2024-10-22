package com.example.engine.ControlloImmagini;

import java.io.File;
import java.time.Duration;
import java.time.format.DateTimeFormatter;
import com.example.engine.Immagine.Immagine;
import org.springframework.stereotype.Service;
import com.example.engine.Immagine.ImmagineRepository;
import org.springframework.web.reactive.function.client.WebClient;
import java.util.ArrayList;

@Service
/**
 * classe che serve per controllare le immagini in modo che se ne arriva una nuova allora viene
 * aggiunta alla coda
 */
public class ControlloreImmagini extends Thread{

    private String immaginiPath = "/immagini";
    private final String oldFormat = "yyyyMMddHHmmss";
    private final String url = "http://Pythonapi:8000/";
    WebClient.Builder builder = WebClient.builder(); //per le richieste http a python
    private final ImmagineRepository immagineRepository;
    private ArrayList<String> list = new ArrayList<>();
    public ControlloreImmagini(ImmagineRepository immagineRepository){
        this.immagineRepository = immagineRepository;
    }

    @Override
    public void run() {
        while(true){
            File folder = new File(immaginiPath);
            File[] listOfFolders = folder.listFiles();
            for (File webcam : listOfFolders) {
                Long webcamId = getCamId(webcam);
                for(File immagine : webcam.listFiles()){
                    if(needsToBeProcessed(immagine,list,webcam.getName()+"/"+immagine.getName())){
                        list.add(webcam.getName()+"/"+immagine.getName());
                        //mando a python l'immagine da processare e quando torna lo tolgo dalla lista
                        builder.build().get().uri(url+("?path="+immagine.getName())).retrieve().bodyToMono(RispostaElaborazione.class).timeout(Duration.ofMinutes(3L)).subscribe((response)->{
                            immagineRepository.save(new Immagine(response.getAuto(),response.getCamion(),response.getMoto(),getLocalDateTimeFromString(getDateTime(immagine),oldFormat),immagineRepository.getWebcamFromId(webcamId).get()));
                            list.remove(webcam.getName()+"/"+immagine.getName());
                        });
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

}
