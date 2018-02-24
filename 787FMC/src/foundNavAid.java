class foundNavAid implements java.io.Serializable{
  
 
  private final String navAidInfo;
  private final boolean found;
  private final java.util.List<String> data;
  private final static long serialVersionUID=1L;
  
  
  public foundNavAid(String info, boolean found, java.util.List<String> dataNav){
  this.navAidInfo=info;
  this.found=found;
  this.data=dataNav;
  }
  
  
  public String getInfo(){
   return this.navAidInfo; 
  }
  
  
  public boolean getFound(){
  return this.found;
  }
  
  public java.util.List<String> getData(){
   return this.data; 
  }
  
}