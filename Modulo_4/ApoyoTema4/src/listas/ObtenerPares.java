package listas;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ObtenerPares {

    public static List<Integer> obtenerSoloPares(List<Integer> numeros) {
        List<Integer> pares = new LinkedList<>();
        for (Integer n : numeros) {
            if (n % 2 == 0) {
                pares.add(n);
            }
        }
        return pares;
    }

    public static void main(String[] args) {
        List<Integer> lista = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        List<Integer> soloPares = obtenerSoloPares(lista);
        System.out.println(soloPares); // Salida: [2, 4, 6, 8]
    }
}
