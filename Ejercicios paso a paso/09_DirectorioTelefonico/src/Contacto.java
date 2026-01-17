/**
 * Clase que representa un contacto en el directorio.
 */
public class Contacto {

    private String nombre;
    private String telefono;
    private String email;

    /**
     * Constructor del contacto.
     */
    public Contacto(String nombre, String telefono, String email) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
    }

    // ==================== GETTERS ====================

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }

    // ==================== SETTERS ====================

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // ==================== MÉTODOS ====================

    /**
     * Representación en texto del contacto.
     */
    @Override
    public String toString() {
        return "Nombre: " + nombre + "\n" +
               "Teléfono: " + telefono + "\n" +
               "Email: " + email;
    }

    /**
     * Representación corta para listados.
     */
    public String toStringCorto() {
        return nombre + " (" + telefono + ")";
    }
}

