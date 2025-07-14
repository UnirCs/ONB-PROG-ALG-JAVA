package mapas;

import java.util.*;

public class Soluciones {
    // 1. Contar ocurrencias
    public static Map<String, Integer> contarOcurrencias(String[] palabras) {
        Map<String, Integer> mapa = new HashMap<>();
        for (String p : palabras) {
            mapa.put(p, mapa.getOrDefault(p, 0) + 1);
        }
        return mapa;
    }

    // 2. Buscar por clave
    public static Integer buscarEdad(Map<String, Integer> mapa, String nombre) {
        return mapa.get(nombre);
    }

    // 3. Invertir un mapa
    public static Map<String, Integer> invertirMapa(Map<Integer, String> mapa) {
        Map<String, Integer> invertido = new HashMap<>();
        for (Map.Entry<Integer, String> e : mapa.entrySet()) {
            invertido.put(e.getValue(), e.getKey());
        }
        return invertido;
    }

    // 4. Eliminar por valor
    public static <K, V> void eliminarPorValor(Map<K, V> mapa, V valor) {
        mapa.values().removeIf(v -> Objects.equals(v, valor));
    }

    // 5. Sumar valores
    public static int sumarValores(Map<String, Integer> mapa) {
        int suma = 0;
        for (int v : mapa.values()) suma += v;
        return suma;
    }

    public static void main(String[] args) {
        String[] palabras = {"java", "mapa", "java", "codigo", "mapa", "java"};
        Map<String, Integer> ocurrencias = contarOcurrencias(palabras);
        System.out.println("Ocurrencias: " + ocurrencias);

        Map<String, Integer> edades = new HashMap<>();
        edades.put("Ana", 25);
        edades.put("Luis", 30);
        edades.put("Marta", 28);
        System.out.println("Edad de Luis: " + buscarEdad(edades, "Luis"));

        Map<Integer, String> mapaOriginal = new HashMap<>();
        mapaOriginal.put(1, "uno");
        mapaOriginal.put(2, "dos");
        mapaOriginal.put(3, "tres");
        System.out.println("Mapa invertido: " + invertirMapa(mapaOriginal));

        Map<String, String> mapaEliminar = new HashMap<>();
        mapaEliminar.put("a", "rojo");
        mapaEliminar.put("b", "azul");
        mapaEliminar.put("c", "rojo");
        eliminarPorValor(mapaEliminar, "rojo");
        System.out.println("Mapa tras eliminar valor 'rojo': " + mapaEliminar);

        Map<String, Integer> mapaSumar = new HashMap<>();
        mapaSumar.put("a", 10);
        mapaSumar.put("b", 20);
        mapaSumar.put("c", 30);
        System.out.println("Suma de valores: " + sumarValores(mapaSumar));
    }
}