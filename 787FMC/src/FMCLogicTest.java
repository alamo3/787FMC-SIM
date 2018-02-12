/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.*;
import java.util.*;
import java.lang.*;
/**
 *
 * @author omer
 */
public class FMCLogicTest {
  
  
  public String runwaySelected;
    public String SidSelected;
    public String TransSelected;
  
 /*public static void main(String [] args){
   FMCLogicTest obj1=new FMCLogicTest(); 
    List<String> new1=obj1.getTransition("CYYZ","AVSEP3");
  }*/
  
  
   public String filepath=System.getProperty("user.dir") ;
        File fileScanner=new File(filepath+"/navdata/navdata/PROC");
        
        
         String airportChosenDep="";
String airportChosenArr="";
public void setAirportDep(String x){airportChosenDep=x;}
public String getAirportDep(){return airportChosenDep;}
public void setAirportArr(String x){airportChosenArr=x;}
public String getAirportArr(){return airportChosenArr;}


/************************
  * 
  * Method to pull transitions for a Sid / STAR from NAVIGRAPH ARINC 424 DB
  * 
  * 
  * *******************/

public List<String> getTransition(String x, String y){
 List<String> transitions=new ArrayList<>(); 
String icao=x;  
 String proc=y;
 
 String line;
 
 try{
   BufferedReader br=new BufferedReader(new InputStreamReader(new DataInputStream(new FileInputStream(System.getProperty("user.dir")+"/navdata/navdata/PROC/"+icao+".txt"))));
   
   while((line=br.readLine())!=null){
     if((line.contains("SID,")&&line.contains(proc))||(line.contains("STAR,")&&line.contains(proc))){
      transitions.add(line); 
       
       
     }
   
     
   }
 }catch(IOException e){}
  String [] temp=transitions.stream().toArray(String []::new);
  List<String> transFinal=new ArrayList<>();
  for(int i=0; i<temp.length;i++){
    String [] temp1=temp[i].split(",");
    
    if(Character.isDigit(temp1[2].charAt(0))==false&&Character.isDigit(temp1[2].charAt(1))==false){
      transFinal.add(temp1[2]);
    }
    
  }
  
 
  
  
  
  return transFinal;
}

/*************************
  * 
  * Method to pull Airport Location from Navigraph ARINC 424 DB
  * 
  * **********************/

public String[] getAirportLatLong(String x){
 String airportData="";
       String  icao=x;
       String line;
 try{
 BufferedReader br= new BufferedReader(new InputStreamReader(new DataInputStream(new FileInputStream(System.getProperty("user.dir")+"/navdata/navdata/Airports.txt"))));
 while((line=br.readLine())!=null){
     
     if(line.contains(","+icao+",")){
     airportData=line;
     break;
     }
     
 }
 
 
 System.out.println(airportData);
 }catch(IOException ex){}
    String [] temp=airportData.split(",");
     for(String next:temp){
   System.out.println(next); 
  }
    String []finalData=new String[3];
    finalData[0]=temp[2];
    finalData[1]=temp[3];
    finalData[2]=temp[4];
    
  for(String next:finalData){
   System.out.println(next); 
  }
    
    return finalData;
}
/***************
  * Method to pull All Airports in the world recognized by an ICAO Code 
  * From Navigraph ARINC 424 DB
  * *****************/

public String[] getAirports(){
 String [] airports = fileScanner.list();
 for(int i=0; i<airports.length;i++){
  airports[i]=airports[i].substring(0,4); 
 }
 
 
 
 
         return airports;
}

///////////////////////////////////////////////////////////////////////////////////////////////////////////////

public List<String> getProcstoRunways(String x, String y){
 String icao=x;
 
 String procedure=y;
  String directory=System.getProperty("user.dir")+"/navdata/navdata/PROC/"+icao+".txt";
    
 List<String> procFound=new LinkedList<>();
 
 
 String line;
 try(BufferedReader br = new BufferedReader(new InputStreamReader(new DataInputStream(new FileInputStream(directory))))){
   while((line=br.readLine())!=null){
  
     if(line.contains(procedure)){
       String [] temp=line.split(","); 
       if(Character.isDigit(temp[2].charAt(0))==true&&Character.isDigit(temp[2].charAt(1))){
       procFound.add(temp[2]);
       }
       }
     }
     
     
     
     
   }
 catch(IOException e){}
 
 return procFound;
}

public List<String> getRunwaystoSids(String x, String y){
    
    String icao=x;
    String runway=y;
    String departure=System.getProperty("user.dir")+"/navdata/navdata/PROC/"+icao+".txt";
    
    List<String> ProcFound= new ArrayList<>();
    String line;
    try{
     BufferedReader br=new BufferedReader(new InputStreamReader(new DataInputStream(new FileInputStream(departure))));   
        
     while((line=br.readLine())!=null){
      if((line.contains("SID,")&&line.contains(runway))||(line.contains("STAR,")&&line.contains(runway))){   
       ProcFound.add(line);  
         
      }
         
         
     }
    
     
     
    }catch(IOException e){}
     List<String> finalProcs=new ArrayList<>();
     
   
     for(int i=0; i<ProcFound.size();i++){
         String [] temp=ProcFound.get(i).split(",");
         finalProcs.add(temp[1]);
         
     }
    
    
    return finalProcs;
}

/***********
  * 
  * Method to pull Runways for an aiport from Navigraph ARINC 424
  * 
  * *************/
public String[] getRunways(String x){
 String icao=x;
 String [] runways;
  String[] sids;
 String depSelected=System.getProperty("user.dir")+"/navdata/navdata/Airports.txt";
 
 

 

 
 String line2;
  String ph;
  List<String> runwaysFound=new ArrayList<String>();
 
 //Set<String> duplicates=new HashSet<>();
 //String[] Sidident;
// List<String> StringSplits=new ArrayList<String>();
 
 try{
boolean takeInput=false;
  BufferedReader buf = new BufferedReader(new InputStreamReader(new DataInputStream(new FileInputStream(depSelected))));

  while((line2=buf.readLine())!=null){
    if(line2.contains(icao)){
     takeInput=true; 
    }
    if(takeInput==true&&line2.isEmpty()){
     takeInput=false; 
    }
    
    if(takeInput==true&&line2.startsWith("R,")){
     String [] temp=line2.split(",");
     runwaysFound.add(temp[1]);
    }
    
  }
 }catch(IOException ex){
   
 }
 
   
  
 runways=runwaysFound.toArray(new String[runwaysFound.size()]); 
 
 return runways;
 
 }
  
  
  /******************************
*
*Method to check if inputted Airport exists or not. Pulls Data from ARINC 424 Database
* 
* *********************************/

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




/**************
  * 
  * Method to pull All SIDS from a Navigraph ARINC 424 DB
  * 
  * ********************/

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
    


/***************
  * 
  * Method to pull Stars from Navigraph Database ARINC 424
  * 
  * **************/




public List<String> getStars(String icao){
  double timeCheck= System.nanoTime();
 List<String> stars = new ArrayList<>();
 String arrSelected=System.getProperty("user.dir")+"/navdata/navdata/PROC/"+icao+".txt";
 
String line;

try(BufferedReader br = new BufferedReader(new InputStreamReader(new DataInputStream(new FileInputStream(arrSelected))))){
  while((line=br.readLine())!=null){
    if(line.contains("STAR,")){
  String [] temp=line.split(",");
 // if(Character.isDigit(temp[2].charAt(0))==true&&Character.isDigit(temp[2].charAt(1))==true){
    if(stars.contains(temp[1])==false){
     stars.add(temp[1]); 
    }
 // }
    }
  }
}catch (IOException e){System.out.println("File Not Found");}
double timeEnd=System.nanoTime();
double timeTotal=(timeEnd-timeCheck)/1000000;
System.out.println(timeTotal);
//System.out.println(stars);
  return stars;
  
}
}  
        
    
    
    


