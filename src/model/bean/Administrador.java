package model.bean;

public class Administrador {
    
    private static String nome, validade, usuario, senha;
    private static int tipo;

    public static String getNome() {
        return nome;
    }

    public static void setNome(String nome) {
        Administrador.nome = nome;
    }

    public static String getUsuario() {
        return usuario;
    }

    public static void setUsuario(String usuario) {
        Administrador.usuario = usuario;
    }

    public static String getSenha() {
        return senha;
    }

    public static void setSenha(String senha) {
        Administrador.senha = senha;
    }

    public static int getTipo() {
        return tipo;
    }

    public static void setTipo(int tipo) {
        Administrador.tipo = tipo;
    }

    public static String getValidade() {
        return validade;
    }

    public static void setValidade(String validade) {
        Administrador.validade = validade;
    }
    
}
