package com.example.pubblicazione.Webcam;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.pubblicazione.Immagine.Immagine;
import com.example.pubblicazione.Webcam.Webcam.WebcamSenzaMedie;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping(path = "/webcam")
public class WebcamController {

    private final WebcamService fotocameraService;

    public WebcamController(WebcamService fotocameraService) {
        this.fotocameraService = fotocameraService;
    }

    @GetMapping(path = "/all")
    public List<Webcam.WebcamConIdEPosizione> getAll(){
        return fotocameraService.findAllWebcam();
    }

    @GetMapping(path = "/today")
    public List<Webcam.WebcamSenzaMedie> getWebcamToday() {
        List<Webcam.WebcamSenzaMedie> fotocamere = fotocameraService.getWebcamToday();
        for(WebcamSenzaMedie f : fotocamere){
            List<Immagine> tmp = new ArrayList<Immagine>();
            for(Immagine I: f.getImmagini()){
                if(isDateToday(I.getData())){
                    tmp.add(I);
                }
            }
            f.setImmagini(tmp);
        }

        return fotocamere;
    }

    @GetMapping(path = "/medie")
    public List<Webcam> getWebcamTodayMedie(){
        List<Webcam> fotocamere = fotocameraService.getWebcamTodayMedie();
        for(Webcam f : fotocamere){
            List<Immagine> tmp = new ArrayList<Immagine>();
            for(Immagine I: f.getImmagini()){
                if(isDateToday(I.getData())){
                    tmp.add(I);
                }
            }
            f.setImmagini(tmp);
        }
        fotocamere.sort((w1, w2) -> {
            return w2.getMediaVeicoli().compareTo(w1.getMediaVeicoli());
        });
        return fotocamere;
    }

    @GetMapping(path = "/medie/{numeroWebcam}")
    public List<Webcam> getMostBusy(@PathVariable("numeroWebcam") int numeroWebcam){
        List<Webcam> webcam = getWebcamTodayMedie();
        List<Webcam> tmp = new ArrayList<>(numeroWebcam);
        for (int i = 0; i < numeroWebcam && i < webcam.size(); i++) {
            tmp.add(webcam.get(i));
        }
        return tmp;
    }

    @PostMapping(path = "/filtrato")
    public List<Webcam> getWebcamFiltrate(@RequestBody List<PostBody> body){
        List<Webcam> fotocamere = fotocameraService.getWebcamFiltrate(body);
        for(Webcam f : fotocamere){
            List<Immagine> tmp = new ArrayList<Immagine>();
            for(Immagine I: f.getImmagini()){
                if(isDateToday(I.getData())){
                    tmp.add(I);
                }
            }
            f.setImmagini(tmp);
        }

        return fotocamere;
    }

    @GetMapping(path = "/filtrato/{id}")
    public Webcam getWebcamFiltrata(@PathVariable("id") Long id){
        try {
            Webcam webcam = this.fotocameraService.getWebcamById(id).get();
            List<Immagine> tmp = new ArrayList<Immagine>();
            for (Immagine I : webcam.getImmagini()) {
                if (isDateToday(I.getData())) {
                    tmp.add(I);
                }
            }
            webcam.setImmagini(tmp);
            return webcam;
        } catch (Exception e) {
            return null;
        }
    }

    @GetMapping(path = "/day/{day}")
    public List<Webcam> getWebcamPassate(@PathVariable("day") LocalDate day){
        List<Webcam> fotocamere = this.fotocameraService.getWebcamPassate(day);
        for(Webcam f : fotocamere){
            List<Immagine> tmp = new ArrayList<Immagine>();
            for(Immagine I: f.getImmagini()){
                if(areDatesEqual(day,I.getData())){
                    tmp.add(I);
                }
            }
            f.setImmagini(tmp);
        }

        return fotocamere;
    }

    @GetMapping(path = "/day/{day}/{webcam}")
    public Webcam getWebcamPassata(@PathVariable("day") LocalDate day,@PathVariable("webcam") Long cam){
        try{
            Webcam webcam = this.fotocameraService.getWebcamPassata(day,cam).get();

            List<Immagine> tmp = new ArrayList<Immagine>();
            for (Immagine I : webcam.getImmagini()) {
                if (areDatesEqual(day,I.getData())) {
                    tmp.add(I);
                }
            }
            webcam.setImmagini(tmp);
            return webcam;
        }catch (Exception e){
            return null;
        }

    }

    @GetMapping(path = "medieGenerali")
    public Optional<WebcamMedie> getMedieGenerali(){
        return fotocameraService.getMedieGenerali();
    }

    @GetMapping(path="immagine/{id}")
    public ResponseEntity<?> getImmagine(@PathVariable Long id){
        return this.fotocameraService.getImmagine(id);
    }

    private boolean isDateToday(LocalDateTime time){
        return time.getDayOfMonth() == MonthDay.now().getDayOfMonth() && time.getMonth() == YearMonth.now().getMonth() && time.getYear() == Year.now().getValue();
    }

    private boolean areDatesEqual(LocalDate time1, LocalDateTime time2){
        if(time1.getDayOfMonth() != time2.getDayOfMonth()){
            return false;
        }
        if(!(time1.getMonth().equals(time2.getMonth()))){
            return false;
        }
        return time1.getYear() == time2.getYear();
    }

}
