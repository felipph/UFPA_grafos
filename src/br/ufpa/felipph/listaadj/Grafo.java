/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpa.felipph.listaadj;

import br.ufpa.felipph.matrizadj.Aresta;

/**
 *
 * @author Felipph Calado
 */
public class Grafo {

    private static class Celula {

        int vertice, peso;

        public Celula(int v, int p) {
            this.vertice = v;
            this.peso = p;
        }

        public boolean equals(Object obj) {
            Celula item = (Celula) obj;
            return (this.vertice == item.vertice);
        }
    }
    private Lista adj[];
    private int numVertices;

    private int grausNaoOrientado[];
    private int grausOrientado[];

    public Grafo(int numVertices) {
        this.adj = new Lista[numVertices];
        this.grausOrientado = new int[numVertices];
        this.grausNaoOrientado = new int[numVertices];
        this.numVertices = numVertices;
        for (int i = 0; i < this.numVertices; i++) {
            this.adj[i] = new Lista();
            this.grausOrientado[i] = 0;
            this.grausNaoOrientado[i] = 0;
        }
    }  //@\lstcontinue@

    public Grafo(int numVertices, int numArestas) {
        this.adj = new Lista[numVertices];
        this.numVertices = numVertices;
        for (int i = 0; i < this.numVertices; i++) {
            this.adj[i] = new Lista();
        }
    }  //@\lstcontinue@

    public void insereArestaNaoDirecionada(int v1, int v2, int peso) {
        System.out.println("Criando aresta entre " + v1 + " e " + v2);
        Celula item = new Celula(v2, peso);
        this.adj[v1].insere(item);

        item = new Celula(v1, peso);
        this.adj[v2].insere(item);
        this.grausNaoOrientado[v1]++;
        this.grausNaoOrientado[v2]++;

    }

    public void insereAresta(int v1, int v2, int peso) {
        System.out.println("Criando aresta entre " + v1 + " e " + v2);
        Celula item = new Celula(v2, peso);
        this.adj[v1].insere(item);
        this.grausOrientado[v1]++;
    }

    public void imprimeGraus() {
        for (int i = 0; i < this.numVertices; i++) {
            System.out.println("Vertice " + i + ": " + this.grausOrientado[i]);
        }
    }

    public boolean existeAresta(int v1, int v2) {
        Celula item = new Celula(v2, 0);
        System.out.println("Pesquisando no vertice " + v1 + "...");
        return (this.adj[v1].pesquisa(item) != null);
    }

    public boolean listaAdjVazia(int v) {
        return this.adj[v].vazia();
    }

    public Aresta primeiroListaAdj(int v) {
        // @{\it Retorna a primeira aresta que o v\'ertice v participa ou}@
        // @{\it {\bf NULL} se a lista de adjac\^encia de v for vazia}@ 
        Celula item = (Celula) this.adj[v].primeiro();
        return item != null ? new Aresta(v, item.vertice, item.peso) : null;
    }

    public Aresta proxAdj(int v) {
        // @{\it Retorna a pr\'oxima aresta que o v\'ertice v participa ou}@
        // @{\it {\bf null} se a lista de adjac\^encia de v estiver no fim}@
        Celula item = (Celula) this.adj[v].proximo();
        return item != null ? new Aresta(v, item.vertice, item.peso) : null;
    }

    public Aresta retiraAresta(int v1, int v2) throws Exception {
        Celula chave = new Celula(v2, 0);
        Celula item = (Celula) this.adj[v1].retira(chave);
        return item != null ? new Aresta(v1, v2, item.peso) : null;
    }

    public void imprime() {
        for (int i = 0; i < this.numVertices; i++) {
            System.out.println("Vertice " + i + ":");
            Celula item = (Celula) this.adj[i].primeiro();
            while (item != null) {
                System.out.print("  " + item.vertice + " (" + item.peso + "), ");
                item = (Celula) this.adj[i].proximo();
            }
            System.out.println("");
        }
    }

    public String imprimeString() {
        String s = "";
        for (int i = 0; i < this.numVertices; i++) {
            s += "Vertice " + i + ":\n";
            Celula item = (Celula) this.adj[i].primeiro();
            while (item != null) {
                s += "  " + item.vertice + " (" + item.peso + "), ";
                item = (Celula) this.adj[i].proximo();
            }
            s += "\n";
        }
        return s;
    }

    public void listaAdjacentes(int v) {

        System.out.println("Listando os adjacentes do Vertice " + v + ":");
        Celula item = (Celula) this.adj[v].primeiro();
        while (item != null) {
            System.out.println("  " + item.vertice + " (" + item.peso + ")");
            item = (Celula) this.adj[v].proximo();
        }
    }

    public boolean checkAresta(int v1, int v2) {

        System.out.println("Vertice " + v1 + ":");
        Celula item = (Celula) this.adj[v1].primeiro();
        while (item != null) {
            System.out.println("Comparando adjacente: " + item.vertice + " com " + v2);
            if (item.vertice == v2) {
                System.out.println("  " + item.vertice + " (" + item.peso + ")");
                return true;

            }
            item = (Celula) this.adj[v1].proximo();

        }
        return false;
    }

    public boolean conexo() {
        //criando um vetor do tamanho dos vertice
        int[] vetores = new int[this.numVertices];
        //inicializando
        for (int i = 0; i < this.adj.length; i++) {
            vetores[i] = 0;
        }
        for (int i = 0; i < this.adj.length; i++) {
            vetores[i] = 0;
            Celula item = (Celula) this.adj[i].primeiro();
            while (item != null) {
                System.out.println("Vertice "+i+ "tem aresta");
                vetores[i]++;
                vetores[item.vertice]++;
                item = (Celula) this.adj[i].proximo();
            }
        }
        // checando
        for (int i = 0; i < this.adj.length; i++) {
            if(vetores[i]==0){
                return false;
            }
        }
        return true;
    }

    public int numVertices() {
        return this.numVertices;
    }

    public Grafo grafoTransposto() {
        Grafo grafoT = new Grafo(this.numVertices);
        for (int v = 0; v < this.numVertices; v++) {
            if (!this.listaAdjVazia(v)) {
                Aresta adj = this.primeiroListaAdj(v);
                while (adj != null) {
                    grafoT.insereAresta(adj.v2(), adj.v1(), adj.peso());
                    adj = this.proxAdj(v);
                }
            }
        }
        return grafoT;
    }
}
