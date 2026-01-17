/**
 * Clase abstracta base para todos los tipos de usuarios de la biblioteca.
 */
public abstract class Usuario {

    protected String id;
    protected String nombre;
    protected int prestamosActivos;

    public Usuario(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.prestamosActivos = 0;
    }

    // ==================== MÉTODOS ABSTRACTOS ====================

    /**
     * Retorna el máximo de libros que puede tener prestados.
     * Cada tipo de usuario tiene un límite diferente.
     */
    public abstract int getMaxLibros();

    /**
     * Retorna los días de préstamo permitidos.
     * Cada tipo de usuario tiene un período diferente.
     */
    public abstract int getDiasPrestamo();

    /**
     * Retorna el tipo de usuario (para mostrar en pantalla).
     */
    public abstract String getTipoUsuario();

    // ==================== MÉTODOS COMUNES ====================

    /**
     * Verifica si el usuario puede tomar más libros prestados.
     */
    public boolean puedePrestar() {
        return prestamosActivos < getMaxLibros();
    }

    /**
     * Incrementa el contador de préstamos activos.
     */
    public void incrementarPrestamos() {
        prestamosActivos++;
    }

    /**
     * Decrementa el contador de préstamos activos.
     */
    public void decrementarPrestamos() {
        if (prestamosActivos > 0) {
            prestamosActivos--;
        }
    }

    /**
     * Retorna cuántos libros más puede tomar prestados.
     */
    public int getPrestamosRestantes() {
        return getMaxLibros() - prestamosActivos;
    }

    // ==================== GETTERS ====================

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPrestamosActivos() {
        return prestamosActivos;
    }

    @Override
    public String toString() {
        return String.format("%s (%s) - ID: %s - Préstamos: %d/%d",
            nombre, getTipoUsuario(), id, prestamosActivos, getMaxLibros());
    }
}

