import nav.*;
import logic.*;
import java.util.*;
import java.io.*;

class testRTE{
  
  public static WaypoimtAccess navDataPull=new WaypoimtAccess();
  public static Map<String, Airways> airwaysList=new LinkedHashMap<>();
  public static Map<Integer,Map<Integer,Waypoints>> wptLegs=new LinkedHashMap<>();
  public static void main(String args[]){ 
  
 
 
  
        
        try(FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"/navdata/navdata/airwaysFinal.ser"); ObjectInputStream ois=new ObjectInputStream(fis)){
          
          airwaysList=(LinkedHashMap)ois.readObject();
          ois.close();
          fis.close();
          
        }catch(IOException e){e.printStackTrace();}
        catch(ClassNotFoundException f){f.printStackTrace();}
        System.out.println("ATS IMPORTED");
        
        
        
        
        
  
  }
  
  
  public static void calcWpts(String airway, String waypoint){
  
    boolean goingUp=false;
    boolean goingDown=false;
    String wptStart="";
    Map<String,waypointsAirway> wpts=airwaysList.get(airway).getWaypoints();
    
    List<String> wptNames=new LinkedList<>();
   
    wptNames.addAll(wpts.keySet());
    
    if(numWpt==0&&activeRtePage==1){
    
    if(sidSelected!=null && TransSelected!=null){
     
      wptStart=TransSelected;  
    }else{
        List<String> wptsName=navDataPull.getSIDWpt(panelSelector.retrieveProperty("origin"),sidSelected,panelSelector.retrieveProperty("runwaydep"),null);
        wptStart=wptsName.get(wptsName.size()-1);
      }
    
    
    }else{
     wptStart=wptRTE.get(wptRTE.size()-1).getName();
      
    }
    
    stop12 :for(int i=wptNames.indexOf(wptStart);i<wpts.size();i++){
     if(wptNames.get(i).contains(waypoint)){
       goingDown=true; 
        goingUp=false;
       break stop12;
      }else{
       goingUp=true; 
        
      }
    }
    
    if(goingUp==true){
      stop: for(int i=wptNames.indexOf(wptStart)-1;i>-1;i--){
        wptRTE.put(numWpt,new Waypoints(wpts.get(wptNames.get(i)).getWptName(),wpts.get(wptNames.get(i)).getLatitude(),wpts.get(wptNames.get(i)).getLongitude()));
        numWpt++;
        if(wptNames.get(i).equals(waypoint)){
          break stop;
        }
      }
    
    }else{
      stop1: for(int i=wptNames.indexOf(wptStart)+1;i<wpts.size();i++){
        wptRTE.put(numWpt,new Waypoints(wpts.get(wptNames.get(i)).getWptName(),wpts.get(wptNames.get(i)).getLatitude(),wpts.get(wptNames.get(i)).getLongitude()));
        numWpt++;
        if(wptNames.get(i).equals(waypoint)){
          break stop1;
        }
      
    }
    }
    wptLegs.put(entries,wptRTE);
    entries++;
    wptRTE.clear();
   // wptRTE.forEach((k,v) -> System.out.println("Current Airway :"+airway+" Waypoint :" +v.getName()));
  
  
  }
  
  
  
  
}