package nav;

import java.io.*;
import java.util.*;
import java.lang.*;

public class waypointsAirway implements java.io.Serializable{
  
  
 private final String wptName;
private final  String latitude;
 private final String longitude;
  
  
  private long serialVersionUID;
  
  public waypointsAirway(String wptName, String latitude, String longitude){
  this.wptName=wptName;
  this.latitude=latitude;
  this.longitude=longitude;
  
  }
  
  
  //GETSET() METHODS
  
  
  public String getWptName(){
    
   return this.wptName; 
    
  }
  
  public String getLatitude(){
    
   return this.latitude; 
  }
  
  public String getLongitude(){
    
   return this.longitude; 
  }
}