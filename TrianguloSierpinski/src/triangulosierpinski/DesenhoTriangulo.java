/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package triangulosierpinski;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bruno Campos Menezes
 */
public class DesenhoTriangulo extends Canvas {
    //ALUNO: BRUNO CAMPOS MENEZES
    

    //Variaveis declaradas aqui para facilitar a alteracao dos valores 
    private static int nVezes;
    private static int tEspera;

    public DesenhoTriangulo(int nVezes, int tEspera) {
        this.tEspera = tEspera;
        this.nVezes = nVezes;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g); //To change body of generated methods, choose Tools | Templates.
        criaTriangulo(g);
    }

    private void criaTriangulo(Graphics g) {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException ex) {
            Logger.getLogger(AulaTrianguloSierpinski.class.getName()).log(Level.SEVERE, null, ex);
        }
        double largura = getWidth() - 5;
        double altura = getHeight() - 30;
        int[] vetX = {(int) 0, (int) largura / 2, (int) largura};
        int[] vetY = {(int) altura, (int) 0, (int) altura};
        g.fillPolygon(vetX, vetY, 3);
        try {
            Thread.sleep(tEspera);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        g.setColor(Color.WHITE);
        try {
            Thread.sleep(400);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (nVezes > 0) {
            criaTrianguloRecu(g, 1, nVezes, 0, altura, largura / 2, 0, largura, altura);
        }

    }

    private void criaTrianguloRecu(Graphics g, int nivel, int nivelMax,
              double x1, double y1, double x2, double y2, double x3, double y3) {
        if (nivel < nivelMax) {
            //Chamada do triangulo da esquerda, desenha o do meio e 
            // chama o da direita e o de cima
            //Triangulo esquerda
            criaTrianguloRecu(g, nivel + 1, nivelMax, x1, y1, (x1 + x2) / 2, (y1 + y2) / 2, (x1 + x3) / 2, (y1 + y3) / 2);
            //Triangulo maior (desenhar o do meio)
            int[] vx = {(int) (x1 + x2) / 2, (int) (x2 + x3) / 2, (int) (x1 + x3) / 2};
            int[] vy = {(int) (y1 + y2) / 2, (int) (y2 + y3) / 2, (int) (y1 + y3) / 2};
            desenhaTriangulo(vx, vy, g);
            //Triangulo de cima
            criaTrianguloRecu(g, nivel + 1, nivelMax, (x1 + x2) / 2, (y1 + y2) / 2,
                      x2, y2, (x2 + x3) / 2, (y2 + y3) / 2);
            //Triangulo da direita
            criaTrianguloRecu(g, nivel + 1, nivelMax, (x1 + x3) / 2, (y1 + y3) / 2,
                      (x2 + x3) / 2, (y2 + y3) / 2, x3, y3);
        } else {
            //Desenhar
            int[] vx = {(int) (x1 + x2) / 2, (int) (x1 + x3) / 2, (int) (x2 + x3) / 2};
            int[] vy = {(int) (y1 + y2) / 2, (int) (y1 + y3) / 2, (int) (y2 + y3) / 2};
            desenhaTriangulo(vx, vy, g);
        }
    }

    public void desenhaTriangulo(int[] vx, int[] vy, Graphics g) {
        try {
            Thread.sleep(tEspera);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        g.fillPolygon(vx, vy, 3);
    }

}
