import java.util.*;
import java.lang.*;

public class Airways implements java.io.Serializable{
  
  
 private final String AIRWAYIDENT;
 private final Map<String,waypointsAirway>waypoints;
 private final String latitude;
 private final String longitude;
 private long serialVersionUID;
  
  
 public Airways(String ident,Map<String,waypointsAirway> waypoints2, String latitude, String longitude){ 
  this.AIRWAYIDENT=ident;
  this.waypoints=waypoints2;
  this.latitude=latitude;
  this.longitude=longitude;
 }
  
 public String getAirwayIdent(){
   return AIRWAYIDENT;
 }
  
 
 public Map<String,waypointsAirway> getWaypoints(){
  return waypoints; 
   
 }
 
 public String [] getLocation(){
   String [] temp=new String[2];
   temp[0]=latitude;
   temp[1]=longitude;
   return temp;
 }
 
 
@Override
public boolean equals(Object obj){
   if(obj==this){
    return true;
   }
   if((obj==null)|| (obj.getClass()!=this.getClass())){
    return false; 
   }
   
   String objName=((Airways) obj).getAirwayIdent();
   
   return this.AIRWAYIDENT.equals(objName);
   
 }

@Override

  public int hashCode(){
  
 return this.AIRWAYIDENT.hashCode()+32; 
}
  
}