import java.util.*;
import java.io.*;
import java.nio.*;
import java.lang.*;
  


class Stars{
  
  private final String STARNAME;
  private final String STARICAO;
  private final List<String> Transitions;
  private final List<String> RunwaysAvail;
  
  public Stars (String StarIcao,String StarName, List<String> trans, List<String> runways){
    
   this.STARICAO=StarIcao; 
    this.STARNAME=StarName;
    Transitions=trans;
   RunwaysAvail=runways;
   
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
  
  public List<String> getRunways(){
   return RunwaysAvail; 
  }
  
}