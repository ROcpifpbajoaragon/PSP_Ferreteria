/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ferreteria;

import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author juanma
 */
public class ServidorHilo extends Thread {
   private  Socket socketCliente;
    public ServidorHilo (Socket socketCliente) {
    this.socketCliente = socketCliente;
  }
  public void run() {
    try{
      System.out.println("Atendiendo al cliente ");
     
      socketCliente.close();
      System.out.println("cliente atendido");
      
    } catch (IOException ex) {
    }
  }}
