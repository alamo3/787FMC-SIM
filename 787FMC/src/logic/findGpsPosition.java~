/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author omer
 */

import java.io.*;
import java.util.*;
import java.lang.*;
import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import java.io.File;
import java.io.IOException;

import java.net.*;





public class findGpsPosition {
  
 
  
    String currentip="";
    public void getIP(){

try
        {
            URL url_name = new URL("http://bot.whatismyipaddress.com");
 
            BufferedReader sc =
            new BufferedReader(new InputStreamReader(url_name.openStream()));
 
            // reads system IPAddress
            currentip = sc.readLine().trim();
        }catch (Exception ex){}
//System.out.println(currentip);
}
    
   /* public String[] getLocation() throws GeoIp2Exception {
        getIP();
        String dblocation="GeoLiteCity.dat";
        File db=new File("GeoLiteCity.dat");
        String[] coords=new String[2];
                try{
DatabaseReader reader = new DatabaseReader.Builder(db).build();
 
InetAddress ipAddressGet = InetAddress.getByName("128.101.101.101");
CityResponse response = reader.city(ipAddressGet);
Location location = response.getLocation();

System.out.println(location.getLatitude());

coords[0]=Double.toString(location.getLatitude());
coords[1]=Double.toString(location.getLongitude());
                }catch(IOException ex){}
                
 
return coords;
  }*/
    
    public String[] getLatLongIP(){
      getIP();
       String data="";
      try
        {
           Document doc = Jsoup.connect("http://www.infosniper.net").get();
            data = doc.body().text();
        }catch (Exception ex){}
       
       boolean takeChar=false;
       
       String [] myArray=new String[2];
       char [] stringToArray= data.toCharArray();
      
      
       myArray[0]="";
         for(int i=734;i<741;i++){
            
         myArray[0]=myArray[0] + data.charAt(i);
         }
         
         
        
        myArray[1]="";
         for(int i=849;i<857;i++){
           
         myArray[1]=myArray[1] + data.charAt(i);
         }
   
      
      return myArray;
    }
    

    
    
}

    

