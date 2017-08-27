/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpa.felipph.main;

import br.ufpa.felipph.buscas.BuscaEmProfundidade;
import br.ufpa.felipph.buscas.Cfc;
import br.ufpa.felipph.matrizadj.Aresta;
import br.ufpa.felipph.matrizadj.Grafo;
import br.ufpa.felipph.shared.ImgDisplay;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;

/**
 *
 * @author Felipph Calado
 */
public class Grafos {

    /**
     * @param args the command line arguments
     */
    public static ArrayList<Aresta> arestas = new ArrayList<Aresta>();

    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Atividade prática de implementação de GRAFOS em JAVA");

        grafo2();

        Thread.sleep(4000);
        //System.exit(0);

    }

    public static void grafo1() throws IOException, InterruptedException {
        //exibindo o grafo da primeira questão
        BufferedImage grafo1 = ImageIO.read(new File("./grafo_q1.png"));
        ImgDisplay img = new ImgDisplay(null, false, grafo1);
        Thread t = new Thread(img);
        t.start();

        System.out.println("Populando o grafo utilizando Matriz de Adjacencia...");

        Grafo g = new Grafo(8);

        System.out.println("Criando arestas na ordem crescente dos vertices");

        Grafos.arestas.add(new Aresta(0, 1, 1));
        Grafos.arestas.add(new Aresta(1, 0, 1));

        Grafos.arestas.add(new Aresta(0, 3, 1));
        Grafos.arestas.add(new Aresta(3, 0, 1));

        Grafos.arestas.add(new Aresta(0, 4, 1));
        Grafos.arestas.add(new Aresta(4, 0, 1));

        Grafos.arestas.add(new Aresta(1, 5, 1));
        Grafos.arestas.add(new Aresta(5, 1, 1));

        Grafos.arestas.add(new Aresta(1, 2, 1));
        Grafos.arestas.add(new Aresta(2, 1, 1));

        Grafos.arestas.add(new Aresta(2, 7, 1));
        Grafos.arestas.add(new Aresta(7, 2, 1));

        Grafos.arestas.add(new Aresta(2, 3, 1));
        Grafos.arestas.add(new Aresta(3, 2, 1));

        Grafos.arestas.add(new Aresta(3, 6, 1));
        Grafos.arestas.add(new Aresta(6, 3, 1));

        Grafos.arestas.add(new Aresta(4, 6, 1));
        Grafos.arestas.add(new Aresta(6, 4, 1));

        Grafos.arestas.add(new Aresta(4, 5, 1));
        Grafos.arestas.add(new Aresta(5, 4, 1));

        Grafos.arestas.add(new Aresta(5, 7, 1));
        Grafos.arestas.add(new Aresta(7, 5, 1));

        Grafos.arestas.add(new Aresta(6, 7, 1));
        Grafos.arestas.add(new Aresta(7, 6, 1));

        System.out.println("Gerando a Matriz");

        for (Aresta a : Grafos.arestas) {
            g.insereAresta(a.v1(), a.v2(), 1);
            //g.insereAresta(a.v2(), a.v1(), 1);
        }

        System.out.println("Matriz:");

        g.imprime();

        System.out.println("=================");
        System.out.println("=================");
        System.out.println("Criando o grafo utilizando lista de adjacencia");

        br.ufpa.felipph.listaadj.Grafo gadj = new br.ufpa.felipph.listaadj.Grafo(8);
        for (Aresta a : Grafos.arestas) {
            gadj.insereAresta(a.v1(), a.v2(), 1);
        }
        System.out.println("Lista:");
        gadj.imprime();

        System.out.println("Questão 1,2,3 e 4");
        Thread.sleep(1000);

        System.out.println("Elabore um procedimento que informe a existência, \n"
                + "ou não, de uma certa aresta no grafo de entrada. A operação\n"
                + " deve retornar “verdadeiro”, se a aresta (i, j) \n"
                + "está presente no grafo, senão retornar “falso”\n\n");
        System.out.println("Utilizando a Matriz");

        long startTime = System.nanoTime();
        System.out.println(g.existeAresta(0, 3));
        System.out.println("------");
        System.out.println(g.existeAresta(2, 1));
        System.out.println("------");
        System.out.println(g.existeAresta(2, 6));
        System.out.println("------");
        System.out.println("------");
        long stopTime = System.nanoTime();
        long elapsedTimeMatriz = stopTime - startTime;

        startTime = System.nanoTime();
        System.out.println("Utilizando Lista:");

        System.out.println(gadj.checkAresta(0, 3));
        System.out.println("------");
        System.out.println(gadj.checkAresta(2, 1));
        System.out.println("------");
        System.out.println(gadj.checkAresta(2, 6));
        stopTime = System.nanoTime();
        long elapsedTimeLista = stopTime - startTime;

        System.out.println("Tempos(em nanosegundos): ");
        System.out.println("Matriz: ");
        System.out.println(elapsedTimeMatriz);
        System.out.println("Lista: ");
        System.out.println(elapsedTimeLista);

        System.out.println("Percebe-se que a matriz, é quase duas vezes \n"
                + "mais eficiente para busca de arestas dado o grafo da \n"
                + "questão pois somente necessita verificar se existe um índice\n"
                + "em um vetor bidimencional. Já com lista, é necessário \n"
                + "percorrer todos os adjacentes do vértice.");

        System.out.println("============================================");
        System.out.println("============================================");
        System.out.println("============================================");
        System.out.println("\n\n");

        System.out.println("Transformação em Grafo Completo");
        Thread.sleep(2000);

        System.out.println("Usando Matriz de incidência\n será feita a checagem"
                + "de arestas e inserindo somente as que não existem...");
        //apenas completando as arestas que não existem
        startTime = System.nanoTime();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (!g.existeAresta(i, j)) {
                    Aresta a = new Aresta(i, j, 1);
                    Grafos.arestas.add(a);
                    g.insereAresta(a.v1(), a.v2(), 1);
                } else {
                    System.out.println("Encontrada, nada a fazer...");
                }
            }
        }

        stopTime = System.nanoTime();
        elapsedTimeMatriz = stopTime - startTime;

        g.imprime();

        System.out.println("Agora completando a lista de adjacencia");
        startTime = System.nanoTime();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (!gadj.checkAresta(i, j)) {
                    gadj.insereAresta(i, j, 1);
                } else {
                    System.out.println("Encontrada, nada a fazer...");
                }
            }
        }
        stopTime = System.nanoTime();
        elapsedTimeLista = stopTime - startTime;

        gadj.imprime();
        System.out.println("Tempo Matriz: " + elapsedTimeMatriz);

        System.out.println("Tempo Lista: " + elapsedTimeLista);
        long perc = elapsedTimeLista / elapsedTimeMatriz;

        System.out.println("Tempo da operação com lista " + perc + "x maior");
        System.out.println("Repetindo as questões 3 e 4 agora com o grafo completo");

        startTime = System.nanoTime();
        System.out.println(g.existeAresta(0, 3));
        System.out.println("------");
        System.out.println(g.existeAresta(2, 1));
        System.out.println("------");
        System.out.println(g.existeAresta(2, 6));
        System.out.println("------");
        System.out.println("------");
        stopTime = System.nanoTime();
        elapsedTimeMatriz = stopTime - startTime;

        startTime = System.nanoTime();
        System.out.println("Utilizando Lista:");

        System.out.println(gadj.checkAresta(0, 3));
        System.out.println("------");
        System.out.println(gadj.checkAresta(2, 1));
        System.out.println("------");
        System.out.println(gadj.checkAresta(2, 6));
        stopTime = System.nanoTime();
        elapsedTimeLista = stopTime - startTime;

        System.out.println("Tempos(em nanosegundos): ");
        System.out.println("Matriz: ");
        System.out.println(elapsedTimeMatriz);
        System.out.println("Lista: ");
        System.out.println(elapsedTimeLista);

        System.out.println("Com a lista ainda maior e não ordenada, percebemos \n"
                + "que cresce muito o tempo de execução da lista em relação a matriz\n"
                + " uma vez que a busca em lista é lenta pois necessita varrer\n"
                + "todos os elementos adjacentes ao vértice.");

    }

    public static void grafo2() throws IOException {
        ArrayList<Aresta> arestasGrafo = new ArrayList<Aresta>();

        /**
         * mostrando o grafo na tela
         */
        BufferedImage grafo1 = ImageIO.read(new File("./grafo_q2.png"));
        ImgDisplay img = new ImgDisplay(null, false, grafo1);
        Thread t = new Thread(img);
        t.start();
        //criando as arestas

        arestasGrafo.add(new Aresta(0, 2, 1));
        arestasGrafo.add(new Aresta(0, 3, 1));

        arestasGrafo.add(new Aresta(1, 4, 1));
        arestasGrafo.add(new Aresta(1, 8, 1));

        arestasGrafo.add(new Aresta(2, 5, 1));

        arestasGrafo.add(new Aresta(3, 8, 1));
        arestasGrafo.add(new Aresta(3, 7, 1));

        arestasGrafo.add(new Aresta(4, 8, 1));

        arestasGrafo.add(new Aresta(5, 6, 1));

        arestasGrafo.add(new Aresta(6, 2, 1));

        arestasGrafo.add(new Aresta(7, 9, 1));

        arestasGrafo.add(new Aresta(8, 0, 1));

        arestasGrafo.add(new Aresta(9, 7, 1));

        //criando o grafo
        br.ufpa.felipph.listaadj.Grafo gAdj = new br.ufpa.felipph.listaadj.Grafo(10);

        System.out.println("Criando as arestas e adiconando ao grafo");

        System.out.println("Populando o Grafo");

        for (Aresta a : arestasGrafo) {
            gAdj.insereAresta(a.v1(), a.v2(), a.peso());
        }
        gAdj.imprime();

        System.out.println(" Em seguida, elabore um procedimento computacional\n"
                + " para validar o resultado encontrado. \n"
                + "Apresente o log de execução. ");

        System.out.println(" R: Foi utilizada a forma Lista de Adjacencia para\n"
                + "representar o grafo.");
        System.out.println("Executando a busca:");

        BuscaEmProfundidade busca = new BuscaEmProfundidade(gAdj);

        busca.buscaEmProfundidade();

        System.out.println("Tempos de visita: ");

        for (int v = 0; v < gAdj.numVertices(); v++) {
            System.out.println("d[" + v + "]:" + busca.d(v) + " -- t[" + v + "]:" + busca.t(v)
                    + " -- antecessor[" + v + "]:" + busca.antecessor(v));
        }
        
        System.out.println("==================================");
        System.out.println("==================================");
        System.out.println("==================================\n\n\n\n");
        System.out.println("Processamento para obtenção dos componentes fortemente conexos:");

        Cfc cfc = new Cfc(gAdj);
        cfc.obterCfc();

    }
}
