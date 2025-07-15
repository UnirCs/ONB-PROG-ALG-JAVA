package optional;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class EjemploOptional1 {
    public static void main(String[] args) {
        Map<String, String> capitales = new HashMap<>();
        capitales.put("España", "Madrid");
        capitales.put("Francia", "París");

        String pais = "Alemania";

        Optional<String> capital = Optional.ofNullable(capitales.get(pais));

        if (capital.isPresent()) {
            System.out.println("La capital de " + pais + " es " + capital.get());
        } else {
            System.out.println("No se encontró la capital de " + pais);
        }
    }
}

