package herencia;

public class Empleado extends Persona {
    protected String departamento;

    public Empleado(String nombre, String departamento) {
        super(nombre);
        this.departamento = departamento;
    }

    public void trabajar() {
        System.out.println(nombre + " está trabajando en el departamento de " + departamento);
    }
}

