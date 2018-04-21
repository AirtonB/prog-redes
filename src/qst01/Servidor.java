/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qst01;

import java.io.IOException;
import java.io.PrintStream;
import java.net.InetAddress;
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
            String ipServidor = InetAddress.getByName("localhost").getHostAddress();
            System.out.printf("Servidor %s aguardando conexão na porta %d \n", ipServidor, PORTA);
            while (true) {
                Socket cliente = servidor.accept();
                String ipCliente = cliente.getInetAddress().getHostAddress();
                System.out.println("Conexão estabelecidda com o cliente " + ipCliente);
                Scanner dadosEntrada = new Scanner(cliente.getInputStream());
                PrintStream saidaDados = new PrintStream(cliente.getOutputStream());
                while (dadosEntrada.hasNextLine()) {
                    String msg = dadosEntrada.nextLine();
                    System.out.println("CLIENTE " + ipCliente + " : " + msg);
                    saidaDados.println(msg.toUpperCase());
                }
                dadosEntrada.close();
                saidaDados.close();
                cliente.close();
                System.out.println("Conexão encerrada!");
            }
        } catch (Exception e) {
            System.out.println("Erro Inesperado!");
        }
    }
}
