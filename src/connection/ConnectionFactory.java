/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import static java.lang.Class.*;
import java.sql.*;



/**
 *
 * @author mathepublic static java.sql.Connection getConnection() {
 
        Connection connection = null;          //atributo do tipo Connection
 
  
 
try {
 
// Carregando o JDBC Driver padrão
 
String driverName = "com.mysql.jdbc.Driver";                        
 
Class.forName(driverName);
 
  
 
// Configurando a nossa conexão com um banco de dados//
 
        String serverName = "localhost";    //caminho do servidor do BD
 
        String mydatabase ="mysql";        //nome do seu banco de dados
 
        String url = "jdbc:mysql://" + serverName + "/" + mydatabase;
 
        String username = "root";        //nome de um usuário de seu BD      
 
        String password = "admin";      //sua senha de acesso
 
        connection = DriverManager.getConnection(url, username, password);
 
 */
public class ConnectionFactory {
    private static final String DRIVER = "com.mysql.jdbc.Driver";
private static final String URL = "jdbc:mysql://localhost:3306/banco?zeroDateTimeBehavior=convertToNull";;
    private static final String USER = "root";
    private static final String PASS = "";
    public static String status = "Não conectou...";
    
    ConnectionFactory(){
        getConnection();
    }
    
    public static Connection getConnection(){
        Connection connection = null;
        
        String driverName = "com.mysql.jdbc.Driver";                        
        try {
            Class.forName(driverName);
            connection = DriverManager.getConnection(URL, USER, PASS);
 
 
 
        //Testa sua conexão//  
 
        if (connection != null) {
 
            status = ("STATUS--->Conectado com sucesso!");
 
        } else {
 
            status = ("STATUS--->Não foi possivel realizar conexão");
 
        }
 
 
 
        return connection;
} catch (ClassNotFoundException e) {  //Driver não encontrado
 
  
 
            System.out.println("O driver expecificado nao foi encontrado.");
 
            return null;
 
        } catch (SQLException e) {
 
//Não conseguindo se conectar ao banco
 
            System.out.println("Nao foi possivel conectar ao Banco de Dados.");
 
            return null;
 
        }
 
  
 
    }
 
    public static void closeConnection(Connection con){
       
        if(con!= null){
        
            try {
                con.close();
            } catch (SQLException ex) {
                System.err.println("Erro! "+ ex);
            }
        }
    }
    
    
    public static void closeConnection(Connection con, PreparedStatement stmt){
       
        if(stmt!= null){
        
            try {
                stmt.close();
            } catch (SQLException ex) {
                System.err.println("Erro! "+ ex);
            }
        }
       closeConnection(con);
    }
    
    
    public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs){
       
        if(rs!= null){
        
            try {
                rs.close();
            } catch (SQLException ex) {
                System.err.println("Erro! "+ ex);
            }
        }
       closeConnection(con, stmt);
    }
}

 

