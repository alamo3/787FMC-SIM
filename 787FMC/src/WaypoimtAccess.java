/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author omer
 */import java.io.*;
import java.util.*;
import java.lang.*;


public class WaypoimtAccess {
    
    
    
    
    FMCLogicTest wpt=new FMCLogicTest();
    
    public List<String> getSIDWpt(String w,String x, String y){
        List<String> Waypoints=new ArrayList<String>();
        String line;
        String sid=x;
        String rwy=y;
        String icao=w;
        boolean takeInput=false;
        icao=System.getProperty("user.dir")+"/navdata/navdata/PROC/"+icao+".txt";
        
        int number=0;;
        try{
        BufferedReader br=new BufferedReader(new InputStreamReader(new DataInputStream(new FileInputStream(icao))));
        
        label1: while((line=br.readLine())!=null){
        
         number++;
         if(line.contains(sid)&&line.contains(rwy)){
             takeInput=true;
         }
         if(takeInput==true&&line.isEmpty()==true){
             takeInput=false;
             break label1;
         }
         if(takeInput==true){
          Waypoints.add(line);   
         }
        }
        
        }catch(IOException e){
            
        }
        
        for(int i=0; i<Waypoints.size();i++){
          if(Waypoints.get(i).contains("VA")||Waypoints.get(i).contains("VM")){
           Waypoints.remove(i); 
          }
        }
        boolean takeChar=false;
          String[] temp=new String[Waypoints.size()];
          
          for(int i=0;i<temp.length;i++){
           temp[i]=""; 
            
          }
          
        for(int i=0;i<Waypoints.size();i++){
          for(int j=0; j<Waypoints.get(i).length();j++){
            try{
            if((Waypoints.get(i).charAt(j-1)==','&&Waypoints.get(i).charAt(j-2)=='F'&&Waypoints.get(i).charAt(j-3)=='D'&&Character.isLetter(Waypoints.get(i).charAt(j))==true)||(Waypoints.get(i).charAt(j-1)==','&&Waypoints.get(i).charAt(j-2)=='F'&&Waypoints.get(i).charAt(j-3)=='T'&&Character.isLetter(Waypoints.get(i).charAt(j))==true)){
             takeChar=true; 
            }
            if(takeChar==true&&Waypoints.get(i).charAt(j)==','){
              takeChar=false;
            }
            }catch(StringIndexOutOfBoundsException e){}
            if(takeChar==true){
             temp[i]=temp[i]+Waypoints.get(i).charAt(j); 
            }
            
            
            
          }
          
        }
        
        
        Waypoints.clear();
        for(int i=0;i<temp.length;i++){
          while(temp[i].isEmpty()==true){
           i++; 
          }
          Waypoints.add(temp[i]);
        }
        
        return Waypoints;
    }
    
    
    
}
