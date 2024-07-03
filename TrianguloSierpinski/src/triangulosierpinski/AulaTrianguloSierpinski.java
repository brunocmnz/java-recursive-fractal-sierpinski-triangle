/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package triangulosierpinski;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author Bruno Campos Menezes
 */
public class AulaTrianguloSierpinski extends JFrame{
    //ALUNO: BRUNO CAMPOS MENEZES

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        TrianguloSierpinski ts = new TrianguloSierpinski(5, 100);
    }
    
}
