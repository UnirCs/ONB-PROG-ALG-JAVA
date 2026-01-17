/**
 * Gerente: recibe un bono por cada empleado a su cargo.
 *
 * Demuestra:
 * - Atributos adicionales en clase hija
 * - Constantes de clase (static final)
 * - Cálculo personalizado de salario
 */
public class Gerente extends Empleado {

    // Atributo específico del gerente
    private int empleadosACargo;

    // Constante: $100 de bono por cada empleado a cargo
    private static final double BONO_POR_EMPLEADO = 100.0;

    /**
     * Constructor del gerente.
     */
    public Gerente(String nombre, String id, double salarioBase, int empleadosACargo) {
        super(nombre, id, salarioBase);
        this.empleadosACargo = empleadosACargo;
    }

    public int getEmpleadosACargo() {
        return empleadosACargo;
    }

    /**
     * Calcula el salario incluyendo el bono por equipo.
     */
    @Override
    public double calcularSalario() {
        double bonoEquipo = empleadosACargo * BONO_POR_EMPLEADO;
        return salarioBase + bonoEquipo;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("--- Gerente ---");
        super.mostrarInformacion();
        System.out.println("Empleados a cargo: " + empleadosACargo);
        System.out.printf("Bono por equipo: $%.2f%n", empleadosACargo * BONO_POR_EMPLEADO);
        System.out.printf("Salario Total: $%.2f%n", calcularSalario());
    }
}

