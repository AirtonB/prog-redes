/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qst04;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Leandro
 */
public class Piloto implements Runnable {

    Random numeroGerado = new Random();
    private String nome;
    private Vencedor winner;

    public Piloto(String nome, Vencedor win) throws InterruptedException {
        this.nome = nome;
        this.winner = win;
    }

    @Override
    public void run() {

        try {
            for (int i = 0; i <= 65; i++) {
                long num = numeroGerado.nextInt((1000 - 0) + 0);
                System.out.println("# - "+this.nome + " - Volta : " + i);
                Thread.sleep(num);
                System.out.println();
            }
            this.winner.setGanhador(nome);
        } catch (InterruptedException ex) {
            Logger.getLogger(Piloto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
