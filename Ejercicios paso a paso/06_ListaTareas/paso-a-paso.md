# Paso a Paso: Lista de Tareas (To-Do List)

## Análisis del problema

Los arrays tienen un tamaño fijo, pero necesitamos una lista que pueda crecer y reducirse dinámicamente. Para esto usamos **ArrayList**.

**Diferencias Array vs ArrayList:**

| Característica | Array | ArrayList |
|----------------|-------|-----------|
| Tamaño | Fijo | Dinámico |
| Tipos primitivos | Sí | No (usa wrappers) |
| Sintaxis tamaño | `length` | `size()` |
| Agregar elemento | No se puede | `add()` |
| Eliminar elemento | No se puede | `remove()` |

## Paso 1: Crear la clase Tarea

```java
public class Tarea {
    private String descripcion;
    private boolean completada;
    
    public Tarea(String descripcion) {
        this.descripcion = descripcion;
        this.completada = false; // Por defecto, no completada
    }
    
    public String getDescripcion() {
        return descripcion;
    }
    
    public boolean isCompletada() {
        return completada;
    }
    
    public void marcarCompletada() {
        this.completada = true;
    }
}
```

**Nota:** Para booleanos, el getter se llama `isXxx()` en lugar de `getXxx()`.

## Paso 2: Sobreescribir toString()

El método `toString()` viene de la clase Object y podemos personalizarlo:

```java
@Override
public String toString() {
    String estado = completada ? "[✓]" : "[ ]";
    return estado + " " + descripcion;
}
```

**¿Qué es `@Override`?** Es una anotación que indica que estamos reemplazando un método de la clase padre. No es obligatoria, pero es buena práctica porque el compilador te avisa si cometes errores.

**Operador ternario:** `condicion ? valorSiTrue : valorSiFalse`

## Paso 3: Crear la clase GestorTareas con ArrayList

```java
import java.util.ArrayList;

public class GestorTareas {
    private ArrayList<Tarea> tareas;
    
    public GestorTareas() {
        tareas = new ArrayList<>();
    }
}
```

**Sintaxis de ArrayList:**
- `ArrayList<Tipo>` - Se especifica el tipo de elemento entre `<>`
- `new ArrayList<>()` - El tipo se puede inferir (diamond operator)

## Paso 4: Implementar método para agregar tareas

```java
public void agregarTarea(String descripcion) {
    Tarea nuevaTarea = new Tarea(descripcion);
    tareas.add(nuevaTarea);
    System.out.println("Tarea agregada con éxito.");
}
```

**`add(elemento)`** agrega el elemento al final de la lista.

## Paso 5: Implementar método para eliminar tareas

```java
public void eliminarTarea(int indice) {
    // Convertir de índice usuario (1-based) a índice Java (0-based)
    int indiceReal = indice - 1;
    
    if (indiceReal >= 0 && indiceReal < tareas.size()) {
        Tarea eliminada = tareas.remove(indiceReal);
        System.out.println("Tarea eliminada: " + eliminada.getDescripcion());
    } else {
        System.out.println("Error: Índice no válido.");
    }
}
```

**`remove(indice)`** elimina y devuelve el elemento en esa posición.

## Paso 6: Implementar método para marcar como completada

```java
public void marcarCompletada(int indice) {
    int indiceReal = indice - 1;
    
    if (indiceReal >= 0 && indiceReal < tareas.size()) {
        tareas.get(indiceReal).marcarCompletada();
        System.out.println("¡Tarea completada!");
    } else {
        System.out.println("Error: Índice no válido.");
    }
}
```

**`get(indice)`** devuelve el elemento en esa posición sin eliminarlo.

## Paso 7: Implementar método para mostrar todas las tareas

```java
public void mostrarTodas() {
    if (tareas.isEmpty()) {
        System.out.println("No hay tareas en la lista.");
        return;
    }
    
    System.out.println("\n=== TODAS LAS TAREAS ===");
    int numero = 1;
    for (Tarea tarea : tareas) {
        System.out.println(numero + ". " + tarea);
        numero++;
    }
}
```

**Bucle for-each:** `for (Tipo elemento : coleccion)` - Forma simplificada de recorrer.

## Paso 8: Implementar método para mostrar tareas pendientes

```java
public void mostrarPendientes() {
    System.out.println("\n=== TAREAS PENDIENTES ===");
    int numero = 1;
    boolean hayPendientes = false;
    
    for (Tarea tarea : tareas) {
        if (!tarea.isCompletada()) {
            System.out.println(numero + ". " + tarea.getDescripcion());
            hayPendientes = true;
        }
        numero++;
    }
    
    if (!hayPendientes) {
        System.out.println("¡No hay tareas pendientes! 🎉");
    }
}
```

## Paso 9: Implementar método para mostrar resumen

```java
public void mostrarResumen() {
    int total = tareas.size();
    int completadas = 0;
    
    for (Tarea tarea : tareas) {
        if (tarea.isCompletada()) {
            completadas++;
        }
    }
    
    int pendientes = total - completadas;
    
    System.out.println("\n=== RESUMEN ===");
    System.out.println("Total de tareas: " + total);
    System.out.println("Completadas: " + completadas);
    System.out.println("Pendientes: " + pendientes);
}
```

## Paso 10: Crear la clase principal con el menú

```java
import java.util.Scanner;

public class AplicacionTareas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GestorTareas gestor = new GestorTareas();
        
        System.out.println("=== LISTA DE TAREAS ===");
        
        int opcion;
        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer
            
            switch (opcion) {
                case 1:
                    System.out.print("\nIngrese la descripción de la tarea: ");
                    String descripcion = scanner.nextLine();
                    gestor.agregarTarea(descripcion);
                    break;
                // ... resto de casos
            }
        } while (opcion != 7);
    }
    
    public static void mostrarMenu() {
        System.out.println("\n--- MENÚ ---");
        System.out.println("1. Agregar tarea");
        // ...
    }
}
```

## Métodos principales de ArrayList

```java
ArrayList<String> lista = new ArrayList<>();

// Agregar elementos
lista.add("Primero");           // Agrega al final
lista.add(0, "Nuevo primero");  // Agrega en posición específica

// Acceder a elementos
String elemento = lista.get(0); // Obtiene elemento en posición 0

// Modificar elementos
lista.set(0, "Modificado");     // Reemplaza elemento en posición 0

// Eliminar elementos
lista.remove(0);                // Elimina por índice
lista.remove("Primero");        // Elimina por valor (primera ocurrencia)

// Información
int tamaño = lista.size();      // Cantidad de elementos
boolean vacia = lista.isEmpty(); // ¿Está vacía?
boolean existe = lista.contains("algo"); // ¿Contiene el elemento?

// Limpiar
lista.clear();                  // Elimina todos los elementos
```

## Resumen del flujo

```
┌─────────────────────┐
│   Crear gestor      │
│   (ArrayList vacío) │
└──────────┬──────────┘
           │
           ▼
┌─────────────────────┐◄──────────┐
│   Mostrar menú      │           │
└──────────┬──────────┘           │
           │                      │
           ▼                      │
     ┌─────┴─────┐                │
     │  Opción   │                │
     └─────┬─────┘                │
           │                      │
    ┌──────┼──────┐               │
    ▼      ▼      ▼               │
  Agregar  Ver   Marcar           │
           │                      │
           └──────────────────────┘
```

## Errores comunes a evitar

1. **IndexOutOfBoundsException**: Acceder a un índice que no existe. Siempre valida con `size()`.

2. **Olvidar limpiar el buffer**: Después de `nextInt()`, usar `nextLine()` para limpiar.

3. **Modificar lista mientras la recorres**: Usar `remove()` dentro de un for-each causa `ConcurrentModificationException`. Usa un iterador o recorre al revés.

4. **Confundir índice con tamaño**: El último índice válido es `size() - 1`.

## Mejoras posibles

- Agregar prioridad a las tareas (alta, media, baja)
- Agregar fecha de vencimiento
- Guardar las tareas en un archivo
- Buscar tareas por descripción
- Editar descripción de tareas existentes

