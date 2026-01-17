# Paso a Paso: Registro de Calificaciones

## Análisis del problema

Este ejercicio nos introduce a los **arrays**, una estructura que permite almacenar múltiples valores del mismo tipo. Es perfecto para situaciones donde tenemos colecciones de datos relacionados.

**Tareas a realizar:**
1. Crear un array para almacenar las calificaciones
2. Encontrar el valor máximo
3. Encontrar el valor mínimo
4. Calcular el promedio
5. Contar aprobados y reprobados
6. Ordenar las calificaciones

## Paso 1: Crear el array de calificaciones

```java
import java.util.Scanner;

public class RegistroCalificaciones {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== REGISTRO DE CALIFICACIONES ===\n");
        
        // Solicitar cantidad de estudiantes
        System.out.print("¿Cuántos estudiantes tiene la clase? ");
        int cantidad = scanner.nextInt();
        
        // Crear el array con el tamaño indicado
        double[] calificaciones = new double[cantidad];
    }
}
```

**¿Qué es un array?**
- Es una colección de elementos del mismo tipo
- Se declara con `tipo[] nombre`
- Se inicializa con `new tipo[tamaño]`
- El tamaño es fijo una vez creado

## Paso 2: Llenar el array con las calificaciones

```java
System.out.println();
for (int i = 0; i < calificaciones.length; i++) {
    System.out.print("Ingrese la calificación del estudiante " + (i + 1) + ": ");
    calificaciones[i] = scanner.nextDouble();
}
```

**Detalles importantes:**
- `calificaciones.length` nos da el tamaño del array
- Los índices van de `0` a `length - 1`
- `i + 1` para mostrar al usuario números desde 1 (más amigable)

## Paso 3: Crear método para encontrar el máximo

```java
public static double encontrarMaximo(double[] notas) {
    double maximo = notas[0]; // Asumimos que el primero es el mayor
    
    for (int i = 1; i < notas.length; i++) {
        if (notas[i] > maximo) {
            maximo = notas[i];
        }
    }
    
    return maximo;
}
```

**Algoritmo:**
1. Tomamos el primer elemento como máximo inicial
2. Recorremos el resto del array
3. Si encontramos uno mayor, actualizamos el máximo

## Paso 4: Crear método para encontrar el mínimo

```java
public static double encontrarMinimo(double[] notas) {
    double minimo = notas[0];
    
    for (int i = 1; i < notas.length; i++) {
        if (notas[i] < minimo) {
            minimo = notas[i];
        }
    }
    
    return minimo;
}
```

**Nota:** Es igual que el máximo pero con `<` en vez de `>`.

## Paso 5: Crear método para calcular el promedio

```java
public static double calcularPromedio(double[] notas) {
    double suma = 0;
    
    for (int i = 0; i < notas.length; i++) {
        suma += notas[i]; // suma = suma + notas[i]
    }
    
    return suma / notas.length;
}
```

**Fórmula:** Promedio = Suma de todos los elementos / Cantidad de elementos

## Paso 6: Crear método para contar aprobados

```java
public static int contarAprobados(double[] notas) {
    int contador = 0;
    
    for (int i = 0; i < notas.length; i++) {
        if (notas[i] >= 6) {
            contador++;
        }
    }
    
    return contador;
}
```

**Nota:** Los reprobados serán `total - aprobados`.

## Paso 7: Crear método de ordenamiento burbuja

El ordenamiento burbuja es un algoritmo simple que compara elementos adyacentes y los intercambia si están en el orden incorrecto.

```java
public static void ordenarBurbuja(double[] notas) {
    int n = notas.length;
    
    for (int i = 0; i < n - 1; i++) {
        for (int j = 0; j < n - i - 1; j++) {
            // Si el elemento actual es mayor que el siguiente, intercambiar
            if (notas[j] > notas[j + 1]) {
                double temp = notas[j];
                notas[j] = notas[j + 1];
                notas[j + 1] = temp;
            }
        }
    }
}
```

**Visualización del algoritmo:**
```
Array inicial: [8.5, 6.0, 4.5, 9.0, 7.5]

Primera pasada:
[8.5, 6.0, 4.5, 9.0, 7.5] → compara 8.5 y 6.0 → intercambia
[6.0, 8.5, 4.5, 9.0, 7.5] → compara 8.5 y 4.5 → intercambia
[6.0, 4.5, 8.5, 9.0, 7.5] → compara 8.5 y 9.0 → no intercambia
[6.0, 4.5, 8.5, 9.0, 7.5] → compara 9.0 y 7.5 → intercambia
[6.0, 4.5, 8.5, 7.5, 9.0] → El mayor (9.0) ya está al final

... continúa hasta que todo esté ordenado
```

## Paso 8: Crear método para mostrar el array

```java
public static String arrayToString(double[] notas) {
    StringBuilder sb = new StringBuilder("[");
    
    for (int i = 0; i < notas.length; i++) {
        sb.append(notas[i]);
        if (i < notas.length - 1) {
            sb.append(", ");
        }
    }
    
    sb.append("]");
    return sb.toString();
}
```

**¿Por qué StringBuilder?** Es más eficiente que concatenar Strings con `+` en un bucle.

## Paso 9: Juntar todo en el main

```java
// Mostrar resultados
System.out.println("\n=== RESULTADOS ===");
System.out.println("Calificaciones: " + arrayToString(calificaciones));
System.out.println("Calificación más alta: " + encontrarMaximo(calificaciones));
System.out.println("Calificación más baja: " + encontrarMinimo(calificaciones));
System.out.printf("Promedio de la clase: %.1f%n", calcularPromedio(calificaciones));

int aprobados = contarAprobados(calificaciones);
System.out.println("Aprobados: " + aprobados);
System.out.println("Reprobados: " + (calificaciones.length - aprobados));

// Ordenar y mostrar
ordenarBurbuja(calificaciones);
System.out.println("\nCalificaciones ordenadas: " + arrayToString(calificaciones));
```

## Resumen del flujo

```
┌─────────────────────┐
│ Crear array vacío   │
└──────────┬──────────┘
           │
           ▼
┌─────────────────────┐
│ Llenar array con    │
│ calificaciones      │
└──────────┬──────────┘
           │
           ▼
┌─────────────────────┐
│ Calcular máximo     │
│ mínimo, promedio    │
│ aprobados/reprobados│
└──────────┬──────────┘
           │
           ▼
┌─────────────────────┐
│ Ordenar array       │
└──────────┬──────────┘
           │
           ▼
┌─────────────────────┐
│ Mostrar resultados  │
└─────────────────────┘
```

## Arrays en Java - Conceptos clave

```java
// Declaración
double[] notas;           // Solo declara la referencia
double notas[];           // Sintaxis alternativa (menos común)

// Inicialización con tamaño
notas = new double[5];    // Array de 5 elementos, todos inicializados a 0.0

// Declaración e inicialización juntas
double[] notas = new double[5];

// Inicialización con valores
double[] notas = {8.5, 6.0, 4.5, 9.0, 7.5};

// Acceso a elementos
notas[0]                  // Primer elemento
notas[notas.length - 1]   // Último elemento

// Tamaño del array
notas.length              // ¡Sin paréntesis!
```

## Errores comunes a evitar

1. **ArrayIndexOutOfBoundsException**: Acceder a un índice que no existe (ej: `notas[5]` cuando el array tiene 5 elementos, el último es `notas[4]`).

2. **Confundir `length` con `length()`**: Arrays usan `length` (sin paréntesis), Strings usan `length()` (con paréntesis).

3. **Empezar el bucle en 1**: Los arrays en Java empiezan en índice 0.

4. **Modificar el tamaño**: Los arrays tienen tamaño fijo, no se pueden agrandar.

## Mejoras posibles

- Validar que las calificaciones estén entre 0 y 10
- Mostrar qué estudiantes aprobaron/reprobaron
- Calcular la moda (calificación más frecuente)
- Usar `Arrays.sort()` en lugar del ordenamiento manual

