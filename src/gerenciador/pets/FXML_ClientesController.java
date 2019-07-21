package gerenciador.pets;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javax.swing.JOptionPane;
import model.bean.ListaProprietarios;
import model.bean.ListaProprietariosPesquisa;
import model.bean.Proprietario;
import model.bean.ProprietarioSelecionado;
import model.dao.ProprietarioDAO;

/**
 * FXML Controller class
 *
 * @author Matheus - DELL
 */
public class FXML_ClientesController implements Initializable {

    @FXML
    private TextField txtPesquisaClientes;
    @FXML
    private ImageView btnPesquisaClientes;
    @FXML
    private TableView<Proprietario> tabelaClientes;
    @FXML
    private TableColumn<Proprietario, String> colunaClientesNome;
    @FXML
    private TableColumn<Proprietario, String> colunaClientesNumero;
    @FXML
    private TableColumn<Proprietario, String> colunaClientesCPF;
    @FXML
    private AnchorPane apClientes;
    @FXML
    private AnchorPane apLateral;
    @FXML
    private VBox vBoxLateral;
    @FXML
    private HBox hBoxAddProprietario;
    @FXML
    private Label txtAddProprietario;
    @FXML
    private ImageView btnAddProprietario;
    
    AnchorPane fmlxAddProprietarios = null;
    AnchorPane fmlxExibirProprietario = null;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        try {
       
            fmlxAddProprietarios = (AnchorPane) FXMLLoader.load(getClass().getResource("FXML_AdicionarProprietarios.fxml"));
            
        } catch (IOException ex) {
            
            JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage());
            
        }
        
        // SETAR ALTURA DA TABELA PARA A MESMA DO ANCHORPANE LATERAL
        System.out.println("ALTURA ANCHORPANE: " + apLateral.heightProperty());
        tabelaClientes.prefHeightProperty().bind(apLateral.heightProperty());
        
        // SETAR LARGURA DA TABELA PARA A MESMA DO ANCHORPANE LATERAL
        System.out.println("LARGURA ANCHORPANE: " + apLateral.widthProperty());
        tabelaClientes.prefWidthProperty().bind(apLateral.widthProperty());
        
        colunaClientesNome.setCellValueFactory(
                new PropertyValueFactory<>("nome"));
        
        colunaClientesNumero.setCellValueFactory(
                new PropertyValueFactory<>("numero"));
        
        colunaClientesCPF.setCellValueFactory(
                new PropertyValueFactory<>("cpf"));
        
        final KeyCombination ENTER = (KeyCombination) new KeyCodeCombination(KeyCode.ENTER);
        
        txtPesquisaClientes.setOnKeyPressed(k -> {
            
            if(ENTER.match(k)){
                
                pesquisarClientes(null);
                
            }
            
        });
        
        tabelaClientes.setItems(listaDeProprietarios());
        
    }
    
    @FXML
    private void onMouseClickedTable(MouseEvent event) {
        
        if(txtPesquisaClientes.getText().equals(" ") || txtPesquisaClientes.getText().isEmpty()){
            
            System.out.println("Clicou em: " + tabelaClientes.getSelectionModel().getFocusedIndex());

            ProprietarioSelecionado.setNome(listaDeProprietarios().get(tabelaClientes.getSelectionModel().getFocusedIndex()).getNome());
            ProprietarioSelecionado.setNumero(listaDeProprietarios().get(tabelaClientes.getSelectionModel().getFocusedIndex()).getNumero());
            ProprietarioSelecionado.setId(listaDeProprietariosPesquisa(txtPesquisaClientes.getText()).get(tabelaClientes.getSelectionModel().getFocusedIndex()).getId());


            System.out.println("PROPRIETARIO SELECIONADO: " 
                    + listaDeProprietarios().get(tabelaClientes.getSelectionModel().getFocusedIndex()).getNome()
                    + " "
                    + listaDeProprietarios().get(tabelaClientes.getSelectionModel().getFocusedIndex()).getNumero()
            );
            System.out.println("NOME SELECIONADO: " + ProprietarioSelecionado.getNome());
            System.out.println("NUMERO SELECIONADO: " + ProprietarioSelecionado.getNumero());
            
        }else{
            
            System.out.println("Clicou em: " + tabelaClientes.getSelectionModel().getFocusedIndex());

            ProprietarioSelecionado.setNome(listaDeProprietariosPesquisa(txtPesquisaClientes.getText()).get(tabelaClientes.getSelectionModel().getFocusedIndex()).getNome());
            ProprietarioSelecionado.setNumero(listaDeProprietariosPesquisa(txtPesquisaClientes.getText()).get(tabelaClientes.getSelectionModel().getFocusedIndex()).getNumero());
            ProprietarioSelecionado.setId(listaDeProprietariosPesquisa(txtPesquisaClientes.getText()).get(tabelaClientes.getSelectionModel().getFocusedIndex()).getId());


            System.out.println("PROPRIETARIO SELECIONADO: " 
                    + listaDeProprietarios().get(tabelaClientes.getSelectionModel().getFocusedIndex()).getNome()
                    + " "
                    + listaDeProprietarios().get(tabelaClientes.getSelectionModel().getFocusedIndex()).getNumero()
            );
            System.out.println("NOME SELECIONADO: " + ProprietarioSelecionado.getNome());
            System.out.println("NUMERO SELECIONADO: " + ProprietarioSelecionado.getNumero());
            
        }
        
        
        
        
        try {
            
            fmlxExibirProprietario = (AnchorPane) FXMLLoader.load(getClass().getResource("FXML_ExibirProprietario.fxml"));
            
            iniciarAnchor(fmlxExibirProprietario);
            
        } catch (IOException ex) {
            
            JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage());
        }
        
    }
    
    @FXML
    private void onMouseClicked(MouseEvent event) {
        
        System.out.println("Clicou em: " + event.getTarget().toString());
        
        iniciarAnchor(fmlxAddProprietarios);
        
    }
    
    private void iniciarAnchor(AnchorPane apFilho){
        
        try {
            
            removerAnchor(fmlxAddProprietarios);
            removerAnchor(fmlxExibirProprietario);
            
            apClientes.setTopAnchor(apFilho, 0.0);
            apClientes.setBottomAnchor(apFilho, 0.0);
            apClientes.setLeftAnchor(apFilho, 0.0);
            apClientes.setRightAnchor(apFilho, 0.0);
            apClientes.getChildren().add(apFilho);
            
        } catch (Exception ex) {
            
            JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage());
            
        }
        
    }
    
    private void removerAnchor(AnchorPane apAnterior){
        
        try {

            apClientes.getChildren().remove(apAnterior);
            
        } catch (Exception ex) {
            
            JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage());
            
        }
        
    }
    
    private ObservableList<Proprietario> listaDeProprietarios() {
        
        ListaProprietarios.getListaProprietarios().clear();
        
        ProprietarioDAO p = new ProprietarioDAO();
        
        for(Proprietario pro : p.read()){
            
            ListaProprietarios.setListaProprietarios(pro);
            
        }
        
        return FXCollections.observableArrayList(
                
                ListaProprietarios.getListaProprietarios()
                
        );
    }
    
    private ObservableList<Proprietario> listaDeProprietariosPesquisa(String pesquisa) {
            
        ListaProprietariosPesquisa.getListaProprietarios().clear();
        
        ProprietarioDAO p = new ProprietarioDAO();
        
        for(Proprietario pro : p.search(pesquisa)){
            /*
            String nome = pro.getNome().toUpperCase();
            String numero = pro.getNumero().toUpperCase();
            
            if(nome.contains(pesquisa.toUpperCase()) || numero.contains(pesquisa.toUpperCase())){
                */
                ListaProprietariosPesquisa.setListaProprietarios(pro);
                
                System.out.println("ENCONTRADO");
                System.out.println("NOME: " + pro.getNome());
                System.out.println("NUMERO: " + pro.getNumero());
                
           // }
            
        }
        
        return FXCollections.observableArrayList(
                
                ListaProprietariosPesquisa.getListaProprietarios()
                
        );
    }
    
    @FXML
    private void pesquisarClientes(MouseEvent event) {
        
        if(!txtPesquisaClientes.getText().isEmpty() || !txtPesquisaClientes.getText().equals(" ")){
                    
            System.out.println("PESQUISA: " + txtPesquisaClientes.getText());
            
            tabelaClientes.setItems(listaDeProprietariosPesquisa(txtPesquisaClientes.getText()));

        }
        
    }
    
}
