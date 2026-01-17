import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Clase que representa un préstamo de libro.
 */
public class Prestamo {

    private Libro libro;
    private Usuario usuario;
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;
    private boolean devuelto;

    private static final DateTimeFormatter FORMATO_FECHA = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Prestamo(Libro libro, Usuario usuario) {
        this.libro = libro;
        this.usuario = usuario;
        this.fechaPrestamo = LocalDate.now();
        this.fechaDevolucion = fechaPrestamo.plusDays(usuario.getDiasPrestamo());
        this.devuelto = false;
    }

    /**
     * Marca el préstamo como devuelto.
     */
    public void marcarDevuelto() {
        this.devuelto = true;
    }

    /**
     * Verifica si el préstamo está vencido.
     */
    public boolean estaVencido() {
        return !devuelto && LocalDate.now().isAfter(fechaDevolucion);
    }

    /**
     * Calcula los días de retraso (si los hay).
     */
    public long getDiasRetraso() {
        if (!estaVencido()) {
            return 0;
        }
        return java.time.temporal.ChronoUnit.DAYS.between(fechaDevolucion, LocalDate.now());
    }

    // ==================== GETTERS ====================

    public Libro getLibro() {
        return libro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    public boolean isDevuelto() {
        return devuelto;
    }

    public String getFechaPrestamoFormateada() {
        return fechaPrestamo.format(FORMATO_FECHA);
    }

    public String getFechaDevolucionFormateada() {
        return fechaDevolucion.format(FORMATO_FECHA);
    }

    @Override
    public String toString() {
        String estado = devuelto ? "Devuelto" : (estaVencido() ? "VENCIDO" : "Activo");
        return String.format("%s → %s | Préstamo: %s | Devolución: %s | Estado: %s",
            libro.toStringCorto(),
            usuario.getNombre(),
            getFechaPrestamoFormateada(),
            getFechaDevolucionFormateada(),
            estado);
    }
}

