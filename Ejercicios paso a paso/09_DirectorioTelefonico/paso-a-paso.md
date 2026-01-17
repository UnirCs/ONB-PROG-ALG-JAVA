# Paso a Paso: Directorio Telefónico con HashMap

## Análisis del problema

Un **HashMap** es una estructura de datos que almacena pares clave-valor. Es ideal cuando necesitas:
- Buscar elementos rápidamente por una clave única
- Asociar datos con identificadores

**¿Por qué HashMap y no ArrayList?**

| Operación | ArrayList | HashMap |
|-----------|-----------|---------|
| Buscar por índice | O(1) Rápido | N/A |
| Buscar por valor | O(n) Lento | O(1) Rápido (por clave) |
| Agregar al final | O(1) | O(1) |
| Mantiene orden | Sí | No (usa LinkedHashMap si necesitas orden) |

## Paso 1: Crear la clase Contacto

```java
public class Contacto {
    private String nombre;
    private String telefono;
    private String email;
    
    public Contacto(String nombre, String telefono, String email) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
    }
    
    // Getters y setters
    public String getNombre() { return nombre; }
    public String getTelefono() { return telefono; }
    public String getEmail() { return email; }
    
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    @Override
    public String toString() {
        return "Nombre: " + nombre + "\n" +
               "Teléfono: " + telefono + "\n" +
               "Email: " + email;
    }
}
```

## Paso 2: Crear la clase DirectorioTelefonico con HashMap

```java
import java.util.HashMap;

public class DirectorioTelefonico {
    
    // HashMap: la clave es el nombre (String), el valor es el Contacto
    private HashMap<String, Contacto> contactos;
    
    public DirectorioTelefonico() {
        contactos = new HashMap<>();
    }
}
```

**Sintaxis de HashMap:**
- `HashMap<TipoClave, TipoValor>`
- Las claves deben ser únicas
- Los valores pueden repetirse

## Paso 3: Implementar método para agregar contacto

```java
public void agregarContacto(String nombre, String telefono, String email) {
    // Verificar si ya existe
    if (contactos.containsKey(nombre)) {
        System.out.println("Ya existe un contacto con ese nombre.");
        return;
    }
    
    Contacto nuevoContacto = new Contacto(nombre, telefono, email);
    contactos.put(nombre, nuevoContacto);
    System.out.println("✓ Contacto agregado correctamente.");
}
```

**`put(clave, valor)`**: Agrega o reemplaza un par clave-valor.

**`containsKey(clave)`**: Verifica si existe la clave.

## Paso 4: Implementar método para buscar contacto

```java
public Contacto buscarContacto(String nombre) {
    Contacto contacto = contactos.get(nombre);
    
    if (contacto == null) {
        System.out.println("Contacto no encontrado.");
        return null;
    }
    
    return contacto;
}
```

**`get(clave)`**: Retorna el valor asociado a la clave, o `null` si no existe.

## Paso 5: Implementar método para eliminar contacto

```java
public void eliminarContacto(String nombre) {
    if (contactos.containsKey(nombre)) {
        contactos.remove(nombre);
        System.out.println("✓ Contacto eliminado.");
    } else {
        System.out.println("Contacto no encontrado.");
    }
}
```

**`remove(clave)`**: Elimina el par clave-valor y retorna el valor eliminado.

## Paso 6: Implementar método para modificar teléfono

```java
public void modificarTelefono(String nombre, String nuevoTelefono) {
    Contacto contacto = contactos.get(nombre);
    
    if (contacto != null) {
        contacto.setTelefono(nuevoTelefono);
        System.out.println("✓ Teléfono actualizado.");
    } else {
        System.out.println("Contacto no encontrado.");
    }
}
```

## Paso 7: Implementar método para listar todos los contactos

```java
public void listarTodos() {
    if (contactos.isEmpty()) {
        System.out.println("El directorio está vacío.");
        return;
    }
    
    System.out.println("\n=== TODOS LOS CONTACTOS ===");
    
    // Forma 1: Iterar sobre las claves
    for (String nombre : contactos.keySet()) {
        Contacto c = contactos.get(nombre);
        System.out.println("- " + nombre + " (" + c.getTelefono() + ")");
    }
}
```

**`keySet()`**: Retorna un Set con todas las claves.

También puedes usar **`entrySet()`** para obtener pares clave-valor:

```java
// Forma 2: Iterar sobre entradas (más eficiente)
for (Map.Entry<String, Contacto> entrada : contactos.entrySet()) {
    String nombre = entrada.getKey();
    Contacto c = entrada.getValue();
    System.out.println("- " + nombre + " (" + c.getTelefono() + ")");
}
```

## Paso 8: Implementar búsqueda por texto parcial

```java
public void buscarPorTexto(String texto) {
    System.out.println("\n=== RESULTADOS DE BÚSQUEDA ===");
    boolean encontrado = false;
    
    for (String nombre : contactos.keySet()) {
        // Buscar coincidencia ignorando mayúsculas/minúsculas
        if (nombre.toLowerCase().contains(texto.toLowerCase())) {
            Contacto c = contactos.get(nombre);
            System.out.println("- " + nombre + " (" + c.getTelefono() + ")");
            encontrado = true;
        }
    }
    
    if (!encontrado) {
        System.out.println("No se encontraron contactos que coincidan con: " + texto);
    }
}
```

## Paso 9: Crear la clase principal con menú

```java
import java.util.Scanner;

public class AplicacionDirectorio {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DirectorioTelefonico directorio = new DirectorioTelefonico();
        
        // Agregar algunos contactos de ejemplo
        directorio.agregarContacto("María García", "612345678", "maria@email.com");
        directorio.agregarContacto("Pedro García", "698765432", "pedro@email.com");
        
        int opcion;
        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine();
            
            switch (opcion) {
                case 1: // Agregar
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Teléfono: ");
                    String telefono = scanner.nextLine();
                    System.out.print("Email: ");
                    String email = scanner.nextLine();
                    directorio.agregarContacto(nombre, telefono, email);
                    break;
                // ... resto de casos
            }
        } while (opcion != 7);
    }
}
```

## Métodos principales de HashMap

```java
HashMap<String, Integer> mapa = new HashMap<>();

// Agregar elementos
mapa.put("uno", 1);           // Agrega par clave-valor
mapa.putIfAbsent("uno", 10);  // Solo agrega si la clave no existe

// Obtener elementos
Integer valor = mapa.get("uno");           // Obtiene valor (o null)
Integer valorDef = mapa.getOrDefault("dos", 0); // Obtiene valor o default

// Verificar existencia
boolean existe = mapa.containsKey("uno");    // ¿Existe la clave?
boolean tieneValor = mapa.containsValue(1);  // ¿Existe el valor?

// Eliminar
mapa.remove("uno");           // Elimina por clave
mapa.clear();                 // Elimina todo

// Información
int tamaño = mapa.size();     // Cantidad de pares
boolean vacio = mapa.isEmpty(); // ¿Está vacío?

// Iteración
Set<String> claves = mapa.keySet();          // Todas las claves
Collection<Integer> valores = mapa.values(); // Todos los valores
Set<Map.Entry<String, Integer>> entradas = mapa.entrySet(); // Pares
```

## Diagrama de HashMap

```
       HashMap<String, Contacto>
       ┌─────────────────────────────────────┐
       │                                     │
       │   Clave (String)     Valor (Contacto)
       │   ┌──────────────┐   ┌────────────────┐
       │   │"María García"│ → │ Contacto       │
       │   └──────────────┘   │ tel: 612345678 │
       │                      │ email: maria@..│
       │                      └────────────────┘
       │   ┌──────────────┐   ┌────────────────┐
       │   │"Pedro García"│ → │ Contacto       │
       │   └──────────────┘   │ tel: 698765432 │
       │                      │ email: pedro@..│
       │                      └────────────────┘
       │                                     │
       └─────────────────────────────────────┘
       
       get("María García") → Contacto (O(1) - instantáneo)
```

## Errores comunes a evitar

1. **Claves duplicadas**: Si haces `put()` con una clave existente, se REEMPLAZA el valor anterior.

2. **Comparar con `==`**: Las claves String deben compararse con `.equals()`, aunque HashMap lo hace internamente.

3. **Modificar claves**: Si cambias un objeto usado como clave después de agregarlo, puede quedar "perdido" en el mapa.

4. **NullPointerException**: `get()` puede devolver `null`. Siempre verifica antes de usar el resultado.

## Variantes de HashMap

```java
// HashMap - No mantiene orden
HashMap<String, Integer> hashMap = new HashMap<>();

// LinkedHashMap - Mantiene orden de inserción
LinkedHashMap<String, Integer> linkedMap = new LinkedHashMap<>();

// TreeMap - Mantiene orden natural (alfabético para String)
TreeMap<String, Integer> treeMap = new TreeMap<>();
```

## Mejoras posibles

- Agregar validación de formato de teléfono y email
- Permitir múltiples teléfonos por contacto
- Implementar grupos de contactos
- Guardar/cargar contactos de un archivo
- Buscar por teléfono (requiere otro HashMap inverso)

