package optional;

import java.util.Optional;

public class EjemploOptional3 {
    public static void main(String[] args) {
        Optional<String> correo = Optional.of("usuario@example.com");

        int longitud = correo
                .map(String::length)
                .orElse(0);

        System.out.println("Longitud del correo: " + longitud);
    }
}

