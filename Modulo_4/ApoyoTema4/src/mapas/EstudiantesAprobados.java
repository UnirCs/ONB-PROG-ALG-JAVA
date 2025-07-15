package mapas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EstudiantesAprobados {

    public static List<String> obtenerAprobados(Map<String, Integer> calificaciones) {
        List<String> aprobados = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : calificaciones.entrySet()) {
            if (entry.getValue() >= 5) {
                aprobados.add(entry.getKey());
            }
        }
        return aprobados;
    }

    public static void main(String[] args) {
        Map<String, Integer> calificaciones = new HashMap<>();
        calificaciones.put("Ana", 8);
        calificaciones.put("Luis", 4);
        calificaciones.put("Marta", 6);
        calificaciones.put("Juan", 3);

        List<String> aprobados = obtenerAprobados(calificaciones);
        System.out.println(aprobados); // Salida: [Ana, Marta]
    }
}
