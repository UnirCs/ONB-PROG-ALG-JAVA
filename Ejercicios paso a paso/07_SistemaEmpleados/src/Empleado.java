/**
 * Clase abstracta base para todos los tipos de empleados.
 *
 * Esta clase demuestra:
 * - Clases abstractas
 * - Métodos abstractos
 * - Modificador protected
 */
public abstract class Empleado {

    // Atributos protegidos: accesibles por las clases hijas
    protected String nombre;
    protected String id;
    protected double salarioBase;

    /**
     * Constructor de la clase base.
     * Las clases hijas deben llamar a este constructor con super().
     */
    public Empleado(String nombre, String id, double salarioBase) {
        this.nombre = nombre;
        this.id = id;
        this.salarioBase = salarioBase;
    }

    // ==================== GETTERS ====================

    public String getNombre() {
        return nombre;
    }

    public String getId() {
        return id;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    // ==================== MÉTODOS ====================

    /**
     * Método abstracto: cada tipo de empleado debe implementar
     * su propia forma de calcular el salario.
     *
     * @return El salario total calculado
     */
    public abstract double calcularSalario();

    /**
     * Muestra la información básica del empleado.
     * Las clases hijas pueden extender este método.
     */
    public void mostrarInformacion() {
        System.out.println("Nombre: " + nombre);
        System.out.println("ID: " + id);
        System.out.printf("Salario Base: $%.2f%n", salarioBase);
    }
}

