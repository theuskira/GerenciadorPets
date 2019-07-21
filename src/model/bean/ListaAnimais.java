package model.bean;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Matheus - DELL
 */
public class ListaAnimais {
    
    private static List<Animal> listaAnimais = new ArrayList<>();
    private static List<Animal> listaPesquisaAnimais = new ArrayList<>();

    public static List<Animal> getListaAnimais() {
        return listaAnimais;
    }

    public static void setListaAnimais(Animal animal) {
        ListaAnimais.listaAnimais.add(animal);
    }

    public static List<Animal> getListaPesquisaAnimais() {
        return listaPesquisaAnimais;
    }

    public static void setListaPesquisaAnimais(Animal animal) {
        ListaAnimais.listaPesquisaAnimais.add(animal);
    }
    
}
