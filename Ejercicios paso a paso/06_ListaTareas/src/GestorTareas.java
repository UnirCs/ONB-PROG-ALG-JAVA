import java.util.ArrayList;

/**
 * Clase que gestiona la lista de tareas.
 *
 * Demuestra:
 * - Uso de ArrayList
 * - Métodos add(), remove(), get(), size()
 * - Bucle for-each
 */
public class GestorTareas {

    // ArrayList para almacenar las tareas (tamaño dinámico)
    private ArrayList<Tarea> tareas;

    /**
     * Constructor que inicializa la lista vacía.
     */
    public GestorTareas() {
        tareas = new ArrayList<>();
    }

    /**
     * Agrega una nueva tarea a la lista.
     *
     * @param descripcion Descripción de la tarea
     */
    public void agregarTarea(String descripcion) {
        Tarea nuevaTarea = new Tarea(descripcion);
        tareas.add(nuevaTarea);
        System.out.println("Tarea agregada con éxito.");
    }

    /**
     * Elimina una tarea por su número (índice + 1).
     *
     * @param numero Número de la tarea (empezando en 1)
     */
    public void eliminarTarea(int numero) {
        // Convertir de índice usuario (1-based) a índice Java (0-based)
        int indice = numero - 1;

        if (indice >= 0 && indice < tareas.size()) {
            Tarea eliminada = tareas.remove(indice);
            System.out.println("Tarea eliminada: " + eliminada.getDescripcion());
        } else {
            System.out.println("Error: Número de tarea no válido.");
        }
    }

    /**
     * Marca una tarea como completada.
     *
     * @param numero Número de la tarea (empezando en 1)
     */
    public void marcarCompletada(int numero) {
        int indice = numero - 1;

        if (indice >= 0 && indice < tareas.size()) {
            Tarea tarea = tareas.get(indice);
            if (tarea.isCompletada()) {
                System.out.println("Esta tarea ya estaba completada.");
            } else {
                tarea.marcarCompletada();
                System.out.println("¡Tarea completada!");
            }
        } else {
            System.out.println("Error: Número de tarea no válido.");
        }
    }

    /**
     * Muestra todas las tareas (completadas y pendientes).
     */
    public void mostrarTodas() {
        if (tareas.isEmpty()) {
            System.out.println("\nNo hay tareas en la lista.");
            return;
        }

        System.out.println("\n=== TODAS LAS TAREAS ===");
        int numero = 1;

        // Bucle for-each: forma simplificada de recorrer colecciones
        for (Tarea tarea : tareas) {
            System.out.println(numero + ". " + tarea);
            numero++;
        }
    }

    /**
     * Muestra solo las tareas pendientes (no completadas).
     */
    public void mostrarPendientes() {
        if (tareas.isEmpty()) {
            System.out.println("\nNo hay tareas en la lista.");
            return;
        }

        System.out.println("\n=== TAREAS PENDIENTES ===");
        int numero = 1;
        boolean hayPendientes = false;

        for (Tarea tarea : tareas) {
            if (!tarea.isCompletada()) {
                System.out.println(numero + ". " + tarea.getDescripcion());
                hayPendientes = true;
            }
            numero++;
        }

        if (!hayPendientes) {
            System.out.println("¡No hay tareas pendientes! 🎉");
        }
    }

    /**
     * Muestra un resumen con estadísticas de las tareas.
     */
    public void mostrarResumen() {
        int total = tareas.size();
        int completadas = 0;

        for (Tarea tarea : tareas) {
            if (tarea.isCompletada()) {
                completadas++;
            }
        }

        int pendientes = total - completadas;

        System.out.println("\n=== RESUMEN ===");
        System.out.println("Total de tareas: " + total);
        System.out.println("Completadas: " + completadas);
        System.out.println("Pendientes: " + pendientes);

        if (total > 0) {
            int porcentaje = (completadas * 100) / total;
            System.out.println("Progreso: " + porcentaje + "%");
        }
    }
}

