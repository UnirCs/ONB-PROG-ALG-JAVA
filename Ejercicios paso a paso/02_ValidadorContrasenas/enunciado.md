# Ejercicio 2: Validador de Contraseñas

## Contexto
Trabajas en el departamento de seguridad de una empresa y te han pedido crear un sistema que valide si las contraseñas de los usuarios cumplen con los requisitos de seguridad establecidos.

## Enunciado
Crea un programa en Java que valide si una contraseña cumple con los siguientes criterios de seguridad:

1. Debe tener al menos 8 caracteres.
2. Debe contener al menos una letra mayúscula.
3. Debe contener al menos una letra minúscula.
4. Debe contener al menos un dígito numérico.

El programa debe informar al usuario si la contraseña es válida o, en caso contrario, indicar qué requisitos no cumple.

## Requisitos técnicos
- Uso de `String` y sus métodos (`length()`, `charAt()`).
- Bucles `for` para recorrer caracteres.
- Métodos de `Character` (`isUpperCase()`, `isLowerCase()`, `isDigit()`).
- Estructuras condicionales `if-else`.

## Ejemplo de ejecución
```
=== VALIDADOR DE CONTRASEÑAS ===
Ingrese una contraseña para validar: MiClave1

✓ La contraseña es válida y cumple todos los requisitos.
```

```
=== VALIDADOR DE CONTRASEÑAS ===
Ingrese una contraseña para validar: abc123

✗ La contraseña NO es válida. Problemas encontrados:
  - Debe tener al menos 8 caracteres (tiene 6)
  - Debe contener al menos una letra mayúscula
```

## Conceptos que aprenderás
- Manipulación de cadenas de texto (String)
- Recorrido de caracteres con bucles
- Uso de la clase Character
- Validaciones múltiples con contadores/banderas

## Recursos y documentación
- [String - Java Documentation](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/String.html)
- [Character - Java Documentation](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/Character.html)
- [Bucle for - Oracle Tutorial](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/for.html)
- [Strings - Oracle Tutorial](https://docs.oracle.com/javase/tutorial/java/data/strings.html)
