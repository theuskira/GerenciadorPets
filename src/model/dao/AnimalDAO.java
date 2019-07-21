package model.dao;

import connection.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.bean.Animal;
import model.bean.Proprietario;

/**
 *
 * @author Matheus - DELL
 */
public class AnimalDAO {
    
    private Connection con = Conexao.getConnection();
    private PreparedStatement stmt = null;
    
    public void create(Animal animal){
        
        try {
            
            stmt = con.prepareStatement("INSERT INTO"
                    + " animal "
                    + "(nome, raca, pelagem, tipo, idade, sexo, peso, proprietarioId) "
                    + "VALUES "
                    + "(?, ?, ?, ?, ?, ?, ?, ?);");
            
            stmt.setString(1, animal.getNome());
            stmt.setString(2, animal.getRaca());
            stmt.setString(3, animal.getPelagem());
            stmt.setString(4, animal.getTipo());
            stmt.setString(5, animal.getIdade());
            stmt.setString(6, animal.getSexo());
            stmt.setDouble(7, animal.getPeso());
            stmt.setInt(8, animal.getProprietarioId());
            
            stmt.executeUpdate();
            
            System.out.println(animal.getNome() + " salvo!");
            JOptionPane.showMessageDialog(null, animal.getNome() + " salvo!");
            
        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage());
            
        }finally{
            
            Conexao.closeConnection(con, stmt);
            
        }
        
    }
    
    public List<Animal> read(){
        
       ResultSet rs = null;
        
       List<Animal> listaAnimal = new ArrayList<>();
        
        try {
            
            stmt = con.prepareStatement("SELECT * FROM animal ORDER BY nome");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                
                Animal a = new Animal(
                        rs.getInt("id"),
                        rs.getInt("proprietarioId"),
                        rs.getString("nome"),
                        rs.getString("raca"),
                        rs.getString("idade"),
                        rs.getString("pelagem"),
                        rs.getString("tipo"),
                        rs.getString("sexo"),
                        rs.getString("dataCadastro"),
                        rs.getDouble("peso")
                );
                
                listaAnimal.add(a);
                
            }
            
        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage());
            
        }finally{
            
            Conexao.closeConnection(con, stmt, rs);
            
        }
        
        return listaAnimal;
        
    }
    
    public List<Animal> readFromOwner(int id){
        
       ResultSet rs = null;
        
       List<Animal> listaAnimal = new ArrayList<>();
        
        try {
            
            stmt = con.prepareStatement("SELECT * FROM animal WHERE proprietarioId = " + id + " ORDER BY nome");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                
                Animal a = new Animal(
                        rs.getInt("id"),
                        rs.getInt("proprietarioId"),
                        rs.getString("nome"),
                        rs.getString("raca"),
                        rs.getString("idade"),
                        rs.getString("pelagem"),
                        rs.getString("tipo"),
                        rs.getString("sexo"),
                        rs.getString("dataCadastro"),
                        rs.getDouble("peso")
                );
                
                listaAnimal.add(a);
                
            }
            
        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage());
            
        }finally{
            
            Conexao.closeConnection(con, stmt, rs);
            
        }
        
        return listaAnimal;
        
    }
    
    public List<Animal> search(String search){
        
       ResultSet rs = null;
        
       List<Animal> listaAnimal = new ArrayList<>();
        
        try {
            
            stmt = con.prepareStatement("SELECT * FROM proprietario WHERE nome LIKE '%"
                    + search 
                    +"%' OR raca LIKE '%"
                    + search 
                    +"%' OR pelagem LIKE '%"
                    + search 
                    +"%' OR tipo LIKE '%"
                    + search 
                    +"%' ORDER BY nome");
            
            rs = stmt.executeQuery();
            
            while(rs.next()){
                
                Animal a = new Animal(
                        rs.getInt("id"),
                        rs.getInt("proprietarioId"),
                        rs.getString("nome"),
                        rs.getString("raca"),
                        rs.getString("idade"),
                        rs.getString("pelagem"),
                        rs.getString("tipo"),
                        rs.getString("sexo"),
                        rs.getString("dataCadastro"),
                        rs.getDouble("peso")
                );
                
                listaAnimal.add(a);
                
            }
            
        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage());
            
        }finally{
            
            Conexao.closeConnection(con, stmt, rs);
            
        }
        
        return listaAnimal;
    }
    
}
