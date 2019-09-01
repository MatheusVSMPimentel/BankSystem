/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author mathe
 */
public class UsuarioDAOTest {
    
    public UsuarioDAOTest() {
    }
@Ignore
    @Test
    public void insert() {
        
        Usuario user = new Usuario(9960, 02, "Paloma", "Santos", "1168.00", "1234");
        UsuarioDAO dao = new UsuarioDAO();
        
        if(dao.save(user)){
            System.out.println("Deu certo");
        }else{
        fail("Erro ao salvar");
        
    }
    
}
    @Test
    public void atualizar() {
        
        Usuario user = new Usuario();
        user.setConta(3436);
        user.setSaldo("2000.00");
        UsuarioDAO dao = new UsuarioDAO();
        
        if(dao.updateSaldo(user)){
            System.out.println("Deu certo");
        }else{
        fail("Erro ao salvar");
        
    }
    
}
    @Test
    @Ignore
    public void listar(){
        UsuarioDAO dao = new UsuarioDAO();
        String[][] arq = new String[7][5];
        int i = 0;
        for(Usuario c: dao.findAll()){
            arq[i][0] = String.valueOf(c.getContaTipo());
            arq[i][0] = String.valueOf(c.getConta());
            arq[i][0] = c.getNome();
            arq[i][0] = c.getSobrenome();
            arq[i][0] = c.getSaldo();
            arq[i][0] = c.getSenha();
            i++;
            System.out.println("Saldo: " + c.getSaldo());
                
        }
        System.out.println("Conexão Sucedida");
        }
    }

