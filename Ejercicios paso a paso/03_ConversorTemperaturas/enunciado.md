# Ejercicio 3: Conversor de Temperaturas

## Contexto
Trabajas en una estación meteorológica internacional donde reciben datos de temperatura en diferentes unidades (Celsius, Fahrenheit, Kelvin) y necesitan convertirlos para unificar los reportes.

## Enunciado
Crea un programa en Java que convierta temperaturas entre diferentes unidades utilizando **funciones/métodos**. El programa debe:

1. Mostrar un menú con las opciones de conversión:
   - Celsius a Fahrenheit
   - Fahrenheit a Celsius
   - Celsius a Kelvin
   - Kelvin a Celsius
2. Solicitar la temperatura a convertir.
3. Realizar la conversión usando métodos específicos para cada tipo.
4. Mostrar el resultado.
5. Permitir realizar múltiples conversiones hasta que el usuario decida salir.

## Fórmulas de conversión
- Celsius a Fahrenheit: `F = (C × 9/5) + 32`
- Fahrenheit a Celsius: `C = (F - 32) × 5/9`
- Celsius a Kelvin: `K = C + 273.15`
- Kelvin a Celsius: `C = K - 273.15`

## Requisitos técnicos
- Crear métodos separados para cada conversión.
- Uso de bucle `do-while` para repetir el programa.
- Retorno de valores desde métodos.
- Formateo de números decimales.

## Ejemplo de ejecución
```
=== CONVERSOR DE TEMPERATURAS ===

Seleccione el tipo de conversión:
1. Celsius → Fahrenheit
2. Fahrenheit → Celsius
3. Celsius → Kelvin
4. Kelvin → Celsius
5. Salir
Opción: 1

Ingrese la temperatura en Celsius: 25
Resultado: 25.00°C = 77.00°F

¿Desea realizar otra conversión? (s/n): s
...
```

## Conceptos que aprenderás
- Definición y llamada de métodos
- Parámetros y valores de retorno
- Bucle do-while
- Modularización del código

## Recursos y documentación
- [Definición de métodos - Oracle Tutorial](https://docs.oracle.com/javase/tutorial/java/javaOO/methods.html)
- [Retorno de valores - Oracle Tutorial](https://docs.oracle.com/javase/tutorial/java/javaOO/returnvalue.html)
- [Bucles while y do-while - Oracle Tutorial](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/while.html)
- [Paso de parámetros - Oracle Tutorial](https://docs.oracle.com/javase/tutorial/java/javaOO/arguments.html)
