package streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EjemploStream3 {
    public static void main(String[] args) {
        List<String> palabras = Arrays.asList("java", "stream", "java", "map", "stream", "filter");

        Map<String, Long> conteo = palabras.stream()
                .collect(Collectors.groupingBy(p -> p, Collectors.counting()));

        System.out.println("Frecuencia de cada palabra: " + conteo);
    }
}

