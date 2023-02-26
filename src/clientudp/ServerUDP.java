/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clientudp;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 *
 * @author hp
 */
public class ServerUDP {
    
    
  DatagramSocket socket = null;

    public ServerUDP() {
        try {
        socket = new DatagramSocket(1789);
        } catch (SocketException e) {
            System.err.println("Errore nel socket!");
    }
}

public void sendAndReceive() {
    try {
        byte[] incomingData = new byte[1024];

        while (true) {
            
            //Ricezione dello stream di byte
            DatagramPacket incomingPacket = new DatagramPacket(incomingData, incomingData.length);
            socket.receive(incomingPacket);
            
            byte[] data = incomingPacket.getData();
            
            //Deserializzazione: dallo stream di byte all'oggetto
            ByteArrayInputStream in = new ByteArrayInputStream(data);
            ObjectInputStream is = new ObjectInputStream(in);
            
            try {
                Dipendente dipendente = (Dipendente) is.readObject();
                System.out.println("Dal client Dipendente;" + dipendente);
            } catch (ClassNotFoundException e) {
                System.err.println("La classe dipendenre non esiste");
            }
        
            //Recupero dei dati del mittente
            InetAddress IPAddress = incomingPacket.getAddress();
            int port = incomingPacket.getPort();
            
            //Invio della risposta
            String risposta = "il messaggio è stato ricevuto";
            byte[] replyByte = risposta.getBytes();
            DatagramPacket replyPacket = new DatagramPacket(replyByte, replyByte.length, IPAddress, port);
            socket.send(replyPacket);
            
            Thread.sleep(1000);
            
           
    }

    } catch (SocketException e) {
        System.err.println("Errore del socket");
    } catch (IOException i) {
        System.err.println("Errore I/O");
    } catch (InterruptedException e) {
        System.err.println("Errore nel thread");
    }
}
    public static void main(String[] args) {
          ServerUDP server = new ServerUDP();
        server.sendAndReceive();
    }
}

 