/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpa.felipph.buscas;

import br.ufpa.felipph.listaadj.Fila;
import br.ufpa.felipph.listaadj.Grafo;
import br.ufpa.felipph.matrizadj.Aresta;

/**
 *
 * @author Felipph Calado
 */
public class BuscaEmLargura {

    public static final byte branco = 0;
    public static final byte cinza = 1;
    public static final byte preto = 2;
    private int d[], antecessor[];
    private Grafo grafo;

    public BuscaEmLargura(Grafo grafo) {
        this.grafo = grafo;
        int n = this.grafo.numVertices();
        this.d = new int[n];
        this.antecessor = new int[n];
    }

    private void visitaBfs(int u, int cor[]) throws Exception {
        cor[u] = cinza;
        this.d[u] = 0;
        Fila fila = new Fila();
        System.out.println("Enfileirando "+u);
        fila.enfileira(new Integer(u));
//        System.out.print ("Visita origem:"+u+" cor: cinza F:");
//        fila.imprime ();
        while (!fila.vazia()) {
            Integer aux = (Integer) fila.desenfileira();
            u = aux.intValue();
            System.out.println("Desenfileirando "+u);
            if (!this.grafo.listaAdjVazia(u)) {
                System.out.println("Obtendo a primeira aresta de "+u);
                Aresta a = this.grafo.primeiroListaAdj(u);
                while (a != null) {
                    int v = a.v2();
                    System.out.println("Verificando se o vertice adjacente "+v+" ja foi visitado:");
                    if (cor[v] == branco) {
                        System.out.println("Pintando "+v+" de cinza");
                        cor[v] = cinza; 
                        System.out.println("d["+v+"] + 1");
                        this.d[v] = this.d[u] + 1;
                        System.out.println("pi["+v+"] = "+u);
                        this.antecessor[v] = u;
                        System.out.println("Enfileirando "+v);
                        fila.enfileira(new Integer(v));
                    }
                    a = this.grafo.proxAdj(u);
                }
            }
            cor[u] = preto;
//      System.out.print("Visita "+u+" dist: "+this.d[u]+" cor: preto F:");
//      fila.imprime ();
        }
    }

    public void buscaEmLargura() throws Exception {
        int cor[] = new int[this.grafo.numVertices()];
        System.out.println("Pintando todos os vertices de branco:");
        for (int u = 0; u < grafo.numVertices(); u++) {
            cor[u] = branco;
            System.out.println(u+": branco");
            System.out.println("D["+u+"] INFINITO");            
            this.d[u] = Integer.MAX_VALUE;
            System.out.println("PI["+u+"] NIL");
            this.antecessor[u] = -1;
        }
        for (int u = 0; u < grafo.numVertices(); u++) {
            if (cor[u] == branco) {
                System.out.println("Visitando vizinhos de "+ u);
                this.visitaBfs(u, cor);
            }
        }
    }

    public int d(int v) {
        return this.d[v];
    }

    public int antecessor(int v) {
        return this.antecessor[v];
    }

    public void imprimeCaminho(int origem, int v) {
        if (origem == v) {
            System.out.println(origem);
        } else if (this.antecessor[v] == -1) {
            System.out.println("Nao existe caminho de " + origem + " ate " + v);
        } else {
            imprimeCaminho(origem, this.antecessor[v]);
            System.out.println(v);
        }
    }
}
