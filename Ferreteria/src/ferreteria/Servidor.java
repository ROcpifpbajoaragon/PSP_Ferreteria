/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ferreteria;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author juanma
 */
public class Servidor {
    
    public static void main(String[] args) throws IOException, Exception {

    ServerSocket socServidor = new ServerSocket(8066);
    
    Socket socCliente;

    while (true) {
     
      socCliente = socServidor.accept();
      
      ServidorHilo sh = new ServidorHilo(socCliente);
                sh.start();

    }
  }
    }
