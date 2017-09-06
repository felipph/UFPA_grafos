/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpa.felipph.buscas;

/**
 *
 * @author felipph
 */
import java.io.*;
import java.util.*;

public class BellmanFord {

    LinkedList<Edge> edges;
    int d[], p[];
    int n, e, s;
    final int INFINITY = 999;

    private static class Edge {

        int u, v, w;

        public Edge(int a, int b, int c) {
            u = a;
            v = b;
            w = c;
        }

        @Override
        public String toString() {
            return "ARESTA: {" + "origen=" + u + ", destino=" + v + ", custo=" + w + '}';
        }
    }

    public BellmanFord(int[][] a, int origem) throws IOException {
        n = a.length;
        int item;
        edges = new LinkedList<Edge>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                item = a[i][j];
                if (item != 0) {
//                    System.out.println("Criando aresta " + i + " - " + j + ": peso: " + item);
                    edges.add(new Edge(i, j, item));
                }
            }
        }

//        for (Edge ar : edges) {
//            System.out.println("Arestas do grafo: " + ar.toString());
//        }
        e = edges.size();
//        System.out.println("Arestas: " + e);
        d = new int[n];
        p = new int[n];

        s = origem;
    }

    void relax() {
//        System.out.println("n:" + n);
        int i, j;
        for (i = 0; i < n; ++i) {
            d[i] = INFINITY;
            p[i] = -1;
        }

        d[s] = 0;
        for (i = 0; i < n - 1; ++i) {
            for (j = 0; j < e; ++j) { //here i am calculating the shortest path
                if (d[edges.get(j).u] + edges.get(j).w < d[edges.get(j).v]) {
                    d[edges.get(j).v] = d[edges.get(j).u] + edges.get(j).w;
                    p[edges.get(j).v] = edges.get(j).u;
                }
            }

        }
    }

    boolean cycle() {
        int j;
        for (j = 0; j < e; ++j) {
            if (d[edges.get(j).u] + edges.get(j).w < d[edges.get(j).v]) {
                return false;
            }
        }
        return true;
    }

    public void print() {
        for (int i = 0; i < n; i++) {
            System.out.println("Vértice " + i + " tem predecessor " + p[i]);
        }
    }

    public void processa() {
        this.relax();
        if (this.cycle()) {
            for (int i = 0; i < this.n; i++) {
                System.out.println("Custo de " + this.s + " ==> " + i + ": " + this.d[i]);
            }
        } else {
            System.out.println("Ciclo Negativo");
        }
        System.out.println(Arrays.toString(this.d));
        System.out.println(Arrays.toString(this.p));
    }

//    public static void main(String args[]) throws IOException   {
//        BellmanFord  r = new BellmanFord ();
//        r.relax();
//        if(r.cycle()) {
//            for(int i=0;i<r.n;i++)
//                System.out.println(r.s+" ==> "+r.d[i]);
//        } else {
//            System.out.println(" There is a negative edge cycle ");
//        }
//
//        r.print();
//    }
}
