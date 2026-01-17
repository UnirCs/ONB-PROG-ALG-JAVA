# Ejercicio 6: Lista de Tareas (To-Do List)

## Contexto
Necesitas una aplicación para organizar tus tareas diarias. Quieres poder agregar, eliminar, marcar como completadas y ver todas tus tareas pendientes.

## Enunciado
Crea un programa en Java que gestione una lista de tareas utilizando **ArrayList**. El programa debe:

1. Crear una clase `Tarea` con:
   - Atributos: descripcion, completada (boolean)
   - Métodos: marcarCompletada(), toString()

2. Crear una clase gestora que permita:
   - Agregar nuevas tareas
   - Eliminar tareas por índice
   - Marcar tareas como completadas
   - Mostrar todas las tareas
   - Mostrar solo las tareas pendientes
   - Contar tareas pendientes y completadas

## Requisitos técnicos
- Uso de `ArrayList<Tarea>` para almacenar las tareas.
- Recorrido de listas con bucle for-each.
- Métodos de ArrayList: `add()`, `remove()`, `get()`, `size()`.
- Clase con atributos y métodos.

## Ejemplo de ejecución
```
=== LISTA DE TAREAS ===

--- MENÚ ---
1. Agregar tarea
2. Eliminar tarea
3. Marcar tarea como completada
4. Ver todas las tareas
5. Ver tareas pendientes
6. Ver resumen
7. Salir
Opción: 1

Ingrese la descripción de la tarea: Comprar leche
Tarea agregada con éxito.

Opción: 1
Ingrese la descripción de la tarea: Estudiar Java
Tarea agregada con éxito.

Opción: 4

=== TODAS LAS TAREAS ===
1. [ ] Comprar leche
2. [ ] Estudiar Java

Opción: 3
Ingrese el número de tarea a completar: 1
¡Tarea completada!

Opción: 4

=== TODAS LAS TAREAS ===
1. [✓] Comprar leche
2. [ ] Estudiar Java
```

## Conceptos que aprenderás
- ArrayList y colecciones dinámicas
- Diferencia entre arrays y ArrayList
- Métodos de ArrayList
- Bucle for-each
- Sobreescritura del método toString()

## Recursos y documentación
- [ArrayList - Java Documentation](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/ArrayList.html)
- [Collections Framework - Oracle Tutorial](https://docs.oracle.com/javase/tutorial/collections/index.html)
- [List Interface - Oracle Tutorial](https://docs.oracle.com/javase/tutorial/collections/interfaces/list.html)
- [Bucle for-each - Oracle Tutorial](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/for.html)
- [Método toString - Oracle Tutorial](https://docs.oracle.com/javase/tutorial/java/IandI/objectclass.html)
