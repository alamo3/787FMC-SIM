package logic;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author newlife network
 */
import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import java.io.*;
public class WeatherInformation {
    public static void main(String[]args){
        WeatherInformation obj1=new WeatherInformation();
        obj1.getMetar("OMDB");
    }
    
    
    
    public String[] getMetar(String x){
        String Metar="";
    String icao=x;
      
    String html = "https://www.aviationweather.gov/adds/metars/?station_ids="+icao+"&std_trans=standard&chk_metars=on&hoursStr=most+recent+only&chk_tafs=on";
    try{
    Document doc = Jsoup.connect(html).get(); 
Metar = doc.body().text(); 


    }catch(IOException e){
      
    }
  // System.out.println(Metar);
     String[]Metar2=new String[4];
     int indexC=0;
     boolean takeEntry=false;
     boolean takeEntry2=false;
     Metar2[0]=icao;
     Metar2[1]="";
      Metar2[2]="";
     for(int i=0; i<Metar.length();i++){
       if(indexC==0){
         char current=Metar.charAt(i);
         if(i!=0){
         if(Metar.charAt(i-1)=='('&&Character.isDigit(Metar.charAt(i))==true){
          takeEntry=true;
         }
         if(takeEntry==true){
          Metar2[indexC+1]=Metar2[indexC+1]+Metar.charAt(i); 
         }
         if(Character.isDigit(Metar.charAt(i))==true&&Metar.charAt(i+1)==')'){
          takeEntry=false; 
          indexC++;
         }
         }
       }
     }
        for(int i=0;i<Metar.length();i++) {
         //  if(Character.isLetter(Metar.charAt(i))==true&&Metar.charAt(i-1)==' '&& Metar.charAt(i-2)==' '&& Metar.charAt(i-3)==' '){
           // takeEntry=true;
           //}
          if(i>10){
           //if(Metar.charAt(i-3)=='/'){
            //takeEntry2=true; 
          // }
            if(i==150){
           takeEntry2=true;
           }
           if(takeEntry2==true){
              Metar2[2]=Metar2[2]+Metar.charAt(i); 
           }
           if(Metar.charAt(i)==' '&&Metar.charAt(i+1)=='T'&&Metar.charAt(i+2)=='A'&&Metar.charAt(i+3)=='F'){
            takeEntry2=false;
            indexC++;
           }
           }
        }
        boolean takeEntry3=false;
        Metar2[3]="";
        
       
        
         for(int i=0;i<Metar.length();i++) {
         //  if(Character.isLetter(Metar.charAt(i))==true&&Metar.charAt(i-1)==' '&& Metar.charAt(i-2)==' '&& Metar.charAt(i-3)==' '){
           // takeEntry=true;
           //}
           if(Metar.contains("TAF")){
          if(i>10){
           //if(Metar.charAt(i-3)=='/'){
            //takeEntry2=true; 
          // }
            try{
            if(Metar.charAt(i)=='T'&&Metar.charAt(i+1)=='A'&&Metar.charAt(i+2)=='F'){
           takeEntry3=true;
            }}catch(StringIndexOutOfBoundsException e){}
           if(takeEntry3==true){
              Metar2[3]=Metar2[3]+Metar.charAt(i); 
           }
           if(i==Metar.length()-1){
            takeEntry3=false;
            indexC++;
           }
           }
           }
        }
         
       
       
     
     
     
     
return Metar2;
    }
}
