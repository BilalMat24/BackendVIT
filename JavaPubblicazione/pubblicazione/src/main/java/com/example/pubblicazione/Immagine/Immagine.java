package com.example.pubblicazione.Immagine;

import java.time.LocalDateTime;

import com.example.pubblicazione.Webcam.Webcam;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table
public class Immagine {
    @Id
    @SequenceGenerator(
            name = "traffico_sequence",
            sequenceName = "traffico_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "traffico_sequence"
    )
    @JsonIgnore
    private Long id;
    @Transient
    private Integer veicoli;
    private Integer macchine;
    private Integer camion;
    private Integer moto;
    private LocalDateTime data;
    @ManyToOne
    @JoinColumn(name = "webcam_id")
    @JsonIgnore
    private Webcam webcam;


    public Immagine() {

    }

    public Immagine(Long id, Integer macchine, Integer camion, Integer moto, LocalDateTime data) {
        this.id = id;
        this.macchine = macchine;
        this.camion = camion;
        this.moto = moto;
        this.data = data;
    }

    public Immagine(Integer macchine, Integer camion, Integer moto, LocalDateTime data) {
        this.macchine = macchine;
        this.camion = camion;
        this.moto = moto;
        this.data = data;
    }

    public Immagine(Integer macchine, Integer camion, Integer moto, LocalDateTime data, Webcam fotocamera) {
        this.macchine = macchine;
        this.camion = camion;
        this.moto = moto;
        this.data = data;
        this.webcam = fotocamera;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getMacchine() {
        return macchine;
    }

    public void setMacchine(Integer macchine) {
        this.macchine = macchine;
    }

    public Integer getCamion() {
        return camion;
    }

    public void setCamion(Integer camion) {
        this.camion = camion;
    }

    public Integer getMoto() {
        return moto;
    }

    public void setMoto(Integer moto) {
        this.moto = moto;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public Webcam getWebcam() {
        return webcam;
    }

    public void setWebcam(Webcam fotocamera) {
        this.webcam = fotocamera;
    }

    public Integer getVeicoli() {
        return this.camion + this.macchine + this.moto;
    }

    public void setVeicoli(Integer veicoli){
        this.veicoli = veicoli;
    }

    @Override
    public String toString() {
        return "Traffico{" +
                "id=" + id +
                ", macchine=" + macchine +
                ", camion=" + camion +
                ", moto=" + moto +
                ", data=" + data +
                '}';
    }

}
