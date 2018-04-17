package fmcConnect;

import nasaConnect.*;

public class panelState{
  
  String data="";
  
  
  
  public static float[] convert(String data){
   float [] result = new float[data.length()];
   
   char[] temp = data.toCharArray();
   
   for(int i=0;i<data.length();i++){
     result[i]=(float)data.charAt(i);
   }
  return result;
  }
  public void display(){
    
  }
  public void performAction(String button){
    
  }
  
  public void recPosInit(panelState obj1){
    
  }
}