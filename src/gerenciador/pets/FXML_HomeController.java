package gerenciador.pets;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import model.bean.Administrador;

/**
 * FXML Controller class
 *
 * @author Matheus - DELL
 */
public class FXML_HomeController implements Initializable {

    @FXML
    private Label txtNomeUsuario;

    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        txtNomeUsuario.setText(Administrador.getNome());
        
    } 
    
}
