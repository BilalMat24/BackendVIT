package com.example.engine.ControlloImmagini;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class WebcamInfo {

    private final Long id;
    private int anno;
    private int mese;
    private int giorno;
    private int index;
    private final String path;
    private String lastImmagineElaborata;

    public WebcamInfo(Long id, int anno, int mese, int giorno,int ora,int minuto,int secondo, String lastImmagineElaborata) {
        this.id = id;
        this.anno = anno;
        this.mese = mese;
        this.giorno = giorno;
        this.path = "/nuovaImmagini";
        this.index = getStartingIndex(secondo,minuto,ora);
        this.lastImmagineElaborata = lastImmagineElaborata;

    }

    public Long getId() {
        return this.id;
    }

    public int getIndex(){
        return this.index;
    }

    //getter for day month year
    public int getYear() {
        return this.anno;
    }

    public int getMonth() {
        return this.mese;
    }

    public int getDay() {
        return this.giorno;
    }

    public void setIndex(int index){
        this.index = index;
    }

    public File getCurrentCartella(){
        return new File(path+"/"+anno+"/"+(mese < 10 ? ("0" + mese) : mese)+"/"+ (giorno < 10 ? ("0" + giorno) : giorno)+"/cam"+id);
    }

    public String getLastImmagineElaborata(){
        return this.lastImmagineElaborata;
    }

    public void setLastImmagineElaborata(String lastImmagineElaborata){
        this.lastImmagineElaborata = lastImmagineElaborata;
    }

    public File nextCartella(){
        if(mese == 2 && giorno == 28 && (anno%4!=0)){
            mese = 3;
            giorno = 1;
            this.index = 0;
            return getCurrentCartella();
        }

        if(mese == 2 && giorno == 29){
            mese = 3;
            giorno = 1;
            this.index = 0;
            return getCurrentCartella();
        }

        if((mese == 11 || mese == 4 || mese == 9 || mese == 6) && giorno == 30){
            mese++;
            giorno = 1;
            this.index = 0;
            return getCurrentCartella();
        }

        if(mese == 12 && giorno == 31){
            anno++;
            mese = 1;
            giorno = 1;
            this.index = 0;
            return getCurrentCartella();
        }

        if(giorno == 31){
            giorno = 1;
            mese++;
            this.index = 0;
            return getCurrentCartella();
        }

        else{
            giorno++;
            this.index = 0;
            return getCurrentCartella();
        }
    }

    public boolean checkFolders(){
        int giorno = this.giorno;
        int mese = this.mese;
        int anno = this.anno;
        int index = this.index;
        File nextCartella = nextCartella();

        if(!(nextCartella.exists()) || nextCartella.listFiles().length == 0){
            this.giorno = giorno;
            this.mese = mese;
            this.anno = anno;
            this.index = index;
            return false;
        }
        return true;

    }

    private int getStartingIndex(int secondo,int minuto,int ora){
        try{
            File[] files = getCurrentCartella().listFiles();
            if(files != null){
                for(int i = 0; i < files.length; i++){
                    LocalDateTime data = getLocalDateTimeFromString(getDateTime(files[i]),"yyyyMMddHHmmss");
                    System.out.println("confronto la data "+data+"con l'ultima del db");
                    if(giorno == data.getDayOfMonth() && mese == data.getMonthValue() && anno == data.getYear() && secondo == data.getSecond() && minuto == data.getMinute() && ora == data.getHour()){
                        System.out.println("nuovo index");
                        System.out.println(i);
                        return i;
                    }
                }
                System.out.println("index 0");
                return 0;
            } else{
                System.out.println("files null");
                return -1;
            }

        }catch(Exception e){
            e.printStackTrace();
            return -1;
        }

    }

    private java.time.LocalDateTime getLocalDateTimeFromString(String date, String format){
        return java.time.LocalDateTime.parse(date, DateTimeFormatter.ofPattern(format));
    }

    private String getDateTime(File file){
        return file.getName().split("_")[1];
    }
}
