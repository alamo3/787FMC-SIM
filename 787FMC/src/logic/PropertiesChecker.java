package logic;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;
import java.io.*;
/**
 *
 * @author newlife network
 */
public class PropertiesChecker {
    public Properties panel=new Properties();
    
    public void writeProperty(String propertyName, String propertyValue){
        try{
        panel.setProperty(propertyName, propertyValue);
        panel.store(new FileOutputStream("panelpage.properties"),null);
        }catch(IOException e){}
        
        }
    
    
    public void writePanelState(String panelState){ 
        try{
        panel.setProperty("panelstate", panelState);
        panel.store(new FileOutputStream("panelPage.properties"), null);
        }catch(IOException e){
            
            
        }
    
    
    }
        public void writeICAO(String icao){ 
        try{
        panel.setProperty("ICAO", icao);
        panel.store(new FileOutputStream("panelPage.properties"), null);
        }catch(IOException e){
            
            
        }
    
    
    }
        
         public void writeSID(String Sid){ 
        try{
        panel.setProperty("SID", Sid);
        panel.store(new FileOutputStream("panelPage.properties"), null);
        }catch(IOException e){
            
            
        }
    
    
    }
         
         
          public void writeRwy(String rwy){ 
        try{
        panel.setProperty("Runway", rwy);
        panel.store(new FileOutputStream("panelPage.properties"), null);
        }catch(IOException e){
            
            
        }
    
    
    }
        
    public String retrieveProperty(String x){
         String property=x;
         String propertyDef="";
        try{
            panel.load(new FileInputStream("panelpage.properties"));
             propertyDef=panel.getProperty(property);
            
        }catch(IOException ex){
            
        }
        return propertyDef;
    }

}
