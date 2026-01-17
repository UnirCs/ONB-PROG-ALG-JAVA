/**
 * Implementación de notificación push para dispositivos móviles.
 */
public class NotificacionPush implements Notificable {

    private String titulo;

    /**
     * Constructor con título personalizado.
     */
    public NotificacionPush(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Constructor por defecto.
     */
    public NotificacionPush() {
        this.titulo = "Nueva notificación";
    }

    @Override
    public boolean enviarNotificacion(String destinatario, String mensaje) {
        // El destinatario sería el token del dispositivo
        if (destinatario == null || destinatario.isEmpty()) {
            System.out.println("\n[PUSH] Error: Token de dispositivo inválido");
            return false;
        }

        System.out.println("\n[PUSH] Enviando notificación push a dispositivo: " + destinatario);
        System.out.println("Título: " + titulo);
        System.out.println("Mensaje: " + mensaje);
        System.out.println("Estado: ✓ Enviado");
        return true;
    }

    @Override
    public String obtenerTipoNotificacion() {
        return "Push";
    }
}

