# Ejercicio 9: Directorio Telefónico con HashMap

## Contexto
Necesitas crear una agenda telefónica digital que permita almacenar contactos y buscarlos rápidamente por nombre. Los mapas (HashMap) son perfectos para esta tarea porque permiten acceso directo a los valores mediante una clave.

## Enunciado
Crea una aplicación de directorio telefónico utilizando **HashMap**. La aplicación debe:

1. Crear una clase `Contacto` con: nombre, telefono, email
2. Usar un `HashMap<String, Contacto>` donde la clave es el nombre
3. Implementar las siguientes operaciones:
   - Agregar contacto
   - Buscar contacto por nombre
   - Eliminar contacto
   - Modificar teléfono de un contacto
   - Listar todos los contactos
   - Buscar contactos que contengan un texto en su nombre

## Requisitos técnicos
- Uso de `HashMap<K, V>` para almacenamiento clave-valor
- Métodos de HashMap: `put()`, `get()`, `remove()`, `containsKey()`
- Iteración sobre HashMap con `keySet()` o `entrySet()`
- Búsqueda parcial de contactos

## Ejemplo de ejecución
```
=== DIRECTORIO TELEFÓNICO ===

--- MENÚ ---
1. Agregar contacto
2. Buscar contacto
3. Eliminar contacto
4. Modificar teléfono
5. Listar todos
6. Buscar por texto
7. Salir
Opción: 1

Nombre: María García
Teléfono: 612345678
Email: maria@email.com
✓ Contacto agregado correctamente.

Opción: 2
Nombre a buscar: María García

=== CONTACTO ENCONTRADO ===
Nombre: María García
Teléfono: 612345678
Email: maria@email.com

Opción: 6
Texto a buscar: García

=== RESULTADOS ===
- María García (612345678)
- Pedro García (698765432)
```

## Conceptos que aprenderás
- HashMap y estructura clave-valor
- Diferencia entre ArrayList y HashMap
- Métodos principales de HashMap
- Iteración sobre mapas
- Búsqueda eficiente por clave

## Recursos y documentación
- [HashMap - Java Documentation](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/HashMap.html)
- [Map Interface - Oracle Tutorial](https://docs.oracle.com/javase/tutorial/collections/interfaces/map.html)
- [Implementaciones de Map - Oracle Tutorial](https://docs.oracle.com/javase/tutorial/collections/implementations/map.html)
- [Collections Framework - Oracle Tutorial](https://docs.oracle.com/javase/tutorial/collections/index.html)
