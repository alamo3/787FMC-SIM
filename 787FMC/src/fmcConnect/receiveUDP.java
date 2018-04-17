import java.io.*;
import java.net.*;

class receiveUDP{
  byte [] receiveData;
  InetAddress udpServer;
  final int PORT;
  
  DatagramSocket receive;
  String received;
  
  receiveUDP(){
    PORT=52000;
    try{
      receiveData= new byte[1024];
      udpServer= InetAddress.getByName("127.0.0.1");
      receive = new DatagramSocket(PORT);
    }catch(SocketException e){e.printStackTrace();}
    catch(UnknownHostException f){f.printStackTrace();}
  }
  
  
  public String receieveString(){
    try{
   DatagramPacket byte1= new DatagramPacket(receiveData,receiveData.length);
   receive.receive(byte1);
   receiveData=byte1.getData();
    }catch(IOException ex){ex.printStackTrace();}
   received = new String(receiveData);
   return received;
   
  }
  
}