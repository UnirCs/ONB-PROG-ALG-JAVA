import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Clase principal que gestiona toda la biblioteca.
 * Integra ArrayList y HashMap para diferentes tipos de almacenamiento.
 */
public class Biblioteca {

    private ArrayList<Libro> catalogo;
    private HashMap<String, Usuario> usuarios;
    private ArrayList<Prestamo> prestamos;
    private String nombre;

    public Biblioteca(String nombre) {
        this.nombre = nombre;
        this.catalogo = new ArrayList<>();
        this.usuarios = new HashMap<>();
        this.prestamos = new ArrayList<>();
    }

    // ==================== GESTIÓN DE LIBROS ====================

    public void agregarLibro(Libro libro) {
        // Verificar que no exista el ISBN
        if (buscarLibroPorIsbn(libro.getIsbn()) != null) {
            System.out.println("Ya existe un libro con ese ISBN.");
            return;
        }
        catalogo.add(libro);
        System.out.println("✓ Libro agregado: " + libro.getTitulo());
    }

    public Libro buscarLibroPorIsbn(String isbn) {
        for (Libro libro : catalogo) {
            if (libro.getIsbn().equals(isbn)) {
                return libro;
            }
        }
        return null;
    }

    public ArrayList<Libro> buscarLibrosPorTitulo(String texto) {
        ArrayList<Libro> resultados = new ArrayList<>();
        for (Libro libro : catalogo) {
            if (libro.getTitulo().toLowerCase().contains(texto.toLowerCase())) {
                resultados.add(libro);
            }
        }
        return resultados;
    }

    public ArrayList<Libro> getLibrosDisponibles() {
        ArrayList<Libro> disponibles = new ArrayList<>();
        for (Libro libro : catalogo) {
            if (libro.estaDisponible()) {
                disponibles.add(libro);
            }
        }
        return disponibles;
    }

    public void listarTodosLosLibros() {
        if (catalogo.isEmpty()) {
            System.out.println("No hay libros en el catálogo.");
            return;
        }
        System.out.println("\n=== CATÁLOGO COMPLETO ===");
        for (Libro libro : catalogo) {
            System.out.println(libro);
        }
    }

    // ==================== GESTIÓN DE USUARIOS ====================

    public void registrarUsuario(Usuario usuario) {
        if (usuarios.containsKey(usuario.getId())) {
            System.out.println("Ya existe un usuario con ese ID.");
            return;
        }
        usuarios.put(usuario.getId(), usuario);
        System.out.println("✓ Usuario registrado: " + usuario.getNombre() + " (" + usuario.getTipoUsuario() + ")");
    }

    public Usuario buscarUsuario(String id) {
        return usuarios.get(id);
    }

    public void listarUsuarios() {
        if (usuarios.isEmpty()) {
            System.out.println("No hay usuarios registrados.");
            return;
        }
        System.out.println("\n=== USUARIOS REGISTRADOS ===");
        for (Map.Entry<String, Usuario> entrada : usuarios.entrySet()) {
            System.out.println(entrada.getValue());
        }
    }

    // ==================== GESTIÓN DE PRÉSTAMOS ====================

    public boolean realizarPrestamo(String idUsuario, String isbn) {
        // Buscar usuario y libro
        Usuario usuario = buscarUsuario(idUsuario);
        Libro libro = buscarLibroPorIsbn(isbn);

        // Validaciones
        if (usuario == null) {
            System.out.println("✗ Usuario no encontrado: " + idUsuario);
            return false;
        }

        if (libro == null) {
            System.out.println("✗ Libro no encontrado: " + isbn);
            return false;
        }

        if (!libro.estaDisponible()) {
            System.out.println("✗ El libro no está disponible actualmente.");
            return false;
        }

        if (!usuario.puedePrestar()) {
            System.out.println("✗ El usuario ha alcanzado su límite de préstamos (" +
                usuario.getMaxLibros() + " libros).");
            return false;
        }

        // Realizar el préstamo
        libro.prestar();
        usuario.incrementarPrestamos();
        Prestamo prestamo = new Prestamo(libro, usuario);
        prestamos.add(prestamo);

        System.out.println("\n✓ Préstamo realizado con éxito.");
        System.out.println("  Libro: " + libro.getTitulo());
        System.out.println("  Usuario: " + usuario.getNombre() + " (" + usuario.getTipoUsuario() + ")");
        System.out.println("  Fecha devolución: " + prestamo.getFechaDevolucionFormateada());
        System.out.println("  Libros restantes permitidos: " + usuario.getPrestamosRestantes());

        return true;
    }

    public boolean devolverLibro(String idUsuario, String isbn) {
        // Buscar el préstamo activo
        for (Prestamo prestamo : prestamos) {
            if (!prestamo.isDevuelto() &&
                prestamo.getUsuario().getId().equals(idUsuario) &&
                prestamo.getLibro().getIsbn().equals(isbn)) {

                // Realizar la devolución
                prestamo.getLibro().devolver();
                prestamo.getUsuario().decrementarPrestamos();
                prestamo.marcarDevuelto();

                System.out.println("\n✓ Libro devuelto con éxito.");
                System.out.println("  Libro: " + prestamo.getLibro().getTitulo());

                if (prestamo.estaVencido()) {
                    System.out.println("  ⚠ AVISO: El libro fue devuelto con " +
                        prestamo.getDiasRetraso() + " días de retraso.");
                }

                return true;
            }
        }

        System.out.println("✗ No se encontró un préstamo activo con esos datos.");
        return false;
    }

    public ArrayList<Prestamo> getPrestamosUsuario(String idUsuario) {
        ArrayList<Prestamo> resultado = new ArrayList<>();
        for (Prestamo prestamo : prestamos) {
            if (!prestamo.isDevuelto() &&
                prestamo.getUsuario().getId().equals(idUsuario)) {
                resultado.add(prestamo);
            }
        }
        return resultado;
    }

    public void mostrarPrestamosActivos() {
        System.out.println("\n=== PRÉSTAMOS ACTIVOS ===");
        boolean hayActivos = false;

        for (Prestamo prestamo : prestamos) {
            if (!prestamo.isDevuelto()) {
                System.out.println(prestamo);
                hayActivos = true;
            }
        }

        if (!hayActivos) {
            System.out.println("No hay préstamos activos.");
        }
    }

    // ==================== ESTADÍSTICAS ====================

    public void mostrarEstadisticas() {
        int totalLibros = catalogo.size();
        int librosDisponibles = getLibrosDisponibles().size();
        int librosPrestados = totalLibros - librosDisponibles;
        int totalUsuarios = usuarios.size();
        int prestamosActivos = 0;
        int prestamosVencidos = 0;

        for (Prestamo p : prestamos) {
            if (!p.isDevuelto()) {
                prestamosActivos++;
                if (p.estaVencido()) {
                    prestamosVencidos++;
                }
            }
        }

        System.out.println("\n╔════════════════════════════════════╗");
        System.out.println("║        ESTADÍSTICAS - " + nombre);
        System.out.println("╠════════════════════════════════════╣");
        System.out.println("║ Total de libros:        " + String.format("%10d", totalLibros) + " ║");
        System.out.println("║ Libros disponibles:     " + String.format("%10d", librosDisponibles) + " ║");
        System.out.println("║ Libros prestados:       " + String.format("%10d", librosPrestados) + " ║");
        System.out.println("║ Usuarios registrados:   " + String.format("%10d", totalUsuarios) + " ║");
        System.out.println("║ Préstamos activos:      " + String.format("%10d", prestamosActivos) + " ║");
        System.out.println("║ Préstamos vencidos:     " + String.format("%10d", prestamosVencidos) + " ║");
        System.out.println("╚════════════════════════════════════╝");
    }

    public String getNombre() {
        return nombre;
    }
}

