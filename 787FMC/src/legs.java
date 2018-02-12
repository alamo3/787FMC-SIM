import java.io.*;
import java.util.*;
import java.lang.*;


class legs extends WaypoimtAccess{
  
  
  String legName;
  String latitude;
  String longitude;
  String distanceFromLast;
  String bearingFromLast;
  String altRestr;

  //CONSTRUCTOR

    public legs(String legName, String latitude, String longitude, String distanceFromLast, String bearingFromLast, String altRestr) {
        this.legName = legName;
        this.latitude = latitude;
        this.longitude = longitude;
        this.distanceFromLast = distanceFromLast;
        this.bearingFromLast = bearingFromLast;
        this.altRestr=altRestr;


    }

    //GET SET METHODS
    public String getaltRestr(){
     return altRestr; 
    }
    
    public String getLegName() {
        return legName;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public String getDistanceFromLast() {
        return distanceFromLast;
    }

    public String getBearingFromLast() {
        return bearingFromLast;
    }

    public void setLegName(String legName) {
        this.legName = legName;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public void setDistanceFromLast(String distanceFromLast) {
        this.distanceFromLast = distanceFromLast;
    }

    public void setBearingFromLast(String bearingFromLast) {
        this.bearingFromLast = bearingFromLast;
    }
}