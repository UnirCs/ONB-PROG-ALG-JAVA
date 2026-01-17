# Paso a Paso: Sistema de Cuenta Bancaria

## Análisis del problema

Este ejercicio introduce la **Programación Orientada a Objetos (POO)**. En lugar de tener solo datos y funciones sueltas, vamos a modelar una "cosa" del mundo real: una cuenta bancaria.

**¿Qué es un objeto?** Una entidad que tiene:
- **Atributos** (datos): titular, número de cuenta, saldo
- **Métodos** (comportamiento): depositar, retirar, consultar saldo

**¿Qué es una clase?** El "molde" o "plantilla" para crear objetos.

## Paso 1: Diseñar la clase CuentaBancaria

Antes de programar, pensemos qué necesita una cuenta bancaria:

| Atributo | Tipo | Descripción |
|----------|------|-------------|
| titular | String | Nombre del dueño |
| numeroCuenta | String | Identificador único |
| saldo | double | Dinero disponible |

| Método | Parámetros | Retorno | Descripción |
|--------|------------|---------|-------------|
| depositar | double cantidad | void | Añade dinero al saldo |
| retirar | double cantidad | boolean | Resta dinero si hay fondos |
| getSaldo | - | double | Devuelve el saldo actual |

## Paso 2: Crear la estructura básica de la clase

```java
public class CuentaBancaria {
    // Atributos (privados para encapsulamiento)
    private String titular;
    private String numeroCuenta;
    private double saldo;
}
```

**¿Por qué `private`?** Para proteger los datos. Nadie de fuera puede modificar el saldo directamente, solo a través de nuestros métodos controlados.

## Paso 3: Crear el constructor

El constructor es un método especial que se ejecuta cuando creamos un objeto.

```java
public CuentaBancaria(String titular, String numeroCuenta, double saldoInicial) {
    this.titular = titular;
    this.numeroCuenta = numeroCuenta;
    this.saldo = saldoInicial;
}
```

**¿Qué es `this`?** Se refiere al objeto actual. Usamos `this.titular` para diferenciar el atributo de la clase del parámetro con el mismo nombre.

**Características del constructor:**
- Tiene el mismo nombre que la clase
- No tiene tipo de retorno (ni siquiera `void`)
- Se ejecuta automáticamente al usar `new`

## Paso 4: Crear los métodos getter

Los getters permiten leer los atributos privados desde fuera de la clase.

```java
public String getTitular() {
    return titular;
}

public String getNumeroCuenta() {
    return numeroCuenta;
}

public double getSaldo() {
    return saldo;
}
```

**Convención de nombres:** `getAtributo()` para leer, `setAtributo()` para modificar.

## Paso 5: Crear el método depositar

```java
public void depositar(double cantidad) {
    if (cantidad > 0) {
        saldo += cantidad;
        System.out.println("Depósito realizado con éxito.");
    } else {
        System.out.println("Error: La cantidad debe ser positiva.");
    }
}
```

**¿Por qué validamos `cantidad > 0`?** Para evitar depósitos negativos (que serían retiros encubiertos).

## Paso 6: Crear el método retirar

```java
public boolean retirar(double cantidad) {
    if (cantidad <= 0) {
        System.out.println("Error: La cantidad debe ser positiva.");
        return false;
    }
    
    if (cantidad > saldo) {
        System.out.printf("Error: Fondos insuficientes. Saldo disponible: $%.2f%n", saldo);
        return false;
    }
    
    saldo -= cantidad;
    System.out.println("Retiro realizado con éxito.");
    return true;
}
```

**¿Por qué devuelve `boolean`?** Para que el código que llama al método sepa si la operación fue exitosa o no.

## Paso 7: Crear el método mostrarInformacion

```java
public void mostrarInformacion() {
    System.out.println("\n=== INFORMACIÓN DE LA CUENTA ===");
    System.out.println("Titular: " + titular);
    System.out.println("Número de cuenta: " + numeroCuenta);
    System.out.printf("Saldo: $%.2f%n", saldo);
}
```

## Paso 8: Crear la clase principal

Ahora creamos la clase con el `main` que usa nuestra CuentaBancaria:

```java
import java.util.Scanner;

public class SistemaBancario {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Crear una cuenta bancaria
        CuentaBancaria cuenta = new CuentaBancaria("Juan García", "001234", 0);
        
        System.out.println("=== SISTEMA BANCARIO ===");
        System.out.println("Creando cuenta para: " + cuenta.getTitular());
        System.out.println("Número de cuenta: " + cuenta.getNumeroCuenta());
        
        // Menú de operaciones
        int opcion;
        do {
            // ... mostrar menú y procesar opciones
        } while (opcion != 5);
    }
}
```

**`new CuentaBancaria(...)`**: Crea un nuevo objeto (instancia) de la clase CuentaBancaria.

## Paso 9: Implementar el menú completo

```java
do {
    System.out.println("\n--- MENÚ ---");
    System.out.println("1. Depositar");
    System.out.println("2. Retirar");
    System.out.println("3. Consultar saldo");
    System.out.println("4. Ver información de la cuenta");
    System.out.println("5. Salir");
    System.out.print("Opción: ");
    opcion = scanner.nextInt();
    
    switch (opcion) {
        case 1:
            System.out.print("\nIngrese cantidad a depositar: ");
            double deposito = scanner.nextDouble();
            cuenta.depositar(deposito);
            System.out.printf("Nuevo saldo: $%.2f%n", cuenta.getSaldo());
            break;
            
        case 2:
            System.out.print("\nIngrese cantidad a retirar: ");
            double retiro = scanner.nextDouble();
            cuenta.retirar(retiro);
            System.out.printf("Saldo actual: $%.2f%n", cuenta.getSaldo());
            break;
            
        case 3:
            System.out.printf("\nSaldo actual: $%.2f%n", cuenta.getSaldo());
            break;
            
        case 4:
            cuenta.mostrarInformacion();
            break;
            
        case 5:
            System.out.println("\n¡Gracias por usar nuestro sistema!");
            break;
            
        default:
            System.out.println("\nOpción no válida.");
    }
} while (opcion != 5);
```

## Diagrama de la clase

```
┌─────────────────────────────────────┐
│          CuentaBancaria             │
├─────────────────────────────────────┤
│ - titular: String                   │  ← Atributos (privados)
│ - numeroCuenta: String              │
│ - saldo: double                     │
├─────────────────────────────────────┤
│ + CuentaBancaria(...)               │  ← Constructor (público)
│ + getTitular(): String              │  ← Getters (públicos)
│ + getNumeroCuenta(): String         │
│ + getSaldo(): double                │
│ + depositar(cantidad: double): void │  ← Métodos (públicos)
│ + retirar(cantidad: double): boolean│
│ + mostrarInformacion(): void        │
└─────────────────────────────────────┘
```

**Notación:**
- `-` significa private
- `+` significa public

## Flujo de uso del objeto

```
┌─────────────────────────┐
│ CuentaBancaria cuenta = │
│ new CuentaBancaria(...) │
└───────────┬─────────────┘
            │ Crea objeto
            ▼
      ┌───────────┐
      │  OBJETO   │
      │  cuenta   │
      │───────────│
      │ titular   │
      │ numero    │
      │ saldo: 0  │
      └─────┬─────┘
            │
            ▼
    cuenta.depositar(1000)
            │
            ▼
      ┌───────────┐
      │  cuenta   │
      │───────────│
      │ saldo:1000│
      └─────┬─────┘
            │
            ▼
    cuenta.retirar(500)
            │
            ▼
      ┌───────────┐
      │  cuenta   │
      │───────────│
      │ saldo: 500│
      └───────────┘
```

## Errores comunes a evitar

1. **Olvidar `this`** cuando hay conflicto de nombres entre parámetros y atributos.

2. **Hacer atributos públicos**: Rompe el encapsulamiento, cualquiera podría hacer `cuenta.saldo = -1000000`.

3. **No validar en los métodos**: Siempre valida que las operaciones sean válidas.

4. **Olvidar crear el objeto**: Declarar `CuentaBancaria cuenta;` no crea el objeto, solo la variable. Necesitas `new`.

## Mejoras posibles

- Agregar historial de transacciones (con ArrayList)
- Generar números de cuenta automáticamente
- Agregar transferencias entre cuentas
- Crear diferentes tipos de cuentas (ahorro, corriente)

