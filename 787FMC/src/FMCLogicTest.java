/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.*;
import java.util.*;

/**
 *
 * @author omer
 */
public class FMCLogicTest {
  
  public static void main(String[]args){
    System.out.println("Working Directory = " +System.getProperty("user.dir"));
    FMCLogicTest obj1=new FMCLogicTest();
    obj1.getAirports();
    
  }
  
   public String filepath=System.getProperty("user.dir") ;
        File fileScanner=new File(filepath+"/navdata/navdata/PROC");
        
        
         String airportChosenDep="";
String airportChosenArr="";
public void setAirportDep(String x){airportChosenDep=x;}
public String getAirportDep(){return airportChosenDep;}
public void setAirportArr(String x){airportChosenArr=x;}
public String getAirportArr(){return airportChosenArr;}


public String[] getAirports(){
 String [] airports = fileScanner.list();
 for(int i=0; i<airports.length;i++){
  airports[i]=airports[i].substring(0,4); 
 }
 
 
 
 for(int i=0; i<40;i++){
  System.out.println(airports[i]); 
   
 }
         return airports;
}

public boolean checkAirport(String x){
   String icao=x;
   String [] airportsDatabase=getAirports();
    
    boolean isAirportFound=false;
    
    for(int i=0;i<airportsDatabase.length; i++ ){
  if(icao.equals(airportsDatabase[i])){
       isAirportFound=true;
       }
}
   return isAirportFound;
}


public String[] getSIDS(){
 String[] sids;
 String depSelected=System.getProperty("user.dir")+"/navdata/navdata/PROC/"+airportChosenDep+".txt";
 
 

 
 try{

  LineNumberReader sidScanner=new LineNumberReader(new FileReader(depSelected));
 int data=sidScanner.read();
 
 
 }catch(IOException ex){
  ex.printStackTrace();
 }
 return sids;
    
}
    
}  
        
    
    
    


