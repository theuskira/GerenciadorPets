/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Matheus - DELL
 */
public class Proprietario {
    
        private final SimpleIntegerProperty id;
        private final SimpleStringProperty nome, cpf, endereco, numero;

        public Proprietario(Integer id, String nome, String cpf, String endereco, String numero) {
            this.id = new SimpleIntegerProperty(id);
            this.nome = new SimpleStringProperty(nome);
            this.cpf = new SimpleStringProperty(cpf);
            this.endereco = new SimpleStringProperty(endereco);
            this.numero = new SimpleStringProperty(numero);
        }
        
        public Proprietario(String nome, String numero) {
            this.id = new SimpleIntegerProperty();
            this.cpf = new SimpleStringProperty();
            this.endereco = new SimpleStringProperty();
            this.nome = new SimpleStringProperty(nome);
            this.numero = new SimpleStringProperty(numero);
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

        // CPF
        public SimpleStringProperty cpfProperty() {
            return cpf;
        }
        
        public String getCpf() {
            return cpf.get();
        }
        
        public void setCpf(String cpf) {
            this.cpf.set(cpf);
        }

        // Endereco
        public SimpleStringProperty enderecoProperty() {
            return endereco;
        }
        
        public String getEndereco() {
            return endereco.get();
        }
        
        public void setEndereco(String endereco) {
            this.endereco.set(endereco);
        }

        // NUMERO
        public SimpleStringProperty numeroProperty() {
            return numero;
        }
        
        public String getNumero() {
            return numero.get();
        }
        
        public void setNumero(String numero) {
            this.numero.set(numero);
        }

    }
