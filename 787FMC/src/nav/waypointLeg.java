package nav;

import java.util.*;
import java.io.*;


public class waypointLeg{
  
  
  private final String IDENT;
  private final double DFL;
  private final double BFL;
  private final Integer AR;
  private final Integer SA;
  
  public waypointLeg(String a,double b, double c, int d, int e){
  IDENT=a;
  DFL=b;
  BFL=c;
  AR=d;
  SA=e;
  }
  
  
  public String getName(){
   return this.IDENT; 
  }
  public double getDFL(){
   return this.DFL; 
    
  }
  
  public double getBFL(){
   return this.BFL; 
  }
  
  
  public int getAR(){
   return this.AR; 
  }
  
  public String getARString(){
   return this.AR.toString(); 
  }
  
  public int getSA(){
   return this.SA; 
  }
  
  public String getSAString(){
   return this.SA.toString(); 
  }
  
  
}



