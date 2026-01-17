# Paso a Paso: Validador de Contraseñas

## Análisis del problema

Necesitamos verificar 4 condiciones en una contraseña:
1. Longitud mínima de 8 caracteres
2. Al menos una mayúscula
3. Al menos una minúscula  
4. Al menos un dígito

**Estrategia**: Recorrer la contraseña carácter por carácter y usar banderas (boolean) para marcar si encontramos cada tipo de carácter.

## Paso 1: Estructura básica y lectura de datos

```java
import java.util.Scanner;

public class ValidadorContrasenas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== VALIDADOR DE CONTRASEÑAS ===");
        System.out.print("Ingrese una contraseña para validar: ");
        String contrasena = scanner.nextLine();
        
        scanner.close();
    }
}
```

**¿Por qué `nextLine()` y no `next()`?** Porque `nextLine()` lee toda la línea incluyendo espacios, mientras que `next()` solo lee hasta el primer espacio.

## Paso 2: Verificar la longitud

La longitud es fácil de verificar con el método `length()`:

```java
boolean longitudValida = contrasena.length() >= 8;
```

**¿Por qué?** `length()` retorna el número de caracteres del String.

## Paso 3: Inicializar las banderas para los demás requisitos

```java
boolean tieneMayuscula = false;
boolean tieneMinuscula = false;
boolean tieneDigito = false;
```

**¿Por qué empezamos en `false`?** Asumimos que no cumple hasta que encontremos evidencia de lo contrario.

## Paso 4: Recorrer la contraseña carácter por carácter

```java
for (int i = 0; i < contrasena.length(); i++) {
    char c = contrasena.charAt(i);
    
    if (Character.isUpperCase(c)) {
        tieneMayuscula = true;
    }
    if (Character.isLowerCase(c)) {
        tieneMinuscula = true;
    }
    if (Character.isDigit(c)) {
        tieneDigito = true;
    }
}
```

**¿Por qué usamos `if` separados y no `if-else`?** Porque un carácter solo puede ser una cosa (mayúscula, minúscula o dígito), pero queremos verificar todas las posibilidades para cada carácter.

**Métodos útiles de Character**:
- `Character.isUpperCase(c)` → ¿Es mayúscula?
- `Character.isLowerCase(c)` → ¿Es minúscula?
- `Character.isDigit(c)` → ¿Es un dígito (0-9)?
- `Character.isLetter(c)` → ¿Es una letra?

## Paso 5: Determinar si la contraseña es válida

```java
boolean esValida = longitudValida && tieneMayuscula && tieneMinuscula && tieneDigito;
```

**¿Por qué usamos `&&`?** Porque TODOS los requisitos deben cumplirse. Si usáramos `||`, bastaría con cumplir uno.

## Paso 6: Mostrar el resultado detallado

```java
if (esValida) {
    System.out.println("\n✓ La contraseña es válida y cumple todos los requisitos.");
} else {
    System.out.println("\n✗ La contraseña NO es válida. Problemas encontrados:");
    
    if (!longitudValida) {
        System.out.println("  - Debe tener al menos 8 caracteres (tiene " + contrasena.length() + ")");
    }
    if (!tieneMayuscula) {
        System.out.println("  - Debe contener al menos una letra mayúscula");
    }
    if (!tieneMinuscula) {
        System.out.println("  - Debe contener al menos una letra minúscula");
    }
    if (!tieneDigito) {
        System.out.println("  - Debe contener al menos un dígito numérico");
    }
}
```

**¿Por qué mostramos cada problema por separado?** Para dar retroalimentación útil al usuario sobre qué debe corregir.

## Resumen del flujo

```
┌─────────────────────────┐
│   Leer contraseña       │
└───────────┬─────────────┘
            │
            ▼
┌─────────────────────────┐
│   Verificar longitud    │
└───────────┬─────────────┘
            │
            ▼
┌─────────────────────────┐
│   Recorrer caracteres   │──┐
│   y actualizar banderas │  │ for each char
└───────────┬─────────────┘◄─┘
            │
            ▼
┌─────────────────────────┐
│   ¿Todas las banderas   │
│   son true?             │
└───────────┬─────────────┘
        ┌───┴───┐
        │       │
       SÍ      NO
        │       │
        ▼       ▼
    Válida   Mostrar
            problemas
```

## Errores comunes a evitar

1. **Confundir `length()` con `length`**: Los Strings usan `length()` (con paréntesis), los arrays usan `length` (sin paréntesis).

2. **Usar `==` para comparar Strings**: Aunque aquí no lo hacemos, recuerda usar `.equals()` para comparar contenido de Strings.

3. **Olvidar que los índices empiezan en 0**: `charAt(0)` es el primer carácter.

4. **No considerar todos los casos**: Asegúrate de verificar cada requisito.

## Mejoras posibles

- Agregar validación de caracteres especiales (@, #, $, etc.)
- Crear un método separado para cada validación
- Implementar un sistema de "fortaleza" de contraseña (débil, media, fuerte)
- Permitir validar múltiples contraseñas en un bucle

