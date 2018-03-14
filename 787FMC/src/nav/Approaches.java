package nav;

import java.util.*;
import java.io.*;


public class Approaches{
 
  private final String NAME;
  private final String [] TRANSITIONS;
  
  
  public Approaches(String name, String [] trans){
  this.NAME=name;
  this.TRANSITIONS=trans;
  
  }
  
  public String getIdent(){
   return this.NAME; 
  }
  public String[] getTrans(){
   return this.TRANSITIONS; 
  }
  
}
