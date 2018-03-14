package logic;

import java.io.*;
import java.util.*;
import java.lang.*;
import com.google.common.collect.*;

import nav.*;

   @SuppressWarnings("unchecked")
class TestFile{
  
 
static WaypoimtAccess navDataPull=new WaypoimtAccess();
static FMCLogicTest accessLogic=new FMCLogicTest();
  public static void main(String [] args){
    TestFile obj1=new TestFile();
 
    
    
    
    
    
    
    
    
    
   
  
  
  }
  
  
  public Map<String,List<String>>  getStarWpts(String icao, String star, String runway, String transition, String approach, String runwayTrans){
      Map<String,List<String>> wpts=new LinkedHashMap<>();
      
      String directory=(System.getProperty("user.dir").substring(0,52)+"/navdata/navdata/Proc"+icao+".txt");
      String line="";
      String [] temp;
      boolean start=false;
      try(BufferedReader br=new BufferedReader(new InputStreamReader(new DataInputStream(new FileInputStream(directory))))){
        while((line=br.readLine())!=null){
        temp=splitString(line,',');
       
        if()
        
        
        
        
        }
      }
      
      
      
      
      
      return wpts;
    }
  
  
  
  public static String[] latlongDep;
  public static String[] latlongArr;
  public static Double bearing1;
  
 
  
  public static String getDirectionBWAirports(String dep,String arr){
     latlongDep=accessLogic.getAirportLatLong(dep);
      latlongArr=accessLogic.getAirportLatLong(arr);
    
    
    
    bearing1= navDataPull.calcBearing(Double.valueOf(latlongDep[1]),Double.valueOf(latlongDep[2]),Double.valueOf(latlongArr[1]),Double.valueOf(latlongArr[2]));
    System.out.println( "Bearing :"+bearing1);
    
     int bearing = bearing1.intValue();
    if(bearing>=0&& bearing<=90){
     return "east"; 
    }else if(bearing>90&&bearing<=180){
    return "south";
    }else if(bearing>180&&bearing<=270){
     return "west"; 
    }else if(bearing==0||bearing==360){
     return "north"; 
    }
    return "nowhere";
  }
  
  
 
  
 
    public static String[] splitString(String line, char delimiter){
  
    List<String> splits=new ArrayList<>();
  int begin=0;
  int end=0;
   int j=0;
   String catchWord="";
   
 char[] charSplit=line.toCharArray();
 for(int i=0;i<charSplit.length;i++){
   if(charSplit[i]==delimiter){
     j=i;
     end = begin;
     while(end<i){
      catchWord=catchWord+charSplit[end]; 
      end++;
     }
     splits.add(catchWord);
     begin=i+1;
     catchWord="";
   }
 
   
 }
    splits.add(line.substring(line.lastIndexOf(delimiter)+1,line.length()));
    


  
   
  return splits.toArray(new String[splits.size()]);
 
  }
  
    public List<String> readLines(){
     List<String> linesRead=new LinkedList<>();
     
     String directory="C:/Users/omer/Documents/GitHub/787FMC-SIM/787FMC/src"+"/navdata/navdata/Navaids.txt";
     String line="";
     try(BufferedReader br=new BufferedReader(new InputStreamReader(new DataInputStream(new FileInputStream(directory))))){
       while((line=br.readLine())!=null){
        linesRead.add(line); 
        // System.out.println(line);
         
         
       }
       
       
     }catch (IOException e){}
      
      return linesRead;
    }
    
    String legIdent="";
    
    public void writeLegObject(String airName, Map<String,waypointsAirway> legsStore){
      legIdent = System.getProperty("user.dir")+"/legs/";
     
  try( FileOutputStream writeObject= new FileOutputStream(legIdent+airName+".ser")){
 
  ObjectOutputStream oos=new ObjectOutputStream (writeObject);
  oos.writeObject(legsStore);
  }catch(IOException e){e.printStackTrace();}
    }
}
