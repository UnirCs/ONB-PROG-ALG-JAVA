package herencia.abstraccion;

public abstract class Persona {
    protected String nombre;

    public Persona(String nombre) {
        this.nombre = nombre;
    }

    // Método abstracto que cada subclase debe implementar
    public abstract void presentarse();
}

