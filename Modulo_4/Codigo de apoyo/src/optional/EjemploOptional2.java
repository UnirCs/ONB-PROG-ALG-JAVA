package optional;

import java.util.Optional;

public class EjemploOptional2 {
    public static void main(String[] args) {
        Optional<String> usuario = Optional.ofNullable(null);

        String nombreMostrado = usuario.orElse("Invitado");

        System.out.println("Bienvenido, " + nombreMostrado);
    }
}

