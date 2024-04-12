/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clienteServidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
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
}