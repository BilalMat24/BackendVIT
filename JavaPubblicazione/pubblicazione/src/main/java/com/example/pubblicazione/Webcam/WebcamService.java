package com.example.pubblicazione.Webcam;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;

@Service
public class WebcamService {

    private final WebcamRepository fotocameraRepository;

    public WebcamService(WebcamRepository fotocameraRepository) {
        this.fotocameraRepository = fotocameraRepository;
    }

    public List<Webcam.WebcamConIdEPosizione> findAllWebcam() {
        return fotocameraRepository.findAllWebcam();
    }

    public Optional<Webcam> getWebcamById(Long id) {
        return fotocameraRepository.findById(id);
    }

    public List<Webcam.WebcamSenzaMedie> getWebcamToday(){
        return fotocameraRepository.findWebcamToday();
    }

    public List<Webcam> getWebcamTodayMedie(){
        return fotocameraRepository.findWebcamTodayMedie();
    }

    public List<Webcam> getWebcamFiltrate(List<PostBody> body){
        List<Long> ids = new ArrayList<Long>();
        for(PostBody id : body)
            ids.add(id.id);
        return fotocameraRepository.findWebcamFiltrate(ids);
    }

    public Optional<WebcamMedie> getMedieGenerali(){
        return fotocameraRepository.findMedieGenerali();
    }

    public Optional<Webcam> getWebcamFiltrata(Long id){
        return this.fotocameraRepository.findById(id);
    }

    public List<Webcam> getWebcamPassate(LocalDate day){
        return this.fotocameraRepository.findWebcamPassate(day.getDayOfMonth(),day.getMonthValue(),day.getYear());
    }

    public Optional<Webcam> getWebcamPassata(LocalDate day, Long webcam){
        return this.fotocameraRepository.findWebcamPassata(day.getDayOfMonth(),day.getMonthValue(),day.getYear(), webcam);
    }

    public ResponseEntity<?> getImmagine(Long id){
        try{
            File[] immagini = new File("/output/predict").listFiles();
            for(File immagine : immagini){
                if(getCamId(immagine).equals(id)){
                    return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf("image/jpg")).body(Files.readAllBytes(immagine.toPath()));
                }
            }
            return null;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    private Long getCamId(File folder){
        String tmp = folder.getName().split("cam")[1];
        return Long.parseLong(tmp.split(".jpg")[0]);
    }

    

}
