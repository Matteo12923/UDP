/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package clientudp;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 *
 * @author hp
 */
public class ClientUDP {

   DatagramSocket Socket;
    InetAddress IP;
    
    public ClientUDP() {
         try {
             Socket = new DatagramSocket();
             IP = InetAddress.getByName("localhost");
         }
         catch (UnknownHostException e) {
            System.err.println("Errore DNS!");
        } catch (SocketException e) {
            System.err.println("Errore nel socket!");
        }
        
}

public void sendAndReceive() {
    try {

        byte[] inData = new byte[1024];
        
        Dipendente dipendente= new Dipendente("Nome","Cognome",Id);
        
        //Serializzazione: dall'oggetto allo stream di byte
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ObjectOutputStream os = new ObjectOutputStream(outputStream);
        os.writeObject(dipendente);
        
        
        
        byte[] data = outputStream.toByteArray();
        
        //Invio dello stream di byte
        DatagramPacket sendPacket = new DatagramPacket(data, data.length, IP, 5969);
        Socket.send(sendPacket);
        System.out.println("Messaggio per il server");
        
        //Ricezione della risposta
        DatagramPacket inPacket = new DatagramPacket(inData, inData.length);
        Socket.receive(inPacket);
        String risposta = new String(inPacket.getData());
        System.out.println("Risposta dal server: " + risposta);
        Thread.sleep(2000);

        } catch (UnknownHostException e) {
            System.err.println("Errore del DNS");
        } catch (SocketException e) {
            System.err.println("Errore del socket");
        } catch (IOException e) {
            System.err.println("Errore I/O");
        } catch (InterruptedException e) {
            System.err.println("Errore del thread");
    }
}
    public static void main(String[] args) {
        ClientUDP client = new ClientUDP();
        client.sendAndReceive();
    }
    
}
