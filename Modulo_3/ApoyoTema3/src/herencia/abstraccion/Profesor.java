package herencia.abstraccion;

import herencia.Empleado;

public class Profesor extends Empleado {
    private String asignatura;

    public Profesor(String nombre, String departamento, String asignatura) {
        super(nombre, departamento);
        this.asignatura = asignatura;
    }

    @Override
    public void trabajar() {
        System.out.println(nombre + " está dando clase de " + asignatura);
    }

    public void corregirExamenes() {
        System.out.println(nombre + " está corrigiendo exámenes.");
    }
}

