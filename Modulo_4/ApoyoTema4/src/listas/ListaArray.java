package listas;

import java.util.ArrayList;
import java.util.List;

public class ListaArray {
    public static void main(String[] args) {
        List<String> nombres = new ArrayList<>();
        nombres.add("Ana");
        nombres.add("Luis");
        nombres.add("Carlos");

        System.out.println("Primer nombre: " + nombres.get(0));
        System.out.println("Tamaño de la lista: " + nombres.size());
    }
}

