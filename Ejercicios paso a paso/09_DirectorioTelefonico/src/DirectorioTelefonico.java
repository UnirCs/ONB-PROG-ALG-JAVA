import java.util.HashMap;
import java.util.Map;

/**
 * Directorio telefónico implementado con HashMap.
 *
 * Este ejercicio demuestra:
 * - Uso de HashMap para almacenamiento clave-valor
 * - Métodos principales: put, get, remove, containsKey
 * - Iteración sobre HashMap con keySet y entrySet
 */
public class DirectorioTelefonico {

    // HashMap donde la clave es el nombre y el valor es el Contacto
    private HashMap<String, Contacto> contactos;

    public DirectorioTelefonico() {
        contactos = new HashMap<>();
    }

    /**
     * Agrega un nuevo contacto al directorio.
     *
     * @return true si se agregó correctamente, false si ya existía
     */
    public boolean agregarContacto(String nombre, String telefono, String email) {
        // Verificar si ya existe un contacto con ese nombre
        if (contactos.containsKey(nombre)) {
            System.out.println("⚠ Ya existe un contacto con el nombre: " + nombre);
            return false;
        }

        // Crear y agregar el nuevo contacto
        Contacto nuevoContacto = new Contacto(nombre, telefono, email);
        contactos.put(nombre, nuevoContacto);
        System.out.println("✓ Contacto agregado correctamente.");
        return true;
    }

    /**
     * Busca un contacto por su nombre exacto.
     *
     * @param nombre El nombre a buscar
     * @return El contacto encontrado o null si no existe
     */
    public Contacto buscarContacto(String nombre) {
        Contacto contacto = contactos.get(nombre);

        if (contacto == null) {
            System.out.println("✗ Contacto no encontrado: " + nombre);
        }

        return contacto;
    }

    /**
     * Elimina un contacto del directorio.
     *
     * @param nombre El nombre del contacto a eliminar
     * @return true si se eliminó, false si no existía
     */
    public boolean eliminarContacto(String nombre) {
        if (contactos.containsKey(nombre)) {
            contactos.remove(nombre);
            System.out.println("✓ Contacto eliminado: " + nombre);
            return true;
        } else {
            System.out.println("✗ Contacto no encontrado: " + nombre);
            return false;
        }
    }

    /**
     * Modifica el teléfono de un contacto existente.
     */
    public boolean modificarTelefono(String nombre, String nuevoTelefono) {
        Contacto contacto = contactos.get(nombre);

        if (contacto != null) {
            String telefonoAnterior = contacto.getTelefono();
            contacto.setTelefono(nuevoTelefono);
            System.out.println("✓ Teléfono actualizado.");
            System.out.println("  Anterior: " + telefonoAnterior);
            System.out.println("  Nuevo: " + nuevoTelefono);
            return true;
        } else {
            System.out.println("✗ Contacto no encontrado: " + nombre);
            return false;
        }
    }

    /**
     * Lista todos los contactos del directorio.
     */
    public void listarTodos() {
        if (contactos.isEmpty()) {
            System.out.println("El directorio está vacío.");
            return;
        }

        System.out.println("\n=== TODOS LOS CONTACTOS (" + contactos.size() + ") ===");

        // Iterar usando entrySet (más eficiente que keySet + get)
        for (Map.Entry<String, Contacto> entrada : contactos.entrySet()) {
            Contacto c = entrada.getValue();
            System.out.println("- " + c.toStringCorto());
        }
    }

    /**
     * Busca contactos cuyo nombre contenga el texto especificado.
     *
     * @param texto El texto a buscar (ignora mayúsculas/minúsculas)
     */
    public void buscarPorTexto(String texto) {
        System.out.println("\n=== RESULTADOS DE BÚSQUEDA: \"" + texto + "\" ===");
        boolean encontrado = false;

        for (String nombre : contactos.keySet()) {
            // Búsqueda ignorando mayúsculas/minúsculas
            if (nombre.toLowerCase().contains(texto.toLowerCase())) {
                Contacto c = contactos.get(nombre);
                System.out.println("- " + c.toStringCorto());
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("No se encontraron contactos que coincidan.");
        }
    }

    /**
     * Obtiene la cantidad de contactos en el directorio.
     */
    public int getCantidadContactos() {
        return contactos.size();
    }

    /**
     * Verifica si el directorio está vacío.
     */
    public boolean estaVacio() {
        return contactos.isEmpty();
    }
}

