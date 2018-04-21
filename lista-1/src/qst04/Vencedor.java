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
public class Vencedor {
    private String ganhador;
    private boolean fim = false;

    public void setGanhador(String ganhador) {

        if (fim == false) {
            this.ganhador = ganhador;
            fim = true;
        }
    }

    public String getGanhador() {
        return ganhador;
    }
}
