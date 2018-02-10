import java.io.*;
import java.util.*;
import java.lang.*;


class TestFile{
  
  
  PropertiesChecker panelSelector = new PropertiesChecker();
FMCLogicTest accessLogic=new FMCLogicTest();
public static WaypoimtAccess navDataPull=new WaypoimtAccess();

  public String runwaySelected="24L";
    public String starSelected="LINNG8";
    public String TransSelected="WOZEE";
    String icao="CYYZ";
  public static void main(String[]args){
    
TestFile obj1=new TestFile();
    
obj1.displayStars();





        } 
    
    
    
  
 /* public void displayLegs(){
   Map<String,legs> legsData=new HashMap<>();

    List<String> rawDataSID=navDataPull.getSIDWpt(icao,sidSelected,runwaySelected,TransSelected);
    List<String> rawDataSIDLatLong=navDataPull.getSIDWptLatLong(icao,sidSelected,runwaySelected,TransSelected);
    List<String> distanceFromWPT=new ArrayList<>();
    List<String> bearingFromWPT=new ArrayList<>();
    
    List<String> altRestrictions=new LinkedList<>();
    try{
     altRestrictions=navDataPull.getAltRest(icao,sidSelected,TransSelected); 
    }catch(IOException e){}
    
    for(int i=0;i<altRestrictions.size();i++){
     System.out.println(altRestrictions.get(i)); 
    }
    
    System.out.println(rawDataSIDLatLong);
   

    for(int i=0;i<rawDataSIDLatLong.size()-2;i+=2){

        Double lat1=Double.parseDouble(rawDataSIDLatLong.get(i));
        Double lon1=Double.parseDouble(rawDataSIDLatLong.get(i+1));
        Double lat2=Double.parseDouble(rawDataSIDLatLong.get(i+2));
        Double lon2=0D;
        
        lon2=Double.parseDouble(rawDataSIDLatLong.get(i+3));
        
       navDataPull.distanceNM(lat1,lon1,lat2,lon2);
        distanceFromWPT.add(Double.toString(navDataPull.distanceNM(lat1,lon1,lat2,lon2)));

        bearingFromWPT.add(Double.toString(navDataPull.calcBearing(lat1,lon1,lat2,lon2)));


    }

    
  String []  runwayData=navDataPull.runwayData(icao,runwaySelected).split(",");

 bearingFromWPT.add(0,runwayData[2]);
    
    
     System.out.println("DFWPT: "+distanceFromWPT);
     System.out.println("ALL HGS: "+bearingFromWPT);
    int latlongselect=0;
   System.out.println(distanceFromWPT.size()-1  +"  "+ bearingFromWPT.size() );
    int latlong=0;
    int latlongBearing=0;
    int altrest=0;
    for(int i=0; i<rawDataSID.size();i++){
      
        String distanceFromLast="0 NM";
        String bearingFromLast="N/A";
        String altRestr="----";
         if(i>0&&i< bearingFromWPT.size()+3&&!(rawDataSID.get(i).charAt(0)=='('||rawDataSID.get(i).contains("VECTORS")==true)){
          
            bearingFromLast=bearingFromWPT.get(latlongBearing);
            distanceFromLast=distanceFromWPT.get(latlong);
           
//            System.out.println("Distance :" +distanceFromLast);
//            System.out.println("HDG :"+bearingFromLast);
latlong++;
latlongBearing++;


         }else if(rawDataSID.get(i).contains("RW"+runwaySelected)){
           bearingFromLast=bearingFromWPT.get(0);
           latlongBearing++;
         }
          if(i>0&&i<altRestrictions.size()+3){
            altRestr=altRestrictions.get(altrest);
            altrest++;
         }
         if(rawDataSID.get(i).charAt(0)=='('||rawDataSID.get(i).contains("VECTORS")==true){
           legsData.put(rawDataSID.get(i),new legs(rawDataSID.get(i),rawDataSIDLatLong.get(latlongselect),rawDataSIDLatLong.get(latlongselect+1),"0 NM",bearingFromLast,altRestr) );
         }else{
        legsData.put(rawDataSID.get(i),new legs(rawDataSID.get(i),rawDataSIDLatLong.get(latlongselect),rawDataSIDLatLong.get(latlongselect+1),distanceFromLast,bearingFromLast,altRestr) );
    }
        
        if(latlongselect!=rawDataSIDLatLong.size()-2){
        latlongselect+=2;
        }

    } 
   for(int i=0; i<legsData.size();i++){
   System.out.println(legsData.get(rawDataSID.get(i)).getLegName()+": Latitude: " +legsData.get(rawDataSID.get(i)).getLatitude()+" ,Longitude: "+ legsData.get(rawDataSID.get(i)).getLongitude() +" ,Distance from last:"+ legsData.get(rawDataSID.get(i)).getDistanceFromLast()+" ,Bearing From Last:"+legsData.get(rawDataSID.get(i)).getBearingFromLast() +
   " ALTITUDE RESTRICTION: "+legsData.get(rawDataSID.get(i)).getaltRestr());
   
   }
    
  }*/
  
  
  
  public void displayStars(){
    Map<String,Stars> stars=new LinkedHashMap<>();
    
    List<String> rawDataStars=accessLogic.getStars(icao);
    List<String> starsTransition;
    List<String> runwayAvail;
    if(starSelected!=null){
    //  starsTransition=accessLogic.getTransition(icao,starSelected);
    }

    System.out.println(rawDataStars);
    for(int i=0;i<rawDataStars.size();i++){
    
     starsTransition= accessLogic.getTransition(icao,rawDataStars.get(i));
     runwayAvail=accessLogic.getProcstoRunways(icao,rawDataStars.get(i));
      stars.put(rawDataStars.get(i),new Stars(icao,rawDataStars.get(i),starsTransition,runwayAvail));
      
      
    }
//    System.out.println(stars.size());
//    for(int i =0; i<stars.size();i++){
//      try{
//        String test;
//     System.out.println(stars.get(rawDataStars.get(i)).getStarIcao() + " : "+stars.get(rawDataStars.get(i)).getStarIdent()+" : "+stars.get(rawDataStars.get(i)).getTrans()+" : "+stars.get(rawDataStars.get(i)).getRunways());
//     }catch(NullPointerException e){}
//      
      
    }
    
    
    
    
  }
  
  
