package model.bean;

/**
 *
 * @author Matheus - DELL
 */
public class ProprietarioSelecionado {
    
    private static String nome, cpf, endereco, numero;
    private static int id;

    public static String getNome() {
        return nome;
    }

    public static void setNome(String nome) {
        ProprietarioSelecionado.nome = nome;
    }

    public static String getCpf() {
        return cpf;
    }

    public static void setCpf(String cpf) {
        ProprietarioSelecionado.cpf = cpf;
    }

    public static String getEndereco() {
        return endereco;
    }

    public static void setEndereco(String endereco) {
        ProprietarioSelecionado.endereco = endereco;
    }

    public static String getNumero() {
        return numero;
    }

    public static void setNumero(String numero) {
        ProprietarioSelecionado.numero = numero;
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        ProprietarioSelecionado.id = id;
    }
    
}
