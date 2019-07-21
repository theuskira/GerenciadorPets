package model.bean;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Matheus - DELL
 */
public class ListaProprietariosPesquisa {
    
    private static List<Proprietario> listaProprietarios = new ArrayList<>();
    private static List<Proprietario> listaPesquisaProprietarios = new ArrayList<>();

    public static List<Proprietario> getListaProprietarios() {
        return listaProprietarios;
    }

    public static void setListaProprietarios(Proprietario proprietario) {
        ListaProprietariosPesquisa.listaProprietarios.add(proprietario);
    }

    public static List<Proprietario> getListaPesquisaProprietarios() {
        return listaPesquisaProprietarios;
    }

    public static void setListaPesquisaProprietarios(Proprietario proprietario) {
        ListaProprietariosPesquisa.listaPesquisaProprietarios.add(proprietario);
    }
    
    
    
}
