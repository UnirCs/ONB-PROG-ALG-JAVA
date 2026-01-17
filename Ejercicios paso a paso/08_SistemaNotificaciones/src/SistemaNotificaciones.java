/**
 * Clase principal que demuestra el uso de interfaces.
 *
 * Este ejercicio demuestra:
 * - Definición e implementación de interfaces
 * - Polimorfismo con interfaces
 * - Uso de interfaz como tipo de colección
 */
public class SistemaNotificaciones {

    public static void main(String[] args) {
        System.out.println("=== SISTEMA DE NOTIFICACIONES ===\n");

        // Crear el gestor de notificaciones
        GestorNotificaciones gestor = new GestorNotificaciones();

        System.out.println("Configurando canales de notificación...");

        // Agregar diferentes tipos de notificadores
        // Todos son tratados como Notificable (polimorfismo)
        gestor.agregarCanal(new NotificacionEmail("Alerta del Sistema"));
        gestor.agregarCanal(new NotificacionSMS());
        gestor.agregarCanal(new NotificacionPush("Alerta del Sistema"));

        // Enviar notificación a todos los canales
        String mensaje = "Su pedido #12345 ha sido enviado y llegará en 2-3 días hábiles.";

        // Simular diferentes destinatarios para cada canal
        System.out.println("\n--- Notificación por EMAIL ---");
        gestor.notificarPorTipo("Email", "usuario@email.com", mensaje);

        System.out.println("\n--- Notificación por SMS ---");
        gestor.notificarPorTipo("SMS", "+34612345678", mensaje);

        System.out.println("\n--- Notificación PUSH ---");
        gestor.notificarPorTipo("Push", "device_token_abc123", mensaje);

        // Mostrar resumen
        gestor.mostrarResumen();

        // También podemos enviar a todos los canales con un solo destinatario
        System.out.println("\n\n========================================");
        System.out.println("Enviando alerta urgente a todos los canales...");
        gestor.notificarATodos("usuario@email.com", "¡ALERTA! Acceso detectado desde nuevo dispositivo.");

        gestor.mostrarResumen();
    }
}

