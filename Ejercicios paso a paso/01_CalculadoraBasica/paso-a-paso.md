# Paso a Paso: Calculadora Básica

## Análisis del problema

Antes de escribir código, analicemos qué necesitamos:
1. **Entrada**: Una opción de menú y dos números
2. **Proceso**: Realizar la operación matemática según la opción elegida
3. **Salida**: Mostrar el resultado de la operación

## Paso 1: Crear la estructura básica del programa

Primero, creamos la clase principal con el método `main`:

```java
public class Calculadora {
    public static void main(String[] args) {
        // Aquí irá nuestro código
    }
}
```

**¿Por qué?** Todo programa Java necesita al menos una clase con un método `main` que sirve como punto de entrada.

## Paso 2: Importar Scanner y crear el objeto para leer datos

Para leer datos del usuario, necesitamos la clase `Scanner`:

```java
import java.util.Scanner;

public class Calculadora {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
    }
}
```

**¿Por qué?** `Scanner` es la clase de Java que nos permite leer entrada del usuario desde la consola.

## Paso 3: Mostrar el menú de opciones

Usamos `System.out.println()` para mostrar el menú:

```java
System.out.println("=== CALCULADORA BÁSICA ===");
System.out.println("Seleccione una operación:");
System.out.println("1. Suma");
System.out.println("2. Resta");
System.out.println("3. Multiplicación");
System.out.println("4. División");
System.out.print("Opción: ");
```

**¿Por qué?** Primero mostramos las opciones para que el usuario sepa qué puede hacer.

## Paso 4: Leer la opción del usuario

```java
int opcion = scanner.nextInt();
```

**¿Por qué?** Guardamos la opción como `int` porque esperamos un número entero (1, 2, 3 o 4).

## Paso 5: Solicitar los dos números

```java
System.out.print("Ingrese el primer número: ");
double numero1 = scanner.nextDouble();

System.out.print("Ingrese el segundo número: ");
double numero2 = scanner.nextDouble();
```

**¿Por qué?** Usamos `double` para poder trabajar con números decimales.

## Paso 6: Crear variable para el resultado

```java
double resultado = 0;
```

**¿Por qué?** Necesitamos una variable donde guardar el resultado de la operación.

## Paso 7: Implementar la lógica con switch-case

```java
switch (opcion) {
    case 1:
        resultado = numero1 + numero2;
        System.out.println("Resultado: " + numero1 + " + " + numero2 + " = " + resultado);
        break;
    case 2:
        resultado = numero1 - numero2;
        System.out.println("Resultado: " + numero1 + " - " + numero2 + " = " + resultado);
        break;
    case 3:
        resultado = numero1 * numero2;
        System.out.println("Resultado: " + numero1 + " * " + numero2 + " = " + resultado);
        break;
    case 4:
        if (numero2 != 0) {
            resultado = numero1 / numero2;
            System.out.println("Resultado: " + numero1 + " / " + numero2 + " = " + resultado);
        } else {
            System.out.println("Error: No se puede dividir por cero.");
        }
        break;
    default:
        System.out.println("Opción no válida.");
}
```

**¿Por qué?** 
- `switch` es ideal cuando tenemos múltiples opciones predefinidas.
- Cada `case` representa una opción del menú.
- En la división, verificamos que `numero2` no sea cero para evitar errores.
- `default` maneja cualquier opción que no sea 1, 2, 3 o 4.

## Paso 8: Cerrar el Scanner

```java
scanner.close();
```

**¿Por qué?** Es buena práctica cerrar los recursos que abrimos para liberar memoria.

## Resumen del flujo

```
┌─────────────────────┐
│   Mostrar menú      │
└──────────┬──────────┘
           │
           ▼
┌─────────────────────┐
│   Leer opción       │
└──────────┬──────────┘
           │
           ▼
┌─────────────────────┐
│   Leer números      │
└──────────┬──────────┘
           │
           ▼
┌─────────────────────┐
│   Según opción:     │
│   ejecutar operación│
└──────────┬──────────┘
           │
           ▼
┌─────────────────────┐
│   Mostrar resultado │
└─────────────────────┘
```

## Errores comunes a evitar

1. **Olvidar el `break`** en cada case del switch (causa que se ejecuten múltiples casos).
2. **No validar la división por cero** (causa una excepción en tiempo de ejecución).
3. **Usar `int` en vez de `double`** (perdemos precisión en decimales).
4. **No importar Scanner** (error de compilación).

## Mejoras posibles

Una vez domines este ejercicio, podrías mejorarlo:
- Agregar más operaciones (potencia, raíz cuadrada, módulo)
- Permitir realizar múltiples operaciones en bucle
- Validar que la entrada sea un número válido

