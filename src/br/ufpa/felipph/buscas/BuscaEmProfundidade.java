/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpa.felipph.buscas;

import br.ufpa.felipph.listaadj.Grafo;
import br.ufpa.felipph.matrizadj.Aresta;
import java.util.ArrayList;

/**
 *
 * @author Felipph Calado
 */
public class BuscaEmProfundidade {

    public static final byte branco = 0;
    public static final byte cinza = 1;
    public static final byte preto = 2;
    private int d[], t[], antecessor[];
    private Grafo grafo;

    public BuscaEmProfundidade(Grafo grafo) {
        this.grafo = grafo;
        int n = this.grafo.numVertices();
        d = new int[n];
        t = new int[n];
        antecessor = new int[n];
    }
    
    private int visitaDfs(int u, int tempo, int cor[]) {
        cor[u] = cinza;
        this.d[u] = ++tempo;
        System.out.println("Visita " + u + " Descoberta:" + this.d[u] + " cinza");
        if (!this.grafo.listaAdjVazia(u)) {
            Aresta a = this.grafo.primeiroListaAdj(u);
            while (a != null) {
                int v = a.v2();
                if(cor[v] == cinza){
                    System.out.println("CICLO em "+ v +"!");
                }
                if (cor[v] == branco) {
                    this.antecessor[v] = u;
                    tempo = this.visitaDfs(v, tempo, cor);
                }
                a = this.grafo.proxAdj(u);
            }
        }
        cor[u] = preto;
        this.t[u] = ++tempo;
        System.out.println("Visita " + u + " Termino:" + this.t[u] + " preto");
        return tempo;
    }

    public void buscaEmProfundidade() {
        int tempo = 0;
        int cor[] = new int[this.grafo.numVertices()];
        for (int u = 0; u < grafo.numVertices(); u++) {
            cor[u] = branco;
            this.antecessor[u] = -1;
        }
        for (int u = 0; u < grafo.numVertices(); u++) {
            if (cor[u] == branco) {
                tempo = this.visitaDfs(u, tempo, cor);
            }
        }
    }

    public int d(int v) {
        return this.d[v];
    }

    public int t(int v) {
        return this.t[v];
    }

    public int antecessor(int v) {
        return this.antecessor[v];
    }
}
