package logic;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.*;
import java.util.*;
import java.lang.*;
import java.util.regex.Pattern;
import nav.*;
/**
 *
 * @author omer
 */
public class FMCLogicTest {
  
  
  public String runwaySelected;
    public String SidSelected;
    public String TransSelected;
  
// public static void main(String [] args){
// FMCLogicTest obj1=new FMCLogicTest();
//   Map<Integer,Approaches> appr=obj1.getApprRun("EGLL");
// 
//  }
  
    
  static File file=new File(System.getProperty("user.dir")+"/FMCLogicTest.java");
    
static String currentDir=file.getAbsoluteFile().getParent().substring(0,52);
    
  
   static String filepath=System.getProperty("user.dir") ;
   
      static   File fileScanner=new File(filepath+"/navdata/navdata/PROC");
        
        
         String airportChosenDep="";
String airportChosenArr="";
public void setAirportDep(String x){airportChosenDep=x;}
public String getAirportDep(){return airportChosenDep;}
public void setAirportArr(String x){airportChosenArr=x;}
public String getAirportArr(){return airportChosenArr;}







/****************************
  * 
  * W.I.P METHOD TO PULL APPROACHES FOR RUNWAYS
  * 
  * *********************************/


public Map<Integer,Approaches> getApprRun(String icao){
  
  Map<Integer,Approaches> appr=new LinkedHashMap<>();
  Set<String> names= new TreeSet<>();
  String directory=currentDir+"/navdata/navdata/Proc/"+icao+".txt";
  String line="";
  Integer count=0;
  String [] temp;
  List<String> transitions=new LinkedList<>();
  String[] temp1;
  String name="";
  int i=0;
  try(BufferedReader br=new BufferedReader(new InputStreamReader(new DataInputStream(new FileInputStream(directory))))){
     while((line=br.readLine())!=null){
      temp=splitString(line,',');
      if(temp[0].equals("APPTR")){
        names.add(temp[1]);
      }
  
      
    }
    
  }catch(IOException e){e.printStackTrace();}
  
 
    Iterator iterate=names.iterator();
    
    while(iterate.hasNext()){
      System.out.println(count);
      name=(String)iterate.next();
     try(BufferedReader br=new BufferedReader(new InputStreamReader(new DataInputStream(new FileInputStream(directory))))){
      
    while((line=br.readLine())!=null){
      
      temp=splitString(line,',');
      if(temp[0].equals("APPTR")&&temp[1].equals(name)){
        transitions.add(temp[3]);
      }
    }
   // System.out.println(transitions);
    temp1=transitions.toArray(new String[transitions.size()]);
    
    appr.put(count,new Approaches(name,temp1));
    transitions.clear();
    i++;
    count++;
    }catch(IOException e){e.printStackTrace();}
  }
  
  //appr.forEach((k,v) -> System.out.println("Approach: "+v.getIdent()+" Transitions: "+v.getTrans()[1]));
  
 return appr; 
}










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
     if(((line.contains("SID,")&&line.contains(proc))||(line.contains("STAR,")&&line.contains(proc)))&&line.contains("ALL")==false){
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
 
 
 }catch(IOException ex){}
    String [] temp=airportData.split(",");
    /* for(String next:temp){
   System.out.println(next); 
  }*/
    String []finalData=new String[3];
    finalData[0]=temp[2];
    finalData[1]=temp[3];
    finalData[2]=temp[4];
    
/*  for(String next:finalData){
   System.out.println(next); 
  }*/
    
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

/**********
  * METHOD TO GET RUNWAYS FOR PROCEDURES FROM NAVIGRAPH ARINC 424 DATABASE
  * 
  * **************/

public List<String> getProcstoRunways(String x, String y){
 String icao=x;
 
 String procedure=y;
  String directory=System.getProperty("user.dir")+"/navdata/navdata/PROC/"+icao+".txt";
    
 List<String> procFound=new LinkedList<>();
 
 
 String line;
 try(BufferedReader br = new BufferedReader(new InputStreamReader(new DataInputStream(new FileInputStream(directory))))){
   label1: while((line=br.readLine())!=null){
  
     if(line.contains(procedure)){
       if(line.contains("ALL")){
         procFound.clear();
         procFound=getRunwaysList(icao);
         break label1;
         
       }
       String [] temp=splitString(line,',');
       if(Character.isDigit(temp[2].charAt(0))==true&&Character.isDigit(temp[2].charAt(1))){
       procFound.add(temp[2]);
       }
       }
     }
     
     
     
     
   }
 catch(IOException e){}
 
 return procFound;
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
    splits.add(line.substring(line.lastIndexOf(',')+1,line.length()));

  
  
  return splits.toArray(new String[splits.size()]);
  
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
     String [] temp=splitString(line2,',');
     runwaysFound.add(temp[1]);
    }
    
  }
 }catch(IOException ex){
   
 }
 
   
  
 runways=runwaysFound.toArray(new String[runwaysFound.size()]); 
 
 return runways;
 
 }



/*************
  * 
  * Same Method as above, just returns a list instead of an array. Did this to not deal with unmodifiable lists returned by Arrays class.
  * 
  * **************/
  public List<String> getRunwaysList(String x){
 String icao=x;

 String depSelected=System.getProperty("user.dir")+"/navdata/navdata/Airports.txt";
 
 

 

 
 String line2;
  
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
     String [] temp=splitString(line2,',');
     runwaysFound.add(temp[1]);
    }
    
  }
 }catch(IOException ex){
   
 }
 return runwaysFound;
 
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

public List<String> getSIDS(String icao){

 String depSelected=System.getProperty("user.dir")+"/navdata/navdata/PROC/"+icao+".txt";
 
 
List<String> SIDFinal= new LinkedList<>();

 String buff;
String [] temp;

 try{

  BufferedReader buf = new BufferedReader(new InputStreamReader(new DataInputStream(new FileInputStream(depSelected))));

 while((buff=buf.readLine()) != null){
  temp=splitString(buff,',');
  if(temp[0].equals("SID")){
    if(SIDFinal.contains(temp[1])==false){
     SIDFinal.add(temp[1]); 
    }
  }
 }

 

 }catch(IOException ex){
  ex.printStackTrace();
 }
 

  return SIDFinal;
}
    


/***************
  * 
  * Method to pull Stars from Navigraph Database ARINC 424
  * 
  * **************/




public List<String> getStars(String icao){
 
 List<String> stars = new ArrayList<>();
 String arrSelected=System.getProperty("user.dir")+"/navdata/navdata/PROC/"+icao+".txt";
 
String line;

try(BufferedReader br = new BufferedReader(new InputStreamReader(new DataInputStream(new FileInputStream(arrSelected))))){
  while((line=br.readLine())!=null){
    if(line.contains("STAR,")){
  String [] temp=splitString(line,',');
 // if(Character.isDigit(temp[2].charAt(0))==true&&Character.isDigit(temp[2].charAt(1))==true){
    if(stars.contains(temp[1])==false){
     stars.add(temp[1]); 
    }
 // }
    }
  }
}catch (IOException e){System.out.println("File Not Found");}
double timeEnd=System.nanoTime();

//System.out.println(stars);
  return stars;
  
}
}  
        
    
    
    


