/**
 * Clase que representa una tarea en la lista.
 *
 * Demuestra:
 * - Encapsulamiento
 * - Sobreescritura de toString()
 * - Uso de boolean y operador ternario
 */
public class Tarea {

    private String descripcion;
    private boolean completada;

    /**
     * Constructor de la tarea.
     * Por defecto, la tarea se crea como no completada.
     *
     * @param descripcion Descripción de la tarea
     */
    public Tarea(String descripcion) {
        this.descripcion = descripcion;
        this.completada = false;
    }

    // ==================== GETTERS ====================

    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Para atributos booleanos, el getter se llama isXxx()
     */
    public boolean isCompletada() {
        return completada;
    }

    // ==================== MÉTODOS ====================

    /**
     * Marca la tarea como completada.
     */
    public void marcarCompletada() {
        this.completada = true;
    }

    /**
     * Devuelve una representación en texto de la tarea.
     * Se usa automáticamente cuando se imprime el objeto.
     */
    @Override
    public String toString() {
        // Operador ternario: condicion ? valorSiTrue : valorSiFalse
        String estado = completada ? "[✓]" : "[ ]";
        return estado + " " + descripcion;
    }
}

