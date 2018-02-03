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
    
    public List<String> returnWaypoints(String x, String y)
    {
    List<String> waypoints=new ArrayList<String>();
    String airway=x;
    String exitAirway=y;
    
    
    
    
    
    
    
    return waypoints;
    }
    public List<String> runwayData(String x, String y){
    String runwayData="";
    
    String runwayNumber=y;
    String airport=x;
    
    String icao=System.getProperty("user.dir")+"/navdata/navdata/Airports.txt";
    String line="";
    List<String> runways=new ArrayList<String>();
     try{
       boolean takeInput=false;
        BufferedReader br=new BufferedReader(new InputStreamReader(new DataInputStream(new FileInputStream(icao))));
      label1: while((line=br.readLine())!=null){
        if(line.contains("A,"+airport+",")){
        takeInput=true;
        }
        if(takeInput==true&&line.isEmpty()==true){
         takeInput=false; 
        }
        if(takeInput==true){
        runways.add(line);
        }
        
      }
        
     }catch(IOException e){}
        
     for(int i=0; i<runways.size();i++){
       if(runways.get(i).contains("R,"+runwayNumber+",")){
        runwayData=runways.get(i); 
         
       }
       
     }
     
     String []temp=runwayData.split(",");
     
     List<String> LatLong= new ArrayList<String>();
     LatLong.add(temp[8]);
     LatLong.add(temp[9]);
     
     
    return LatLong;
    
    }
        public List<String> getSIDWptLatLong(String w,String x, String y){
        List<String> Waypoints=new ArrayList<String>();
        String line;
        String sid=x;
        String rwy=y;
        String icao=w;
        boolean takeInput=false;
        icao=System.getProperty("user.dir")+"/navdata/navdata/PROC/"+icao+".txt";
        
        int number=0;
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
       String [] temp1=new String[Waypoints.size()];
        for(int i=0;i<temp1.length;i++){
         temp1[i]=Waypoints.get(i); 
         System.out.println(temp1[i]);
        }
        
          System.out.println(Waypoints.get(1));
        for(int i=0; i<temp1.length;i++){
          /*System.out.println(temp1[i]);
          System.out.println(temp1[i].charAt(3));
          System.out.println(Character.isLetter(temp1[i].charAt(3)));*/
          if(Character.isLetter(temp1[i].charAt(3))==false||temp1[i].contains("SID")){
            
           temp1[i]="";
          }
   
        }
        
        Waypoints.clear();
        for(int i=0; i<temp1.length;i++){
          if(temp1[i].isEmpty()==false){ 
          Waypoints.add(temp1[i]);
          }
        }
        System.out.println("exiting now :)");
        
        return Waypoints;
        }
        
        
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
        
        List<String> temporaryHold=Waypoints;
        System.out.println(temporaryHold);
        String []temp3=new String[temporaryHold.size()];
        for(int i=0; i<temp3.length; i++){
         temp3[i]=temporaryHold.get(i); 
          
        }
        
       // for(int i=0;i<Waypoints.size();i++){
       //     System.out.println(Waypoints.get(i));
       //   }
        
        String [] temp1=new String[Waypoints.size()];
        for(int i=0;i<temp1.length;i++){
         temp1[i]=Waypoints.get(i); 
         System.out.println(temp1[i]);
        }
        
          System.out.println(Waypoints.get(1));
        for(int i=0; i<temp1.length;i++){
          /*System.out.println(temp1[i]);
          System.out.println(temp1[i].charAt(3));
          System.out.println(Character.isLetter(temp1[i].charAt(3)));*/
          if(Character.isLetter(temp1[i].charAt(3))==false||temp1[i].contains("SID")){
            
           temp1[i]="";
          }
   
        }
        for(int i=0;i<temp1.length;i++){
           System.out.println(temp1[i]); 
            
          }
       // System.out.println("At WP0");
        boolean takeChar=false;
          String[] temp=new String[temp1.length];
          
          for(int i=0;i<temp.length;i++){
           temp[i]=""; 
            
          }
          
         
       for(int i=0;i<temp.length;i++){
          label1: for(int j=0; j<temp1[i].length();j++){
            try{
            if(Character.isLetter(temp1[i].charAt(j))==true&&temp1[i].charAt(j-1)==','&&temp1[i].charAt(j)!='L'){
             takeChar=true; 
            }
            if(takeChar==true&&temp1[i].charAt(j)==','){
              takeChar=false;
              break label1;
            }
            }catch(StringIndexOutOfBoundsException e){}
            if(takeChar==true){
             temp[i]=temp[i]+temp1[i].charAt(j); 
            }
            
            
            
          }
          
        }
        
        
      //  System.out.println("At WP1");
        
        for(int i=0;i<temp.length;i++){
         System.out.println(temp[i]); 
        }
        Waypoints.clear();
        
       //  System.out.println("At WP2");
         for(int i=0;i<temp.length;i++){
           System.out.println(temp[i].isEmpty());
      if(temp[i].isEmpty()==false){ 
      Waypoints.add(temp[i]);
      }
    }
          Waypoints.add(0,"RW"+rwy);
          
          
          for(int i=0;i<temp3.length;i++){
            if(temp3[i].contains("VA")){
              String [] temp2=temp3[i].split(",");
             Waypoints.add(1,"("+temp2[4]+")"); 
            }
            if(temp3[i].contains("VM")){
             Waypoints.add(2,"VECTORS"); 
            }
            if(temp3[i].contains("CI")){
             Waypoints.add(2,"( INTC )"); 
            }
          }
         
        // System.out.println("exiting now :)");
        return Waypoints;
    }
    
    
}
    
    

