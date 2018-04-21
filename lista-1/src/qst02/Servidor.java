/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qst02;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Inet4Address;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author Leandro
 */
public class Servidor {

    public static void main(String[] args) throws IOException {
        final int PORTA = 5000;
        try {
            ServerSocket servidor = new ServerSocket(PORTA);
            String ipServidor = Inet4Address.getByName("localhost").getHostAddress();
            System.out.printf("..Servidor: %s Aguardando Conexão na porta %s .. ", ipServidor, PORTA);
            while (true) {
                Socket cliente = servidor.accept();
                String serverIp = Inet4Address.getLocalHost().getHostAddress();
                PrintStream saidaDados = new PrintStream(cliente.getOutputStream());
                saidaDados.println("Server: " + serverIp + " Alive!");
                //Encerrando as conexões
                saidaDados.close();
                cliente.close();
            }
        } catch (IOException e) {
            System.out.println("Error!");
        }

    }
}
