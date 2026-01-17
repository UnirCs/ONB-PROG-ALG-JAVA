/**
 * Interfaz que define el contrato para elementos que pueden ser prestados.
 */
public interface Prestable {

    /**
     * Marca el elemento como prestado.
     * @return true si se pudo prestar, false si ya estaba prestado
     */
    boolean prestar();

    /**
     * Marca el elemento como devuelto.
     * @return true si se pudo devolver, false si ya estaba disponible
     */
    boolean devolver();

    /**
     * Verifica si el elemento está disponible para préstamo.
     * @return true si está disponible
     */
    boolean estaDisponible();
}

