package mapas;

import java.util.HashMap;
import java.util.Map;

public class FrecuenciaPalabras {
    public static void main(String[] args) {
        String texto = "hola mundo hola java mundo";
        String[] palabras = texto.split(" ");

        Map<String, Integer> frecuencia = new HashMap<>();

        for (String palabra : palabras) {
            if (frecuencia.containsKey(palabra)) {
                frecuencia.put(palabra, frecuencia.get(palabra) + 1);
            } else {
                frecuencia.put(palabra, 1);
            }
        }

        System.out.println("Frecuencia de palabras:");
        for (String clave : frecuencia.keySet()) {
            System.out.println(clave + " → " + frecuencia.get(clave));
        }
    }
}

