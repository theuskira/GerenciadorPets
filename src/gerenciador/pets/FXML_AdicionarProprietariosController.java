package gerenciador.pets;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javax.swing.JOptionPane;
import model.bean.Proprietario;
import model.dao.ProprietarioDAO;

/**
 * FXML Controller class
 *
 * @author Matheus - DELL
 */
public class FXML_AdicionarProprietariosController implements Initializable {

    @FXML
    private TextField txtNome;
    @FXML
    private TextField txtCpf;
    @FXML
    private TextField txtTelefone;
    @FXML
    private TextArea txtEndereco;
    @FXML
    private Button btnSalvar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        //txtTelefone.setOnK
        
    }
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        
        if(verificarCampos()){
            
            if(txtTelefone.getText().length() < 14 || txtTelefone.getText().length() > 15){
                
                JOptionPane.showMessageDialog(null, "Numero inválido!");
                
                txtTelefone.requestFocus();
                txtTelefone.end();
                
            }else if(txtCpf.getText().length() > 14){
                
                JOptionPane.showMessageDialog(null, "CPF inválido!");
                
                txtCpf.requestFocus();
                txtCpf.end();
                
            }else if(txtCpf.getText().length() < 14 && txtCpf.getText().length() > 0){
                
                JOptionPane.showMessageDialog(null, "CPF inválido!");
                
                txtCpf.requestFocus();
                txtCpf.end();
                
            }else{
                
                ProprietarioDAO p = new ProprietarioDAO();
            
                Proprietario pr = new Proprietario(txtNome.getText(), txtTelefone.getText());

                if(!txtCpf.getText().equals("")){
                    
                    pr.setCpf(txtCpf.getText());
                    
                }

                p.create(pr);
                
            }
            
        }
        
    }
    
    @FXML
    private void onTextChangeNumero(KeyEvent event) {

        System.out.println("CODE: " + event.getCode());

        if(event.getCode() == KeyCode.BACK_SPACE){
            System.out.println("APAGANDO");
        }else{
            System.out.println("Digitando: " + txtTelefone.getText() + "!");
            
            if(txtTelefone.getText().length() == 2){

                txtTelefone.setText("(" + txtTelefone.getText() + ") ");

                txtTelefone.end();
                
                System.out.println("TAMANHO: " + txtTelefone.getText().length());

            }
            
            if(txtTelefone.getText().length() == 10){

                txtTelefone.setText(txtTelefone.getText() + "-");

                txtTelefone.end();
                
                System.out.println("TAMANHO: " + txtTelefone.getText().length());

            }
            
        }
        
    }
    
    @FXML
    private void onTextChangeCPF(KeyEvent event) {
        
        System.out.println("CODE: " + event.getCode());

        if(event.getCode() == KeyCode.BACK_SPACE){
            System.out.println("APAGANDO");
        }else{
            System.out.println("Digitando: " + txtCpf.getText() + "!");
            
            if(txtCpf.getText().length() == 3){

                txtCpf.setText(txtCpf.getText() + ".");

                txtCpf.end();
                
                System.out.println("TAMANHO: " + txtCpf.getText().length());

            }
            
            if(txtCpf.getText().length() == 7){

                txtCpf.setText(txtCpf.getText() + ".");

                txtCpf.end();
                
                System.out.println("TAMANHO: " + txtCpf.getText().length());

            }
            
            if(txtCpf.getText().length() == 11){

                txtCpf.setText(txtCpf.getText() + "-");

                txtCpf.end();
                
                System.out.println("TAMANHO: " + txtCpf.getText().length());

            }
            
        }
        
    }

    private boolean verificarCampos(){
        
        if(txtNome.getText().equals(" ") || txtNome.getText().isEmpty()){
            
            JOptionPane.showMessageDialog(null, "O nome não pode ser vazio!");
            
            txtNome.requestFocus();
            txtNome.end();
            
            return false;
  
        }else if(txtNome.getText().length() > 50){
                
                JOptionPane.showMessageDialog(null, "O nome não pode ter mais de 50 caracteres!");
                
                txtNome.requestFocus();
                txtNome.end();
                
                return false;
    
        }else if(txtTelefone.getText().equals(" ") || txtTelefone.getText().isEmpty()){
            
            JOptionPane.showMessageDialog(null, "O número não pode ser vazio!");
            
            txtTelefone.requestFocus();
            txtTelefone.end();
            
            return false;
  
        }else if(txtTelefone.getText().length() < 14 || txtTelefone.getText().length() > 15){
                
                JOptionPane.showMessageDialog(null, "Número inválido!");
                
                txtTelefone.requestFocus();
                txtTelefone.end();
                
                return false;
    
        }else{
    
            return true;
    
        }
        
    }
}