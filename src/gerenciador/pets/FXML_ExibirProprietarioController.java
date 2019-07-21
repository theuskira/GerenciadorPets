/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciador.pets;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import model.bean.Animal;
import model.bean.ListaAnimais;
import model.bean.ListaProprietarios;
import model.bean.Proprietario;
import model.bean.ProprietarioSelecionado;
import model.dao.AnimalDAO;
import model.dao.ProprietarioDAO;

/**
 * FXML Controller class
 *
 * @author Matheus - DELL
 */
public class FXML_ExibirProprietarioController implements Initializable {

    @FXML
    private Label txtNomeProprietario;
    @FXML
    private Label txtEnderecoProprietario;
    @FXML
    private TableView<Animal> tabelaPets;
    @FXML
    private TableColumn<Animal, String> colunaPetNome;
    @FXML
    private TableColumn<Animal, String> colunaPetTipo;
    @FXML
    private TableColumn<Animal, String> colunaPetRaca;
    @FXML
    private TableColumn<Animal, String> colunaPetIdade;
    @FXML
    private TableColumn<Animal, String> colunaPetSexo;
    @FXML
    private TableColumn<Animal, Double> colunaPetPeso;
    @FXML
    private AnchorPane apExibirProprietario;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        colunaPetNome.setCellValueFactory(
                new PropertyValueFactory<>("nome"));
        
        colunaPetTipo.setCellValueFactory(
                new PropertyValueFactory<>("tipo"));
        
        colunaPetRaca.setCellValueFactory(
                new PropertyValueFactory<>("raca"));
        
        colunaPetIdade.setCellValueFactory(
                new PropertyValueFactory<>("idade"));
        
        colunaPetSexo.setCellValueFactory(
                new PropertyValueFactory<>("sexo"));
        
        colunaPetPeso.setCellValueFactory(
                new PropertyValueFactory<>("peso"));
        
        tabelaPets.setItems(listaDeAnimaisProprietario(ProprietarioSelecionado.getId()));
        
        // SETAR ALTURA DA TABELA PARA A MESMA DO ANCHORPANE LATERAL
        System.out.println("ALTURA ANCHORPANE: " + apExibirProprietario.heightProperty());
        tabelaPets.prefHeightProperty().bind(apExibirProprietario.heightProperty());
        
        // SETAR LARGURA DA TABELA PARA A MESMA DO ANCHORPANE LATERAL
        System.out.println("LARGURA ANCHORPANE: " + apExibirProprietario.widthProperty());
        tabelaPets.prefWidthProperty().bind(apExibirProprietario.widthProperty());
        
        txtNomeProprietario.setText(ProprietarioSelecionado.getNome());
        System.out.println("SELECIONADO: " 
                + ProprietarioSelecionado.getNome()
                + " "
                + ProprietarioSelecionado.getNumero()
                
        );
        
    }
    
    private ObservableList<Animal> listaDeAnimaisProprietario(int id) {
        
        System.out.println("ID PROPRIETARIO PESQUISA: " + id);
        
        ListaAnimais.getListaAnimais().clear();
        
        AnimalDAO a = new AnimalDAO();
        
        for(Animal ani : a.readFromOwner(id)){
            
            System.out.println("ANIMAL ENCONTRADO: " + ani.getNome());
            
            ListaAnimais.setListaAnimais(ani);
            
        }
        
        return FXCollections.observableArrayList(
                
                ListaAnimais.getListaAnimais()
                
        );
    }
    
}
