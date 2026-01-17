/**
 * Clase que representa un libro en la biblioteca.
 * Implementa Prestable para gestionar su disponibilidad.
 */
public class Libro implements Prestable {

    private String isbn;
    private String titulo;
    private String autor;
    private boolean disponible;

    public Libro(String isbn, String titulo, String autor) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.disponible = true;
    }

    // ==================== IMPLEMENTACIÓN DE PRESTABLE ====================

    @Override
    public boolean prestar() {
        if (disponible) {
            disponible = false;
            return true;
        }
        return false;
    }

    @Override
    public boolean devolver() {
        if (!disponible) {
            disponible = true;
            return true;
        }
        return false;
    }

    @Override
    public boolean estaDisponible() {
        return disponible;
    }

    // ==================== GETTERS ====================

    public String getIsbn() {
        return isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    // ==================== MÉTODOS ====================

    @Override
    public String toString() {
        String estado = disponible ? "Disponible" : "Prestado";
        return String.format("[%s] %s - %s (%s)", isbn, titulo, autor, estado);
    }

    public String toStringCorto() {
        return titulo + " - " + autor;
    }
}

