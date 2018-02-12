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
  //for testing purposes only  
/*  public static void main(String []args){
   WaypoimtAccess obj1=new WaypoimtAccess();
   
    obj1.getSIDWptLatLong("CYYZ","AVSEP3","05","OTNIK");
    
  }*/
    
    
   
    
    //Calculates the distance between 2 waypoints. Requires Lat and Long for Both
  
  String procedure="";
  String icao="";
  String procTrans="";
  public List<String> getAltRest(String icao, String procedure, String procTrans) throws IOException{
    this.icao=icao;
    this.procedure=procedure;
    List<String> altRest=new ArrayList<>();
    this.procTrans=procTrans;
    
     String directory=System.getProperty("user.dir")+"/navdata/navdata/PROC/"+icao+".txt";
        String lineCapture="";
        boolean takeLine=false;
     try(BufferedReader br=new BufferedReader(new InputStreamReader(new DataInputStream(new FileInputStream(directory))))){
       label1:   while((lineCapture=br.readLine())!=null){
         if(lineCapture.contains("SID,"+procedure)||lineCapture.contains("STAR,"+procedure)){
          takeLine=true; 
         }
         
         if(takeLine==true&&lineCapture.isEmpty()){
          takeLine=false; 
          break label1;
         }
         if(takeLine==true){
           String [] temp=lineCapture.split(",");
           if(lineCapture.startsWith("VA,")||lineCapture.startsWith("CA,")){
             //altRest.add(temp[3]);
             altRest.add(temp[4]);
             
           }else if(lineCapture.startsWith("CF,")||lineCapture.startsWith("VD,")||lineCapture.startsWith("FD,")||lineCapture.startsWith("FC,")||lineCapture.startsWith("CD,")||lineCapture.startsWith("PI,")||lineCapture.startsWith("HA,")||lineCapture.startsWith("HF,")||lineCapture.startsWith("TF,")){
            // altRest.add(temp[10]);
             altRest.add(temp[11]);
             
           }else if(lineCapture.startsWith("CI,")||lineCapture.startsWith("CR,")||lineCapture.startsWith("VM,")||lineCapture.startsWith("VR,")){
           //  altRest.add(temp[5]);
             altRest.add(temp[6]);
           }else if(lineCapture.startsWith("FA,")||lineCapture.startsWith("FM,")||lineCapture.startsWith("AF,")){
          //   altRest.add(temp[9]);
             altRest.add(temp[10]);
             
           } else if(lineCapture.startsWith("RF,")||lineCapture.startsWith("VI,")||lineCapture.startsWith("DF,")||lineCapture.startsWith("IF,")){
         //   altRest.add(temp[8]);
            altRest.add(temp[9]);
           }
           else if(lineCapture.startsWith("HM,")){
        //    altRest.add(temp[13]);
            altRest.add(temp[14]);
           }
           
         }
         
         
       }
       
       
     }
     if(procTrans!=null){
    String lineTrans="";
    boolean takeTransInfo=false;
     try(BufferedReader br=new BufferedReader(new InputStreamReader(new DataInputStream(new FileInputStream(directory))))){
       label2:  while((lineTrans=br.readLine())!=null){
         if(lineTrans.contains("SID,"+procedure+","+procTrans+",")||lineTrans.contains("STAR,"+procedure+","+procTrans+",")){
          takeTransInfo=true; 
           
         }
         if(takeTransInfo==true&&lineTrans.isEmpty()){
          takeTransInfo=false;
          break label2;
         }
         if(takeTransInfo==true){
          String [] temp=lineTrans.split(",");
            if(lineTrans.startsWith("VA,")||lineTrans.startsWith("CA,")){
             //altRest.add(temp[3]);
             altRest.add(temp[4]);
             
           }else if(lineTrans.startsWith("CF,")||lineTrans.startsWith("VD,")||lineTrans.startsWith("FD,")||lineTrans.startsWith("FC,")||lineTrans.startsWith("CD,")||lineTrans.startsWith("PI,")||lineTrans.startsWith("HA,")||lineTrans.startsWith("HF,")||lineTrans.startsWith("TF,")){
            // altRest.add(temp[10]);
             altRest.add(temp[11]);
             
           }else if(lineTrans.startsWith("CI,")||lineTrans.startsWith("CR,")||lineTrans.startsWith("VM,")||lineTrans.startsWith("VR,")){
           //  altRest.add(temp[5]);
             altRest.add(temp[6]);
           }else if(lineTrans.startsWith("FA,")||lineTrans.startsWith("FM,")||lineTrans.startsWith("AF,")){
          //   altRest.add(temp[9]);
             altRest.add(temp[10]);
             
           } else if(lineTrans.startsWith("RF,")||lineTrans.startsWith("VI,")||lineTrans.startsWith("DF,")||lineTrans.startsWith("IF,")){
         //   altRest.add(temp[8]);
            altRest.add(temp[9]);
           }
           else if(lineTrans.startsWith("HM,")){
        //    altRest.add(temp[13]);
            altRest.add(temp[14]);
           }
            
         }
         
         
       }
       
     }
     }
    
    
    
    
    return altRest;
  }
  
  
  
    
    public double distanceNM(double lat1, double lon1, double lat2, double lon2) {
 
 
 double nd_lat = Math.toRadians(lat1);
 double nd_lat2 = Math.toRadians(lat2);
 
 double nd_dlat = Math.toRadians(lat2-lat1);
 double nd_dlon = Math.toRadians(lon2-lon1);
 
 double nd_a = Math.sin(nd_dlat/2)*Math.sin(nd_dlat/2)+Math.cos(nd_lat)*Math.cos(nd_lat2)*Math.sin(nd_dlon/2)*Math.sin(nd_dlon/2);
 double nd_b = 2 * Math.atan2(Math.sqrt(nd_a), Math.sqrt(1-nd_a));
 double nd_dis = nd_b * 3440.064795 ;
 
 return nd_dis;


}
    
    //calculates the bearing between two waypoints. Requires latitude and longitude.

public double calcBearing (double req_lat, double req_lon, double req_lat2, double req_lon2){
 
 double nd_lat = Math.toRadians(req_lat);
 double nd_lon = Math.toRadians(req_lon);
 
 double nd_lat2 = Math.toRadians(req_lat2);
 double nd_lon2 = Math.toRadians(req_lon2);
 
 double nd_y = Math.sin(nd_lon2 - nd_lon) * Math.cos(nd_lat2);
 double nd_x = Math.cos(nd_lat) * Math.sin(nd_lat2) - Math.sin(nd_lat) * Math.cos(nd_lat2) * Math.cos(nd_lon2 - nd_lon);
 double nd_hdg = Math.atan2(nd_y, nd_x);
 nd_hdg = Math.toDegrees(nd_hdg);
 nd_hdg = (nd_hdg + 360) % 360;
 
 return nd_hdg;
}
    
    
    //WIP method.
    public List<String> returnWaypoint(String x, String y) throws IOException
    {
    List<String> waypoints=new ArrayList<String>();
    String airway=x;
    String exitAirway=y;
     String directory=System.getProperty("user.dir")+"/navdata/navdata/PROC/"+icao+".txt";
        String lineCapture="";
     try(BufferedReader br=new BufferedReader(new InputStreamReader(new DataInputStream(new FileInputStream(directory))))){
       while((lineCapture=br.readLine())!=null){
         
         
         
       }
       
       
     }
    
    
    
    
    
    return waypoints;
    }
    
    
    //Gets data for runway selected at specific airport. Specifically the lat and long
    
    public String runwayData(String x, String y){
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
     System.out.println(runwayData);
     
     /*
     List<String> LatLong= new ArrayList<String>();
     LatLong.add(temp[8]);
     LatLong.add(temp[9]);*/
     
     
     System.out.println("--------------");
    return runwayData;
    
    }
    
    
    
    
    
  
    
   //Gets the latitude and longitude of SID waypoints. Gets the lat and long for transition selected if there is one. 
    
        public List<String> getSIDWptLatLong(String w,String x, String y, String z){
        List<String> Waypoints=new ArrayList<String>();
        String line;
        String sid=x;
        String rwy=y;
        String icao=w;
        String airport=w;
        String trans=z;
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
       //  System.out.println(temp1[i]);
        }
        
       //   System.out.println(Waypoints.get(1));
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
         String [] temporaryHold1=Waypoints.toArray(new String[Waypoints.size()]);
         
         Waypoints.clear();
         
          for(String next:temporaryHold1){
           String [] split=next.split(",");
           Waypoints.add(split[2]);
           Waypoints.add(split[3]);
          }
        
      //  System.out.println("exiting now :)");
        
        
        //Added ability to get waypoints for transition and lat long as well 
          if(trans!=null){
        List<String> transitions=new ArrayList<>();
        
        try{
          BufferedReader br=new BufferedReader(new InputStreamReader(new DataInputStream(new FileInputStream(icao))));
          String lineCapture;
          boolean takeWaypoint=false;
          while((lineCapture=br.readLine())!=null){
            if(lineCapture.contains(sid)&&lineCapture.contains(trans)){
             takeWaypoint=true; 
            }
              
            if(takeWaypoint==true&&lineCapture.isEmpty()){
             takeWaypoint=false; 
            }
            
            if(takeWaypoint==true&&lineCapture.contains("SID")==false){
            transitions.add(lineCapture);
            
            }
         
          
          
          }
        }catch(IOException e){}
        
        
        
         String [] temporaryHold=transitions.toArray(new String[transitions.size()]);
       //   for(String next:temporaryHold){
       //    System.out.println(next); 
       //   }
         
          transitions.clear();
          
            for(String next: temporaryHold){
             String [] splitData=next.split(","); 
              transitions.add(splitData[2]);
              transitions.add(splitData[3]);
            }
        
        //  for(int i=0; i<transitions.size();i++){
        //   System.out.println(transitions.get(i)); 
        //  }
     //     for(String next:Waypoints){
     //      System.out.println(Waypoints); 
     //     }
     //     System.out.println();
            Waypoints.addAll(transitions);
            for(String next:Waypoints){
      //     System.out.println(Waypoints); 
          }
            Set<String> duplicates=new LinkedHashSet<>();
            
            duplicates.addAll(Waypoints);
            Waypoints.clear();
            Waypoints.addAll(duplicates);
      //    System.out.println(Waypoints);
          }
          String directory=System.getProperty("user.dir")+"/navdata/navdata/Airports.txt";
          try{
            BufferedReader br=new BufferedReader(new InputStreamReader(new DataInputStream(new FileInputStream(directory))));
            String runwayData="";
            String line3="";
            boolean takeCoords=false;
            while((line3=br.readLine())!=null){
              if(line3.contains("A,"+airport+",")){
                System.out.println(line3);
               takeCoords=true; 
              }
              if(runwayData.contains(rwy)&&takeCoords==true){
               takeCoords=false; 
              }
              if(takeCoords==true&&line3.contains("R,"+rwy+",")){
               runwayData=line3; 
              }
      
            }
            System.out.println(runwayData);
            String [] runwayHold=runwayData.split(",");
            Waypoints.add(0,runwayHold[8]);
             Waypoints.add(1,runwayHold[9]);
            
            
          }catch (IOException e){}
          
          for(int i=0; i<Waypoints.size();i++){
           System.out.println( Waypoints.get(i)); 
          }
          
        return Waypoints;
        }
        
        //gets the waypoints of the sid selected. Will get waypoints for transition if selected and available
        
        
    public List<String> getSIDWpt(String w,String x, String y,String z){
        List<String> Waypoints=new ArrayList<String>();
        String line;
        String sid=x;
        String rwy=y;
        String icao=w;
        String trans=z;
        boolean takeInput=false;
        icao=System.getProperty("user.dir")+"/navdata/navdata/PROC/"+icao+".txt";
        
        int number=0;;
        try{
        BufferedReader br=new BufferedReader(new InputStreamReader(new DataInputStream(new FileInputStream(icao))));
        
        label1: while((line=br.readLine())!=null){
        
         number++;
         if((line.contains(sid)&&line.contains(rwy))){
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
      //   System.out.println(temp1[i]);
        }
        
    //      System.out.println(Waypoints.get(1));
        for(int i=0; i<temp1.length;i++){
          /*System.out.println(temp1[i]);
          System.out.println(temp1[i].charAt(3));
          System.out.println(Character.isLetter(temp1[i].charAt(3)));*/
          if(Character.isLetter(temp1[i].charAt(3))==false||temp1[i].contains("SID")){
            
           temp1[i]="";
          }
   
        }
       // for(int i=0;i<temp1.length;i++){
         //  System.out.println(temp1[i]); 
            
         // }
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
        
        
        Waypoints.clear();
        
       //  System.out.println("At WP2");
         for(int i=0;i<temp.length;i++){
          
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
         

          //added functionality to include transition waypointshygt


          if(trans!=null){
          List<String> transitions=new ArrayList<>();
         
          String line2;
          boolean taketrans=false;
          try{
           BufferedReader br=new BufferedReader(new InputStreamReader(new DataInputStream(new FileInputStream(icao)))); 
            
            label2: while((line2=br.readLine())!=null){
             if(line2.contains(sid)&&line2.contains(trans)){
              
              taketrans=true;
             }
             if(taketrans==true&&line2.isEmpty()==true){
              takeInput=false;
              break label2;
             }
             if(taketrans==true&&line2.contains("SID")==false){
              transitions.add(line2); 
             }
           }
           
          }catch(IOException e){}
          
          
      
       String [] temp4= transitions.toArray(new String[transitions.size()]); 
       for(String next:temp4){
       String []temp5 = next.split(",");
       Waypoints.add(temp5[1]);
       
      }
      
     Set<String> duplicates= new LinkedHashSet<>();
     
     duplicates.addAll(Waypoints);
     
     Waypoints.clear();
     Waypoints.addAll(duplicates);
      for(String next:Waypoints){
       System.out.println(next); 
      }
          }
        return Waypoints;
    }
    
    
}
    
    

