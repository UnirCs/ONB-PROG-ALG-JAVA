/**
 * Implementación de notificación por SMS.
 *
 * Incluye lógica específica para SMS como límite de caracteres.
 */
public class NotificacionSMS implements Notificable {

    // Los SMS tienen un límite de 160 caracteres
    private static final int MAX_CARACTERES = 160;

    @Override
    public boolean enviarNotificacion(String destinatario, String mensaje) {
        // Validar formato de teléfono (simplificado)
        if (!destinatario.startsWith("+") && !Character.isDigit(destinatario.charAt(0))) {
            System.out.println("\n[SMS] Error: Número de teléfono inválido");
            return false;
        }

        System.out.println("\n[SMS] Enviando a: " + destinatario);

        // Truncar mensaje si excede el límite
        String mensajeFinal = mensaje;
        if (mensaje.length() > MAX_CARACTERES) {
            mensajeFinal = mensaje.substring(0, MAX_CARACTERES - 3) + "...";
            System.out.println("(Mensaje truncado por exceder " + MAX_CARACTERES + " caracteres)");
        }

        System.out.println("Mensaje: " + mensajeFinal);
        System.out.println("Estado: ✓ Enviado");
        return true;
    }

    @Override
    public String obtenerTipoNotificacion() {
        return "SMS";
    }
}

