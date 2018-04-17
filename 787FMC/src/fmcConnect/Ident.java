package fmcConnect;

import java.io.*;
import nasaConnect.*;
import logic.*;
import nav.*;


public class Ident extends panelState{
  
  
//  public static void main(String args[]){
//  Ident test=new Ident();
//  test.display();
//  }
  panelState PosInit;
  
  @Override
  public void recPosInit(panelState obj1){
    PosInit=obj1;
  }
  
  
  static String title="IDENT";
  static String line1A="MODEL";
  static String line1B="787-9";
  static String line2A="NAVDATA";
  static String line2B="NAVIGRAPH 1801";
  static String line3A=" ";
  static String line3B=" ";
  static String line4A="OP PROGRAM";
  static String line4B="OPO2018";
  static String line5A=" ";
  static String line5B=" ";
  static String line6="< INDEX";
  static String line7A="ENG RATING";
  static String line7B="GENX 1B-64";
  static String line8A="ACTIVE";
  static String line8B="JAN01FEB01/18";
  static String line9A=" ";
  static String line9B=" ";
  static String line10A=" ";
  static String line10B=" ";
  static String line11A="DRAG/FF";
  static String line11B="+0.0/0.0";
  static String line12="POS INIT >";
  
  public void display(){
    
    try(XPlaneConnect xpc=new XPlaneConnect("127.0.0.1",49009,49000,100)){
    
      xpc.sendDREF("jLabel48",super.convert(title));
      xpc.sendDREF("jLabel51",super.convert(line1A));
      xpc.sendDREF("jLabel52",super.convert(line1B));
      xpc.sendDREF("jLabel49",super.convert(line2A));
      xpc.sendDREF("jLabel50",super.convert(line2B));
      xpc.sendDREF("jLabel54",super.convert(line3A));
      xpc.sendDREF("jLabel53",super.convert(line3B));
      xpc.sendDREF("jLabel55",super.convert(line4A));
      xpc.sendDREF("jLabel56",super.convert(line4B));
      xpc.sendDREF("jLabel58",super.convert(line5A));
      xpc.sendDREF("jLabel59",super.convert(line5B));
      xpc.sendDREF("Jlabel60",super.convert(line6));
      xpc.sendDREF("jLabel61",super.convert(line7A));
      xpc.sendDREF("jLabel62",super.convert(line7B));
      xpc.sendDREF("jLabel63",super.convert(line8A));
      xpc.sendDREF("jLabel64",super.convert(line8B));
      xpc.sendDREF("jLabel65",super.convert(line9A));
      xpc.sendDREF("jLabel66",super.convert(line9B));
      xpc.sendDREF("jLabel67",super.convert(line10A));
      xpc.sendDREF("jLabel68",super.convert(line10B));
      xpc.sendDREF("jLabel69",super.convert(line11A));
      xpc.sendDREF("jLabel70",super.convert(line11B));
      xpc.sendDREF("jLabel57",super.convert(line12));
      
      
    }catch(IOException ex){
      System.out.println("Error:");
System.out.println(ex.getMessage()); 
    }
  }
  
  @Override 
  public void performAction(String button){
    switch(button){
      case "Right6":
        PosInit.display();
        try(XPlaneConnect xpc = new XPlaneConnect("127.0.0.1",49000,49010,100)){
         xpc.sendDREF("panelstate",super.convert("posinit")); 
         System.out.println("Ident Action Complete");
        }catch(IOException ex){
         System.out.println("Ident :" +ex.getMessage()); 
        }
        break;
    }
  }
  
  
}