import org.cutre.soft.ExtPlaneInterface;


class testConnectXP{
  
  
  public static void main(String args[]){
  
  ExtPlaneInterface iface = new ExtPlaneInterface("localhost", 51000);
  try{
iface.start();
iface.includeDataRef("sim/aircraft/view/acf_author");
iface.includeDataRef("sim/cockpit/electrical/battery_on");

String [] test=iface.getDataRefValue("sim/cockpit/electrical/battery_on");

    for(String next: test){
     System.out.println(next); 
    }

  }catch(Exception e){}
  
  }
  
  
}