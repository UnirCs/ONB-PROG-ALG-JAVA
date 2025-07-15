package herencia;

public class Administrativo extends Empleado {
    private String rol;

    public Administrativo(String nombre, String departamento, String rol) {
        super(nombre, departamento);
        this.rol = rol;
    }

    @Override
    public void trabajar() {
        System.out.println(nombre + " está realizando tareas de " + rol);
    }

    public void gestionarDocumentos() {
        System.out.println(nombre + " está gestionando documentos.");
    }
}

