# Paso a Paso: Sistema de Notificaciones con Interfaces

## Análisis del problema

Las **interfaces** definen un "contrato" que las clases deben cumplir. Son perfectas cuando diferentes clases deben hacer lo mismo pero de maneras diferentes.

**¿Interfaz vs Clase Abstracta?**

| Característica | Interface | Clase Abstracta |
|----------------|-----------|-----------------|
| Herencia múltiple | Sí (implements múltiples) | No (solo extends una) |
| Atributos | Solo constantes (static final) | Cualquier tipo |
| Métodos | Abstractos (y default desde Java 8) | Abstractos y concretos |
| Constructor | No tiene | Puede tener |
| Uso principal | Definir capacidades | Definir jerarquía |

## Paso 1: Crear la interfaz Notificable

```java
public interface Notificable {
    
    /**
     * Envía una notificación al destinatario.
     * 
     * @param destinatario A quién enviar (email, teléfono, etc.)
     * @param mensaje El contenido del mensaje
     * @return true si se envió correctamente
     */
    boolean enviarNotificacion(String destinatario, String mensaje);
    
    /**
     * Retorna el tipo de notificación.
     */
    String obtenerTipoNotificacion();
}
```

**Características de una interfaz:**
- Se declara con `interface` en lugar de `class`
- Los métodos son implícitamente `public abstract`
- No tiene constructor
- No puede tener atributos (solo constantes)

## Paso 2: Implementar NotificacionEmail

```java
public class NotificacionEmail implements Notificable {
    
    private String asunto;
    
    public NotificacionEmail(String asunto) {
        this.asunto = asunto;
    }
    
    @Override
    public boolean enviarNotificacion(String destinatario, String mensaje) {
        System.out.println("\n[EMAIL] Enviando a: " + destinatario);
        System.out.println("Asunto: " + asunto);
        System.out.println("Mensaje: " + mensaje);
        
        // Simulamos el envío
        System.out.println("Estado: ✓ Enviado");
        return true;
    }
    
    @Override
    public String obtenerTipoNotificacion() {
        return "Email";
    }
}
```

**`implements`**: Indica que esta clase cumple el contrato de la interfaz.

**DEBES implementar TODOS los métodos** de la interfaz, o la clase debe ser abstracta.

## Paso 3: Implementar NotificacionSMS

```java
public class NotificacionSMS implements Notificable {
    
    private static final int MAX_CARACTERES = 160;
    
    @Override
    public boolean enviarNotificacion(String destinatario, String mensaje) {
        System.out.println("\n[SMS] Enviando a: " + destinatario);
        
        // Truncar mensaje si es muy largo
        if (mensaje.length() > MAX_CARACTERES) {
            mensaje = mensaje.substring(0, MAX_CARACTERES - 3) + "...";
        }
        
        System.out.println("Mensaje: " + mensaje);
        System.out.println("Estado: ✓ Enviado");
        return true;
    }
    
    @Override
    public String obtenerTipoNotificacion() {
        return "SMS";
    }
}
```

## Paso 4: Implementar NotificacionPush

```java
public class NotificacionPush implements Notificable {
    
    private String titulo;
    
    public NotificacionPush(String titulo) {
        this.titulo = titulo;
    }
    
    @Override
    public boolean enviarNotificacion(String destinatario, String mensaje) {
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
```

## Paso 5: Crear el GestorNotificaciones

```java
import java.util.ArrayList;

public class GestorNotificaciones {
    
    // Lista que puede contener cualquier clase que implemente Notificable
    private ArrayList<Notificable> canales;
    private int notificacionesEnviadas;
    
    public GestorNotificaciones() {
        canales = new ArrayList<>();
        notificacionesEnviadas = 0;
    }
    
    /**
     * Agrega un canal de notificación.
     * Acepta cualquier clase que implemente Notificable.
     */
    public void agregarCanal(Notificable canal) {
        canales.add(canal);
        System.out.println("✓ Canal agregado: " + canal.obtenerTipoNotificacion());
    }
    
    /**
     * Envía una notificación a través de TODOS los canales.
     */
    public void notificarATodos(String destinatario, String mensaje) {
        System.out.println("\nEnviando notificación a todos los canales...");
        
        for (Notificable canal : canales) {
            if (canal.enviarNotificacion(destinatario, mensaje)) {
                notificacionesEnviadas++;
            }
        }
    }
    
    public void mostrarResumen() {
        System.out.println("\n=== RESUMEN ===");
        System.out.println("Notificaciones enviadas: " + notificacionesEnviadas);
        
        StringBuilder tipos = new StringBuilder("Canales utilizados: ");
        for (int i = 0; i < canales.size(); i++) {
            tipos.append(canales.get(i).obtenerTipoNotificacion());
            if (i < canales.size() - 1) {
                tipos.append(", ");
            }
        }
        System.out.println(tipos);
    }
}
```

**Polimorfismo con interfaces:**
- `ArrayList<Notificable>` puede contener cualquier objeto que implemente la interfaz
- Llamamos a `enviarNotificacion()` sin saber el tipo exacto
- Cada implementación ejecuta su propia versión

## Paso 6: Crear la clase principal

```java
public class SistemaNotificaciones {
    
    public static void main(String[] args) {
        System.out.println("=== SISTEMA DE NOTIFICACIONES ===\n");
        
        // Crear el gestor
        GestorNotificaciones gestor = new GestorNotificaciones();
        
        System.out.println("Configurando canales de notificación...");
        
        // Agregar diferentes tipos de notificadores
        // Todos son tratados como Notificable
        gestor.agregarCanal(new NotificacionEmail("Alerta del Sistema"));
        gestor.agregarCanal(new NotificacionSMS());
        gestor.agregarCanal(new NotificacionPush("Alerta del Sistema"));
        
        // Enviar notificación a todos los canales
        gestor.notificarATodos(
            "usuario@email.com", 
            "Su pedido ha sido enviado."
        );
        
        // Mostrar resumen
        gestor.mostrarResumen();
    }
}
```

## Diagrama de la interfaz

```
┌─────────────────────────────────────┐
│        <<interface>>                │
│         Notificable                 │
├─────────────────────────────────────┤
│ + enviarNotificacion(dest, msg)     │
│ + obtenerTipoNotificacion()         │
└───────────────────┬─────────────────┘
                    │ implements
        ┌───────────┼───────────┐
        │           │           │
        ▼           ▼           ▼
┌───────────────┐ ┌─────────┐ ┌───────────────┐
│NotificacionEmail│ │Notific. │ │NotificacionPush│
│               │ │   SMS   │ │               │
├───────────────┤ ├─────────┤ ├───────────────┤
│ - asunto      │ │         │ │ - titulo      │
├───────────────┤ ├─────────┤ ├───────────────┤
│ + enviarNotif.│ │+enviar..│ │+ enviarNotif. │
│ + obtenerTipo │ │+obtener.│ │+ obtenerTipo  │
└───────────────┘ └─────────┘ └───────────────┘
```

## Interfaces múltiples

Una clase puede implementar varias interfaces:

```java
public interface Serializable {
    String serializar();
}

public interface Auditable {
    void registrarLog();
}

// Una clase puede implementar múltiples interfaces
public class NotificacionAvanzada implements Notificable, Serializable, Auditable {
    // Debe implementar TODOS los métodos de TODAS las interfaces
    
    @Override
    public boolean enviarNotificacion(String dest, String msg) { ... }
    
    @Override
    public String obtenerTipoNotificacion() { ... }
    
    @Override
    public String serializar() { ... }
    
    @Override
    public void registrarLog() { ... }
}
```

## Métodos default (Java 8+)

Las interfaces pueden tener métodos con implementación por defecto:

```java
public interface Notificable {
    
    boolean enviarNotificacion(String destinatario, String mensaje);
    
    // Método con implementación por defecto
    default void enviarConReintento(String dest, String msg, int intentos) {
        for (int i = 0; i < intentos; i++) {
            if (enviarNotificacion(dest, msg)) {
                return; // Éxito
            }
            System.out.println("Reintentando... (" + (i + 1) + "/" + intentos + ")");
        }
    }
}
```

Las clases que implementen la interfaz heredan este método, pero pueden sobreescribirlo.

## Errores comunes a evitar

1. **Olvidar implementar todos los métodos**: Si no implementas algún método de la interfaz, tu clase debe ser abstracta.

2. **Confundir `implements` con `extends`**: `implements` es para interfaces, `extends` para clases.

3. **Intentar instanciar una interfaz**: `new Notificable()` no es válido. Debes instanciar una clase que la implemente.

4. **Agregar atributos no constantes**: Las interfaces solo pueden tener `public static final` como atributos.

## Mejoras posibles

- Agregar más canales (WhatsApp, Slack, etc.)
- Implementar cola de mensajes pendientes
- Agregar prioridad a las notificaciones
- Crear interfaz `Configurable` para configurar cada canal
- Implementar patrón Observer para suscripción a eventos

