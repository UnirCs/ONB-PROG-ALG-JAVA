package listas;

import java.util.*;
import java.util.stream.*;

public class Soluciones {
    // 1. Filtrar números pares
    public static List<Integer> filtrarPares(List<Integer> lista) {
        return lista.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());
    }

    // 2. Convertir a mayúsculas
    public static List<String> aMayusculas(List<String> lista) {
        return lista.stream().map(String::toUpperCase).collect(Collectors.toList());
    }

    // 3. Obtener el promedio
    public static double promedio(List<Integer> lista) {
        return lista.stream().mapToInt(Integer::intValue).average().orElse(0);
    }

    // 4. Contar elementos mayores a un valor
    public static long contarMayoresA(List<Integer> lista, int n) {
        return lista.stream().filter(x -> x > n).count();
    }

    // 5. Concatenar cadenas
    public static String concatenar(List<String> lista) {
        return lista.stream().collect(Collectors.joining(","));
    }

    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        List<String> cadenas = Arrays.asList("hola", "java", "stream", "ejemplo");

        System.out.println("Números pares: " + filtrarPares(numeros));
        System.out.println("Cadenas en mayúsculas: " + aMayusculas(cadenas));
        System.out.println("Promedio: " + promedio(numeros));
        System.out.println("Mayores a 4: " + contarMayoresA(numeros, 4));
        System.out.println("Cadenas concatenadas: " + concatenar(cadenas));
    }
}