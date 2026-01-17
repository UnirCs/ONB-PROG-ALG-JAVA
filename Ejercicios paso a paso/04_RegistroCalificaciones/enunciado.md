# Ejercicio 4: Registro de Calificaciones

## Contexto
Eres profesor de un curso y necesitas un programa para registrar las calificaciones de tus estudiantes, calcular el promedio de la clase y determinar cuántos aprobaron o reprobaron.

## Enunciado
Crea un programa en Java que gestione las calificaciones de un grupo de estudiantes utilizando **arrays**. El programa debe:

1. Solicitar la cantidad de estudiantes.
2. Leer las calificaciones de cada estudiante (0-10).
3. Calcular y mostrar:
   - La calificación más alta
   - La calificación más baja
   - El promedio de la clase
   - Cantidad de aprobados (calificación >= 6)
   - Cantidad de reprobados (calificación < 6)
4. Mostrar las calificaciones ordenadas de menor a mayor.

## Requisitos técnicos
- Uso de arrays para almacenar las calificaciones.
- Bucles `for` para recorrer el array.
- Métodos auxiliares para cada cálculo.
- Algoritmo de ordenamiento básico (burbuja).

## Ejemplo de ejecución
```
=== REGISTRO DE CALIFICACIONES ===

¿Cuántos estudiantes tiene la clase? 5

Ingrese la calificación del estudiante 1: 8.5
Ingrese la calificación del estudiante 2: 6.0
Ingrese la calificación del estudiante 3: 4.5
Ingrese la calificación del estudiante 4: 9.0
Ingrese la calificación del estudiante 5: 7.5

=== RESULTADOS ===
Calificaciones: [8.5, 6.0, 4.5, 9.0, 7.5]
Calificación más alta: 9.0
Calificación más baja: 4.5
Promedio de la clase: 7.1
Aprobados: 4
Reprobados: 1

Calificaciones ordenadas: [4.5, 6.0, 7.5, 8.5, 9.0]
```

## Conceptos que aprenderás
- Declaración y uso de arrays
- Recorrido de arrays con bucles
- Algoritmos básicos: búsqueda del máximo/mínimo
- Algoritmo de ordenamiento burbuja
- Paso de arrays a métodos

## Recursos y documentación
- [Arrays - Oracle Tutorial](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/arrays.html)
- [Arrays - Java Documentation](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/Arrays.html)
- [Paso de arrays a métodos - Oracle Tutorial](https://docs.oracle.com/javase/tutorial/java/javaOO/arguments.html)
- [Algoritmos de ordenamiento (Wikipedia)](https://es.wikipedia.org/wiki/Algoritmo_de_ordenamiento)
