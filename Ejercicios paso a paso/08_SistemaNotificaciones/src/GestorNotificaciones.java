import java.util.ArrayList;

/**
 * Gestor que administra múltiples canales de notificación.
 *
 * Demuestra el uso de una interfaz como tipo de colección,
 * permitiendo almacenar diferentes implementaciones.
 */
public class GestorNotificaciones {

    // Lista que puede contener cualquier clase que implemente Notificable
    private ArrayList<Notificable> canales;
    private int notificacionesEnviadas;

    public GestorNotificaciones() {
        canales = new ArrayList<>();
        notificacionesEnviadas = 0;
    }

    /**
     * Agrega un canal de notificación al gestor.
     * Acepta cualquier objeto que implemente Notificable.
     *
     * @param canal El canal a agregar
     */
    public void agregarCanal(Notificable canal) {
        canales.add(canal);
        System.out.println("✓ Canal agregado: " + canal.obtenerTipoNotificacion());
    }

    /**
     * Elimina un canal del gestor.
     *
     * @param canal El canal a eliminar
     */
    public void eliminarCanal(Notificable canal) {
        if (canales.remove(canal)) {
            System.out.println("✗ Canal eliminado: " + canal.obtenerTipoNotificacion());
        }
    }

    /**
     * Envía una notificación a través de TODOS los canales configurados.
     *
     * @param destinatario El destinatario del mensaje
     * @param mensaje El contenido del mensaje
     */
    public void notificarATodos(String destinatario, String mensaje) {
        if (canales.isEmpty()) {
            System.out.println("No hay canales configurados.");
            return;
        }

        System.out.println("\nEnviando notificación a todos los canales...");

        for (Notificable canal : canales) {
            // Polimorfismo: cada canal ejecuta SU versión de enviarNotificacion
            if (canal.enviarNotificacion(destinatario, mensaje)) {
                notificacionesEnviadas++;
            }
        }
    }

    /**
     * Envía una notificación solo a través de un tipo específico de canal.
     *
     * @param tipo El tipo de canal a usar (Email, SMS, Push)
     * @param destinatario El destinatario
     * @param mensaje El mensaje
     */
    public void notificarPorTipo(String tipo, String destinatario, String mensaje) {
        for (Notificable canal : canales) {
            if (canal.obtenerTipoNotificacion().equalsIgnoreCase(tipo)) {
                if (canal.enviarNotificacion(destinatario, mensaje)) {
                    notificacionesEnviadas++;
                }
                return;
            }
        }
        System.out.println("No se encontró un canal de tipo: " + tipo);
    }

    /**
     * Muestra un resumen de las notificaciones enviadas.
     */
    public void mostrarResumen() {
        System.out.println("\n=== RESUMEN ===");
        System.out.println("Notificaciones enviadas: " + notificacionesEnviadas);

        if (canales.isEmpty()) {
            System.out.println("No hay canales configurados.");
            return;
        }

        StringBuilder tipos = new StringBuilder("Canales utilizados: ");
        for (int i = 0; i < canales.size(); i++) {
            tipos.append(canales.get(i).obtenerTipoNotificacion());
            if (i < canales.size() - 1) {
                tipos.append(", ");
            }
        }
        System.out.println(tipos);
    }

    /**
     * Obtiene el número de canales configurados.
     */
    public int getCantidadCanales() {
        return canales.size();
    }
}

