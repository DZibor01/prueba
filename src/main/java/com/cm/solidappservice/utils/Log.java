package com.cm.solidappservice.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.nio.file.DirectoryNotEmptyException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoField;

public class Log {
    
    private String Path = "";

    public Log (String path){
        super();
        this.Path = path;
    }

    public void add(String sLog) throws Exception{        
        try{
            createDirectory();

            LocalDateTime now = LocalDateTime.now();
            int year = now.getYear();
            String month = now.getMonthValue() < 10 ? "0"+now.getMonthValue() : now.getMonthValue()+"";
            String day = now.getDayOfMonth() < 10 ? "0"+now.getDayOfMonth() : now.getDayOfMonth()+"";
            String hour = now.getHour() < 10 ? "0"+now.getHour() : now.getHour()+"";
            String minute = now.getMinute() < 10 ? "0"+now.getMinute() : now.getMinute()+"";
            String second = now.getSecond() < 10 ? "0"+now.getSecond() : now.getSecond()+"";
            String millis = now.get(ChronoField.MILLI_OF_SECOND)< 10 ? "0"+now.get(ChronoField.MILLI_OF_SECOND) : now.get(ChronoField.MILLI_OF_SECOND)+"";
            String nombreFile = getNameFIle();
            String cadena = "";
            cadena += year+"/"+month+"/"+day+" "+hour+":"+minute+":"+second+":"+millis+" - "+ sLog + "\n";

            String pathFinal = Path + "/" + nombreFile+".txt";
            BufferedWriter sw = new BufferedWriter(new FileWriter(pathFinal,true));
            sw.write(cadena);
            // sw.newLine();
            sw.close();
        }catch(Exception ex){
            throw new Exception(ex.getMessage());
        }
    }

    private String getNameFIle(){
        String nombre;
        LocalDateTime now = LocalDateTime.now();
        int year = now.getYear();
        String month = now.getMonthValue() < 10 ? "0"+now.getMonthValue() : now.getMonthValue()+"";
        String day = now.getDayOfMonth() < 10 ? "0"+now.getDayOfMonth() : now.getDayOfMonth()+"";
        nombre = "Log_"+year+"_"+month+"_"+day;
        return nombre;
    }

    private void createDirectory() throws DirectoryNotEmptyException{
        File directory = new File(Path);
        if(!directory.exists()){
            directory.mkdirs();
        }
    }



}
