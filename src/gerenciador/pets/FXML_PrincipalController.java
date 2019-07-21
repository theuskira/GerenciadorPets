/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciador.pets;

import connection.Conexao;
import java.io.IOException;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javax.swing.JOptionPane;
import model.bean.Administrador;

/**
 * FXML Controller class
 *
 * @author Matheus - DELL
 */
public class FXML_PrincipalController implements Initializable {
    
    private String alvoClicado = "";

    @FXML
    private SplitPane splitPane;
    @FXML
    private AnchorPane apOpcoes;
    @FXML
    private AnchorPane apPrincipal;
    @FXML
    private HBox opHome;
    @FXML
    private HBox opClientes;
    @FXML
    private HBox opPets;
    @FXML
    private ImageView imgHome;
    @FXML
    private Label txtHome;
    @FXML
    private ImageView imgClientes;
    @FXML
    private Label txtClientes;
    @FXML
    private ImageView imgPets;
    @FXML
    private Label txtPets;
    @FXML
    private ImageView imgStatus;
    @FXML
    private HBox opAdmin;
    @FXML
    private ImageView imgAdmin;
    @FXML
    private Label txtAdmin;
    
    AnchorPane fmlxHome = null;
    AnchorPane fmlxClientes = null;
    
    // TODO - INICIAR
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // TODO
        
        System.out.println("PRINCIPAL INICIADO");
        System.out.println("ADMINISTRADOR: " + Administrador.getNome());
        
        try {
       
            fmlxHome = (AnchorPane) FXMLLoader.load(getClass().getResource("FXML_Home.fxml"));
            fmlxClientes = (AnchorPane) FXMLLoader.load(getClass().getResource("FXML_Clientes.fxml"));
            
        } catch (IOException ex) {
            
            JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage());
        }
        
        if(!verificarConexao()){
            
            JOptionPane.showMessageDialog(null, "Sem conexao ao banco!");
            
        }
        
        if(Administrador.getTipo() == 0){
            
            opAdmin.setVisible(true);
            
        }else{
            
            opAdmin.setVisible(false);
            
        }
        
        alvoClicado = "opHome";
        entrarClique(alvoClicado, "");
        
    }
    
    private void iniciarAnchor(AnchorPane apFilho){
        
        try {

            apPrincipal.setTopAnchor(apFilho, 0.0);
            apPrincipal.setBottomAnchor(apFilho, 0.0);
            apPrincipal.setLeftAnchor(apFilho, 0.0);
            apPrincipal.setRightAnchor(apFilho, 0.0);
            apPrincipal.getChildren().add(apFilho);
            
        } catch (Exception ex) {
            
            JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage());
            
        }
        
    }
    
    private void removerAnchor(AnchorPane apAnterior){
        
        try {

            apPrincipal.getChildren().remove(apAnterior);
            
        } catch (Exception ex) {
            
            JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage());
            
        }
        
    }
    
    @FXML
    private void onMouseClicked(MouseEvent event) {
        
        System.out.println("Clicou em: " + remover(event.getTarget().toString()));
        
        System.out.println("ALVO ENTERIOR: " + alvoClicado);
        String anterior = alvoClicado;
        
        if(!alvoClicado.equals(remover(event.getTarget().toString()))){
            
            alvoClicado = remover(event.getTarget().toString());
            
            entrarClique(alvoClicado, anterior);
            
            System.out.println("NOVO ALVO: " + remover(event.getTarget().toString()));
            
        }
        
        sairTodos(alvoClicado);
        
    }
    
    @FXML
    private void onMouseEntered(MouseEvent event) {
        
        System.out.println("Entrou em: " + remover(event.getTarget().toString()));

        entrar(remover(event.getTarget().toString()));
        
    }
    
    @FXML
    private void onMouseExited(MouseEvent event) {
        
        System.out.println("Saiu de: " + remover(event.getTarget().toString()));
        
        sair(remover(event.getTarget().toString()));
        
    }
    
    private boolean verificarConexao(){
        try{

            if(Conexao.getConnection() != null){
                
                imgStatus.setImage(new Image("gerenciador/pets/img/on.png"));
                
                return true;

            }else{
                
                imgStatus.setImage(new Image("gerenciador/pets/img/off.png"));
                
                return  false;

            }
            
        }catch(Exception e){
            
            System.out.println("Erro: " + e.getMessage());

            imgStatus.setImage(new Image("gerenciador/pets/img/off.png"));
            
            return false;
        }
        
    }
    
    private void entrar(String s){
        
        switch (s){
            case "opHome":
                opHome.setStyle("-fx-background-color: #FFF; -fx-border-radius: 5; -fx-background-radius: 5");
                imgHome.setImage(new Image("gerenciador/pets/img/home_color.png"));
                txtHome.setTextFill(Color.web("#000")); // BLACK
                break; 
                
            case "opClientes":
                opClientes.setStyle("-fx-background-color: #FFF; -fx-border-radius: 5; -fx-background-radius: 5");
                imgClientes.setImage(new Image("gerenciador/pets/img/customer_color.png"));
                txtClientes.setTextFill(Color.web("#000")); // BLACK
                break; 
                
            case "opPets":
                opPets.setStyle("-fx-background-color: #FFF; -fx-border-radius: 5; -fx-background-radius: 5");
                imgPets.setImage(new Image("gerenciador/pets/img/pet_color.png"));
                txtPets.setTextFill(Color.web("#000")); // BLACK
                break; 
            
            case "Admin":
                opAdmin.setStyle("-fx-background-color: #FFF; -fx-border-radius: 5; -fx-background-radius: 5");
                imgAdmin.setImage(new Image("gerenciador/pets/img/protect_color.png"));
                txtAdmin.setTextFill(Color.web("#000")); // BLACK
                break; 
        }
        
    }
    
    private void entrarClique(String s, String anterior){
        
        switch (anterior){
            case "opHome":
                removerAnchor(fmlxHome);
                break; 
                
            case "opClientes":
                removerAnchor(fmlxClientes);
                break; 
                
            case "opPets":
                break; 
            
            case "Admin":
                break; 
        }
        
        switch (s){
            case "opHome":
                opHome.setStyle("-fx-background-color: #FFF; -fx-border-radius: 5; -fx-background-radius: 5");
                imgHome.setImage(new Image("gerenciador/pets/img/home_color.png"));
                txtHome.setTextFill(Color.web("#000")); // BLACK
                iniciarAnchor(fmlxHome);
                break; 
                
            case "opClientes":
                opClientes.setStyle("-fx-background-color: #FFF; -fx-border-radius: 5; -fx-background-radius: 5");
                imgClientes.setImage(new Image("gerenciador/pets/img/customer_color.png"));
                txtClientes.setTextFill(Color.web("#000")); // BLACK
                iniciarAnchor(fmlxClientes);
                break; 
                
            case "opPets":
                opPets.setStyle("-fx-background-color: #FFF; -fx-border-radius: 5; -fx-background-radius: 5");
                imgPets.setImage(new Image("gerenciador/pets/img/pet_color.png"));
                txtPets.setTextFill(Color.web("#000")); // BLACK
                break; 
            
            case "Admin":
                opAdmin.setStyle("-fx-background-color: #FFF; -fx-border-radius: 5; -fx-background-radius: 5");
                imgAdmin.setImage(new Image("gerenciador/pets/img/protect_color.png"));
                txtAdmin.setTextFill(Color.web("#000")); // BLACK
                break; 
        }
        
    }
    
    private void sair(String s){
        
        if(!s.equals(alvoClicado)){
            
            switch (s){
                case "opHome":
                    opHome.setStyle("-fx-background-color: #2E8B57; -fx-border-radius: 5; -fx-background-radius: 5");
                    imgHome.setImage(new Image("gerenciador/pets/img/home.png"));
                    txtHome.setTextFill(Color.web("#FFF")); // WHITE
                    break; 

                case "opClientes":
                    opClientes.setStyle("-fx-background-color: #2E8B57; -fx-border-radius: 5; -fx-background-radius: 5");
                    imgClientes.setImage(new Image("gerenciador/pets/img/customer.png"));
                    txtClientes.setTextFill(Color.web("#FFF")); // WHITE
                    break;

                case "opPets":
                    opPets.setStyle("-fx-background-color: #2E8B57; -fx-border-radius: 5; -fx-background-radius: 5");
                    imgPets.setImage(new Image("gerenciador/pets/img/pet.png"));
                    txtPets.setTextFill(Color.web("#FFF")); // WHITE
                    break; 
                
                case "Admin":
                    opAdmin.setStyle("-fx-background-color: #2E8B57; -fx-border-radius: 5; -fx-background-radius: 5");
                    imgAdmin.setImage(new Image("gerenciador/pets/img/protect.png"));
                    txtAdmin.setTextFill(Color.web("#FFF")); // WHITE
                    break; 
            }
            
        }
        
    }
    
    private void sairTodos(String s){
        
        if(!s.equals("opHome")){
            opHome.setStyle("-fx-background-color: #2E8B57; -fx-border-radius: 5; -fx-background-radius: 5");
            imgHome.setImage(new Image("gerenciador/pets/img/home.png"));
            txtHome.setTextFill(Color.web("#FFF")); // WHITE
        }
        
        if(!s.equals("opClientes")){
            opClientes.setStyle("-fx-background-color: #2E8B57; -fx-border-radius: 5; -fx-background-radius: 5");
            imgClientes.setImage(new Image("gerenciador/pets/img/customer.png"));
            txtClientes.setTextFill(Color.web("#FFF")); // WHITE
        }
        
        if(!s.equals("opPets")){
            opPets.setStyle("-fx-background-color: #2E8B57; -fx-border-radius: 5; -fx-background-radius: 5");
            imgPets.setImage(new Image("gerenciador/pets/img/pet.png"));
            txtPets.setTextFill(Color.web("#FFF")); // WHITE
        }
        
        if(!s.equals("Admin")){
            opAdmin.setStyle("-fx-background-color: #2E8B57; -fx-border-radius: 5; -fx-background-radius: 5");
            imgAdmin.setImage(new Image("gerenciador/pets/img/protect.png"));
            txtAdmin.setTextFill(Color.web("#FFF")); // WHITE
        }
        
    }
    
    private String remover(String s){
        return s.replace("HBox[id=", "")
                .replace("]", "")
                .replace("ImageView[id=", "")
                .replace("styleClass=image-view", "")
                .replace("Text[text=\"", "")
                .replace("x=0.0,", "")
                .replace("y=0.0,", "")
                .replace("alignment=JUSTIFY", "")
                .replace("origin=BASELINE", "")
                .replace("boundsType=LOGICAL", "")
                .replace("_VERTICAL_CENTER", "")
                .replace("font=Font[name=System Bold", "")
                .replace("family=System", "")
                .replace("style=Bold", "")
                .replace("size=20.0", "")
                .replace("fontSmoothingType=GRAY", "")
                .replace("fontSmoothingType=LCD", "")
                .replace("fill=0xffffffff", "")
                .replace("fill=0x000000ff", "")
                .replace("\"", "")
                .replace(" ", "")
                .replace(",", "")
                .replace("img", "")
                .replace("txt", "")
                .replace("op", "")
                .replace("Home", "opHome")
                .replace("Início", "opHome")
                .replace("Clientes", "opClientes")
                .replace("Pets", "opPets");
    }
    
}
