/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpa.felipph.buscas;

import br.ufpa.felipph.listaadj.Grafo;
import br.ufpa.felipph.matrizadj.Aresta;

/**
 *
 * @author Felipph Calado
 */
public class Cfc {

    private static class TempoTermino {

        private int numRestantes, t[];
        private boolean restantes[];

        public TempoTermino(int numVertices) {
            t = new int[numVertices];
            restantes = new boolean[numVertices];
            numRestantes = numVertices;
        }

        public int maxTT() {
            int vMax = 0;
            while (!this.restantes[vMax]) {
                vMax++;
            }
            for (int i = 0; i < this.t.length; i++) {
                if (this.restantes[i]) {
                    if (this.t[i] > this.t[vMax]) {
                        vMax = i;
                    }
                }
            }
            return vMax;
        }
    }
    private Grafo grafo;

    public Cfc(Grafo grafo) {
        this.grafo = grafo;
    }

    private void visitaDfs(Grafo grafo, int u, TempoTermino tt) {
        tt.restantes[u] = false;
        tt.numRestantes--;
        System.out.println("  Vertice: " + u);
        if (!grafo.listaAdjVazia(u)) {
            Aresta a = grafo.primeiroListaAdj(u);
            while (a != null) {
                int v = a.v2();
                if (tt.restantes[v]) {
                    this.visitaDfs(grafo, v, tt);
                }
                a = grafo.proxAdj(u);
            }
        }
    }

    public void obterCfc() {
        System.out.println("Executando a busca em profundidade");
        BuscaEmProfundidade dfs = new BuscaEmProfundidade(this.grafo);
        dfs.buscaEmProfundidade();
        
        System.out.println("Obterndo os tempos");
        TempoTermino tt = new TempoTermino(this.grafo.numVertices());
        for (int u = 0; u < this.grafo.numVertices(); u++) {
            System.out.println("Vertice "+u+" - tempo: "+dfs.t(u));
            tt.t[u] = dfs.t(u);
            tt.restantes[u] = true;
        }
        System.out.println("Transpondo:");
        
        Grafo grafoT = this.grafo.grafoTransposto();
        grafoT.imprime();
        while (tt.numRestantes > 0) {
            int vRaiz = tt.maxTT();            
            System.out.println("Raiz da proxima arvore: " + vRaiz);
            this.visitaDfs(grafoT, vRaiz, tt);
        }
    }
}
