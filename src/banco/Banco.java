/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

import java.util.Scanner;

/**
 *
 * @author mathe
 */
public class Banco {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input = new Scanner(System.in);
        int opc1;
        boolean  saida = true;
        Arquivo arq = new Arquivo();
        arq.listar();
        String [][] bc = arq.getA();
        Print print= new Print();
        Funcoes function = new Funcoes(bc);
        
        while ( saida == true){
            arq.listar();
            bc = arq.getA();
            
            function.setBc(bc);
            print.menu();
        opc1 = input.nextInt();
        OUTER: 
        switch (opc1) {
            case 1: // Função com cartão
                function.opCartoes();
                break;
            case 2 : // FUNÇÂO Sem Cartão
                function.opSemCartao();
                break;
            default:
                saida = false;
                break;
        }
        }
    }
}
                   