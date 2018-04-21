/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qst02;

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
        try {
            Socket cliente = new Socket(ipServidor, PORTA);
            Scanner dadosEntrada = new Scanner(cliente.getInputStream());
            System.out.println(dadosEntrada.nextLine());
        } catch (IOException ex) {
            System.out.println("Error!");
        }

    }
}
