/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpa.felipph.main;

import java.io.IOException;

/**
 *
 * @author Felipph Calado
 */
public class Grafos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException, IOException {
        System.out.println("Atividade prática de implementação de GRAFOS em JAVA");

        Controller c = new Controller();

        c.grafo2();

        Thread.sleep(4000);
        //System.exit(0);
    }

}
