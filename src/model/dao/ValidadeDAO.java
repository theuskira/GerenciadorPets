package model.dao;

import connection.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.bean.Validade;

/**
 *
 * @author Matheus - DELL
 */
public class ValidadeDAO {
    
    private Connection con = Conexao.getConnection();
    private PreparedStatement stmt = null;
    
    public void create(Validade validade){
        
        try {
            
            stmt = con.prepareStatement("INSERT INTO"
                    + " validade "
                    + "(id, dataValidade) "
                    + "VALUES "
                    + "(?, ?);");
            
            stmt.setString(1, validade.getId());
            stmt.setString(2, validade.getDataValidade());
            
            stmt.executeUpdate();
            
            System.out.println(validade.getId() + " salvo para " + validade.getDataCadastro() + "!");
            JOptionPane.showMessageDialog(null, validade.getId() + " salvo para " + validade.getDataCadastro() + "!");
            
        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage());
            
        }finally{
            
            Conexao.closeConnection(con, stmt);
            
        }
        
    }
    
    public List<Validade> read(){
        
       ResultSet rs = null;
        
       List<Validade> listaValidades = new ArrayList<>();
        
        try {
            
            stmt = con.prepareStatement("SELECT * FROM validade");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                
                Validade v = new Validade();
                
                v.setId(rs.getString("id"));
                v.setDataValidade(rs.getString("dataValidade"));
                v.setDataCadastro(rs.getString("dataCadastro"));
                
                listaValidades.add(v);
                
            }
            
        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage());
            
        }finally{
            
            Conexao.closeConnection(con, stmt, rs);
            
        }
        
        return listaValidades;
        
    }
    
}
