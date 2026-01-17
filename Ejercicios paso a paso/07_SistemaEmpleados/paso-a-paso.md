# Paso a Paso: Sistema de Empleados con Herencia

## Análisis del problema

La **herencia** nos permite crear nuevas clases basadas en clases existentes. Es perfecta cuando tenemos entidades que comparten características pero tienen comportamientos diferentes.

**Jerarquía de nuestro sistema:**
```
           Empleado (abstracta)
          /        |          \
EmpleadoRegular  Gerente  Desarrollador
```

**¿Por qué usar herencia?**
- Evita duplicar código (DRY: Don't Repeat Yourself)
- Permite tratar diferentes tipos de manera uniforme (polimorfismo)
- Facilita agregar nuevos tipos de empleados en el futuro

## Paso 1: Diseñar la clase base Empleado

Primero identificamos qué es común a TODOS los empleados:

```java
public abstract class Empleado {
    // Atributos comunes a todos los empleados
    protected String nombre;
    protected String id;
    protected double salarioBase;
    
    // Constructor
    public Empleado(String nombre, String id, double salarioBase) {
        this.nombre = nombre;
        this.id = id;
        this.salarioBase = salarioBase;
    }
}
```

**¿Por qué `abstract`?** Porque no queremos crear "empleados genéricos", solo tipos específicos (Regular, Gerente, Desarrollador).

**¿Por qué `protected`?** Para que las clases hijas puedan acceder directamente a estos atributos.

## Paso 2: Agregar el método abstracto

```java
public abstract class Empleado {
    // ... atributos y constructor ...
    
    /**
     * Método abstracto: cada tipo de empleado lo implementará diferente
     */
    public abstract double calcularSalario();
}
```

**¿Qué es un método abstracto?**
- Solo tiene la firma (declaración), no tiene cuerpo `{}`
- Las clases hijas DEBEN implementarlo
- Fuerza a que cada tipo defina cómo calcular su salario

## Paso 3: Agregar método común

```java
public void mostrarInformacion() {
    System.out.println("Nombre: " + nombre);
    System.out.println("ID: " + id);
    System.out.printf("Salario Base: $%.2f%n", salarioBase);
}
```

Este método es igual para todos, así que lo definimos en la clase padre.

## Paso 4: Crear la clase EmpleadoRegular

```java
public class EmpleadoRegular extends Empleado {
    
    public EmpleadoRegular(String nombre, String id, double salarioBase) {
        super(nombre, id, salarioBase); // Llama al constructor del padre
    }
    
    @Override
    public double calcularSalario() {
        return salarioBase; // Sin modificaciones
    }
    
    @Override
    public void mostrarInformacion() {
        System.out.println("--- Empleado Regular ---");
        super.mostrarInformacion(); // Llama al método del padre
        System.out.printf("Salario Total: $%.2f%n", calcularSalario());
    }
}
```

**`extends`**: Indica que esta clase hereda de Empleado.

**`super(...)`**: Llama al constructor de la clase padre.

**`@Override`**: Indica que estamos reemplazando un método del padre.

## Paso 5: Crear la clase Gerente

```java
public class Gerente extends Empleado {
    
    private int empleadosACargo;
    private static final double BONO_POR_EMPLEADO = 100.0;
    
    public Gerente(String nombre, String id, double salarioBase, int empleadosACargo) {
        super(nombre, id, salarioBase);
        this.empleadosACargo = empleadosACargo;
    }
    
    @Override
    public double calcularSalario() {
        double bono = empleadosACargo * BONO_POR_EMPLEADO;
        return salarioBase + bono;
    }
    
    @Override
    public void mostrarInformacion() {
        System.out.println("--- Gerente ---");
        super.mostrarInformacion();
        System.out.println("Empleados a cargo: " + empleadosACargo);
        System.out.printf("Bono por equipo: $%.2f%n", empleadosACargo * BONO_POR_EMPLEADO);
        System.out.printf("Salario Total: $%.2f%n", calcularSalario());
    }
}
```

**`static final`**: Constante de clase (no cambia, es la misma para todos).

## Paso 6: Crear la clase Desarrollador

```java
public class Desarrollador extends Empleado {
    
    private int horasExtra;
    private static final double TARIFA_HORA_EXTRA = 25.0;
    
    public Desarrollador(String nombre, String id, double salarioBase, int horasExtra) {
        super(nombre, id, salarioBase);
        this.horasExtra = horasExtra;
    }
    
    @Override
    public double calcularSalario() {
        double bonoHorasExtra = horasExtra * TARIFA_HORA_EXTRA;
        return salarioBase + bonoHorasExtra;
    }
    
    @Override
    public void mostrarInformacion() {
        System.out.println("--- Desarrollador ---");
        super.mostrarInformacion();
        System.out.println("Horas extra: " + horasExtra);
        System.out.printf("Bono por horas extra: $%.2f%n", horasExtra * TARIFA_HORA_EXTRA);
        System.out.printf("Salario Total: $%.2f%n", calcularSalario());
    }
}
```

## Paso 7: Demostrar polimorfismo en la clase principal

```java
import java.util.ArrayList;

public class SistemaEmpleados {
    public static void main(String[] args) {
        // Lista de empleados (puede contener cualquier subtipo)
        ArrayList<Empleado> empleados = new ArrayList<>();
        
        // Agregar diferentes tipos de empleados
        empleados.add(new EmpleadoRegular("Ana López", "EMP001", 2000));
        empleados.add(new Gerente("Carlos Ruiz", "GER001", 3500, 5));
        empleados.add(new Desarrollador("María García", "DEV001", 2800, 10));
        
        System.out.println("=== SISTEMA DE GESTIÓN DE EMPLEADOS ===\n");
        System.out.println("Procesando nómina...\n");
        
        double totalNomina = 0;
        
        // Polimorfismo: tratamos todos como Empleado
        for (Empleado emp : empleados) {
            emp.mostrarInformacion(); // Cada uno ejecuta SU versión
            System.out.println();
            totalNomina += emp.calcularSalario();
        }
        
        System.out.println("=== RESUMEN DE NÓMINA ===");
        System.out.println("Total empleados: " + empleados.size());
        System.out.printf("Total a pagar: $%.2f%n", totalNomina);
    }
}
```

**Polimorfismo en acción:**
- La lista es de tipo `Empleado`
- Pero contiene objetos de diferentes subtipos
- Cuando llamamos `mostrarInformacion()`, Java ejecuta la versión correcta según el tipo real del objeto

## Diagrama de clases

```
┌───────────────────────────────────────┐
│         <<abstract>>                  │
│           Empleado                    │
├───────────────────────────────────────┤
│ # nombre: String                      │
│ # id: String                          │
│ # salarioBase: double                 │
├───────────────────────────────────────┤
│ + Empleado(nombre, id, salarioBase)   │
│ + calcularSalario(): double {abstract}│
│ + mostrarInformacion(): void          │
│ + getters...                          │
└───────────────────┬───────────────────┘
                    │
        ┌───────────┼───────────┐
        │           │           │
        ▼           ▼           ▼
┌─────────────┐ ┌─────────┐ ┌─────────────┐
│EmpleadoRegul│ │ Gerente │ │Desarrollador│
├─────────────┤ ├─────────┤ ├─────────────┤
│             │ │-emplead.│ │-horasExtra  │
│             │ │ ACargo  │ │             │
├─────────────┤ ├─────────┤ ├─────────────┤
│+calcular    │ │+calcular│ │+calcular    │
│ Salario()   │ │ Salario │ │ Salario()   │
│+mostrar     │ │+mostrar │ │+mostrar     │
│ Informacion │ │ Inform. │ │ Informacion │
└─────────────┘ └─────────┘ └─────────────┘
```

**Notación:**
- `#` = protected
- `-` = private
- `+` = public
- `{abstract}` = método abstracto

## Conceptos clave

### Modificadores de acceso
```java
public     // Accesible desde cualquier lugar
protected  // Accesible en la clase, subclases y mismo paquete
private    // Solo accesible dentro de la clase
(default)  // Accesible en el mismo paquete
```

### super vs this
```java
this.nombre      // Atributo de ESTA clase
super.nombre     // Atributo de la clase PADRE

this()           // Llama a otro constructor de esta clase
super()          // Llama al constructor del padre
```

## Errores comunes a evitar

1. **Olvidar llamar a `super()`**: Si el padre no tiene constructor sin parámetros, DEBES llamar a super() con los parámetros correctos.

2. **Olvidar implementar métodos abstractos**: Si heredas de una clase abstracta, debes implementar TODOS sus métodos abstractos.

3. **Usar private en la clase padre**: Las clases hijas no podrán acceder. Usa protected.

4. **No usar `@Override`**: No es obligatorio pero ayuda a detectar errores.

## Mejoras posibles

- Agregar más tipos de empleados (Pasante, Consultor)
- Crear una interfaz `Bonificable` para empleados con bonos
- Implementar método para dar aumentos de sueldo
- Agregar sistema de evaluación de desempeño

