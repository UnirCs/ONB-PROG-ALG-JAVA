/**
 * Clase que representa una cuenta bancaria.
 *
 * Esta clase demuestra:
 * - Encapsulamiento (atributos privados)
 * - Constructor
 * - Métodos getters
 * - Métodos de comportamiento
 */
public class CuentaBancaria {

    // Atributos privados (encapsulamiento)
    private String titular;
    private String numeroCuenta;
    private double saldo;

    /**
     * Constructor de la cuenta bancaria.
     *
     * @param titular Nombre del titular de la cuenta
     * @param numeroCuenta Número identificador de la cuenta
     * @param saldoInicial Saldo inicial de la cuenta
     */
    public CuentaBancaria(String titular, String numeroCuenta, double saldoInicial) {
        this.titular = titular;
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldoInicial;
    }

    // ==================== GETTERS ====================

    public String getTitular() {
        return titular;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    // ==================== MÉTODOS DE COMPORTAMIENTO ====================

    /**
     * Deposita una cantidad de dinero en la cuenta.
     *
     * @param cantidad Cantidad a depositar (debe ser positiva)
     */
    public void depositar(double cantidad) {
        if (cantidad > 0) {
            saldo += cantidad;
            System.out.println("Depósito realizado con éxito.");
        } else {
            System.out.println("Error: La cantidad debe ser positiva.");
        }
    }

    /**
     * Retira una cantidad de dinero de la cuenta.
     *
     * @param cantidad Cantidad a retirar
     * @return true si el retiro fue exitoso, false si no había fondos suficientes
     */
    public boolean retirar(double cantidad) {
        if (cantidad <= 0) {
            System.out.println("Error: La cantidad debe ser positiva.");
            return false;
        }

        if (cantidad > saldo) {
            System.out.printf("Error: Fondos insuficientes. Saldo disponible: $%.2f%n", saldo);
            return false;
        }

        saldo -= cantidad;
        System.out.println("Retiro realizado con éxito.");
        return true;
    }

    /**
     * Muestra toda la información de la cuenta.
     */
    public void mostrarInformacion() {
        System.out.println("\n=== INFORMACIÓN DE LA CUENTA ===");
        System.out.println("Titular: " + titular);
        System.out.println("Número de cuenta: " + numeroCuenta);
        System.out.printf("Saldo: $%.2f%n", saldo);
    }
}

