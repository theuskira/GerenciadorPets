package model.dao;

import connection.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.Usuario;

public class UsuarioDAO {
    
    private Connection con = Conexao.getConnection();
    private PreparedStatement stmt = null;
    
    public void create(Usuario usuario){
        
        try {
            
            stmt = con.prepareStatement("INSERT INTO"
                    + " login "
                    + "(nome, usuario, senha, tipo) "
                    + "VALUES "
                    + "(?, ?, ?, ?);");
            
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getUsuario());
            stmt.setString(3, usuario.getSenha());
            stmt.setInt(4, usuario.getTipo());
            
            stmt.executeUpdate();
            
            System.out.println(usuario.getNome() + " salvo!");
            JOptionPane.showMessageDialog(null, usuario.getNome() + " salvo!");
            
        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage());
            
        }finally{
            
            Conexao.closeConnection(con, stmt);
            
        }
        
    }
    
    public List<Usuario> read(){
        
       ResultSet rs = null;
        
       List<Usuario> listaUsuario = new ArrayList<>();
        
        try {
            
            stmt = con.prepareStatement("SELECT * FROM login");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                
                Usuario usuario = new Usuario();
                
                usuario.setUsuario(rs.getString("usuario"));
                usuario.setNome(rs.getString("nome"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setTipo(rs.getInt("tipo"));
                
                listaUsuario.add(usuario);
                
            }
            
        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage());
            
        }finally{
            
            Conexao.closeConnection(con, stmt, rs);
            
        }
        
        return listaUsuario;
        
    }
    
}
