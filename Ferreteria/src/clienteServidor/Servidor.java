/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clienteServidor;

import java.io.*;
import java.net.*;
import java.util.List;
import tienda.Tienda;

/**
 *
 * @author juanma
 */
public class Servidor {

    public static void main(String[] args) {
        final int PUERTO = 8066; // Puerto en el que el servidor está escuchando
        Tienda tienda1 = new Tienda(); // CREAR TIENDA

        try (ServerSocket serverSocket = new ServerSocket(PUERTO)) {
            System.out.println("Servidor esperando conexiones en el puerto " + PUERTO);

            while (true) {
                Socket socket = serverSocket.accept();//SERVIDOR ESPERA CLIENTE
                System.out.println("Cliente conectado desde " + socket.getInetAddress().getHostAddress());

                //MANDA CLIENTE A UN HILO
                Hilo hd = new Hilo(socket, tienda1);
                hd.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //por ahora muestra lo que recibe, más adelante vere que hago con esos datos
    /*
    public static void manejarComunicacionCliente(Socket socket) {
        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream())); PrintWriter writer = new PrintWriter(socket.getOutputStream(), true)) {
            String mensaje;
            while ((mensaje = reader.readLine()) != null && !mensaje.equalsIgnoreCase("salir")) {
                System.out.println("Mensaje recibido del cliente: " + mensaje);
                writer.println("Mensaje recibido por el servidor: " + mensaje);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

     */
    //DEVUELVE UN STRING CON LOS DATOS DE LA TIENDA
    /*
    public static String datosTienda(Tienda tienda1) {
        List<String> productos = tienda1.obtenerProductosDisponibles();
        StringBuilder mensaje = new StringBuilder();
        if (productos.isEmpty()) {
            mensaje.append("No hay productos disponibles en la tienda.");
        } else {
            mensaje.append("Productos disponibles en la tienda:\n");
            for (String producto : productos) {
                mensaje.append(producto).append("\n");
            }
        }
        return mensaje.toString();

    }
*/

    public static void enviarMensaje(Socket socket, String mensaje) {
        try {
            PrintWriter enviarMensaje = new PrintWriter(socket.getOutputStream(), true);
            enviarMensaje.println(mensaje);//ENVIA A CLIENTE
            System.out.println("Mensaje enviado al cliente: " + mensaje); //IMPRIME EN SERVIDOR
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void recibirMensaje(Socket socket) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String mensaje = reader.readLine(); // Lee el mensaje del cliente
            System.out.println("Mensaje recibido del cliente: " + mensaje); // Imprime el mensaje recibido
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
