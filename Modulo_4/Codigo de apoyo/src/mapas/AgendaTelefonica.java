package mapas;

import java.util.HashMap;
import java.util.Map;

public class AgendaTelefonica {
    public static void main(String[] args) {
        Map<String, Contacto> agenda = new HashMap<>();

        // Insertamos contactos en la agenda
        agenda.put("Ana",
                new Contacto("Ana", "123-456-789", "ana@example.com"));
        agenda.put("Luis",
                new Contacto("Luis", "987-654-321", "luis@example.com"));
        agenda.put("Carlos",
                new Contacto("Carlos", "555-123-456", "carlos@example.com"));

        // Consulta de un contacto
        String nombreBuscado = "Luis";
        if (agenda.containsKey(nombreBuscado)) {
            Contacto c = agenda.get(nombreBuscado);
            System.out.println("Información de contacto de " + nombreBuscado + ":");
            System.out.println(c);
        } else {
            System.out.println(nombreBuscado + " no está en la agenda.");
        }

        // Eliminación de un contacto
        agenda.remove("Ana");

        // Mostrar todos los contactos
        System.out.println("\nAgenda completa:");
        for (String clave : agenda.keySet()) {
            System.out.println(agenda.get(clave));
        }
    }
}
