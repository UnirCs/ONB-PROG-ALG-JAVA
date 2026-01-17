/**
 * Interfaz que define el contrato para todos los tipos de notificación.
 *
 * Una interfaz define QUÉ debe hacer una clase, pero no CÓMO.
 * Las clases que implementen esta interfaz deben proporcionar
 * su propia implementación de estos métodos.
 */
public interface Notificable {

    /**
     * Envía una notificación al destinatario especificado.
     *
     * @param destinatario A quién enviar (email, teléfono, token, etc.)
     * @param mensaje El contenido del mensaje
     * @return true si se envió correctamente, false en caso contrario
     */
    boolean enviarNotificacion(String destinatario, String mensaje);

    /**
     * Obtiene el tipo de notificación (Email, SMS, Push, etc.)
     *
     * @return String con el nombre del tipo de notificación
     */
    String obtenerTipoNotificacion();
}

