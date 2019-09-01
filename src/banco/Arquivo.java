/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

/**
 *
 * @author mathe
 */

//Classe arquivo abre, atualiza a matriz do programa e salva
 
public class Arquivo {
    public  int str = 8;
    public  int clm = 5;
    public String[][] arq = new String[str][6];

    /*
    A função listar(),conecta-se ao banco de dados 
    e retorna os valores de cada coluna e retorna um Array com o banco de dados 
    atualizado
    */
    public void listar(){
        UsuarioDAO dao = new UsuarioDAO();
        int i = 0;
        for(Usuario c: dao.findAll()){
            arq[i][0] = String.valueOf(c.getContaTipo());
            arq[i][1] = String.valueOf(c.getConta());
            arq[i][2] = c.getNome();
            arq[i][3] = c.getSobrenome();
            arq[i][4] = c.getSaldo();
            arq[i][5] = c.getSenha();
            i++;}
        }
    
      /*
    A função atualiza(), atualiza o saldo das contas se conectando 
    com o banco de dados e procurando o ID conta  
    */
    public void atualizar(String newSaldo, int conta) {
        
        Usuario user = new Usuario();
        user.setSaldo(newSaldo);
        user.setConta(conta);
        UsuarioDAO dao = new UsuarioDAO();
        
        if(dao.updateSaldo(user)){
            
        }else{
            System.err.println("Erro na conexão");
        
    }
    }
    public void setA(String[][] a) {
        this.arq = a; 
        
    }
    public String[][] getA() {
        return arq;
    }
 }