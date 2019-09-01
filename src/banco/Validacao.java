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
public class Validacao {
    private String[][] matriz;

    
    Validacao(String[][] matriz){   
    //construtor com a matriz de dados
        this.matriz = matriz;
    }
    
    public boolean User(String usuario){ 
    //validação do usuario
             return (row(usuario) != -1);
    }
    
    public boolean Cvc(String usuario, String cvc){ 
    //validação da conta com usuario
        return (matriz[row(usuario)][1].equals(cvc));
    
    }
    
    public int getCvc(String cvc){ 
    //validação da conta com usuario
        return Integer.valueOf(matriz[row(usuario(cvc))][1]);
    
    }
    
     public String sobrenome(String cvc){ 
    //Retorno do sobrenome de usuario 
        for (int row = 0; row<matriz.length; row++){
            String x = (String)matriz[row][1];
            String name = (String)matriz[row][3];
            if (cvc.equals(x)){
                return name ;}
        }
        return null;
    }
    
    public String usuario(String cvc){ 
    //retorno do nome de usuario da cvc 
        for (int row = 0; row<matriz.length; row++){
            String x = (String)matriz[row][1];
            String name = (String)matriz[row][2];
            if (cvc.equals(x)){
                return name ;}
        }
        return null;
    }
    
    public   int row(String usuario){
    // pegar a linha do usuario na Array
        for (int row = 0; row<matriz.length; row++){
            String x = (String)matriz[row][2];
            if (usuario.equals(x)){
                return row;}
        }
        return -1;
    }
    
    public  boolean password(String senha, String cvc){
//Função password() responsavel por verificar a senha do usuario
            int user = row(usuario(cvc));
            String a;
            a = matriz[user][5];
        return senha.equals(a);
    }

    public String[][] getMatriz() {// atualizador de matriz para o main
        return matriz;
    }

    public void setMatriz(String[][] matriz) {
        this.matriz = matriz;
    }
  
    
    
    public boolean deposita(double sacar,String cvc){
//Função deposita() valida a conta a ser favorecida e atualizar saldo referente
        double newsaldo = 0.0;
        String usuario = usuario(cvc);
        int user = row(usuario);
        double saldo = Double.parseDouble(matriz[user][4]);
            newsaldo = (saldo+sacar);
            matriz[user][4] = String.valueOf(newsaldo);
            return  true;}
       
    public void getNewSaldo(double sacar, String cvc){
//Função GetNewSaldo responsavel por atualizar saldo menos valor sacado         
        double newsaldo = 0.0;
        int user = row(usuario(cvc));
        double saldo = Double.parseDouble(matriz[user][4]);
           newsaldo =  (saldo - sacar); 
              this.matriz[user][4] = Double.toString(newsaldo); 
                     
    }
    
    public String getSaldo(String cvc){
//Função getSaldo responsavel por pegar o saldo atualizado
//no Array e lançar para o banco de dados
        int user = row(usuario(cvc));
        return (String)matriz[user][4]; 
    }
    
    
    public  boolean saque(String cvc,double sacar){
//Função saque responsavel por verificar se o usuario tem saldo suficiente para saque
        int user = row(usuario(cvc));
        double saldo = Double.parseDouble(matriz[user][4]);
        return sacar <= saldo;   
    }
}
    
    
   