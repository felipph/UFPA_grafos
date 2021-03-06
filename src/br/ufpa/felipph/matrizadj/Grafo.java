/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpa.felipph.matrizadj;

/**
 *
 * @author Felipph Calado
 */
public class Grafo {

    private int mat[][]; // @{\it pesos do tipo inteiro}@
    private int numVertices;
    private int pos[]; // @{\it posi\c{c}\~ao atual ao se percorrer os adjs de um v\'ertice v}@

    public Grafo(int numVertices) {
        this.mat = new int[numVertices][numVertices];
        this.pos = new int[numVertices];
        this.numVertices = numVertices;
        for (int i = 0; i < this.numVertices; i++) {
            for (int j = 0; j < this.numVertices; j++) {
                this.mat[i][j] = 0;
            }
            this.pos[i] = -1;
        }
    }
    
    public int[][] getMatriz(){
        System.out.println(this.mat[0][0]);
        return this.mat;
    }

    public Grafo(int numVertices, int numArestas) {
        this.mat = new int[numVertices][numVertices];
        this.pos = new int[numVertices];
        this.numVertices = numVertices;
        for (int i = 0; i < this.numVertices; i++) {
            for (int j = 0; j < this.numVertices; j++) {
                this.mat[i][j] = 0;
            }
            this.pos[i] = -1;
        }
    }

    public boolean conexo() {
        for (int i = 0; i < this.mat.length; i++) {
            int sum1 = 0;
            int sum2 = 0;
            for (int j = 0; j < this.mat[i].length; j++) {
                sum1 += this.mat[i][j];
                sum2 += this.mat[j][i];
            }
            if(sum1 == 0 && sum2 == 0){
                return false;
            }
        }
        return true;
    }

    public void listaAdjacentes(int v) {
        System.out.println("Listando os adjacentes do Vertice " + v + ":");
        for (int i = 0; i < this.mat[v].length; i++) {
            if (this.mat[v][i] > 0) {
                System.out.println("\t Vertice: " + i);
            }
        }

    }

    public void insereAresta(int v1, int v2, int peso) {
        System.out.println("Criando aresta direcionada entre " + v1 + " e " + v2);
        this.mat[v1][v2] = peso;
    }

    public boolean existeAresta(int v1, int v2) {
        System.out.println("Checando se existe o índice [" + v1 + "]"
                + "[" + v2 + "]");
        return (this.mat[v1][v2] > 0);
    }

    public boolean listaAdjVazia(int v) {
        for (int i = 0; i < this.numVertices; i++) {
            if (this.mat[v][i] > 0) {
                return false;
            }
        }
        return true;
    }

    public Aresta primeiroListaAdj(int v) {
        // @{\it Retorna a primeira aresta que o v\'ertice v participa ou}@ 
        // @{\it {\bf null} se a lista de adjac\^encia de v for vazia}@
        this.pos[v] = -1;
        return this.proxAdj(v);
    }

    public Aresta proxAdj(int v) {
        // @{\it Retorna a pr\'oxima aresta que o v\'ertice v participa ou}@ 
        // @{\it {\bf null} se a lista de adjac\^encia de v estiver no fim}@ 
        this.pos[v]++;
        while ((this.pos[v] < this.numVertices)
                && (this.mat[v][this.pos[v]] == 0)) {
            this.pos[v]++;
        }
        if (this.pos[v] == this.numVertices) {
            return null;
        } else {
            return new Aresta(v, this.pos[v], this.mat[v][this.pos[v]]);
        }
    }

    public Aresta retiraAresta(int v1, int v2) {
        if (this.mat[v1][v2] == 0) {
            return null; // @{\it Aresta n\~ao existe}@
        } else {
            Aresta aresta = new Aresta(v1, v2, this.mat[v1][v2]);
            this.mat[v1][v2] = 0;
            return aresta;
        }
    }

    public void imprime() {
        System.out.print("   ");
        for (int i = 0; i < this.numVertices; i++) {
            System.out.print(i + "   ");
        }
        System.out.println();
        for (int i = 0; i < this.numVertices; i++) {
            System.out.print(i + "  ");
            for (int j = 0; j < this.numVertices; j++) {
                System.out.print(this.mat[i][j] + "   ");
            }
            System.out.println();
        }
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
