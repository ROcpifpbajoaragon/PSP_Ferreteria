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

/**
 *
 * @author juanma
 */
public class Cliente {

    public static void main(String[] args) {
        final String SERVIDOR = "localhost";
        final int PUERTO = 8066; // Puerto en el que el servidor está escuchando

        //Conecta clienta al servidor
        try {
            //conecta servidor
            Socket socket = new Socket(SERVIDOR, PUERTO);
            System.out.println("Conexión establecida con el servidor en " + SERVIDOR + ":" + PUERTO);

            BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter enviarMensaje = new PrintWriter(socket.getOutputStream(), true);
            String mensaje;
            String respuestaServidor;
            int cantidad;

            do {
                
                do {
                    respuestaServidor = recibirMensaje(reader);
                    mensaje = teclado.readLine();
                    enviarMensaje(enviarMensaje, mensaje);
                    respuestaServidor = recibirMensaje(reader);

                } while (!respuestaServidor.equalsIgnoreCase("OK"));

                do {

                    respuestaServidor = recibirMensaje(reader);
                    cantidad = Integer.parseInt(teclado.readLine());
                    enviarCantidad(enviarMensaje, cantidad);
                    respuestaServidor = recibirMensaje(reader);
                } while (!respuestaServidor.equalsIgnoreCase("Pedido realizado"));

            } while (!mensaje.equalsIgnoreCase("salir"));

           
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String recibirMensaje(BufferedReader reader) {
        String mensaje = null;
        try {
            mensaje = reader.readLine(); // Lee el mensaje del servidor
            System.out.println("Mensaje recibido del servidor: " + mensaje); // Imprime el mensaje recibido

        } catch (IOException e) {
            e.printStackTrace();
        }

        return mensaje;
    }

    public static void enviarMensaje(PrintWriter enviarMensaje, String mensaje) {
        enviarMensaje.println(mensaje);//ENVIA A CLIENTE
        System.out.println("Mensaje enviado al servidor: " + mensaje); //IMPRIME EN SERVIDOR
    }

    public static void enviarCantidad(PrintWriter enviarMensaje, int cantidad) {
        enviarMensaje.println(cantidad);//ENVIA A CLIENTE
        System.out.println("Mensaje enviado al servidor: " + cantidad); //IMPRIME EN SERVIDOR
    }
}
