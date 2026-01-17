# Ejercicio 7: Sistema de Empleados con Herencia

## Contexto
Una empresa necesita gestionar diferentes tipos de empleados: empleados regulares, gerentes y desarrolladores. Cada tipo tiene características comunes pero también comportamientos específicos.

## Enunciado
Crea un sistema de gestión de empleados utilizando **herencia**. Debes implementar:

1. Una clase base `Empleado` con:
   - Atributos: nombre, id, salarioBase
   - Método abstracto: `calcularSalario()`
   - Método: `mostrarInformacion()`

2. Clases hijas:
   - `EmpleadoRegular`: Salario = salarioBase
   - `Gerente`: Salario = salarioBase + bono por empleados a cargo
   - `Desarrollador`: Salario = salarioBase + bono por horas extra

3. Una clase principal que cree varios empleados de diferentes tipos y los gestione en una lista.

## Requisitos técnicos
- Clase abstracta con método abstracto
- Herencia con `extends`
- Polimorfismo (tratar diferentes tipos como Empleado)
- Uso de `@Override`
- Llamada al constructor padre con `super()`

## Ejemplo de ejecución
```
=== SISTEMA DE GESTIÓN DE EMPLEADOS ===

Procesando nómina...

--- Empleado Regular ---
Nombre: Ana López
ID: EMP001
Salario Base: $2000.00
Salario Total: $2000.00

--- Gerente ---
Nombre: Carlos Ruiz
ID: GER001
Salario Base: $3500.00
Empleados a cargo: 5
Bono por equipo: $500.00
Salario Total: $4000.00

--- Desarrollador ---
Nombre: María García
ID: DEV001
Salario Base: $2800.00
Horas extra: 10
Bono por horas extra: $250.00
Salario Total: $3050.00

=== RESUMEN DE NÓMINA ===
Total empleados: 3
Total a pagar: $9050.00
```

## Conceptos que aprenderás
- Herencia y la palabra clave `extends`
- Clases abstractas y métodos abstractos
- Polimorfismo
- Uso de `super` para llamar al constructor padre
- Sobreescritura de métodos (@Override)

## Recursos y documentación
- [Herencia - Oracle Tutorial](https://docs.oracle.com/javase/tutorial/java/IandI/subclasses.html)
- [Clases abstractas - Oracle Tutorial](https://docs.oracle.com/javase/tutorial/java/IandI/abstract.html)
- [Polimorfismo - Oracle Tutorial](https://docs.oracle.com/javase/tutorial/java/IandI/polymorphism.html)
- [Sobreescritura de métodos - Oracle Tutorial](https://docs.oracle.com/javase/tutorial/java/IandI/override.html)
- [Palabra clave super - Oracle Tutorial](https://docs.oracle.com/javase/tutorial/java/IandI/super.html)
