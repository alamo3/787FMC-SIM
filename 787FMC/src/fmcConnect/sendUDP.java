package fmcConnect;


import java.net.*;
import java.io.*;

class sendUDP{
  
 byte [] sendData;
 InetAddress udpServer;
  final int  PORT;
 DatagramSocket sendSocket;
 
 sendUDP(){
    sendData = new byte[1024];
    try{
    udpServer = InetAddress.getByName("127.0.0.1");
    }catch(UnknownHostException ex){ex.printStackTrace();}
    PORT=52000;
    try{
    sendSocket = new DatagramSocket(PORT);
    }catch(SocketException ex){ex.printStackTrace();}
 }
 
 public void sendString(String data){
   try{
   sendData= data.getBytes();
  DatagramPacket packet = new DatagramPacket(sendData,sendData.length,udpServer,PORT);
  sendSocket.send(packet);
   }catch(IOException ex){ex.printStackTrace();}
 }
 
 
 
}