/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpa.felipph.main;

import br.ufpa.felipph.shared.TextAreaOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author felipph
 */
public class TelaInicial extends javax.swing.JFrame {

    /**
     * Creates new form TelaInicial
     */
    Controller c = new Controller();
    public TelaInicial() {
        initComponents();
        TextAreaOutputStream t = new TextAreaOutputStream(txtSaida);
        PrintStream ps = new PrintStream( t );
        System.setOut( ps );
        System.setErr( ps );
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnQ1 = new javax.swing.JButton();
        btnQ2 = new javax.swing.JButton();
        btnQ3 = new javax.swing.JButton();
        btnQ4 = new javax.swing.JButton();
        btnQ5 = new javax.swing.JButton();
        btnQ6 = new javax.swing.JButton();
        btnQ7 = new javax.swing.JButton();
        btnQ8 = new javax.swing.JButton();
        btnQ9 = new javax.swing.JButton();
        btnQ10 = new javax.swing.JButton();
        btnQ11 = new javax.swing.JButton();
        btnQ12 = new javax.swing.JButton();
        btnQ13 = new javax.swing.JButton();
        btnQ14 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtSaida = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Atividade de Grafos");

        btnQ1.setText("Questão 3");
        btnQ1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQ1ActionPerformed(evt);
            }
        });

        btnQ2.setText("Questão 1");
        btnQ2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQ2ActionPerformed(evt);
            }
        });

        btnQ3.setText("Questão 2");
        btnQ3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQ3ActionPerformed(evt);
            }
        });

        btnQ4.setText("Questão 4");
        btnQ4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQ4ActionPerformed(evt);
            }
        });

        btnQ5.setText("Questão 5");
        btnQ5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQ5ActionPerformed(evt);
            }
        });

        btnQ6.setText("Questão 6");
        btnQ6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQ6ActionPerformed(evt);
            }
        });

        btnQ7.setText("Questão 7");
        btnQ7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQ7ActionPerformed(evt);
            }
        });

        btnQ8.setText("Questão 8");
        btnQ8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQ8ActionPerformed(evt);
            }
        });

        btnQ9.setText("Questão 9");
        btnQ9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQ9ActionPerformed(evt);
            }
        });

        btnQ10.setText("Questão 10");
        btnQ10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQ10ActionPerformed(evt);
            }
        });

        btnQ11.setText("Questão 11");
        btnQ11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQ11ActionPerformed(evt);
            }
        });

        btnQ12.setText("Questão 12");
        btnQ12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQ12ActionPerformed(evt);
            }
        });

        btnQ13.setText("Questão 13");
        btnQ13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQ13ActionPerformed(evt);
            }
        });

        btnQ14.setText("Questão 14");
        btnQ14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQ14ActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Saída"));

        txtSaida.setColumns(20);
        txtSaida.setRows(5);
        jScrollPane1.setViewportView(txtSaida);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 427, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnQ4, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnQ5, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnQ6, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnQ7, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnQ8, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnQ9, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnQ10, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnQ11, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnQ12, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnQ13, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnQ14, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnQ2, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnQ1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnQ3, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnQ2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnQ3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnQ1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnQ4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnQ5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnQ6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnQ7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnQ8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnQ9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnQ10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnQ11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnQ12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnQ13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnQ14)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnQ1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQ1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnQ1ActionPerformed

    private void btnQ2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQ2ActionPerformed
        this.out(this.c.q1());
        try {
            this.c.showGrafo1();
        } catch (IOException ex) {
            Logger.getLogger(TelaInicial.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnQ2ActionPerformed

    private void btnQ3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQ3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnQ3ActionPerformed

    private void btnQ4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQ4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnQ4ActionPerformed

    private void btnQ5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQ5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnQ5ActionPerformed

    private void btnQ6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQ6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnQ6ActionPerformed

    private void btnQ7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQ7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnQ7ActionPerformed

    private void btnQ8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQ8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnQ8ActionPerformed

    private void btnQ9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQ9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnQ9ActionPerformed

    private void btnQ10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQ10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnQ10ActionPerformed

    private void btnQ11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQ11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnQ11ActionPerformed

    private void btnQ12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQ12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnQ12ActionPerformed

    private void btnQ13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQ13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnQ13ActionPerformed

    private void btnQ14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQ14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnQ14ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaInicial().setVisible(true);
            }
        });
    }

    public void out(String out) {
        String output = out;
        output += this.txtSaida.getText();
        this.txtSaida.setText(output);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnQ1;
    private javax.swing.JButton btnQ10;
    private javax.swing.JButton btnQ11;
    private javax.swing.JButton btnQ12;
    private javax.swing.JButton btnQ13;
    private javax.swing.JButton btnQ14;
    private javax.swing.JButton btnQ2;
    private javax.swing.JButton btnQ3;
    private javax.swing.JButton btnQ4;
    private javax.swing.JButton btnQ5;
    private javax.swing.JButton btnQ6;
    private javax.swing.JButton btnQ7;
    private javax.swing.JButton btnQ8;
    private javax.swing.JButton btnQ9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtSaida;
    // End of variables declaration//GEN-END:variables
}