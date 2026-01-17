import java.util.Scanner;

/**
 * Clase principal de la aplicación de lista de tareas.
 *
 * Este ejercicio demuestra:
 * - Uso de ArrayList para listas dinámicas
 * - Interacción entre múltiples clases
 * - Menú interactivo con el usuario
 */
public class AplicacionTareas {

    public static void mostrarMenu() {
        System.out.println("\n--- MENÚ ---");
        System.out.println("1. Agregar tarea");
        System.out.println("2. Eliminar tarea");
        System.out.println("3. Marcar tarea como completada");
        System.out.println("4. Ver todas las tareas");
        System.out.println("5. Ver tareas pendientes");
        System.out.println("6. Ver resumen");
        System.out.println("7. Salir");
        System.out.print("Opción: ");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GestorTareas gestor = new GestorTareas();

        System.out.println("=== LISTA DE TAREAS ===");

        int opcion;

        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer después de nextInt()

            switch (opcion) {
                case 1: // Agregar tarea
                    System.out.print("\nIngrese la descripción de la tarea: ");
                    String descripcion = scanner.nextLine();

                    if (descripcion.trim().isEmpty()) {
                        System.out.println("Error: La descripción no puede estar vacía.");
                    } else {
                        gestor.agregarTarea(descripcion);
                    }
                    break;

                case 2: // Eliminar tarea
                    gestor.mostrarTodas();
                    System.out.print("\nIngrese el número de tarea a eliminar: ");
                    int numEliminar = scanner.nextInt();
                    gestor.eliminarTarea(numEliminar);
                    break;

                case 3: // Marcar como completada
                    gestor.mostrarTodas();
                    System.out.print("\nIngrese el número de tarea a completar: ");
                    int numCompletar = scanner.nextInt();
                    gestor.marcarCompletada(numCompletar);
                    break;

                case 4: // Ver todas
                    gestor.mostrarTodas();
                    break;

                case 5: // Ver pendientes
                    gestor.mostrarPendientes();
                    break;

                case 6: // Ver resumen
                    gestor.mostrarResumen();
                    break;

                case 7: // Salir
                    System.out.println("\n¡Hasta pronto! No olvides completar tus tareas.");
                    break;

                default:
                    System.out.println("\nOpción no válida. Por favor, seleccione 1-7.");
            }

        } while (opcion != 7);

        scanner.close();
    }
}

