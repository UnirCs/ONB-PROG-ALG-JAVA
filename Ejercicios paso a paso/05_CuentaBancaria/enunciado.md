# Ejercicio 5: Sistema de Cuenta Bancaria

## Contexto
Un banco te contrata para crear un sistema básico de gestión de cuentas bancarias. Cada cuenta tiene un titular, un número de cuenta y un saldo, y permite realizar operaciones básicas.

## Enunciado
Crea un programa en Java que simule una cuenta bancaria utilizando **Programación Orientada a Objetos (POO)**. Debes:

1. Crear una clase `CuentaBancaria` con:
   - Atributos: titular, numeroCuenta, saldo
   - Constructor para inicializar la cuenta
   - Métodos: depositar, retirar, consultarSaldo

2. Crear una clase principal que:
   - Cree una cuenta bancaria
   - Muestre un menú con las operaciones disponibles
   - Permita realizar múltiples operaciones
   - Valide que no se pueda retirar más dinero del disponible

## Requisitos técnicos
- Definición de una clase con atributos privados.
- Uso de constructor.
- Métodos getters para acceder a los atributos.
- Encapsulamiento (atributos private, métodos public).

## Ejemplo de ejecución
```
=== SISTEMA BANCARIO ===
Creando cuenta para: Juan García
Número de cuenta: 001234

--- MENÚ ---
1. Depositar
2. Retirar
3. Consultar saldo
4. Ver información de la cuenta
5. Salir
Opción: 1

Ingrese cantidad a depositar: 1000
Depósito realizado con éxito.
Nuevo saldo: $1000.00

--- MENÚ ---
Opción: 2

Ingrese cantidad a retirar: 1500
Error: Fondos insuficientes. Saldo disponible: $1000.00
```

## Conceptos que aprenderás
- Clases y objetos
- Atributos y métodos
- Constructores
- Encapsulamiento (public/private)
- Creación de instancias con `new`

## Recursos y documentación
- [Clases - Oracle Tutorial](https://docs.oracle.com/javase/tutorial/java/javaOO/classes.html)
- [Objetos - Oracle Tutorial](https://docs.oracle.com/javase/tutorial/java/javaOO/objects.html)
- [Constructores - Oracle Tutorial](https://docs.oracle.com/javase/tutorial/java/javaOO/constructors.html)
- [Control de acceso - Oracle Tutorial](https://docs.oracle.com/javase/tutorial/java/javaOO/accesscontrol.html)
- [Encapsulamiento - Oracle Tutorial](https://docs.oracle.com/javase/tutorial/java/concepts/object.html)
