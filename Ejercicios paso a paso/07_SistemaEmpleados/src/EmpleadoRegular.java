/**
 * Empleado regular sin bonificaciones adicionales.
 *
 * Demuestra la implementación más simple de herencia.
 */
public class EmpleadoRegular extends Empleado {

    /**
     * Constructor que llama al constructor del padre.
     */
    public EmpleadoRegular(String nombre, String id, double salarioBase) {
        super(nombre, id, salarioBase); // Llamada al constructor de Empleado
    }

    /**
     * Implementación del método abstracto.
     * El empleado regular recibe solo su salario base.
     */
    @Override
    public double calcularSalario() {
        return salarioBase;
    }

    /**
     * Sobreescribe el método para mostrar información específica.
     */
    @Override
    public void mostrarInformacion() {
        System.out.println("--- Empleado Regular ---");
        super.mostrarInformacion(); // Llama al método del padre
        System.out.printf("Salario Total: $%.2f%n", calcularSalario());
    }
}

