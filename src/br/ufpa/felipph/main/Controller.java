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
import br.ufpa.felipph.shared.TextAreaOutputStream;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author felipph
 */
public class Controller {

    public ArrayList<Aresta> arestasGrafo1 = new ArrayList<Aresta>();
    public ArrayList<Aresta> arestasGrafo2 = new ArrayList<Aresta>();
    public ArrayList<Aresta> arestasGrafo3 = new ArrayList<Aresta>();

    public Controller() {

        this.init();

    }

    public void init() {
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
    }

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

    public String q1() {
        String saida = "";

        System.out.println("Q1. Elabore um procedimento que informe a existência, \n"
                + "ou não, de uma certa aresta no grafo de entrada. A operação\n"
                + " deve retornar “verdadeiro”, se a aresta (i, j) \n"
                + "está presente no grafo, senão retornar “falso”\n\n");

        System.out.println("=================");
        System.out.println("Criando o grafo utilizando lista de adjacencia");

        br.ufpa.felipph.listaadj.Grafo gadj = new br.ufpa.felipph.listaadj.Grafo(8);
        for (Aresta a : this.arestasGrafo1) {
            gadj.insereAresta(a.v1(), a.v2(), 1);
        }
        System.out.println("Lista:");
        gadj.imprime();

        System.out.println("=================");
        System.out.println("Criando o grafo utilizando Matriz de incidência");
        Grafo g = new Grafo(8);
        for (Aresta a : this.arestasGrafo1) {
            g.insereAresta(a.v1(), a.v2(), 1);
            //g.insereAresta(a.v2(), a.v1(), 1);
        }
        System.out.println("Matriz:");
        g.imprime();

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

        System.out.println("Usando Matriz de incidência\n será feita a checagem"
                + "de arestas e inserindo somente as que não existem...");
        //apenas completando as arestas que não existem
        startTime = System.nanoTime();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (!g.existeAresta(i, j)) {
                    Aresta a = new Aresta(i, j, 1);
                    this.arestasGrafo1.add(a);
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
        return saida;
    }

    long tempoQ2Matriz;
    long tempoQ2Lista;

    public void q2() {
        System.out.println("Elabore um procedimento que obtenha o conjunto de vértices adjacentes a um\n"
                + "determinado vértice i presente em G. Esse procedimento deve ser implementado\n"
                + "usando matriz e lista de adjacência. Apresente log de execução.");

        br.ufpa.felipph.matrizadj.Grafo gMatriz = new Grafo(8);
        System.out.println("Populando o grafo");

        this.arestasGrafo1 = new ArrayList<Aresta>();
        this.init();
        gMatriz = this.popular_grafo(gMatriz, this.arestasGrafo1);

        try {
            this.showGrafo1();
        } catch (IOException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        gMatriz.imprime();
        System.out.println("Listando adijacentes usando a matriz.");
        System.out.println("Matriz:");
        gMatriz.imprime();

        long startTime = System.nanoTime();

        gMatriz.listaAdjacentes(3);

        gMatriz.listaAdjacentes(5);

        gMatriz.listaAdjacentes(7);

        long stopTime = System.nanoTime();
        this.tempoQ2Matriz = stopTime - startTime;

        System.out.println("Listando adijacentes usando a lista.");

        br.ufpa.felipph.listaadj.Grafo gLista = new br.ufpa.felipph.listaadj.Grafo(8);
        System.out.println("Populando o grafo");
        gLista = this.popular_grafo(gLista, this.arestasGrafo1);

        gLista.imprime();
        startTime = System.nanoTime();
        gLista.listaAdjacentes(3);

        gLista.listaAdjacentes(5);

        gLista.listaAdjacentes(7);
        stopTime = System.nanoTime();
        this.tempoQ2Lista = stopTime - startTime;

    }

    public void q3() {
        System.out.println("Executando a questão 2");
        this.q2();
        System.out.println("Obtendo os tempos:");

        System.out.println("Tempo Matriz: " + this.tempoQ2Matriz);
        System.out.println("Tempo Lista: " + this.tempoQ2Lista);
    }

    public void q4() {
        System.out.println("Após alguns testes, vi que houve em minha execução \n"
                + "diferenças mínimas de performace pois se trata de em grafo pequeno. \n"
                + "Porém, teoricamente a listagem dos adjacentes com lista deveria ser mais performática pois \n"
                + "são executadas somente as interações necessárias para obter os adjacentes. Já\n"
                + "com matriz, é necessário interar sobre cada item do índice escolho para verificar se\n"
                + "a aresta realmente existe.\n"
                + "Logo a lista de adjacencia leva vantagem e relação a matriz para esse\n"
                + "caso.");
    }

    public void q5() {
        System.out.println("Criando o grafom com Lista e Matriz:");
        br.ufpa.felipph.matrizadj.Grafo gMatriz = new Grafo(8);
        gMatriz = this.popular_grafo(gMatriz, this.arestasGrafo1);
        System.out.println("Matriz?");
        gMatriz.imprime();

        br.ufpa.felipph.listaadj.Grafo gLista = new br.ufpa.felipph.listaadj.Grafo(8);
        gLista = this.popular_grafo(gLista, this.arestasGrafo1);
        System.out.println("Lista:");
        gLista.imprime();
        System.out.println("Transformação em Grafo Completo");
        System.out.println("Usando Matriz de incidência\n será feita a checagem"
                + "de arestas e inserindo somente as que não existem...");
        //apenas completando as arestas que não existem
        long startTime = System.nanoTime();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (!gMatriz.existeAresta(i, j)) {
                    Aresta a = new Aresta(i, j, 1);
                    this.arestasGrafo1.add(a);
                    gMatriz.insereAresta(a.v1(), a.v2(), 1);
                } else {
                    System.out.println("Encontrada, nada a fazer...");
                }
            }
        }

        long stopTime = System.nanoTime();
        long elapsedTimeMatriz = stopTime - startTime;

        gMatriz.imprime();

        System.out.println("Agora completando a lista de adjacencia");
        startTime = System.nanoTime();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (!gLista.checkAresta(i, j)) {
                    gLista.insereAresta(i, j, 1);
                } else {
                    System.out.println("Encontrada, nada a fazer...");
                }
            }
        }
        stopTime = System.nanoTime();
        long elapsedTimeLista = stopTime - startTime;

        gLista.imprime();
        System.out.println("Tempo Matriz: " + elapsedTimeMatriz);

        System.out.println("Tempo Lista: " + elapsedTimeLista);
        long perc = elapsedTimeLista / elapsedTimeMatriz;

        System.out.println("Tempo da operação com lista " + perc + "x maior");
        System.out.println("Repetindo as questões 3 e 4 agora com o grafo completo");

        startTime = System.nanoTime();
        System.out.println(gMatriz.existeAresta(0, 3));
        System.out.println("------");
        System.out.println(gMatriz.existeAresta(2, 1));
        System.out.println("------");
        System.out.println(gMatriz.existeAresta(2, 6));
        System.out.println("------");
        System.out.println("------");
        stopTime = System.nanoTime();
        elapsedTimeMatriz = stopTime - startTime;

        startTime = System.nanoTime();
        System.out.println("Utilizando Lista:");

        System.out.println(gLista.checkAresta(0, 3));
        System.out.println("------");
        System.out.println(gLista.checkAresta(2, 1));
        System.out.println("------");
        System.out.println(gLista.checkAresta(2, 6));
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

    public void q6() {
        br.ufpa.felipph.listaadj.Grafo gAdj = new br.ufpa.felipph.listaadj.Grafo(10);

        System.out.println("Populando o Grafo");

        for (Aresta a : this.arestasGrafo2) {
            gAdj.insereAresta(a.v1(), a.v2(), a.peso());
        }
        gAdj.imprime();

        System.out.println("Mostre como a busca em profundidade funciona para o dígrafo D, ou seja, informe a\n"
                + "ordem de visita dos vértices. Em seguida, elabore um procedimento computacional\n"
                + "para validar o resultado encontrado. Apresente o log de execução");

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
    }

    public void q7() {
        br.ufpa.felipph.listaadj.Grafo gAdj = new br.ufpa.felipph.listaadj.Grafo(10);

        System.out.println("Processamento para obtenção dos componentes fortemente conexos:");
        System.out.println("Populando o Grafo:");

        gAdj = this.popular_grafo(gAdj, this.arestasGrafo2);
        gAdj.imprime();
        
        
        Cfc cfc = new Cfc(gAdj);
        System.out.println("Obtendo os componentes fortemente conexos:");
        
        cfc.obterCfc();
    }

    public br.ufpa.felipph.matrizadj.Grafo popular_grafo(br.ufpa.felipph.matrizadj.Grafo g, ArrayList<Aresta> arestas) {
        for (Aresta a : arestas) {
            g.insereAresta(a.v1(), a.v2(), 1);
        }
        return g;
    }

    public br.ufpa.felipph.listaadj.Grafo popular_grafo(br.ufpa.felipph.listaadj.Grafo g, ArrayList<Aresta> arestas) {
        for (Aresta a : arestas) {
            g.insereAresta(a.v1(), a.v2(), 1);
        }
        return g;
    }

    public void grafo1() throws IOException, InterruptedException {
        //exibindo o grafo da primeira questão

        System.out.println("Populando o grafo utilizando Matriz de Adjacencia...");
        Grafo g = new Grafo(8);
        System.out.println("Criando arestas na ordem crescente dos vertices");
        System.out.println("Gerando a Matriz");
        for (Aresta a : this.arestasGrafo1) {
            g.insereAresta(a.v1(), a.v2(), 1);
            //g.insereAresta(a.v2(), a.v1(), 1);
        }

        System.out.println("Matriz:");

        g.imprime();

        System.out.println("=================");
        System.out.println("=================");
        System.out.println("Criando o grafo utilizando lista de adjacencia");

        br.ufpa.felipph.listaadj.Grafo gadj = new br.ufpa.felipph.listaadj.Grafo(8);
        for (Aresta a : this.arestasGrafo1) {
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
                    this.arestasGrafo1.add(a);
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

    public void grafo2() throws IOException {
        /**
         * mostrando o grafo na tela
         */
        BufferedImage grafo1 = ImageIO.read(new File(System.getProperty("user.dir") + "/grafo_q2.PNG"));
        ImgDisplay img = new ImgDisplay(null, false, grafo1);
        Thread t = new Thread(img);
        t.start();
        //criando as arestas

        //criando o grafo
        br.ufpa.felipph.listaadj.Grafo gAdj = new br.ufpa.felipph.listaadj.Grafo(10);

        System.out.println("Criando as arestas e adiconando ao grafo");

        System.out.println("Populando o Grafo");

        for (Aresta a : this.arestasGrafo2) {
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
