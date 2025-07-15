package streams;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class MaximoSalario {

    public static Optional<Integer> obtenerSalarioMaximo(Map<String, Integer> salarios) {
        return salarios.entrySet()
                .stream()
                .max((e1, e2) -> e1.getValue().compareTo(e2.getValue()))
                .map(Map.Entry::getValue);
    }

    public static void main(String[] args) {
        Map<String, Integer> salarios = new HashMap<>();
        salarios.put("Ana", 1200);
        salarios.put("Luis", 1500);
        salarios.put("Marta", 1100);

        Optional<Integer> maxSalario = obtenerSalarioMaximo(salarios);
        maxSalario.ifPresentOrElse(
                s -> System.out.println("Salario máximo: " + s),
                () -> System.out.println("No hay empleados")
        );
    }
}
