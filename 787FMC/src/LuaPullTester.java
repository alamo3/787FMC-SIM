import java.io.*;
import java.util.*;
import java.lang.*;
class LuaPullTester{
  public static void main(String[]args){
    
    
   String line;
   int num=0;
   String textLua="";
   String filepath="C:/Users/omer/Desktop/787 FMC Java/SASLFree/data/components/interactive.lua";
   String getLine="";
   List<String> fileText=new ArrayList<String>();
    try{
   BufferedReader br = new BufferedReader(new InputStreamReader(new DataInputStream(new FileInputStream(filepath))));
   while((line=br.readLine())!=null){
   fileText.add(line);
   
   }
    }catch(IOException e){
  System.out.println("File Not Found");
  
    }
  
    for(int i=0;i<fileText.size();i++){
     System.out.println(fileText.get(i)); 
  
    }
  
  }
}