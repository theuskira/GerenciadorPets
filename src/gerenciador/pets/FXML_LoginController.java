/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciador.pets;

import connection.Conexao;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import model.bean.Administrador;
import model.bean.Usuario;
import model.bean.Validade;
import model.dao.UsuarioDAO;
import model.dao.ValidadeDAO;

/**
 *
 * @author Matheus - DELL
 */
public class FXML_LoginController implements Initializable {

    @FXML
    private TextField txtUsuario;
    @FXML
    private PasswordField txtSenha;
    @FXML
    private Button btnEntrar;
    @FXML
    private ImageView imgStatus;
    @FXML
    private Label txtStatus;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        
        verificarCampos();
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        //pararProgress();
        
        // TODO
        System.out.println("FXML INICIADO");
        
        final KeyCombination ENTER = (KeyCombination) new KeyCodeCombination(KeyCode.ENTER);
        
        verificarConexao();
        
        txtUsuario.setOnKeyPressed(k -> {
            
            if(ENTER.match(k)){
                
                txtSenha.requestFocus();
            
            }
            
        });
        
        txtSenha.setOnKeyPressed(k -> {
            
            if(ENTER.match(k)){
                
                verificarCampos();
                
            }
            
        });
        
    }
    
    private boolean verificarConexao(){
        try{

            if(Conexao.getConnection() != null){

                //txtLoginStatus.setText("Conectado ao banco!");
                
                imgStatus.setImage(new Image("gerenciador/pets/img/on.png"));
                
                return true;

            }else{
                
                txtStatus.setText("Sem conexão!");
                
                txtStatus.setTextFill(Color.web("#FF0000")); // RED
                
                imgStatus.setImage(new Image("gerenciador/pets/img/off.png"));
                
                return  false;

            }
            
        }catch(Exception e){
            
            System.out.println("Erro: " + e.getMessage());
            
            txtStatus.setText("Sem conexão!");
            
            txtStatus.setTextFill(Color.web("#FF0000")); // RED

            imgStatus.setImage(new Image("gerenciador/pets/img/off.png"));
            
            return false;
        }
        
    }
    
    private void verificarCampos(){
        
        if(txtUsuario.getText().equals("") || txtUsuario.getText() == null){
            
            txtStatus.setText("Digite um usuário!");
            txtStatus.setTextFill(Color.web("#FF0000")); // RED
            
        }else if(txtSenha.getText().equals("") || txtSenha.getText() == null){
            
            txtStatus.setText("Digite uma senha!");
            txtStatus.setTextFill(Color.web("#FF0000")); // RED
            
        }else{

            logarusuario();
            
        }
        
    }
    
    private void logarusuario(){
        
        if(verificarConexao()){

            if(verificarUsuario(txtUsuario.getText(), txtSenha.getText())){

                txtStatus.setText("Bem vindo: " + Administrador.getNome());
                
                txtStatus.setTextFill(Color.web("#008000")); // GREEN
                
                if(Administrador.getTipo() == 0){
                    
                    JOptionPane.showMessageDialog(null, "Bem vindo administrador: " + Administrador.getNome());
                    
                    iniciarPrincipal();
                    
                }else{
                    if(verificarValidade()){
                        
                        JOptionPane.showMessageDialog(null, "Bem vindo(a): " + Administrador.getNome());
                    
                        iniciarPrincipal();

                    }else{

                        JOptionPane.showMessageDialog(null, "Sua licença expirou!\nEntre em contado com: (98) 98435-8483 - Matheus Viana");

                    }
                    
                }

            }else{

                txtStatus.setText("Usuário invalido!");
                
                txtStatus.setTextFill(Color.web("#FF0000")); // RED

            }

        }
        
    }

    private boolean verificarUsuario(String usuario, String senha){
        
        UsuarioDAO u = new UsuarioDAO();
        
        for(Usuario user : u.read()){
            
            if(user.getUsuario().equals(usuario) && user.getSenha().equals(senha)){
                
                Administrador.setNome(user.getNome());
                Administrador.setTipo(user.getTipo());
                Administrador.setUsuario(user.getUsuario());
                        
                return true;
                
            }
            
        }
        
        return false;
        
    }
    
    private void iniciarPrincipal(){
        
        try {
            
            FXMLLoader fxmlLoaderPrincipal = new FXMLLoader(getClass().getResource("FXML_Principal.fxml"));
            Parent r = (Parent) fxmlLoaderPrincipal.load();
            Stage stage = new Stage();
            
            Image icon = new Image("gerenciador/pets/img/on.png");
        
            stage.getIcons().add(icon);
            stage.setTitle("Gerenciador de Pets - " + Administrador.getNome());
            stage.setScene(new Scene(r));
            stage.setMaximized(true);
            stage.show();
            
            Stage stageAtual = (Stage) btnEntrar.getScene().getWindow();
            stageAtual.close();
            
           
        } catch (IOException e) {
            
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
            
        }
        
    }
    
    private boolean verificarValidade(){

        int anoAtual = Integer.parseInt(getDateTime().substring(0, 4));
        int mesAtual = Integer.parseInt(getDateTime().substring(5, 7));
        int diaAtual = Integer.parseInt(getDateTime().substring(8, 10));
        
        System.out.println("ATUAL- DIA: " + diaAtual + " MES: " + mesAtual + " ANO: " + anoAtual);
        
        ValidadeDAO v = new ValidadeDAO();
        
        for(Validade val : v.read()){
            
            
            int anoValidade = Integer.parseInt(val.getDataValidade().substring(0, 4));
            int mesValidade = Integer.parseInt(val.getDataValidade().substring(5, 7));
            int diaValidade = Integer.parseInt(val.getDataValidade().substring(8, 10));
            
            System.out.println("VALIDADE - DIA: " + diaValidade + " MES: " + mesValidade + " ANO: " + anoValidade);
            //System.out.println("DATA ATUAL: " + getDateTime());
            
            if(val.getId().equals(Administrador.getUsuario())){
                
                Administrador.setValidade(val.getDataValidade());
                
                if(anoValidade <= anoAtual){
                    
                    if(mesValidade <= mesAtual){
                        
                        if(diaValidade <= diaAtual){
                            
                            return true;
                            
                        }
                        
                    }
                    
                }
                
            }
            
        }
        
        return false;
        
    }
    
    private String getDateTime() {
        DateFormat dateFormat = new SimpleDateFormat("yyy-MM-dd");
        Date date = new Date();
        return dateFormat.format(date);
    }
    
}
