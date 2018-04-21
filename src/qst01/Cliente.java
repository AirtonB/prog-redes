/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qst01;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author Leandro
 */
public class Cliente {

    public static void main(String[] args) throws IOException {
        final int PORTA = 5000;
        String ipServidor = "localhost";
        Socket cliente = new Socket(ipServidor, PORTA);
        System.out.println("Cliente conectado!");
        //
        Scanner entradaTeclado = new Scanner(System.in);
        Scanner dadosEntrada = new Scanner(cliente.getInputStream());
        PrintStream saidaDados = new PrintStream(cliente.getOutputStream());
        System.out.println("Mensagem: ");
        while (entradaTeclado.hasNextLine()) {
            saidaDados.println(entradaTeclado.nextLine());
            System.out.println("\nSERVIDOR ECO: ");
            System.out.println(dadosEntrada.nextLine());
            System.out.println("\nMensagem para enviar: ");

        }
        saidaDados.close();
        entradaTeclado.close();
        entradaTeclado.close();
        cliente.close();

    }
}
