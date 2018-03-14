class Waypoints implements java.io.Serializable{
  
  
 private final String name;
 private final String latitude;
 private final String longitude;
 
 private final static long serialVersionUID=1L;
 
 
 
 public Waypoints(String name, String latitude, String longitude){
  this.name=name;
  this.latitude=latitude;
  this.longitude=longitude;
   
 }
  
 
 public String getName(){
  return this.name; 
   
 }
 public String getLatitude(){
  return this.latitude; 
   
 }
  
 public String getLongitude(){
  return this.longitude; 
 }
 
 
 @Override
 public boolean equals(Object o){
  String name=((Waypoints)o).getName();
  String latitude=((Waypoints)o).getLatitude();
  String longitude=((Waypoints)o).getLongitude();
  
  if(this.name.equals(name)&&this.latitude.equals(latitude)&&this.longitude.equals(longitude)){
   return true; 
  }else{
   return false; 
  }
   
 }
 
 @Override
 public int hashCode(){
  return this.name.hashCode()+23; 
 }
 
  
}