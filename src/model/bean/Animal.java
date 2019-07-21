package model.bean;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Matheus - DELL
 */
public class Animal {
    
    private final SimpleIntegerProperty id, proprietarioId;
    private final SimpleStringProperty nome, raca, idade, pelagem, tipo, sexo, dataCadastro;
    private final SimpleDoubleProperty peso;

    public Animal(Integer id, Integer proprietarioId, String nome,
            String raca, String idade, String pelagem, String tipo,
            String sexo, String dataCadastro, Double peso){
        
        this.id = new SimpleIntegerProperty(id);
        this.proprietarioId = new SimpleIntegerProperty(proprietarioId);
        this.nome = new SimpleStringProperty(nome);
        this.raca = new SimpleStringProperty(raca);
        this.idade = new SimpleStringProperty(idade);
        this.pelagem = new SimpleStringProperty(pelagem);
        this.tipo = new SimpleStringProperty(tipo);
        this.sexo = new SimpleStringProperty(sexo);
        this.dataCadastro = new SimpleStringProperty(dataCadastro);
        this.peso = new SimpleDoubleProperty(peso);
        
    }
    
    public Animal(Integer id, Integer proprietarioId, String nome, String dataCadastro){
        
        this.id = new SimpleIntegerProperty(id);
        this.proprietarioId = new SimpleIntegerProperty(proprietarioId);
        this.nome = new SimpleStringProperty(nome);
        this.raca = new SimpleStringProperty();
        this.idade = new SimpleStringProperty();
        this.pelagem = new SimpleStringProperty();
        this.tipo = new SimpleStringProperty();
        this.sexo = new SimpleStringProperty();
        this.dataCadastro = new SimpleStringProperty(dataCadastro);
        this.peso = new SimpleDoubleProperty();
        
    }
    
    // Geters e Setters
    
    // ID
    public SimpleIntegerProperty idProperty() {
        return id;
    }

    public int getId() {
        return id.get();
    }

    public void setId(int id) {
        this.id.set(id);
    }
    
    // ID PROPRIETARIO
    public SimpleIntegerProperty proprietarioIdProperty() {
        return proprietarioId;
    }

    public int getProprietarioId() {
        return proprietarioId.get();
    }

    public void setProprietarioId(int proprietarioId) {
        this.proprietarioId.set(proprietarioId);
    }
    
    // NOME
    public SimpleStringProperty nomeProperty() {
        return nome;
    }

    public String getNome() {
        return nome.get();
    }

    public void setNome(String nome) {
        this.nome.set(nome);
    }
    

    // RACA
    public SimpleStringProperty racaProperty() {
        return raca;
    }

    public String getRaca() {
        return raca.get();
    }

    public void setRaca(String raca) {
        this.raca.set(raca);
    }
    

    // IDADE
    public SimpleStringProperty idadeProperty() {
        return idade;
    }

    public String getIdade() {
        return idade.get();
    }

    public void setIdade(String idade) {
        this.idade.set(idade);
    }
    
    // PELAGEM
    public SimpleStringProperty pelagemProperty() {
        return pelagem;
    }

    public String getPelagem() {
        return pelagem.get();
    }

    public void setPelagem(String pelagem) {
        this.pelagem.set(pelagem);
    }
    
    // TIPO
    public SimpleStringProperty tipoProperty() {
        return tipo;
    }

    public String getTipo() {
        return tipo.get();
    }

    public void setTipo(String tipo) {
        this.tipo.set(tipo);
    }
    
    // SEXO
    public SimpleStringProperty sexoProperty() {
        return sexo;
    }

    public String getSexo() {
        return sexo.get();
    }

    public void setSexo(String sexo) {
        this.sexo.set(sexo);
    }
    
    // DATA CADASTRO
    public SimpleStringProperty dataCadastroProperty() {
        return dataCadastro;
    }

    public String getDataCadastro() {
        return dataCadastro.get();
    }

    public void setDataCadastro(String dataCadastro) {
        this.dataCadastro.set(dataCadastro);
    }

    // PESO
    public SimpleDoubleProperty pesoProperty() {
        return peso;
    }

    public Double getPeso() {
        return peso.get();
    }

    public void setPeso(Double peso) {
        this.peso.set(peso);
    }
    
    
    
}
