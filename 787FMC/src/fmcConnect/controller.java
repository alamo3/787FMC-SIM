package fmcConnect;

import logic.*;
import nav.*;
import java.io.*;
import nasaConnect.*;
import java.util.*;
import org.apache.commons.collections4.map.*;
import org.apache.commons.collections4.keyvalue.*;
import java.lang.*;
import java.net.*;
import com.google.common.collect.*;


public class controller{
 
  public static PropertiesChecker prop = new PropertiesChecker();
  public static FMCLogicTest accessLogic=new FMCLogicTest();
  public static WaypoimtAccess navDataPull=new WaypoimtAccess();
 
  public static panelState PosInit=new PosInit();
   public static panelState Ident= new Ident();
  public static Left1 Left1=new Left1();
  public static Right6 Right6 = new Right6();
  
  static String commandRecieve="";
   static String panelState1="";
   
  static  panelState current=null;
  public static void main(String args[]){
    Ident.recPosInit(PosInit);
   
    
    
    label1:  while(true){
      try(XPlaneConnect xpc = new XPlaneConnect("127.0.0.1",49009,49001,100)){
        while(true){
        commandRecieve=convertS(xpc.getDREF("fmcCommand"));
        panelState1=convertS(xpc.getDREF("panelstate"));
       System.out.println("Command : " +commandRecieve);
       System.out.println("panelState : "+panelState1);
        
        
        switch(panelState1){
          case "ident" : current = Ident;
          break;
        }
        
        if(commandRecieve.equals("button6R")){
          Right6.performAction(current, panelState1);
          xpc.sendDREF("fmcCommand",convert("noAction"));
          System.out.println("done");
        }
//        System.out.println("Running");
        try{
          Thread.sleep(1000);
        }catch(InterruptedException e){}
        }
      }catch(IOException ex){
        System.out.println("Controller :"+ex.getMessage()); 
       System.out.println("Controller Exiting"); break label1;
      }
    }
      System.out.println("Controller Exiting");
    
    
    
  
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