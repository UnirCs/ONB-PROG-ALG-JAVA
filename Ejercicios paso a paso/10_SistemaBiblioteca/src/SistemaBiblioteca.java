import java.util.ArrayList;
import java.util.Scanner;

/**
 * Aplicación principal del Sistema de Gestión de Biblioteca.
 *
 * Este ejercicio integrador demuestra:
 * - Clases y objetos
 * - Herencia y clases abstractas
 * - Interfaces
 * - ArrayList y HashMap
 * - Encapsulamiento
 * - Polimorfismo
 */
public class SistemaBiblioteca {

    private static Scanner scanner = new Scanner(System.in);
    private static Biblioteca biblioteca;

    public static void main(String[] args) {
        // Inicializar la biblioteca
        biblioteca = new Biblioteca("Biblioteca Central");
        cargarDatosIniciales();

        System.out.println("╔════════════════════════════════════════════╗");
        System.out.println("║   SISTEMA DE GESTIÓN DE BIBLIOTECA         ║");
        System.out.println("║   " + biblioteca.getNombre() + "                      ║");
        System.out.println("╚════════════════════════════════════════════╝");

        int opcion;
        do {
            mostrarMenuPrincipal();
            opcion = leerOpcion();

            switch (opcion) {
                case 1:
                    menuLibros();
                    break;
                case 2:
                    menuUsuarios();
                    break;
                case 3:
                    menuPrestamos();
                    break;
                case 4:
                    biblioteca.mostrarEstadisticas();
                    break;
                case 5:
                    System.out.println("\n¡Gracias por usar el Sistema de Biblioteca!");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 5);

        scanner.close();
    }

    // ==================== MENÚS ====================

    private static void mostrarMenuPrincipal() {
        System.out.println("\n--- MENÚ PRINCIPAL ---");
        System.out.println("1. Gestión de Libros");
        System.out.println("2. Gestión de Usuarios");
        System.out.println("3. Préstamos");
        System.out.println("4. Estadísticas");
        System.out.println("5. Salir");
        System.out.print("Opción: ");
    }

    private static void menuLibros() {
        int opcion;
        do {
            System.out.println("\n--- GESTIÓN DE LIBROS ---");
            System.out.println("1. Agregar libro");
            System.out.println("2. Buscar libro por ISBN");
            System.out.println("3. Buscar libros por título");
            System.out.println("4. Ver libros disponibles");
            System.out.println("5. Ver todos los libros");
            System.out.println("6. Volver");
            System.out.print("Opción: ");
            opcion = leerOpcion();

            switch (opcion) {
                case 1:
                    agregarLibro();
                    break;
                case 2:
                    buscarLibroPorIsbn();
                    break;
                case 3:
                    buscarLibrosPorTitulo();
                    break;
                case 4:
                    mostrarLibrosDisponibles();
                    break;
                case 5:
                    biblioteca.listarTodosLosLibros();
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 6);
    }

    private static void menuUsuarios() {
        int opcion;
        do {
            System.out.println("\n--- GESTIÓN DE USUARIOS ---");
            System.out.println("1. Registrar estudiante");
            System.out.println("2. Registrar profesor");
            System.out.println("3. Buscar usuario");
            System.out.println("4. Ver todos los usuarios");
            System.out.println("5. Volver");
            System.out.print("Opción: ");
            opcion = leerOpcion();

            switch (opcion) {
                case 1:
                    registrarEstudiante();
                    break;
                case 2:
                    registrarProfesor();
                    break;
                case 3:
                    buscarUsuario();
                    break;
                case 4:
                    biblioteca.listarUsuarios();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 5);
    }

    private static void menuPrestamos() {
        int opcion;
        do {
            System.out.println("\n--- PRÉSTAMOS ---");
            System.out.println("1. Realizar préstamo");
            System.out.println("2. Devolver libro");
            System.out.println("3. Ver préstamos de un usuario");
            System.out.println("4. Ver todos los préstamos activos");
            System.out.println("5. Volver");
            System.out.print("Opción: ");
            opcion = leerOpcion();

            switch (opcion) {
                case 1:
                    realizarPrestamo();
                    break;
                case 2:
                    devolverLibro();
                    break;
                case 3:
                    verPrestamosUsuario();
                    break;
                case 4:
                    biblioteca.mostrarPrestamosActivos();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 5);
    }

    // ==================== OPERACIONES DE LIBROS ====================

    private static void agregarLibro() {
        System.out.println("\n=== AGREGAR LIBRO ===");
        System.out.print("ISBN: ");
        String isbn = scanner.nextLine();
        System.out.print("Título: ");
        String titulo = scanner.nextLine();
        System.out.print("Autor: ");
        String autor = scanner.nextLine();

        Libro libro = new Libro(isbn, titulo, autor);
        biblioteca.agregarLibro(libro);
    }

    private static void buscarLibroPorIsbn() {
        System.out.print("\nISBN a buscar: ");
        String isbn = scanner.nextLine();

        Libro libro = biblioteca.buscarLibroPorIsbn(isbn);
        if (libro != null) {
            System.out.println("\n=== LIBRO ENCONTRADO ===");
            System.out.println(libro);
        } else {
            System.out.println("Libro no encontrado.");
        }
    }

    private static void buscarLibrosPorTitulo() {
        System.out.print("\nTexto a buscar en título: ");
        String texto = scanner.nextLine();

        ArrayList<Libro> resultados = biblioteca.buscarLibrosPorTitulo(texto);
        if (resultados.isEmpty()) {
            System.out.println("No se encontraron libros.");
        } else {
            System.out.println("\n=== RESULTADOS ===");
            for (Libro libro : resultados) {
                System.out.println(libro);
            }
        }
    }

    private static void mostrarLibrosDisponibles() {
        ArrayList<Libro> disponibles = biblioteca.getLibrosDisponibles();
        if (disponibles.isEmpty()) {
            System.out.println("\nNo hay libros disponibles actualmente.");
        } else {
            System.out.println("\n=== LIBROS DISPONIBLES ===");
            for (Libro libro : disponibles) {
                System.out.println(libro);
            }
        }
    }

    // ==================== OPERACIONES DE USUARIOS ====================

    private static void registrarEstudiante() {
        System.out.println("\n=== REGISTRAR ESTUDIANTE ===");
        System.out.print("ID (ej: EST001): ");
        String id = scanner.nextLine();
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        Estudiante estudiante = new Estudiante(id, nombre);
        biblioteca.registrarUsuario(estudiante);
    }

    private static void registrarProfesor() {
        System.out.println("\n=== REGISTRAR PROFESOR ===");
        System.out.print("ID (ej: PROF001): ");
        String id = scanner.nextLine();
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        Profesor profesor = new Profesor(id, nombre);
        biblioteca.registrarUsuario(profesor);
    }

    private static void buscarUsuario() {
        System.out.print("\nID del usuario: ");
        String id = scanner.nextLine();

        Usuario usuario = biblioteca.buscarUsuario(id);
        if (usuario != null) {
            System.out.println("\n=== USUARIO ENCONTRADO ===");
            System.out.println(usuario);
        } else {
            System.out.println("Usuario no encontrado.");
        }
    }

    // ==================== OPERACIONES DE PRÉSTAMOS ====================

    private static void realizarPrestamo() {
        System.out.println("\n=== REALIZAR PRÉSTAMO ===");
        System.out.print("ID Usuario: ");
        String idUsuario = scanner.nextLine();
        System.out.print("ISBN del libro: ");
        String isbn = scanner.nextLine();

        biblioteca.realizarPrestamo(idUsuario, isbn);
    }

    private static void devolverLibro() {
        System.out.println("\n=== DEVOLVER LIBRO ===");
        System.out.print("ID Usuario: ");
        String idUsuario = scanner.nextLine();
        System.out.print("ISBN del libro: ");
        String isbn = scanner.nextLine();

        biblioteca.devolverLibro(idUsuario, isbn);
    }

    private static void verPrestamosUsuario() {
        System.out.print("\nID del usuario: ");
        String idUsuario = scanner.nextLine();

        ArrayList<Prestamo> prestamos = biblioteca.getPrestamosUsuario(idUsuario);
        if (prestamos.isEmpty()) {
            System.out.println("El usuario no tiene préstamos activos.");
        } else {
            System.out.println("\n=== PRÉSTAMOS ACTIVOS ===");
            for (Prestamo prestamo : prestamos) {
                System.out.println(prestamo);
            }
        }
    }

    // ==================== UTILIDADES ====================

    private static int leerOpcion() {
        int opcion = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer
        return opcion;
    }

    /**
     * Carga datos iniciales para demostración.
     */
    private static void cargarDatosIniciales() {
        // Agregar libros de ejemplo
        biblioteca.agregarLibro(new Libro("978-84-376-0494-7", "Don Quijote de la Mancha", "Miguel de Cervantes"));
        biblioteca.agregarLibro(new Libro("978-84-206-5192-9", "Cien años de soledad", "Gabriel García Márquez"));
        biblioteca.agregarLibro(new Libro("978-84-233-4827-2", "El principito", "Antoine de Saint-Exupéry"));
        biblioteca.agregarLibro(new Libro("978-84-322-1327-8", "1984", "George Orwell"));
        biblioteca.agregarLibro(new Libro("978-84-663-1298-6", "El hobbit", "J.R.R. Tolkien"));

        // Agregar usuarios de ejemplo
        biblioteca.registrarUsuario(new Estudiante("EST001", "Juan Pérez"));
        biblioteca.registrarUsuario(new Estudiante("EST002", "María López"));
        biblioteca.registrarUsuario(new Profesor("PROF001", "Dr. Carlos Ruiz"));

        System.out.println("\n✓ Datos de ejemplo cargados correctamente.\n");
    }
}

