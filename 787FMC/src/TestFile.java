import java.io.*;
import java.util.*;
import java.lang.*;



class TestFile{
  
  
static WaypoimtAccess navDataPull=new WaypoimtAccess();
static FMCLogicTest accessLogic=new FMCLogicTest();
  public static void main(String [] args){
    TestFile obj1=new TestFile();
    System.out.println("TESTFILE INITIATED");
    
    getDirectionBWAirports("CYYZ","EGLL");
    
 //  List<String> waypoints=obj1.getatsWaypoints();
    double timeInit=System.nanoTime();
    
    HashMap<String,Airways> airways=new LinkedHashMap<>();
    try{
    FileInputStream readAirways=new FileInputStream("airways.ser");
    ObjectInputStream readData=new ObjectInputStream(readAirways);
    airways=(LinkedHashMap)readData.readObject();
    }catch(IOException e){e.printStackTrace();}
    catch(ClassNotFoundException f){f.printStackTrace();}
    double timeEnd=System.nanoTime();
    
    
    timeInit=System.nanoTime();
     legs [] temp5=airways.get("UL18").getWaypoints();
    for(legs h1:temp5){
     System.out.println(h1.getLegName()); 
      
    }
    timeEnd=System.nanoTime();
   

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
  
  
  public List<String> getatsWaypoints(){
    String bearing=getDirectionBWAirports("CYYZ","EGLL");
    
    String directory=System.getProperty("user.dir")+"/navdata/navdata/wpNavRTE.txt";
    
    try{
     File file=new File(directory);
     System.out.println(file.exists());
      
    }catch(Exception e){}
    
    String exit="TANGI";
    String line;
    boolean takeInput=false;
    
   
    String airway="";
    int taken=0;
    List<String> waypoints=new LinkedList<>();
    List<String> cache=new LinkedList<>();
    
    HashMap<String,Airways> airways=new LinkedHashMap<>();
    Map<String,legs> legs=new LinkedHashMap<>();
    String [] temp;
    boolean begin=false;
    String wptName="";
    legs []tempwpt;
    try(BufferedReader br=new BufferedReader(new InputStreamReader(new DataInputStream(new FileInputStream(directory))))){
      
       while((line=br.readLine())!=null){
      temp=splitString(line,' ');
        if(begin==false){
          if(line.startsWith("A1")){
           begin=true; 
           airway="A1";
           cache.add(temp[3]);
           cache.add(temp[4]);
           if(taken==0){
          wptName=temp[2];
        }
          }
        }
        if(airway.equals("Z998")){
          System.out.println(legs);
         System.out.println("At Z998"); 
        }
        
        if(begin==true){
           if(airway.equals(line.replaceAll(" .*",""))==false){
            tempwpt=legs.values().toArray(new legs[legs.size()]);
            
            airways.put(airway,new Airways(airway,tempwpt,cache));
          
            airway=temp[0];
           legs.clear();
            cache.clear();
            cache.add(temp[3]);
           cache.add(temp[4]);
             wptName=temp[2];
             taken=0;
            
           }
        //  try{
        //      System.out.println(airways.get("A100").getAirwayIdent()+" : " + airways.get("A100").getWaypoints());
        //     }catch(Exception e){}
          
          if(taken==0){
          latlongDepAir=accessLogic.getAirportLatLong("CYYZ");
          
        distance=  navDataPull.distanceNM(Double.valueOf(latlongDepAir[1]),Double.valueOf(latlongDepAir[2]),Double.valueOf(temp[3]),Double.valueOf(temp[4]));
        bearing1=navDataPull.calcBearing(Double.valueOf(latlongDepAir[1]),Double.valueOf(latlongDepAir[2]),Double.valueOf(temp[3]),Double.valueOf(temp[4]));
        legs.put(temp[2],new legs(temp[2],temp[3],temp[4],Double.toString(distance),Double.toString(bearing1),"0"));
         wptName=temp[2];
         taken++;
          }else if(taken!=0){
            double distance=0D;
       String something=legs.get(wptName).getLatitude();
         latitudeWpt=Double.valueOf(legs.get(wptName).getLatitude());
       longitudeWpt=Double.valueOf(legs.get(wptName).getLongitude());
         distance=  navDataPull.distanceNM(latitudeWpt,longitudeWpt,Double.valueOf(temp[3]),Double.valueOf(temp[4]));
       double bearing1=navDataPull.calcBearing(latitudeWpt,longitudeWpt,Double.valueOf(temp[3]),Double.valueOf(temp[4]));
        legs.put(temp[2],new legs(temp[2],temp[3],temp[4],Double.toString(distance),Double.toString(bearing1),"0"));
         taken++;
         wptName=temp[2];
          }
          
   
        }
        
        
      }
    }catch(IOException e){e.printStackTrace();}
     //airways.put("Z999",new Airways(airway,tempwpt,cache));
           // airway="Z999";
           // legs.clear();
           // cache.clear();
            
            // wptName=temp[2];
             taken=0;
             
        
             
    
    try{
      FileOutputStream serialize=new FileOutputStream("airways.ser");
      ObjectOutputStream writeAirways=new ObjectOutputStream(serialize);
      writeAirways.writeObject(airways);
    }catch(IOException e){e.printStackTrace();}
    
    return waypoints;
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
  
  
  
}
