# Ejercicio 8: Sistema de Notificaciones con Interfaces

## Contexto
Una aplicación necesita enviar notificaciones a los usuarios por diferentes canales: email, SMS y notificaciones push. Cada canal tiene su propia forma de enviar mensajes, pero todos comparten la capacidad de "notificar".

## Enunciado
Crea un sistema de notificaciones utilizando **interfaces**. Debes implementar:

1. Una interfaz `Notificable` con:
   - Método: `enviarNotificacion(String destinatario, String mensaje)`
   - Método: `obtenerTipoNotificacion()`

2. Clases que implementen la interfaz:
   - `NotificacionEmail`: Envía por correo electrónico
   - `NotificacionSMS`: Envía por mensaje de texto
   - `NotificacionPush`: Envía notificación push

3. Una clase `GestorNotificaciones` que:
   - Almacene diferentes tipos de notificadores
   - Permita enviar un mensaje a través de todos los canales
   - Muestre un log de notificaciones enviadas

## Requisitos técnicos
- Definición de interfaz con `interface`
- Implementación con `implements`
- Uso de interfaz como tipo de variable/parámetro
- ArrayList de interfaz para polimorfismo

## Ejemplo de ejecución
```
=== SISTEMA DE NOTIFICACIONES ===

Configurando canales de notificación...
✓ Canal agregado: Email
✓ Canal agregado: SMS
✓ Canal agregado: Push

Enviando notificación a todos los canales...

[EMAIL] Enviando a: usuario@email.com
Asunto: Alerta del Sistema
Mensaje: Su pedido ha sido enviado.
Estado: ✓ Enviado

[SMS] Enviando a: +34612345678
Mensaje: Su pedido ha sido enviado.
Estado: ✓ Enviado

[PUSH] Enviando notificación push a dispositivo: device_token_123
Título: Alerta del Sistema
Mensaje: Su pedido ha sido enviado.
Estado: ✓ Enviado

=== RESUMEN ===
Notificaciones enviadas: 3
Canales utilizados: Email, SMS, Push
```

## Conceptos que aprenderás
- Interfaces y la palabra clave `interface`
- Implementación con `implements`
- Diferencia entre interfaz, clase abstracta y clase concreta
- Polimorfismo con interfaces
- Diseño orientado a contratos

## Recursos y documentación
- [Interfaces - Oracle Tutorial](https://docs.oracle.com/javase/tutorial/java/IandI/createinterface.html)
- [Implementación de interfaces - Oracle Tutorial](https://docs.oracle.com/javase/tutorial/java/IandI/usinginterface.html)
- [Herencia vs Interfaces - Oracle Tutorial](https://docs.oracle.com/javase/tutorial/java/IandI/abstract.html)
- [Métodos default en interfaces - Oracle Tutorial](https://docs.oracle.com/javase/tutorial/java/IandI/defaultmethods.html)
- [Polimorfismo - Oracle Tutorial](https://docs.oracle.com/javase/tutorial/java/IandI/polymorphism.html)
