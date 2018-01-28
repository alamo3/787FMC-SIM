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
    obj1.setAirportDep("CYYZ");
    obj1.getSIDS(obj1.getAirportDep());
    
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


public String[] getSIDS(String icao){
 String[] sids;
 String depSelected=System.getProperty("user.dir")+"/navdata/navdata/PROC/"+icao+".txt";
 
 
List<Integer> listSidFound = new ArrayList<Integer>();
 int line=0;
 String buff;
 int listSize;
 int line2;
  String ph;
  List<String> Sids=new ArrayList<String>();
 
 Set<String> duplicates=new HashSet<>();
 String[] Sidident;
 String[] SidsFinal;
 try{

  BufferedReader buf = new BufferedReader(new InputStreamReader(new DataInputStream(new FileInputStream(depSelected))));

 while((buff=buf.readLine()) != null){
     line++;
     if(buff.contains("SID,")&&buff.length()<25){
      listSidFound.add(line);   
     }
 }

 
 listSize=listSidFound.size();
  line2=0;
ph="";
 Sidident=new String[listSize];
 BufferedReader br = new BufferedReader(new InputStreamReader(new DataInputStream(new FileInputStream(depSelected))));
 int i=0;
 while((ph=br.readLine())!=null){
  line2++;
   
   if(ph.contains("SID,")&&ph.length()<25){
    Sidident[i]=ph; 
     i++;
   }
   
 }


for(int k=0;k<Sidident.length;k++ ){
  Sids.add(Sidident[k].substring(4,10)); 
   
 }
 }catch(IOException ex){
  ex.printStackTrace();
 }
 
 
 
 
 
 
 duplicates.addAll(Sids);
 Sids.clear();
 Sids.addAll(duplicates);
  Collections.sort(Sids);

int sizeFinal=Sids.size();
 SidsFinal= new String[sizeFinal];
 for(int i=0; i<SidsFinal.length;i++){
   
  SidsFinal[i]=""; 
 }
 
 for(int j=0;j<SidsFinal.length;j++){
  SidsFinal[j]=Sids.get(j); 
   
 }
  for(int j=0;j<SidsFinal.length;j++){
  SidsFinal[j]=SidsFinal[j].replaceAll(",","");
   
 }
  
  return SidsFinal;
}
    

public String[] getStars(String icao){
 String[] stars;
 String arrSelected=System.getProperty("user.dir")+"/navdata/navdata/PROC/"+icao+".txt";
 
 
List<Integer> listStarFound = new ArrayList<Integer>();
 int line=0;
 String buff;
 int listSize;
 int line2;
  String ph;
  List<String> Stars=new ArrayList<String>();
 
 Set<String> duplicates=new HashSet<>();
 String[] Starident;
 String[] StarsFinal;
 try{

  BufferedReader buf = new BufferedReader(new InputStreamReader(new DataInputStream(new FileInputStream(arrSelected))));

 while((buff=buf.readLine()) != null){
     line++;
     if(buff.contains("STAR,")&&buff.length()<25){
      listStarFound.add(line);   
     }
 }

 
 listSize=listStarFound.size();
  line2=0;
ph="";
 Starident=new String[listSize];
 BufferedReader br = new BufferedReader(new InputStreamReader(new DataInputStream(new FileInputStream(arrSelected))));
 int i=0;
 while((ph=br.readLine())!=null){
  line2++;
   
   if(ph.contains("STAR,")&&ph.length()<25){
    Starident[i]=ph; 
     i++;
   }
   
 }


for(int k=0;k<Starident.length;k++ ){
  Stars.add(Starident[k].substring(5,11)); 
   
 }
 }catch(IOException ex){
  ex.printStackTrace();
 }
 
 
 
 
 
 
 duplicates.addAll(Stars);
 Stars.clear();
 Stars.addAll(duplicates);
  Collections.sort(Stars);

int sizeFinal=Stars.size();
 StarsFinal= new String[sizeFinal];
 for(int i=0; i<StarsFinal.length;i++){
   
  StarsFinal[i]=""; 
 }
 
 for(int j=0;j<StarsFinal.length;j++){
  StarsFinal[j]=Stars.get(j); 
   
 }
 for(int j=0;j<StarsFinal.length;j++){
  StarsFinal[j]=StarsFinal[j].replaceAll(",","");
   
 }
 
  
  return StarsFinal;
}
}  
        
    
    
    


