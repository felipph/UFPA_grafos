/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpa.felipph.main;

import br.ufpa.felipph.buscas.AgmPrim;
import br.ufpa.felipph.buscas.BellmanFord;
import br.ufpa.felipph.buscas.BuscaEmLargura;
import br.ufpa.felipph.buscas.BuscaEmProfundidade;
import br.ufpa.felipph.buscas.Cfc;
import br.ufpa.felipph.buscas.Dijkstra;
import br.ufpa.felipph.matrizadj.Aresta;
import br.ufpa.felipph.shared.ImgDisplay;
import br.ufpa.felipph.shared.TextAreaOutputStream;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

/**
 *
 * @author felipph
 */
public class QQGrafo extends javax.swing.JFrame {

    /**
     * Creates new form QQGrafo
     */
    JOptionPane j;
    int qntVertices = 0;
    int qntArestas = 0;
    int naodirecionado = 0;
    ArrayList<Aresta> arestas = new ArrayList<Aresta>();

    br.ufpa.felipph.listaadj.Grafo gAdj;
    br.ufpa.felipph.matrizadj.Grafo gMat;

    public ArrayList<Aresta> arestasGrafo1 = new ArrayList<Aresta>();
    public ArrayList<Aresta> arestasGrafo2 = new ArrayList<Aresta>();
    public ArrayList<Aresta> arestasGrafo3 = new ArrayList<Aresta>();
    private final String[] listaArestanumeros;

    public QQGrafo() {
        initComponents();
        TextAreaOutputStream t = new TextAreaOutputStream(txtSaida);;
        PrintStream ps = new PrintStream(t);
        System.setOut(ps);
        System.setErr(ps);
        
        
        String[] listaArestanumeros = new String[5];
        listaArestanumeros[0] = "S";
        listaArestanumeros[1] = "U";
        listaArestanumeros[2] = "X";
        listaArestanumeros[3] = "V";
        listaArestanumeros[4] = "Y";

        this.listaArestanumeros = listaArestanumeros;
        
    }

    public void setGrafo1() {
        this.gAdj = new br.ufpa.felipph.listaadj.Grafo(8);
        this.gMat = new br.ufpa.felipph.matrizadj.Grafo(8);
        this.arestasGrafo1.add(new Aresta(0, 1, 1));
        this.arestasGrafo1.add(new Aresta(1, 0, 1));

        this.arestasGrafo1.add(new Aresta(0, 3, 1));
        this.arestasGrafo1.add(new Aresta(3, 0, 1));

        this.arestasGrafo1.add(new Aresta(0, 4, 1));
        this.arestasGrafo1.add(new Aresta(4, 0, 1));

        this.arestasGrafo1.add(new Aresta(1, 5, 1));
        this.arestasGrafo1.add(new Aresta(5, 1, 1));

        this.arestasGrafo1.add(new Aresta(1, 2, 1));
        this.arestasGrafo1.add(new Aresta(2, 1, 1));

        this.arestasGrafo1.add(new Aresta(2, 7, 1));
        this.arestasGrafo1.add(new Aresta(7, 2, 1));

        this.arestasGrafo1.add(new Aresta(2, 3, 1));
        this.arestasGrafo1.add(new Aresta(3, 2, 1));

        this.arestasGrafo1.add(new Aresta(3, 6, 1));
        this.arestasGrafo1.add(new Aresta(6, 3, 1));

        this.arestasGrafo1.add(new Aresta(4, 6, 1));
        this.arestasGrafo1.add(new Aresta(6, 4, 1));

        this.arestasGrafo1.add(new Aresta(4, 5, 1));
        this.arestasGrafo1.add(new Aresta(5, 4, 1));

        this.arestasGrafo1.add(new Aresta(5, 7, 1));
        this.arestasGrafo1.add(new Aresta(7, 5, 1));

        this.arestasGrafo1.add(new Aresta(6, 7, 1));
        this.arestasGrafo1.add(new Aresta(7, 6, 1));
        this.gMat = this.popular_grafo(gMat, this.arestasGrafo1);
        this.gAdj = this.popular_grafo(gAdj, this.arestasGrafo1);
    }

    public void setGrafo2() {
        this.gAdj = new br.ufpa.felipph.listaadj.Grafo(10);
        this.gMat = new br.ufpa.felipph.matrizadj.Grafo(10);

        this.arestasGrafo2.add(new Aresta(0, 2, 1));
        this.arestasGrafo2.add(new Aresta(0, 3, 1));

        this.arestasGrafo2.add(new Aresta(1, 4, 1));
        this.arestasGrafo2.add(new Aresta(1, 8, 1));

        this.arestasGrafo2.add(new Aresta(2, 5, 1));

        this.arestasGrafo2.add(new Aresta(3, 8, 1));
        this.arestasGrafo2.add(new Aresta(3, 7, 1));

        this.arestasGrafo2.add(new Aresta(4, 8, 1));

        this.arestasGrafo2.add(new Aresta(5, 6, 1));

        this.arestasGrafo2.add(new Aresta(6, 2, 1));

        this.arestasGrafo2.add(new Aresta(7, 9, 1));

        this.arestasGrafo2.add(new Aresta(8, 0, 1));

        this.arestasGrafo2.add(new Aresta(9, 7, 1));

        this.gMat = this.popular_grafo(this.gMat, this.arestasGrafo2);
        this.gAdj = this.popular_grafo(this.gAdj, this.arestasGrafo2);

    }

    public void setGrafo3() {

        this.gAdj = new br.ufpa.felipph.listaadj.Grafo(5);
        this.gMat = new br.ufpa.felipph.matrizadj.Grafo(5);

        this.arestasGrafo3.add(new Aresta(0, 1, 10)); //S-U
        this.arestasGrafo3.add(new Aresta(0, 2, 5)); //S-X
        this.arestasGrafo3.add(new Aresta(1, 2, 2));  //U-X  
        this.arestasGrafo3.add(new Aresta(1, 3, 1));  //U-V  
        this.arestasGrafo3.add(new Aresta(2, 1, 3));  //X-U        
        this.arestasGrafo3.add(new Aresta(2, 3, 9));  //X-V
        this.arestasGrafo3.add(new Aresta(2, 4, 2));  //X-Y
        this.arestasGrafo3.add(new Aresta(3, 4, 4));  //V-Y
        this.arestasGrafo3.add(new Aresta(4, 0, 7));  //Y-S
        this.arestasGrafo3.add(new Aresta(4, 3, 6));  //Y-V

        this.gMat = this.popular_grafo(gMat, this.arestasGrafo3);
        this.gAdj = this.popular_grafo(gAdj, this.arestasGrafo3);

    }

    public void inputGrafo() throws Exception {
        this.arestas = new ArrayList<Aresta>();

        String strVerices = this.j.showInputDialog("informe a quantidade de vertices");
        this.qntVertices = Integer.parseInt(strVerices);
        while (this.qntVertices <= 0) {
            this.j.showMessageDialog(rootPane, "Quantidade inválida de arestas");
            strVerices = this.j.showInputDialog("informe a quantidade de arestas");
            this.qntVertices = Integer.parseInt(strVerices);
        }

        String strArestas = this.j.showInputDialog("informe a quantidade de arestas");
        this.qntArestas = Integer.parseInt(strArestas);
        while (this.qntArestas <= 0) {
            this.j.showMessageDialog(rootPane, "Quantidade inválida de arestas");
            strVerices = this.j.showInputDialog("informe a quantidade de arestas");
            this.qntArestas = Integer.parseInt(strVerices);
        }

        this.naodirecionado = this.j.showConfirmDialog(this, "O grafo é direcionado?", "Direcionado?", JOptionPane.YES_NO_OPTION);
        System.out.println("Direção: " + naodirecionado);

        this.gAdj = new br.ufpa.felipph.listaadj.Grafo(this.qntVertices);

        for (int i = 0; i < this.qntArestas; i++) {
            String strV1 = this.j.showInputDialog("Por favor informe o vertice 1 da aresta " + (i + 1) + ":");
            int v1 = Integer.parseInt(strV1);
            if (v1 >= (this.qntVertices)) {
                i--;
                this.j.showMessageDialog(rootPane, "Vertice invádido! Vertice Máximo:" + (this.qntVertices - 1));
            }

            String strV2 = this.j.showInputDialog("Por favor informe o vertice 2 da aresta " + (i + 1) + ":");
            int v2 = Integer.parseInt(strV2);

            if (v2 >= (this.qntVertices)) {
                i--;
                this.j.showMessageDialog(rootPane, "Vertice invádido! Vertice Máximo:" + (this.qntVertices - 1));
            }

            String strPeso = this.j.showInputDialog("Por favor informe o peso da aresta " + (i + 1) + ":");
            int peso = Integer.parseInt(strPeso);

            if (this.gAdj.checkAresta(v1, v2)) {
                i--;
                this.j.showMessageDialog(rootPane, "Aresta Existente! Informe novamente!");
                continue;
            } else {
                this.gAdj.insereAresta(v1, v2, peso);
            }
            if (this.naodirecionado == 1) {
                this.arestas.add(new Aresta(v1, v2, peso));
                this.arestas.add(new Aresta(v2, v1, peso));
                this.gAdj.insereAresta(v2, v1, peso);
            } else {
                if (this.gAdj.checkAresta(v1, v2)) {
                    i--;
                    this.j.showMessageDialog(rootPane, "Aresta Existente! Informe novamente!");
                    continue;
                }
                this.arestas.add(new Aresta(v1, v2, peso));
            }
        }
        gAdj.imprime();

        System.out.println("Criando a Matriz");
        this.gMat = new br.ufpa.felipph.matrizadj.Grafo(this.qntVertices);
        this.gMat = this.popular_grafo(gMat, this.arestas);
        this.gMat.imprime();

    }

    public br.ufpa.felipph.matrizadj.Grafo popular_grafo(br.ufpa.felipph.matrizadj.Grafo g, ArrayList<Aresta> arestas) {
        for (Aresta a : arestas) {
            g.insereAresta(a.v1(), a.v2(), a.peso());
        }
        return g;
    }

    public br.ufpa.felipph.listaadj.Grafo popular_grafo(br.ufpa.felipph.listaadj.Grafo g, ArrayList<Aresta> arestas) {
        for (Aresta a : arestas) {
            g.insereAresta(a.v1(), a.v2(), a.peso());
        }
        return g;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnInputGrafo = new javax.swing.JButton();
        btnAresta = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtSaida = new javax.swing.JTextArea();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnInputGrafo.setText("Fornecer Grafo");
        btnInputGrafo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInputGrafoActionPerformed(evt);
            }
        });

        btnAresta.setText("Verificar Aresta");
        btnAresta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnArestaActionPerformed(evt);
            }
        });

        jButton1.setText("Busca Em Largura");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Busca Em Profundidade");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Verif. Conexidade");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Comp Fort. Conexos");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Verificar Ciclos");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Saída"));

        txtSaida.setColumns(20);
        txtSaida.setFont(new java.awt.Font("Liberation Mono", 0, 12)); // NOI18N
        txtSaida.setRows(5);
        jScrollPane1.setViewportView(txtSaida);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 582, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        jButton6.setText("Caminho + Curto - Dijkstra");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("Verifica Articulações");

        jButton8.setText("Verifica ciclo Euleriano");

        jButton9.setText("Caminho Mín. Fonte - BF");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setText("Arvore Geradora Mínima");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton11.setText("Setar Grafo 1");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton12.setText("Setar Grafo 2");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jButton13.setText("Setar Grafo 3");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAresta, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnInputGrafo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                    .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton11)
                            .addComponent(jButton12)
                            .addComponent(jButton13))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnInputGrafo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAresta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton10)
                        .addGap(50, 50, 50)
                        .addComponent(jButton11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton13)
                        .addGap(0, 44, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnInputGrafoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInputGrafoActionPerformed
        try {
            this.inputGrafo();        // TODO add your handling code here:
        } catch (Exception ex) {
//            Logger.getLogger(QQGrafo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnInputGrafoActionPerformed

    private void btnArestaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnArestaActionPerformed
        String strV1 = this.j.showInputDialog("Vertice 1");
        int v1 = Integer.parseInt(strV1);

        String strV2 = this.j.showInputDialog("Vertice 2");
        int v2 = Integer.parseInt(strV2);

        System.out.println("Usando Lista de adjacencia");
        System.out.println(this.gAdj.checkAresta(v1, v2));
        System.out.println("Usando Matriz de adjacencia");
        System.out.println(this.gMat.existeAresta(v1, v2));


    }//GEN-LAST:event_btnArestaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        BuscaEmLargura b = new BuscaEmLargura(this.gAdj);
        try {
            b.buscaEmLargura();

            String strV1 = this.j.showInputDialog("Vertice origem");
            int v1 = Integer.parseInt(strV1);

            String strV2 = this.j.showInputDialog("Vertice destino");
            int v2 = Integer.parseInt(strV2);
            b.imprimeCaminho(v1, v2);

        } catch (Exception ex) {
            Logger.getLogger(QQGrafo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        BuscaEmProfundidade b = new BuscaEmProfundidade(this.gAdj);
        try {
            b.buscaEmProfundidade();

        } catch (Exception ex) {
            Logger.getLogger(QQGrafo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        Cfc cfc = new Cfc(gAdj);
        cfc.obterCfc();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        BuscaEmProfundidade b = new BuscaEmProfundidade(this.gAdj);
        try {
            b.buscaEmProfundidade();

        } catch (Exception ex) {
            Logger.getLogger(QQGrafo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        Dijkstra d = new Dijkstra(gAdj);
        String strRaiz = this.j.showInputDialog("Raiz ACMC");
        int raiz = Integer.parseInt(strRaiz);
        try {
            d.obterArvoreCMC(raiz);
        } catch (Exception ex) {
            Logger.getLogger(QQGrafo.class.getName()).log(Level.SEVERE, null, ex);
        }
        d.imprime();

        String strV1 = this.j.showInputDialog("Vertice origem");
        int v1 = Integer.parseInt(strV1);

        String strV2 = this.j.showInputDialog("Vertice destino");
        int v2 = Integer.parseInt(strV2);
        d.imprimeCaminho(v1, v2);


    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed

        String strRaiz = this.j.showInputDialog("informe a fonte:");
        int raiz = Integer.parseInt(strRaiz);
        BellmanFord b;
        try {
            b = new BellmanFord(gMat.getMatriz(), raiz);
            b.processa();
            b.print();
        } catch (IOException ex) {
            Logger.getLogger(QQGrafo.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        //PRIM
        System.out.println("---PRIM----");
        gMat.imprime();
        AgmPrim p = new AgmPrim(gAdj);
        String strV1 = this.j.showInputDialog("Vertice origem");
        int v1 = Integer.parseInt(strV1);
        try {
            p.obterAgm(v1);
        } catch (Exception ex) {
            Logger.getLogger(QQGrafo.class.getName()).log(Level.SEVERE, null, ex);
        }
        p.imprime();
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed

        try {
            this.showGrafo1();
        } catch (IOException ex) {
            Logger.getLogger(QQGrafo.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.setGrafo1();        // TODO add your handling code here:

        this.gAdj.imprime();
        this.gMat.imprime();
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        try {
            this.showGrafo2();
        } catch (IOException ex) {
            Logger.getLogger(QQGrafo.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.setGrafo2();
        this.gAdj.imprime();
        this.gMat.imprime();
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        
        try {
            this.showGrafo3();
        } catch (IOException ex) {
            Logger.getLogger(QQGrafo.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.setGrafo3();
        this.gAdj.imprime();
        this.gMat.imprime();
        System.out.println("Para manter a implementação anterior, as letras foram associadas à numeros:");
        for (int i = 0; i < this.listaArestanumeros.length; i++) {
            System.out.println("Vertice " + i + " = " + this.listaArestanumeros[i]);
        }
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        System.out.println(this.gMat.conexo());        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    public void showGrafo1() throws IOException {
        BufferedImage grafo1 = ImageIO.read(new File("./grafo_q1.PNG"));
        ImgDisplay img = new ImgDisplay(null, false, grafo1);
        Thread t = new Thread(img);
        t.start();
    }

    public void showGrafo2() throws IOException {
        BufferedImage grafo2 = ImageIO.read(new File(System.getProperty("user.dir") + "/grafo_q2.PNG"));
        ImgDisplay img = new ImgDisplay(null, false, grafo2);
        Thread t = new Thread(img);
        t.start();
    }

    public void showGrafo3() throws IOException {
        BufferedImage grafo3 = ImageIO.read(new File(System.getProperty("user.dir") + "/grafo_q3.PNG"));
        ImgDisplay img = new ImgDisplay(null, false, grafo3);
        Thread t = new Thread(img);
        t.start();
    }

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
            java.util.logging.Logger.getLogger(QQGrafo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QQGrafo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QQGrafo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QQGrafo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QQGrafo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAresta;
    private javax.swing.JButton btnInputGrafo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtSaida;
    // End of variables declaration//GEN-END:variables
}
