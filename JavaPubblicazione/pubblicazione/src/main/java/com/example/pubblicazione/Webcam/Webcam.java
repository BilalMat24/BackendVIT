package com.example.pubblicazione.Webcam;

import java.util.List;
import java.util.ArrayList;
import org.springframework.data.annotation.Transient;
import com.example.pubblicazione.Immagine.Immagine;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table
public class Webcam {
    @Id
    private Long id;
    private String posizione;
    private Double latitudine;
    private Double longitudine;
    @Transient
    private Float mediaMacchine;
    @Transient
    private Float mediaCamion;
    @Transient
    private Float mediaMoto;
    @Transient
    private Float mediaVeicoli;
    @OneToMany
    @JoinColumn(name = "webcam_id")
    private List<Immagine> immagini;
    public Webcam() {

    }

    public Webcam(Long id, String posizione, Double latitudine, Double longitudine) {
        this.id = id;
        this.posizione = posizione;
        this.latitudine = latitudine;
        this.longitudine = longitudine;
    }

    public Webcam(Long id, String posizione, List<Immagine> immagini){
        this.id = id;
        this.posizione = posizione;
        this.immagini = immagini;
    }

    public Webcam(Long id, String posizione, Immagine immagine){
        this.id = id;
        this.posizione = posizione;
        this.immagini = new ArrayList<Immagine>();
        this.immagini.add(immagine);
    }

    public Webcam(Long id, String posizione, Float mediaMacchine, Float mediaCamion, Float mediaMoto){
        this.id = id;
        this.posizione = posizione;
        this.mediaMacchine = mediaMacchine;
        this.mediaCamion = mediaCamion;
        this.mediaMoto = mediaMoto;
    }

    //setter and getters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPosizione() {
        return posizione;
    }

    public void setPosizione(String posizione) {
        this.posizione = posizione;
    }

    public Double getLatitudine() {
        return latitudine;
    }

    public void setLatitudine(Double latitudine) {
        this.latitudine = latitudine;
    }

    public Double getLongitudine() {
        return longitudine;
    }

    public void setLongitudine(Double longitudine) {
        this.longitudine = longitudine;
    }

    //getter for list

    @Override
    public String toString() {
        return "Webcam{" +
                "id=" + id +
                '}';
    }

    public List<Immagine> getImmagini() {
        return immagini;
    }

    public void setImmagini(List<Immagine> immagini) {
        this.immagini = immagini;
    }

    public Float getMediaMacchine(){
        Float mediaMacchine = 0f;
        for(Immagine immagine :immagini){
            mediaMacchine += immagine.getMacchine();
        }
        return mediaMacchine/this.immagini.size();
    }

    public void setMediaMacchine(Float mediaMacchine){
        this.mediaMacchine = mediaMacchine;
    }

    public Float getMediaCamion(){
        Float mediaCamion = 0f;
        for(Immagine immagine :immagini){
            mediaCamion += immagine.getCamion();
        }
        return mediaCamion/this.immagini.size();
    }

    public void setMediaCamion(Float mediaCamion){
        this.mediaCamion = mediaCamion;
    }

    public Float getMediaMoto(){
        Float mediaMoto = 0f;
        for(Immagine immagine :immagini){
            mediaMoto += immagine.getMoto();
        }
        return mediaMoto/this.immagini.size();
    }

    public void setMediaMoto(Float mediaMoto){
        this.mediaMoto = mediaMoto;
    }

    public Float getMediaVeicoli(){
        Float mediaVeicoli = 0f;
        for(Immagine immagine :immagini){
            mediaVeicoli += immagine.getMoto();
            mediaVeicoli += immagine.getMacchine();
            mediaVeicoli += immagine.getCamion();
        }
        return mediaVeicoli/this.immagini.size();
    }

    public void setMediaVeicoli(Float mediaVeicoli){
        this.mediaVeicoli = mediaVeicoli;
    }

    interface WebcamSenzaMedie{
        Long getId();
        String getPosizione();
        List<Immagine> getImmagini();
        Double getLatitudine();
        Double getLongitudine();
        void setId(Long id);
        void setPosizione(String posizione);
        void setImmagini(List<Immagine> immagini);
        void setLatitudine(Double latitudine);
        void setLongitudine(Double longitudine);
    }

    interface WebcamConIdEPosizione{
        Long getId();
        String getPosizione();
        Double getLatitudine();
        Double getLongitudine();
        void setId(Long id);
        void setPosizione(String posizione);
        void setLatitudine(Double latitudine);
        void setLongitudine(Double longitudine);
    }
}