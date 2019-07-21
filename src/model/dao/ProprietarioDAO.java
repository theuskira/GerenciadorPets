package model.dao;

import connection.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.bean.Proprietario;
import model.bean.Usuario;

/**
 *
 * @author Matheus - DELL
 */
public class ProprietarioDAO {
    
    private Connection con = Conexao.getConnection();
    private PreparedStatement stmt = null;
    
    public void create(Proprietario proprietario){
        
        try {
            
            stmt = con.prepareStatement("INSERT INTO"
                    + " proprietario "
                    + "(nome, cpf, endereco, numero) "
                    + "VALUES "
                    + "(?, ?, ?, ?);");
            
            stmt.setString(1, proprietario.getNome());
            stmt.setString(2, proprietario.getCpf());
            stmt.setString(3, proprietario.getEndereco());
            stmt.setString(4, proprietario.getNumero());
            
            stmt.executeUpdate();
            
            System.out.println(proprietario.getNome() + " salvo!");
            JOptionPane.showMessageDialog(null, proprietario.getNome() + " salvo!");
            
        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage());
            
        }finally{
            
            Conexao.closeConnection(con, stmt);
            
        }
        
    }
    
    public List<Proprietario> read(){
        
       ResultSet rs = null;
        
       List<Proprietario> listaProprietario = new ArrayList<>();
        
        try {
            
            stmt = con.prepareStatement("SELECT * FROM proprietario ORDER BY nome");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                
                Proprietario pro = new Proprietario(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("cpf"),
                        rs.getString("endereco"),
                        rs.getString("numero")
                );
                
                listaProprietario.add(pro);
                
            }
            
        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage());
            
        }finally{
            
            Conexao.closeConnection(con, stmt, rs);
            
        }
        
        return listaProprietario;
        
    }
    
    public List<Proprietario> search(String search){
        
       ResultSet rs = null;
        
       List<Proprietario> listaProprietario = new ArrayList<>();
        
        try {
            
            stmt = con.prepareStatement("SELECT * FROM proprietario WHERE nome LIKE '%"
                    + search 
                    +"%' OR cpf LIKE '%"
                    + search 
                    +"%' OR numero LIKE '%"
                    + search 
                    +"%' ORDER BY nome");
            
            rs = stmt.executeQuery();
            
            while(rs.next()){
                
                Proprietario pro = new Proprietario(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("cpf"),
                        rs.getString("endereco"),
                        rs.getString("numero")
                );
                
                listaProprietario.add(pro);
                
            }
            
        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage());
            
        }finally{
            
            Conexao.closeConnection(con, stmt, rs);
            
        }
        
        return listaProprietario;
        
    }
    
}
