package listas;

import java.util.ArrayList;
import java.util.List;

public class EliminarDuplicados {
    public static void main(String[] args) {
        List<Integer> numerosOriginales = List.of(5, 3, 8, 5, 3, 10, 2, 8, 2);
        List<Integer> numerosSinDuplicados = new ArrayList<>();

        for (int numero : numerosOriginales) {
            if (!numerosSinDuplicados.contains(numero)) {
                numerosSinDuplicados.add(numero);
            }
        }

        System.out.println("Números sin duplicados: " + numerosSinDuplicados);
    }
}

