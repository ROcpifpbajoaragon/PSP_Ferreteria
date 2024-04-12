/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clienteServidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import tienda.Tienda;
import java.util.List;

/**
 *
 * @author juanma
 */
public class Hilo extends Thread {

    private Socket socket;
    private Tienda t1;

    public Hilo(Socket socketCliente, Tienda tienda) {
        this.socket = socketCliente;
        this.t1 = tienda;
    }

    public void run() {
        try {
            System.out.println("Atendiendo al cliente desde un Hilo ");

            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter enviarMensaje = new PrintWriter(socket.getOutputStream(), true);
            String recibido;
            int cantidad;
            

            do {

                boolean herramienta = false;
                boolean compra = false;

                do {
                    enviarMensaje(enviarMensaje, t1.infoInventario() + " Escribe la herramienta que desee comprar: ");
                    recibido = recibirMensaje(reader);
                    herramienta = t1.validarProducto(recibido);
                    if (herramienta == true) {
                        enviarMensaje(enviarMensaje, "OK");
                    } else {
                        enviarMensaje(enviarMensaje, "Esa herramienta no se encuentra en la lista");
                    }

                } while (herramienta != true);

                do {
                    enviarMensaje(enviarMensaje, "Que cantidad quieres comprar?");
                    cantidad = recibirCantidad(reader);
                    compra = t1.realizarCompra(recibido, cantidad);
                    if (compra == true) {
                        enviarMensaje(enviarMensaje, "Pedido realizado");
                    } else {
                        enviarMensaje(enviarMensaje, "Pedido no realizado, cantidades incorrectas");
                    }
                } while (compra != true);

            } while (!recibido.equalsIgnoreCase("salir"));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static String recibirMensaje(BufferedReader reader) {
        String mensaje = null;
        try {
            mensaje = reader.readLine(); // Lee el mensaje del cliente
            System.out.println("Mensaje recibido del cliente: " + mensaje); // Imprime el mensaje recibido

        } catch (IOException e) {
            e.printStackTrace();
        }

        return mensaje;
    }

    public static int recibirCantidad(BufferedReader reader) {
        int cantidad = 0;
        try {
            cantidad = Integer.parseInt(reader.readLine());
            System.out.println("Mensaje recibido del cliente: " + cantidad); // Imprime el mensaje recibido

        } catch (IOException e) {
            e.printStackTrace();
        }

        return cantidad;
    }

    public static void enviarMensaje(PrintWriter enviarMensaje, String mensaje) {
        enviarMensaje.println(mensaje);//ENVIA A CLIENTE
        System.out.println("Mensaje enviado al cliente: " + mensaje); //IMPRIME EN SERVIDOR
    }
}
