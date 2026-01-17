# Ejercicio 10: Sistema de Gestión de Biblioteca (Integrador)

## Contexto
Una biblioteca necesita un sistema completo para gestionar sus libros, usuarios y préstamos. Este ejercicio integra todos los conceptos aprendidos en los ejercicios anteriores.

## Enunciado
Crea un sistema de gestión de biblioteca que integre:

### Clases y POO
1. **Clase `Libro`**: isbn, titulo, autor, disponible
2. **Clase abstracta `Usuario`** con subclases:
   - `Estudiante`: máximo 3 libros, préstamo 14 días
   - `Profesor`: máximo 5 libros, préstamo 30 días
3. **Clase `Prestamo`**: libro, usuario, fechaPrestamo, fechaDevolucion

### Interfaz
4. **Interfaz `Prestable`**: metodos `prestar()`, `devolver()`, `estaDisponible()`

### Colecciones
5. Usar `ArrayList<Libro>` para el catálogo
6. Usar `HashMap<String, Usuario>` para usuarios (clave: ID)
7. Usar `ArrayList<Prestamo>` para historial de préstamos

### Funcionalidades
- Agregar/buscar libros
- Registrar usuarios
- Realizar préstamos (validando disponibilidad y límites)
- Devolver libros
- Ver libros disponibles
- Ver préstamos activos de un usuario
- Mostrar estadísticas

## Requisitos técnicos
- Clases y objetos
- Herencia y clases abstractas
- Interfaces
- ArrayList y HashMap
- Validaciones de negocio
- Métodos estáticos para utilidades

## Ejemplo de ejecución
```
=== SISTEMA DE GESTIÓN DE BIBLIOTECA ===

--- MENÚ PRINCIPAL ---
1. Gestión de Libros
2. Gestión de Usuarios
3. Préstamos
4. Estadísticas
5. Salir
Opción: 3

--- PRÉSTAMOS ---
1. Realizar préstamo
2. Devolver libro
3. Ver préstamos de usuario
4. Volver
Opción: 1

ID Usuario: EST001
ISBN del libro: 978-84-376-0494-7

✓ Préstamo realizado con éxito.
  Libro: Don Quijote de la Mancha
  Usuario: Juan Pérez (Estudiante)
  Fecha devolución: 31/01/2026
  Libros restantes permitidos: 2
```

## Conceptos que repasarás
- ✅ Variables y tipos de datos
- ✅ Estructuras de control (if, switch, for, while)
- ✅ Arrays y ArrayList
- ✅ HashMap
- ✅ Clases y objetos
- ✅ Encapsulamiento
- ✅ Herencia y clases abstractas
- ✅ Interfaces
- ✅ Polimorfismo
- ✅ Métodos y funciones

## Recursos y documentación
- [Java SE 17 Documentation](https://docs.oracle.com/en/java/javase/17/docs/api/index.html)
- [The Java Tutorials - Oracle](https://docs.oracle.com/javase/tutorial/)
- [ArrayList - Java Documentation](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/ArrayList.html)
- [HashMap - Java Documentation](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/HashMap.html)
- [LocalDate - Java Documentation](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/time/LocalDate.html)
- [Herencia - Oracle Tutorial](https://docs.oracle.com/javase/tutorial/java/IandI/subclasses.html)
- [Interfaces - Oracle Tutorial](https://docs.oracle.com/javase/tutorial/java/IandI/createinterface.html)
- [Collections Framework - Oracle Tutorial](https://docs.oracle.com/javase/tutorial/collections/index.html)
