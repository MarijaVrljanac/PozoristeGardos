/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads;

import java.net.ServerSocket;
import java.net.Socket;


/**
 *
 * @author Cartman
 */
public class ServerThread extends Thread{
     private ServerSocket serverSocket;

    public ServerThread() {
        try {
            serverSocket = new ServerSocket(9000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            while (!isInterrupted()) {
                Socket socket = serverSocket.accept();
                System.out.println("Klijent je povezan!");
                ObradaKlijentskogZahtevaNit nit = new ObradaKlijentskogZahtevaNit(socket);
                nit.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
}
