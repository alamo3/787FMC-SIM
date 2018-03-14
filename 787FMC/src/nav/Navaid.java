package nav;

import java.lang.*;
import java.util.*;
import java.io.*;
import java.util.Map;

public class Navaid implements Serializable{
 
  private final String navAidIdent;
  private final String navAidType;
  private final String navAidFreq;
  private final String navAidLat;
  private final String navAidLong;
  private final String navAidName;
  
  private static final long serialVersionUID=1L;
  
  public Navaid(String localname, String name, String type, String freq, String lat, String longitude){
  
  this.navAidName=localname;
  this.navAidIdent=name;
  this.navAidType=type;
  this.navAidFreq=freq;
  this.navAidLat=lat;
  this.navAidLong=longitude;
  
  
  }
  
  
  public String getIdent(){
   return this.navAidIdent; 
    
  }
  
  public String getType(){
   return this.navAidType; 
  }
  
  public String getFreq(){
   return this.navAidFreq; 
  }
  public String getLatitude(){
   return this.navAidLat; 
  }
  public String getLongitude(){
   return this.navAidLong; 
    
  }
  public String getName(){
   return this.navAidName; 
  }
  
  
  
  
  
  
  @Override
  public boolean equals(Object o){
  
    String ident=((Navaid)o).getName();
    String name=((Navaid)o).getIdent();
    String type=((Navaid)o).getType();
    String lat =((Navaid)o).getLatitude();
    String longitude=((Navaid)o).getLongitude();
    String frequency =((Navaid) o).getFreq();
    if(((name).equals(this.navAidIdent))&&((type).equals(this.navAidType))&&((lat).equals(this.navAidLat))&&((longitude).equals(this.navAidLong))&&(frequency.equals(this.navAidFreq))&&((ident).equals(this.navAidName))){
     return true; 
    }else {
     return false; 
    }
   
    
  }
  
 
  
  @Override
  public int hashCode(){
   return navAidIdent.hashCode()+45; 
  }
    

  
    
  
  
  
  
}