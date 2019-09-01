/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

/**
 *
 * @author mathe
 * classe usuario valida, organiza, atualiza, os dados do banco de dados 
 */
public class Usuario {
    private int row;
    
    private int contaTipo;
    private String nome;
    private String sobrenome;
    private String senha;
    private String saldo;
    private int conta;

    public Usuario() {
    }
   

   
    

    public Usuario(  int contaTipo, int conta, String nome, String sobrenome, String saldo,
            String senha) {
        
        this.contaTipo = contaTipo;
        this.conta = conta;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.saldo = saldo;
        this.senha = senha;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getContaTipo() {
        return contaTipo;
    }

    public void setContaTipo(int contaTipo) {
        this.contaTipo = contaTipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getSaldo() {
        return saldo;
    }

    public void setSaldo(String saldo) {
        this.saldo = saldo;
    }

    public int getConta() {
        return conta;
    }

    public void setConta(int conta) {
        this.conta = conta;
    }

  
    
}
