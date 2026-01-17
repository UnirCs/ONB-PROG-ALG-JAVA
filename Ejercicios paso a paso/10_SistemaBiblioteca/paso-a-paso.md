# Paso a Paso: Sistema de Gestión de Biblioteca (Integrador)

## Análisis del problema

Este ejercicio integra todos los conceptos aprendidos. Vamos a estructurarlo paso a paso.

### Diagrama de clases completo

```
                    <<interface>>
                     Prestable
                    ┌──────────────────┐
                    │+ prestar()       │
                    │+ devolver()      │
                    │+ estaDisponible()│
                    └────────┬─────────┘
                             │ implements
                             ▼
                    ┌──────────────────┐
                    │      Libro       │
                    ├──────────────────┤
                    │- isbn: String    │
                    │- titulo: String  │
                    │- autor: String   │
                    │- disponible: bool│
                    └──────────────────┘

        <<abstract>>
         Usuario
    ┌─────────────────────┐
    │- id: String         │
    │- nombre: String     │
    │- prestamosActivos   │
    ├─────────────────────┤
    │+ getMaxLibros()     │
    │+ getDiasPrestamo()  │
    │+ puedePrestar()     │
    └──────────┬──────────┘
               │ extends
       ┌───────┴───────┐
       ▼               ▼
┌─────────────┐ ┌─────────────┐
│ Estudiante  │ │  Profesor   │
├─────────────┤ ├─────────────┤
│max: 3 libros│ │max: 5 libros│
│14 días      │ │30 días      │
└─────────────┘ └─────────────┘

    ┌──────────────────────────────┐
    │          Prestamo            │
    ├──────────────────────────────┤
    │- libro: Libro                │
    │- usuario: Usuario            │
    │- fechaPrestamo: LocalDate    │
    │- fechaDevolucion: LocalDate  │
    │- devuelto: boolean           │
    └──────────────────────────────┘

    ┌──────────────────────────────────────┐
    │          Biblioteca                  │
    ├──────────────────────────────────────┤
    │- catalogo: ArrayList<Libro>          │
    │- usuarios: HashMap<String, Usuario>  │
    │- prestamos: ArrayList<Prestamo>      │
    ├──────────────────────────────────────┤
    │+ agregarLibro()                      │
    │+ registrarUsuario()                  │
    │+ realizarPrestamo()                  │
    │+ devolverLibro()                     │
    └──────────────────────────────────────┘
```

## Paso 1: Crear la interfaz Prestable

```java
public interface Prestable {
    boolean prestar();
    boolean devolver();
    boolean estaDisponible();
}
```

Esta interfaz define el contrato para elementos que pueden ser prestados.

## Paso 2: Crear la clase Libro

```java
public class Libro implements Prestable {
    private String isbn;
    private String titulo;
    private String autor;
    private boolean disponible;
    
    public Libro(String isbn, String titulo, String autor) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.disponible = true; // Por defecto disponible
    }
    
    @Override
    public boolean prestar() {
        if (disponible) {
            disponible = false;
            return true;
        }
        return false;
    }
    
    @Override
    public boolean devolver() {
        if (!disponible) {
            disponible = true;
            return true;
        }
        return false;
    }
    
    @Override
    public boolean estaDisponible() {
        return disponible;
    }
    
    // Getters...
}
```

## Paso 3: Crear la clase abstracta Usuario

```java
public abstract class Usuario {
    protected String id;
    protected String nombre;
    protected int prestamosActivos;
    
    public Usuario(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.prestamosActivos = 0;
    }
    
    // Métodos abstractos: cada tipo de usuario los implementa
    public abstract int getMaxLibros();
    public abstract int getDiasPrestamo();
    
    // Método común
    public boolean puedePrestar() {
        return prestamosActivos < getMaxLibros();
    }
    
    public void incrementarPrestamos() {
        prestamosActivos++;
    }
    
    public void decrementarPrestamos() {
        if (prestamosActivos > 0) {
            prestamosActivos--;
        }
    }
}
```

## Paso 4: Crear las subclases Estudiante y Profesor

```java
public class Estudiante extends Usuario {
    private static final int MAX_LIBROS = 3;
    private static final int DIAS_PRESTAMO = 14;
    
    public Estudiante(String id, String nombre) {
        super(id, nombre);
    }
    
    @Override
    public int getMaxLibros() {
        return MAX_LIBROS;
    }
    
    @Override
    public int getDiasPrestamo() {
        return DIAS_PRESTAMO;
    }
}

public class Profesor extends Usuario {
    private static final int MAX_LIBROS = 5;
    private static final int DIAS_PRESTAMO = 30;
    
    public Profesor(String id, String nombre) {
        super(id, nombre);
    }
    
    @Override
    public int getMaxLibros() {
        return MAX_LIBROS;
    }
    
    @Override
    public int getDiasPrestamo() {
        return DIAS_PRESTAMO;
    }
}
```

## Paso 5: Crear la clase Prestamo

```java
import java.time.LocalDate;

public class Prestamo {
    private Libro libro;
    private Usuario usuario;
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;
    private boolean devuelto;
    
    public Prestamo(Libro libro, Usuario usuario) {
        this.libro = libro;
        this.usuario = usuario;
        this.fechaPrestamo = LocalDate.now();
        this.fechaDevolucion = fechaPrestamo.plusDays(usuario.getDiasPrestamo());
        this.devuelto = false;
    }
    
    public void marcarDevuelto() {
        this.devuelto = true;
    }
    
    public boolean estaVencido() {
        return !devuelto && LocalDate.now().isAfter(fechaDevolucion);
    }
    
    // Getters...
}
```

**`LocalDate`**: Clase de Java para manejar fechas (sin hora).

## Paso 6: Crear la clase Biblioteca

```java
import java.util.ArrayList;
import java.util.HashMap;

public class Biblioteca {
    private ArrayList<Libro> catalogo;
    private HashMap<String, Usuario> usuarios;
    private ArrayList<Prestamo> prestamos;
    
    public Biblioteca() {
        catalogo = new ArrayList<>();
        usuarios = new HashMap<>();
        prestamos = new ArrayList<>();
    }
    
    // Gestión de libros
    public void agregarLibro(Libro libro) {
        catalogo.add(libro);
    }
    
    public Libro buscarLibroPorIsbn(String isbn) {
        for (Libro libro : catalogo) {
            if (libro.getIsbn().equals(isbn)) {
                return libro;
            }
        }
        return null;
    }
    
    // Gestión de usuarios
    public void registrarUsuario(Usuario usuario) {
        usuarios.put(usuario.getId(), usuario);
    }
    
    public Usuario buscarUsuario(String id) {
        return usuarios.get(id);
    }
    
    // Gestión de préstamos
    public boolean realizarPrestamo(String idUsuario, String isbn) {
        Usuario usuario = buscarUsuario(idUsuario);
        Libro libro = buscarLibroPorIsbn(isbn);
        
        // Validaciones
        if (usuario == null) {
            System.out.println("Usuario no encontrado.");
            return false;
        }
        
        if (libro == null) {
            System.out.println("Libro no encontrado.");
            return false;
        }
        
        if (!libro.estaDisponible()) {
            System.out.println("El libro no está disponible.");
            return false;
        }
        
        if (!usuario.puedePrestar()) {
            System.out.println("El usuario ha alcanzado su límite de préstamos.");
            return false;
        }
        
        // Realizar préstamo
        libro.prestar();
        usuario.incrementarPrestamos();
        Prestamo prestamo = new Prestamo(libro, usuario);
        prestamos.add(prestamo);
        
        return true;
    }
}
```

## Paso 7: Implementar la devolución

```java
public boolean devolverLibro(String idUsuario, String isbn) {
    // Buscar el préstamo activo
    for (Prestamo prestamo : prestamos) {
        if (!prestamo.isDevuelto() &&
            prestamo.getUsuario().getId().equals(idUsuario) &&
            prestamo.getLibro().getIsbn().equals(isbn)) {
            
            prestamo.getLibro().devolver();
            prestamo.getUsuario().decrementarPrestamos();
            prestamo.marcarDevuelto();
            
            if (prestamo.estaVencido()) {
                System.out.println("⚠ Nota: El libro fue devuelto con retraso.");
            }
            
            return true;
        }
    }
    
    System.out.println("No se encontró un préstamo activo con esos datos.");
    return false;
}
```

## Paso 8: Métodos de consulta y estadísticas

```java
public ArrayList<Libro> getLibrosDisponibles() {
    ArrayList<Libro> disponibles = new ArrayList<>();
    
    for (Libro libro : catalogo) {
        if (libro.estaDisponible()) {
            disponibles.add(libro);
        }
    }
    
    return disponibles;
}

public ArrayList<Prestamo> getPrestamosUsuario(String idUsuario) {
    ArrayList<Prestamo> resultado = new ArrayList<>();
    
    for (Prestamo prestamo : prestamos) {
        if (!prestamo.isDevuelto() && 
            prestamo.getUsuario().getId().equals(idUsuario)) {
            resultado.add(prestamo);
        }
    }
    
    return resultado;
}

public void mostrarEstadisticas() {
    int totalLibros = catalogo.size();
    int librosDisponibles = getLibrosDisponibles().size();
    int librosPrestados = totalLibros - librosDisponibles;
    int totalUsuarios = usuarios.size();
    int prestamosActivos = 0;
    
    for (Prestamo p : prestamos) {
        if (!p.isDevuelto()) {
            prestamosActivos++;
        }
    }
    
    System.out.println("=== ESTADÍSTICAS ===");
    System.out.println("Total de libros: " + totalLibros);
    System.out.println("Libros disponibles: " + librosDisponibles);
    System.out.println("Libros prestados: " + librosPrestados);
    System.out.println("Usuarios registrados: " + totalUsuarios);
    System.out.println("Préstamos activos: " + prestamosActivos);
}
```

## Resumen de conceptos integrados

| Concepto | Dónde se aplica |
|----------|-----------------|
| Variables/Tipos | Atributos de todas las clases |
| Condicionales | Validaciones en préstamos |
| Bucles | Búsquedas y listados |
| ArrayList | Catálogo, préstamos |
| HashMap | Usuarios por ID |
| Clases/Objetos | Libro, Usuario, Prestamo |
| Encapsulamiento | Atributos private, getters/setters |
| Herencia | Estudiante, Profesor extends Usuario |
| Clase abstracta | Usuario |
| Interfaz | Prestable |
| Polimorfismo | ArrayList<Usuario>, tratamiento uniforme |
| Métodos | Toda la lógica de negocio |

## Flujo del sistema

```
                    ┌─────────────────────┐
                    │   MENÚ PRINCIPAL    │
                    └──────────┬──────────┘
              ┌────────┬───────┼───────┬────────┐
              ▼        ▼       ▼       ▼        ▼
         ┌────────┐ ┌──────┐ ┌──────┐ ┌──────┐ ┌────┐
         │ Libros │ │Usuar.│ │Prést.│ │Estad.│ │Salir│
         └───┬────┘ └──┬───┘ └──┬───┘ └──────┘ └────┘
             │         │        │
     ┌───────┼─────┐   │   ┌────┼─────┐
     ▼       ▼     ▼   ▼   ▼    ▼     ▼
  Agregar Buscar Listar │ Prestar Devolver Consultar
                  Registrar
```

## Mejoras posibles

- Agregar sistema de multas por retraso
- Implementar reservas de libros
- Agregar categorías/géneros de libros
- Persistencia en archivos
- Búsqueda avanzada (por autor, título parcial)
- Sistema de renovación de préstamos

