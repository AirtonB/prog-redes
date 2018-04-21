/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qst04;

/**
 *
 * @author Leandro
 */
public class Teste {

    public static void main(String[] args) throws InterruptedException {
        Vencedor winner = new Vencedor();
        Thread[] threads = new Thread[2];
        threads[0] = new Thread(new Piloto("Lewis Hamilton", winner));
        threads[1] = new Thread(new Piloto("Felipe Massa", winner));
        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }

        for (int i = 0; i < threads.length; i++) {
            threads[i].join();
        }
        System.out.println("###Chegada###\nGanhador: " + winner.getGanhador());
    }
}
