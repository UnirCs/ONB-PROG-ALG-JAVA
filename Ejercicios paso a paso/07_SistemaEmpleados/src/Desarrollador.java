/**
 * Desarrollador: recibe un bono por horas extra trabajadas.
 *
 * Demuestra:
 * - Atributos adicionales en clase hija
 * - Cálculo de bonos basado en horas
 */
public class Desarrollador extends Empleado {

    // Atributo específico del desarrollador
    private int horasExtra;

    // Constante: $25 por cada hora extra
    private static final double TARIFA_HORA_EXTRA = 25.0;

    /**
     * Constructor del desarrollador.
     */
    public Desarrollador(String nombre, String id, double salarioBase, int horasExtra) {
        super(nombre, id, salarioBase);
        this.horasExtra = horasExtra;
    }

    public int getHorasExtra() {
        return horasExtra;
    }

    /**
     * Calcula el salario incluyendo el bono por horas extra.
     */
    @Override
    public double calcularSalario() {
        double bonoHorasExtra = horasExtra * TARIFA_HORA_EXTRA;
        return salarioBase + bonoHorasExtra;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("--- Desarrollador ---");
        super.mostrarInformacion();
        System.out.println("Horas extra: " + horasExtra);
        System.out.printf("Bono por horas extra: $%.2f%n", horasExtra * TARIFA_HORA_EXTRA);
        System.out.printf("Salario Total: $%.2f%n", calcularSalario());
    }
}

