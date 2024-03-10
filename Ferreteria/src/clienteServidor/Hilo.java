/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clienteServidor;

import java.io.IOException;
import java.net.Socket;
import tienda.Tienda;
import java.util.List;

/**
 *
 * @author juanma
 */
public class Hilo extends Thread {
    private  Socket socketCliente;
    private Tienda tienda;
    
    public Hilo(Socket socketCliente, Tienda tienda) {
    this.socketCliente = socketCliente;
    this.tienda = tienda;
  }
  public void run() {
    try{
      System.out.println("Atendiendo al cliente HILO ");
      String datos = tienda.obtenerDatosInventario();
      System.out.println(datos);
      Servidor.enviarMensaje(socketCliente, datos);
      Servidor.recibirMensaje(socketCliente);
      //CREAR UN BUCLE DE RECIBIR MENSAJES HASTA QUE EL MENSAJE RECIBIDO SEA = SALIR equalsIgnoreCase
      socketCliente.close();
      System.out.println("cliente atendido");
      
    } catch (IOException ex) {
    }
  }
}
