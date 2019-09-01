/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author mathe
 */

public class UsuarioDAO {
    
    private Connection con = null;

    public UsuarioDAO() {
       con = ConnectionFactory.getConnection();
    }
    
    public boolean save(Usuario user){
//Função save para salvar dados no banco de dados
        String sql = "INSERT INTO usuarios(Conta_Tipo ,Conta , Nome, Sobrenome, Senha, Saldo) VALUES(?,?,?,?,?,?)";
        PreparedStatement  stmt = null;
        try {
            stmt  = con.prepareStatement(sql);
            stmt.setInt(1, user.getConta());
            stmt.setInt(2, user.getContaTipo());
            stmt.setString(3, user.getNome());
            stmt.setString(4, user.getSobrenome());
            stmt.setString(5, user.getSenha());
            stmt.setString(6, user.getSaldo());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro! daw " + ex);
            return false;
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }   
        
    }
    
    public List<Usuario> findAll(){
/*Função findAll, listar o banco de dados e 
seus respectivos dados em suas respctivas colunas atribuindo esse valores a
        categoria usuario que organiza os dados para função listar() 
        coleta e gravar na raiz do programa
        */
            String sql = "SELECT * FROM usuarios";
            PreparedStatement stmt = null;
            ResultSet rs = null;
            List<Usuario> usuarios = new ArrayList<>();
            try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while(rs.next()){
            
                Usuario usuario = new Usuario();
                usuario.setContaTipo(rs.getInt("Conta_Tipo"));
                usuario.setConta(rs.getInt("Conta"));
                usuario.setNome(rs.getString("Nome"));
                usuario.setSobrenome(rs.getString("Sobrenome"));
                usuario.setSaldo(rs.getString("Saldo"));
                usuario.setSenha(rs.getString("Senha"));
                usuarios.add(usuario);
            }
        } catch (SQLException ex) {
            System.err.println("Categoria DAO" + ex);
            
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
            return usuarios;
        } 
        
    public boolean updateSaldo(Usuario user){
        /*
        Função updateSaldo utilizada para atualiza o saldo de um usuario
        a partir da função atualizar() da classe arquivo pelo ID conta
        */
        String sql = "UPDATE usuarios SET Saldo = ? WHERE Conta = ?";
        PreparedStatement  stmt = null;
        try {
            stmt  = con.prepareStatement(sql);
            stmt.setString(1, user.getSaldo());
            stmt.setInt(2, user.getConta());
            
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro! daw " + ex);
            return false;
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }   
        
    }
}


