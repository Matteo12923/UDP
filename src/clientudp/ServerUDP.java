/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clientudp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 *
 * @author hp
 */
public class ServerUDP {
    
    
    DatagramSocket socket = null;
    
    public UDPServer() {
        try {
        socket = new DatagramSocket(1789);
        } catch (SocketException e) {
            System.err.println("Errore nel socket!");
    }
    
    public void InviaRicevi{
    try{

byte[] InData =new byte[2048];
while(true){

DatagramPacket inPacket = new DatagramPacket(InData, InData.length);
            socket.receive(inPacket);
            
            byte[] data =new inPacket.getData();

}


} catch (SocketException e) {
        System.err.println("Errore nel socket!");
    } catch (IOException i) {
        System.err.println("Errore di I/O!");
    } catch (InterruptedException e) {
        System.err.println("Errore nel thread sleeping!");
    }
    
    
}
    public static void main(String[] args) {
        // TODO code application logic here
    }
}

 