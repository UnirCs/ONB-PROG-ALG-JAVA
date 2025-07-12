package herencia;

public class Ejecucion {
    public static void main(String[] args) {
        // Herencia simple y multinivel
        Profesor profe = new Profesor("Ana", "Educación", "Matemáticas");
        Administrativo admin = new Administrativo("Luis", "Administración", "Secretaría");
        Estudiante alumno = new Estudiante("Carlos", "1º de Bachillerato");

        // Polimorfismo: usamos referencia de tipo padre
        Empleado e1 = profe;  // Upcasting implícito
        Empleado e2 = (Empleado) admin; //Upcasting explícito

        // Se invoca la versión sobrescrita del método trabajar()
        e1.trabajar(); // Ana está dando clase de Matemáticas
        e2.trabajar(); // Luis está realizando tareas de Secretaría
        e1.presentarse(); // Hola, soy Ana y soy estudiante del curso Matemáticas
        e2.presentarse();

        // Downcasting: recuperar acceso a métodos específicos de la subclase
        if (e1 instanceof Profesor) {
            Profesor p = (Profesor) e1;  // Downcasting seguro
            p.corregirExamenes();
        }

        if (e2 instanceof Administrativo) {
            Administrativo a = (Administrativo) e2;
            a.gestionarDocumentos();
        }
    }
}
