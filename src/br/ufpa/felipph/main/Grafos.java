/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpa.felipph.main;

import java.io.IOException;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Felipph Calado
 */
public class Grafos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException, IOException, UnsupportedLookAndFeelException {

        try {
            // Set cross-platform Java L&F (also called "Metal")
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
        } catch (UnsupportedLookAndFeelException e) {
            // handle exception
        } catch (ClassNotFoundException e) {
            // handle exception
        } catch (InstantiationException e) {
            // handle exception
        } catch (IllegalAccessException e) {
            // handle exception
        }

        System.out.println("Atividade prática de implementação de GRAFOS em JAVA");

        TelaInicial t = new TelaInicial();
        t.setVisible(true);
    }

}
