package streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EjemploStream1 {
    public static void main(String[] args) {
        List<String> nombres = Arrays.asList("Ana", "Luis", "Antonio", "Laura", "Alberto");

        List<String> filtrados = nombres.stream()
                .filter(nombre -> nombre.startsWith("A"))
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        System.out.println("Nombres que empiezan por A (en mayúsculas): " + filtrados);
    }
}

