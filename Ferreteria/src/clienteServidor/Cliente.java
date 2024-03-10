/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clienteServidor;

import java.io.*;
import java.net.*;

/**
 *
 * @author juanma
 */
public class Cliente {

    public static void main(String[] args) {
        final String SERVIDOR = "localhost";
        final int PUERTO = 8066; // Puerto en el que el servidor está escuchando

        //Conecta clienta al servidor
        try (Socket socket = new Socket(SERVIDOR, PUERTO)) {
            System.out.println("Conexión establecida con el servidor en " + SERVIDOR + ":" + PUERTO);

            //Creando canales de entrada/salida
            //Teclado
            BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
            //Envia mensaje al servidor
            PrintWriter enviarMensaje = new PrintWriter(socket.getOutputStream(), true);
            //Leer entrada
            BufferedReader entradas = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String mensaje;

            //RECIBIR MENSAJE hasta que no haya mas
            /*
            String mensajeDelServidor;
            while ((mensajeDelServidor = entradas.readLine()) != null) {
                System.out.println("Mensaje del servidor: " + mensajeDelServidor);
            }
             */
            
            //System.out.println(entradas.toString());
            //System.out.println(entradas.lines());
            System.out.println(entradas.readLine());
            
           
            do {

                System.out.println("Escribe un mensaje (o 'salir' para terminar): ");
                // ENVIAMOS MENSAJE
                mensaje = teclado.readLine();
                enviarMensaje.println(mensaje);

                //equalsIsIgnoreCase ignora si es mayus o minusculas.    
            } while (!mensaje.equalsIgnoreCase("salir"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
