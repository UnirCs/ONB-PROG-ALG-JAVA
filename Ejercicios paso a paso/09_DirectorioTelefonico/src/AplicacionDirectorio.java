import java.util.Scanner;

/**
 * Aplicación principal del directorio telefónico.
 *
 * Este ejercicio demuestra:
 * - HashMap para almacenamiento eficiente clave-valor
 * - Búsqueda rápida por clave
 * - Iteración sobre mapas
 */
public class AplicacionDirectorio {

    private static Scanner scanner = new Scanner(System.in);
    private static DirectorioTelefonico directorio = new DirectorioTelefonico();

    public static void mostrarMenu() {
        System.out.println("\n--- MENÚ ---");
        System.out.println("1. Agregar contacto");
        System.out.println("2. Buscar contacto");
        System.out.println("3. Eliminar contacto");
        System.out.println("4. Modificar teléfono");
        System.out.println("5. Listar todos");
        System.out.println("6. Buscar por texto");
        System.out.println("7. Salir");
        System.out.print("Opción: ");
    }

    public static void agregarContacto() {
        System.out.println("\n=== AGREGAR CONTACTO ===");

        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Teléfono: ");
        String telefono = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        directorio.agregarContacto(nombre, telefono, email);
    }

    public static void buscarContacto() {
        System.out.println("\n=== BUSCAR CONTACTO ===");
        System.out.print("Nombre a buscar: ");
        String nombre = scanner.nextLine();

        Contacto contacto = directorio.buscarContacto(nombre);
        if (contacto != null) {
            System.out.println("\n=== CONTACTO ENCONTRADO ===");
            System.out.println(contacto);
        }
    }

    public static void eliminarContacto() {
        System.out.println("\n=== ELIMINAR CONTACTO ===");
        System.out.print("Nombre del contacto a eliminar: ");
        String nombre = scanner.nextLine();

        directorio.eliminarContacto(nombre);
    }

    public static void modificarTelefono() {
        System.out.println("\n=== MODIFICAR TELÉFONO ===");
        System.out.print("Nombre del contacto: ");
        String nombre = scanner.nextLine();

        System.out.print("Nuevo teléfono: ");
        String nuevoTelefono = scanner.nextLine();

        directorio.modificarTelefono(nombre, nuevoTelefono);
    }

    public static void buscarPorTexto() {
        System.out.println("\n=== BUSCAR POR TEXTO ===");
        System.out.print("Texto a buscar: ");
        String texto = scanner.nextLine();

        directorio.buscarPorTexto(texto);
    }

    public static void main(String[] args) {
        System.out.println("=== DIRECTORIO TELEFÓNICO ===");

        // Agregar algunos contactos de ejemplo
        System.out.println("\nCargando contactos de ejemplo...");
        directorio.agregarContacto("María García", "612345678", "maria@email.com");
        directorio.agregarContacto("Pedro García", "698765432", "pedro@email.com");
        directorio.agregarContacto("Ana Martínez", "655443322", "ana@email.com");
        directorio.agregarContacto("Juan López", "677889900", "juan@email.com");

        int opcion;

        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    agregarContacto();
                    break;

                case 2:
                    buscarContacto();
                    break;

                case 3:
                    eliminarContacto();
                    break;

                case 4:
                    modificarTelefono();
                    break;

                case 5:
                    directorio.listarTodos();
                    break;

                case 6:
                    buscarPorTexto();
                    break;

                case 7:
                    System.out.println("\n¡Hasta pronto!");
                    break;

                default:
                    System.out.println("\nOpción no válida. Por favor, seleccione 1-7.");
            }

        } while (opcion != 7);

        scanner.close();
    }
}

