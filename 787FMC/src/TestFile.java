import java.io.*;
import java.util.*;
import java.lang.*;



class TestFile{
  
  
static WaypoimtAccess navDataPull=new WaypoimtAccess();
static FMCLogicTest accessLogic=new FMCLogicTest();
  public static void main(String [] args){
    TestFile obj1=new TestFile();

//    List<String> waypoints=obj1.readLines();
//  int latlong=0;
//     List<String>airwayName=new LinkedList<>();
// Map<String,waypointsAirway> waypointAirway=new LinkedHashMap<>();
// List<String> airwayLoc=new LinkedList<>();
//
// 
//    try(FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/navdata/navdata/airwaysIdent.ser"); ObjectInputStream ois=new ObjectInputStream(fis)){    
//      airwayName=(LinkedList)ois.readObject();
//fis.close();
//ois.close();
//    }catch(IOException e){e.printStackTrace();}
//    catch(ClassNotFoundException f){f.printStackTrace();}
//
//   try(FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/navdata/navdata/airwaysLatLong.ser"); ObjectInputStream ois=new ObjectInputStream(fis)){    
//      airwayLoc=(LinkedList)ois.readObject();
//fis.close();
//ois.close();
//    }catch(IOException e){e.printStackTrace();}
//    catch(ClassNotFoundException f){f.printStackTrace();}
//
//    Map<String, Airways> airways=new LinkedHashMap<>();
//    List<String> finalLat= new LinkedList<>();
//    
//   // System.out.println(airwayLoc/*.get(0)+" : "+airwayLoc.get(1)*/);
//    
//    
//    
//    
//    
//    for(int i=0;i<airwayName.size();i++){
//      
//      try(FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/legs/"+airwayName.get(i)+".ser"); ObjectInputStream ois=new ObjectInputStream(fis)){
//      waypointAirway=(LinkedHashMap) ois.readObject();
//  fis.close();
//  ois.close();
//    }catch(IOException e){e.printStackTrace();}
//    catch(ClassNotFoundException f){f.printStackTrace();}
//   
//    
//    airways.put(airwayName.get(i),new Airways(airwayName.get(i),waypointAirway,airwayLoc.get(latlong),airwayLoc.get(latlong+1)));
//  
//  latlong=latlong+2;
//    
//  }
//    
//    try(FileOutputStream fos=new FileOutputStream(System.getProperty("user.dir")+"/airwaysFinal.ser"); ObjectOutputStream oos=new ObjectOutputStream(fos)){
//     oos.writeObject(airways);
//     oos.close();
//       fos.close();
//    }catch(IOException e){e.printStackTrace();}
//        
   
 
    
        Map<String, Airways> airways=new LinkedHashMap<>();
    
    try(FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/airwaysFinal.ser"); ObjectInputStream ois=new ObjectInputStream(fis)){
          airways=(LinkedHashMap)ois.readObject();
          
    }catch(IOException e){e.printStackTrace();}
        catch(ClassNotFoundException f){f.printStackTrace();}
        
        String[]temp=airways.get("Z924").getLocation();
        System.out.println(temp[0]);
        System.out.println(temp[1]);
        
        
//        
    
//    List<String>retain=new LinkedList<>();
//       boolean start=false;
//    String airway="";
//    String line="";
//       for(ListIterator<String> iterate = waypoints.listIterator(); iterate.hasNext();){
//  line=iterate.next();    
//  if(line.startsWith("A1")&&start==false){
//    airway=line.substring(0,line.indexOf(" "));
//   start=true; 
//  }
//  if(start==true){
//    if(airway.equals(line.substring(0,line.indexOf(" ")))==false){
//   retain.add(line.substring(0,line.indexOf(" "))); 
//   airway=line.substring(0,line.indexOf(" "));
//    }
//  }
//  
//  
//  }
//  
//  try(FileOutputStream fos=new FileOutputStream(System.getProperty("user.dir")+"/navdata/navdata/airways.ser");  ObjectOutputStream oos=new ObjectOutputStream(fos) ){
//   
//  oos.writeObject(retain);
//    oos.close();
//    fos.close();
//  }catch(IOException e){e.printStackTrace();}
  
 
  
    
    
    
  }
        
        
  
  
  
  
  
  String airportDep="CYYZ";
  
  String AirportDest="EGLL";
  public static String[] latlongDep;
  public static String[] latlongArr;
  public static Double bearing1;
  
  double latitudeWpt;
  double longitudeWpt;
  double distance=0D;
  String [] latlongDepAir;
  
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
  
    List<String> splits=new LinkedList<>();
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
     
     String directory=System.getProperty("user.dir")+"/navdata/navdata/wpNavRTE.txt";
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
