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
    
    public void writePanelState(String panelState){ 
        try{
        panel.setProperty("panelstate", panelState);
        panel.store(new FileOutputStream("panelPage.properties"), null);
        }catch(IOException e){
            
            
        }
    
    
    }
    public String retrievePanelState(){
         String panelState="";
        try{
            panel.load(new FileInputStream("panelpage.properties"));
             panelState=panel.getProperty("panelstate");
            
        }catch(IOException ex){
            
        }
        return panelState;
    }

}
