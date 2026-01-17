import java.util.ArrayList;

/**
 * Clase principal que demuestra el uso de herencia y polimorfismo.
 *
 * Este ejercicio demuestra:
 * - Creación de objetos de diferentes subclases
 * - Polimorfismo: tratar diferentes tipos como su clase base
 * - ArrayList con clase base para almacenar diferentes subtipos
 */
public class SistemaEmpleados {

    public static void main(String[] args) {
        // Lista de empleados - puede contener cualquier subtipo de Empleado
        ArrayList<Empleado> empleados = new ArrayList<>();

        // Crear diferentes tipos de empleados
        EmpleadoRegular regular = new EmpleadoRegular("Ana López", "EMP001", 2000);
        Gerente gerente = new Gerente("Carlos Ruiz", "GER001", 3500, 5);
        Desarrollador dev = new Desarrollador("María García", "DEV001", 2800, 10);

        // Agregar a la lista (todos son tratados como Empleado)
        empleados.add(regular);
        empleados.add(gerente);
        empleados.add(dev);

        // Agregar más empleados directamente
        empleados.add(new EmpleadoRegular("Pedro Sánchez", "EMP002", 1800));
        empleados.add(new Desarrollador("Laura Martínez", "DEV002", 3000, 5));

        System.out.println("=== SISTEMA DE GESTIÓN DE EMPLEADOS ===\n");
        System.out.println("Procesando nómina...\n");

        double totalNomina = 0;

        // Polimorfismo en acción:
        // Recorremos todos los empleados y cada uno ejecuta SU versión
        // de los métodos según su tipo real
        for (Empleado emp : empleados) {
            emp.mostrarInformacion();
            System.out.println();
            totalNomina += emp.calcularSalario();
        }

        // Mostrar resumen
        System.out.println("=== RESUMEN DE NÓMINA ===");
        System.out.println("Total empleados: " + empleados.size());
        System.out.printf("Total a pagar: $%.2f%n", totalNomina);

        // Demostrar que podemos seguir accediendo a métodos específicos
        // si conocemos el tipo real
        System.out.println("\n=== INFORMACIÓN ADICIONAL ===");
        for (Empleado emp : empleados) {
            if (emp instanceof Gerente) {
                Gerente g = (Gerente) emp; // Cast para acceder a métodos específicos
                System.out.println(g.getNombre() + " tiene " + g.getEmpleadosACargo() + " empleados a cargo");
            }
        }
    }
}

