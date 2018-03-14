package nav;

import java.util.*;
import java.io.*;
import java.nio.*;
import java.lang.*;
  


public class Stars{
  
  private final String STARNAME;
  private final String STARICAO;
  private final List<String> Transitions;
  
  
  public Stars (String StarIcao,String StarName, List<String> trans){
    
   this.STARICAO=StarIcao; 
    this.STARNAME=StarName;
    Transitions=trans;
  
   
  }

  public String getStarIdent(){
   return STARNAME; 
   
  }
  public String getStarIcao(){
   return STARICAO; 
    
  }
  
  public List<String> getTrans(){
   return Transitions; 
  }
  
  
  
}