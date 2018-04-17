package fmcConnect;
import java.io.*;
import java.io.*;
import java.net.*;
  import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;

import java.util.*;
class UDPServer
{
   public static void main(String args[]) throws Exception
      {
     boolean quit=false;
       DatagramSocket serverSocket = new DatagramSocket(52005);
       InetAddress IPAddress = InetAddress.getByName("127.0.0.1");
     while(quit==false){
     Scanner in= new Scanner(System.in);
       
            byte[] receiveData = new byte[1024];
            byte[] receiveData2= new byte[1024];
            byte[] sendData = new byte[1024];
 
                  sendData = "returnCommand".getBytes();
                  DatagramPacket sendPacket =
                  new DatagramPacket(sendData, sendData.length, IPAddress, 52000);
                  serverSocket.send(sendPacket);
                  DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                   serverSocket.receive(receivePacket);
                  byte [] data=receivePacket.getData();
                  if(data.length==0){
                   System.out.println("Empty response recieved, Closing Connection");
                   quit=true;
                  }
                  String s = new String(receiveData);
                  s=s.substring(0,s.indexOf(' '));
                  System.out.println("Command: "+s);
                  serverSocket.receive(receivePacket);
                  byte [] data1=receivePacket.getData();
                  if(data.length==0){
                   System.out.println("Empty response recieved, Closing Connection");
                   quit=true;
                  }
                  s = new String(receiveData);
                  s=s.substring(0,s.indexOf(' '));
                  System.out.println("State: "+s);
                  
                  try{
                   Thread.sleep(10); 
                  }catch(Exception e){}
     }
      }
}