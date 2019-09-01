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
public class Funcoes {
    public String [][] bc;
    
    Funcoes(String matriz[][]){
         bc = matriz;
    }
    
    public void opCartoes(){/*
        FUNÇÂO OPCARTÔES
        Responsavel por realiza todas as operações que necessitam de cartão
        (Usuario e conta)
        */
        Scanner input = new Scanner(System.in);
        Scanner input2 = new Scanner(System.in);
        double sacar;
        int opc;
        String nome, senha, cvc; 
        Arquivo arq = new Arquivo();
        Print print = new Print();
        Validacao valida = new Validacao(bc);
            System.out.println("Para entrar digite seu primeiro nome e conta ");
            System.out.print("Nome: "); nome = input2.nextLine();
            System.out.println("");
            System.out.print("Conta: "); cvc = input2.nextLine();
                if(valida.User(nome)){ //FUNÇÃO VALIDA USER E VALIDA CVC
                    //Para checagem se o usuario faz parte do banco de dados
                    if(valida.Cvc( nome, cvc)){
                        print.bemvindo(valida.usuario(cvc), valida.sobrenome(cvc));
                        print.comcartao();
                opc = input.nextInt();
                OUTER:
                switch (opc){
                    case 1:/*
                        FUNÇÃO DE SAQUE VALIDA O SALDO E A SENHA
                        */
                        System.out.println("Insira o valor desejado de saque:");
                        sacar = input.nextDouble();
                        if(valida.saque(cvc, sacar)){
                             for (int i = 0; i < 3; i++){
                        System.out.println("Insira sua senha:");
                        senha = input2.nextLine();
                        if(valida.password(senha, cvc)){
                                valida.getNewSaldo(sacar, cvc);
                                bc = valida.getMatriz();
                                arq.atualizar(valida.getSaldo(cvc), valida.getCvc(cvc));
                                System.out.println("Saque efetuado com sucesso!!");
                                break OUTER;
                                                        }
                                System.out.println("!Senha invalida! Tente novamente!");
                                                       }
                                System.out.println("Cartão Bloqueado:");
                                break;
                                    }
                        else {
                                System.out.println("Saldo Insuficiente");
                                break;
                        }
                    case 2:/*FUNÇÂO SALDO
                        resgata o saldo atual da conta
                        */
                        System.out.println("Saldo");
                        System.out.println("Insira sua senha:");
                        senha = input2.nextLine();
                        if(valida.password(senha, cvc)){
                            System.out.print("Seu Saldo atual é de:  ");
                            System.out.println(bc[valida.row(nome)][4]);
                        }
                        break;
                    case 3:
                        /*
                        FUNÇÂO Transferencia
                        já tenho o nome validado do favorecedor lá em cima como: 
                        #nome
                        ag_fav = quem recebe o dinheiro
                        if ag_fav == true
                        print nome do favorecido
                        1 para confirmar 
                        if true
                        quantidade de valor a ser transferido 
                        se for valida (valor) transferencia
                        validar saque e deposito
                        */
                        System.out.println("Transferencia");
                        System.out.println("Digite o numero da conta do favorecido:");
                        System.out.print("Conta: "); 
                        String cvc_fav = input2.nextLine();
                            if(valida.Cvc(valida.usuario(cvc_fav), cvc_fav)) {
                                System.out.println(valida.usuario(cvc_fav)
                                + " " + cvc_fav);
                                print.transferencia();
                                System.out.println("Confirme para continuar: ");
                            int deposito = input.nextInt();
                        switch (deposito){
                                case 1:        
                                    System.out.println("Valor de transferencia: ");
                                    sacar = input.nextInt();
                                    if(valida.saque(cvc, sacar)){
                                        for (int i = 0; i < 3; i++){
                                            System.out.println("Insira sua senha:");
                                    senha = input2.nextLine();
                                    if(valida.password(senha, cvc)){
                                    if(valida.deposita(sacar,cvc_fav)){
                                        valida.getNewSaldo(sacar, cvc);
                                        arq.atualizar(valida.getSaldo(cvc), valida.getCvc(cvc));
                                        arq.atualizar(valida.getSaldo(cvc_fav), valida.getCvc(cvc_fav));
                                        bc = valida.getMatriz();
                                        System.out.println("Transferencia efetuada com sucesso!!");
                                        break OUTER ;
                                                                        }
                                            System.out.println("!Senha invalida! Tente novamente!");
                                                                    }
                                                System.out.println("Cartão Bloqueado:");
                                                break;}
                                                                }
                                    else{
                                            System.out.println("Saldo indisponivel!");
                                            break; 
                                    }
                    default:
                        break;
                        }
                                }
        else{System.out.println("Nome ou conta invalida");
        break;
                        }
                }
            } }
                    else{System.out.println("Nome ou conta invalida");
        }
       
    }
    
    
    public void opSemCartao(){/*
        FUNÇÃO OPSEMCARTÃO
        Menu utilizado para fazer deposito somente
        */
            Scanner input = new Scanner(System.in);
            Scanner input2 = new Scanner(System.in);
            double sacar;
            String cvc; 
            Arquivo arq = new Arquivo();
            Print print = new Print();
            Validacao valida = new Validacao(bc);
                        print.semcartao();
                        System.out.println("Digite o numero da conta");
                        System.out.print("Conta: "); 
                        cvc = input.nextLine();
                        String usuario = valida.usuario(cvc);
            if(valida.User(usuario)) {
                System.out.println(usuario
                + " " + cvc);
                print.deposito();
                System.out.print("Confirme para continuar: ");
                   int deposito = input2.nextInt();
                   switch (deposito){
                       case 1:
                           System.out.print("Digite valor a ser depositado: ");
                           sacar = input.nextInt();
                        if(valida.deposita(sacar, cvc)){
                        bc = valida.getMatriz();
                        arq.atualizar(valida.getSaldo(cvc), valida.getCvc(cvc));
                        System.out.println("Deposito efetuado com sucesso!!");
                        break;
                            }
                       default: 
                           System.out.println("Volte ao inicio e tente novamente!");
                           break;
                            }
            }
            else{System.out.println("Conta não encontrada");
            }
    }

    public void setBc(String[][] bc) {
        this.bc = bc;
    }
    
    }

