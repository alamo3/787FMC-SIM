package fmcConnect;
import java.io.*;
import nasaConnect.*;

public class testConnect{
  public static void main(String args[]){
   try(XPlaneConnect xpc = new XPlaneConnect("127.0.0.1",49009,49001,100000)){
       
        commandRecieve=convertS(xpc.getDREF("fmcCommand"));
        panelState1=convertS(xpc.getDREF("panelstate"));
        
        
       
        System.out.println("Command : "+commandRecieve);
        System.out.println("panelstate : "+panelstate1);


        
      }catch(IOException ex){
        System.out.println("Controller :"+ex.getMessage()); 
       System.out.println("Controller Exiting"); 
      }
  }
  
  
  public static float[] convert(String data){
   float [] result = new float[data.length()];
   
   char[] temp = data.toCharArray();
   
   for(int i=0;i<data.length();i++){
     result[i]=(float)data.charAt(i);
   }
  return result;
  }
  
  
  
  public static String convertS(float [] data){
   String temp="";
   for(int i=0;i<data.length;i++){
    temp=temp+(char)data[i];
   }
   return temp;
    
  }
  
}