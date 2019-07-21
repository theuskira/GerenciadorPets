package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexao {
    
        private static final String DRIVE = "com.mysql.jdbc.Driver";
        //private static final String LOCAL = "localhost";
        private static final String LOCAL = "10.0.0.200";
        private static final String URL = "jdbc:mysql://" + LOCAL + ":3306/gerenciadorpets";
        //private static final String USER = "root";
        private static final String USER = "theuskira";
        //private static final String PASSWORD = "";
        private static final String PASSWORD = "pw123456";
    
    public static Connection getConnection(){
        
        try{
            
            Class.forName(DRIVE);
            
            return DriverManager.getConnection(URL, USER, PASSWORD);
            
        }catch(SQLException | ClassNotFoundException e){
            
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
            return null;
            
        }
    
    }
    
    public static void closeConnection(Connection con){
        
        if(con != null){
            
            try {
                
                con.close();
                
            } catch (SQLException e) {
                
                JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
                
            }
        }
        
    }
    
    public static void closeConnection(Connection con, PreparedStatement stmt){
        
        closeConnection(con);
            
        if(stmt != null){
            
            try {
                
                stmt.close();
                
            } catch (SQLException e) {
                
                JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
                
            }
        }
        
    }
    
    public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs){
        
        closeConnection(con, stmt);
            
        if(rs != null){
            
            try {
                
                rs.close();
                
            } catch (SQLException e) {
                
                JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
                
            }
        }
        
    }
    
}
