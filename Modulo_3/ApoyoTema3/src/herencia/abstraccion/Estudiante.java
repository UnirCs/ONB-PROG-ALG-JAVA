package herencia.abstraccion;

import herencia.Persona;

public class Estudiante extends Persona {
    private String curso;

    public Estudiante(String nombre, String curso) {
        super(nombre);
        this.curso = curso;
    }

    public void estudiar() {
        System.out.println(nombre + " está estudiando el curso de " + curso);
    }

    @Override
    public void presentarse() {
        System.out.println("Hola, soy " + nombre + " y soy estudiante del curso " + curso);
    }
}

