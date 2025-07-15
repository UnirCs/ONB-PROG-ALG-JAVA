package herencia.abstraccion;

public abstract class Empleado extends Persona {
    protected String departamento;

    public Empleado(String nombre, String departamento) {
        super(nombre);
        this.departamento = departamento;
    }

    // Método abstracto obligatorio en subclases
    public abstract void trabajar();
}

