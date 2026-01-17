/**
 * Implementación de notificación por correo electrónico.
 *
 * Demuestra cómo una clase implementa una interfaz
 * y proporciona su propia lógica para los métodos.
 */
public class NotificacionEmail implements Notificable {

    private String asunto;

    /**
     * Constructor que recibe el asunto del email.
     */
    public NotificacionEmail(String asunto) {
        this.asunto = asunto;
    }

    /**
     * Constructor por defecto con asunto genérico.
     */
    public NotificacionEmail() {
        this.asunto = "Notificación";
    }

    @Override
    public boolean enviarNotificacion(String destinatario, String mensaje) {
        // Validar que el destinatario parece un email
        if (!destinatario.contains("@")) {
            System.out.println("\n[EMAIL] Error: Dirección de email inválida");
            return false;
        }

        System.out.println("\n[EMAIL] Enviando a: " + destinatario);
        System.out.println("Asunto: " + asunto);
        System.out.println("Mensaje: " + mensaje);

        // Simulamos el envío (en un sistema real, aquí iría la lógica de envío)
        System.out.println("Estado: ✓ Enviado");
        return true;
    }

    @Override
    public String obtenerTipoNotificacion() {
        return "Email";
    }
}

