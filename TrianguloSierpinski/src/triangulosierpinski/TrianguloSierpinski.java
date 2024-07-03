/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package triangulosierpinski;

import javax.swing.JFrame;

/**
 *
 * @author Bruno Campos Menezes
 */
public class TrianguloSierpinski extends JFrame {
    //ALUNO: BRUNO CAMPOS MENEZES
    
    
    //Variaveis declaradas aqui para facilitar a alteracao dos valores 
    private static int nVezes;
    private static int tEspera;
    
    public TrianguloSierpinski(int nVezes, int tEspera) {
        this.tEspera = tEspera;
        this.nVezes = nVezes;
        initGui();
    }

    //Inicializar componentes gráficos
    private void initGui() {
        //Alterando titulo
        this.setTitle("Triangulo de Sierpinski");
        //Tamanho em pixels altura e largura
        setSize(750, 750);
        //Janela aparecer no meio
        setLocationRelativeTo(null);
        //terminar a aplicacao ao fechar a janela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        DesenhoTriangulo desenho = new DesenhoTriangulo(nVezes, tEspera);
        this.add(desenho);
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //Tornar a janela visivel
        setVisible(true);
    }
}
