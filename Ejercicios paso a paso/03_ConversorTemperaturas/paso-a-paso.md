# Paso a Paso: Conversor de Temperaturas

## Análisis del problema

Este ejercicio nos introduce a un concepto fundamental: **los métodos**. En lugar de escribir todo el código en el `main`, vamos a crear funciones separadas para cada conversión.

**Ventajas de usar métodos:**
- Código más organizado y legible
- Reutilización (podemos llamar el mismo método varias veces)
- Más fácil de mantener y depurar

## Paso 1: Diseñar los métodos de conversión

Antes de programar, pensemos qué métodos necesitamos:

| Método | Entrada | Salida |
|--------|---------|--------|
| `celsiusAFahrenheit` | double celsius | double fahrenheit |
| `fahrenheitACelsius` | double fahrenheit | double celsius |
| `celsiusAKelvin` | double celsius | double kelvin |
| `kelvinACelsius` | double kelvin | double celsius |

## Paso 2: Crear la estructura básica con los métodos

```java
import java.util.Scanner;

public class ConversorTemperaturas {
    
    // Método para convertir de Celsius a Fahrenheit
    public static double celsiusAFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }
    
    // Método para convertir de Fahrenheit a Celsius
    public static double fahrenheitACelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }
    
    // Método para convertir de Celsius a Kelvin
    public static double celsiusAKelvin(double celsius) {
        return celsius + 273.15;
    }
    
    // Método para convertir de Kelvin a Celsius
    public static double kelvinACelsius(double kelvin) {
        return kelvin - 273.15;
    }
    
    public static void main(String[] args) {
        // Aquí irá el código principal
    }
}
```

**¿Por qué `public static`?** 
- `public`: El método es accesible desde cualquier lugar.
- `static`: Pertenece a la clase, no necesitamos crear un objeto para usarlo.
- Esto nos permite llamar a los métodos directamente desde `main` (que también es static).

## Paso 3: Implementar el menú en el método main

```java
public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String continuar;
    
    System.out.println("=== CONVERSOR DE TEMPERATURAS ===");
    
    do {
        // Mostrar menú
        System.out.println("\nSeleccione el tipo de conversión:");
        System.out.println("1. Celsius → Fahrenheit");
        System.out.println("2. Fahrenheit → Celsius");
        System.out.println("3. Celsius → Kelvin");
        System.out.println("4. Kelvin → Celsius");
        System.out.println("5. Salir");
        System.out.print("Opción: ");
        
        int opcion = scanner.nextInt();
        
        // ... resto del código
        
    } while (!continuar.equalsIgnoreCase("n"));
}
```

**¿Por qué `do-while` y no `while`?** Porque queremos que el menú se muestre al menos una vez antes de preguntar si continuar.

## Paso 4: Implementar la lógica según la opción elegida

```java
if (opcion == 5) {
    System.out.println("¡Hasta luego!");
    break; // Salir del bucle
}

double temperatura, resultado;

switch (opcion) {
    case 1:
        System.out.print("\nIngrese la temperatura en Celsius: ");
        temperatura = scanner.nextDouble();
        resultado = celsiusAFahrenheit(temperatura);
        System.out.printf("Resultado: %.2f°C = %.2f°F%n", temperatura, resultado);
        break;
        
    case 2:
        System.out.print("\nIngrese la temperatura en Fahrenheit: ");
        temperatura = scanner.nextDouble();
        resultado = fahrenheitACelsius(temperatura);
        System.out.printf("Resultado: %.2f°F = %.2f°C%n", temperatura, resultado);
        break;
        
    // ... casos 3 y 4 similares
        
    default:
        System.out.println("Opción no válida.");
}
```

**¿Qué es `printf`?** Es un método para formatear la salida:
- `%.2f` → número decimal con 2 decimales
- `%n` → salto de línea (equivalente a `\n` pero más portable)

## Paso 5: Preguntar si desea continuar

```java
scanner.nextLine(); // Limpiar el buffer
System.out.print("\n¿Desea realizar otra conversión? (s/n): ");
continuar = scanner.nextLine();
```

**¿Por qué `scanner.nextLine()` adicional?** Después de `nextDouble()`, queda un salto de línea en el buffer que debemos consumir antes de leer el siguiente String.

## Resumen del flujo

```
┌─────────────────────┐
│   Mostrar menú      │◄──────────┐
└──────────┬──────────┘           │
           │                      │
           ▼                      │
┌─────────────────────┐           │
│   Leer opción       │           │
└──────────┬──────────┘           │
           │                      │
           ▼                      │
      ┌────┴────┐                 │
      │ ¿Es 5?  │                 │
      └────┬────┘                 │
       SÍ  │  NO                  │
       │   │                      │
       │   ▼                      │
       │  ┌─────────────────┐     │
       │  │ Leer temperatura│     │
       │  └────────┬────────┘     │
       │           │              │
       │           ▼              │
       │  ┌─────────────────┐     │
       │  │ Llamar método   │     │
       │  │ de conversión   │     │
       │  └────────┬────────┘     │
       │           │              │
       │           ▼              │
       │  ┌─────────────────┐     │
       │  │ Mostrar result. │     │
       │  └────────┬────────┘     │
       │           │              │
       │           ▼              │
       │  ┌─────────────────┐     │
       │  │ ¿Continuar?     │     │
       │  └────────┬────────┘     │
       │       SÍ  │  NO          │
       │       │   │              │
       │       │   ▼              │
       │       │  FIN             │
       │       └──────────────────┘
       │
       ▼
      FIN
```

## Anatomía de un método

```java
public static double celsiusAFahrenheit(double celsius) {
//│       │     │           │              │
//│       │     │           │              └─ Parámetro de entrada
//│       │     │           └─ Nombre del método
//│       │     └─ Tipo de retorno (lo que devuelve)
//│       └─ Pertenece a la clase, no a instancias
//└─ Accesible desde cualquier lugar
    
    return (celsius * 9 / 5) + 32;
//  └─ Devuelve el resultado al lugar donde se llamó
}
```

## Errores comunes a evitar

1. **Olvidar `static` en los métodos**: Si main es static, solo puede llamar a métodos static directamente.

2. **No consumir el salto de línea**: Después de `nextInt()` o `nextDouble()`, hay que limpiar el buffer antes de `nextLine()`.

3. **División entera**: `9/5` en Java da `1`, no `1.8`. Usa `9.0/5` o `9/5.0` para obtener decimales.

4. **Olvidar el `return`**: Un método con tipo de retorno diferente de `void` debe retornar un valor.

## Mejoras posibles

- Agregar más unidades (Rankine)
- Validar que Kelvin no sea negativo (no existe temperatura menor a 0K)
- Crear un método para mostrar el menú
- Almacenar un historial de conversiones

