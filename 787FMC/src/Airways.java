import java.util.*;
import java.lang.*;

public class Airways implements java.io.Serializable{
  
  
 private final String AIRWAYIDENT;
 private final Map<String,waypointsAirway>waypoints;
 private final List<String> latLongBegin;
 private long serialVersionUID;
  
  
 public Airways(String ident,Map<String,waypointsAirway> waypoints2, List<String> latlong){ 
  this.AIRWAYIDENT=ident;
  this.waypoints=waypoints2;
  latLongBegin=latlong;
 }
  
 public String getAirwayIdent(){
   return AIRWAYIDENT;
 }
  
 
 public Map<String,waypointsAirway> getWaypoints(){
  return waypoints; 
   
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