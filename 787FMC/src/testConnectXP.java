//package gov.nasa.xpc.ex;

import nasaConnect.*;

import java.io.IOException;

/**
 * An example program demonstrating the use of X-PlaneConnect in a continuous loop.
 *
 * @author Jason Watkins
 * @version 1.0
 * @since 2015-06-19
 */
public class testConnectXP
{
    public static void main(String[] args)
    {
      
/**
 * An example program demonstrating the use of X-PlaneConnect in a continuous loop.
 *
 * @author Jason Watkins
 * @version 1.0
 * @since 2015-06-19
 */

        try (XPlaneConnect xpc = new XPlaneConnect())
        {
            int aircraft = 0;
            while(true)
            {
              
                      String posinit="POS INIT";
        
        float[]test=new float[posinit.length()];
        
        for(int i=0;i<posinit.length();i++){
         test[i]=(float)posinit.charAt(i); 
        }
        
      for(float numbers:test){
       System.out.print((char)numbers+","); 
      }
      System.out.println();
      
      xpc.sendDREF("FMC/jLabel48",test);
                
            }
        }
        catch(IOException ex)
        {
            System.out.println("Error:");
            System.out.println(ex.getMessage());
        }
    


        
    }
}
