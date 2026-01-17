import java.util.Scanner;

/**
 * Clase principal que gestiona el sistema bancario.
 *
 * Este ejercicio demuestra:
 * - Creación de objetos con new
 * - Uso de métodos de un objeto
 * - Interacción con el usuario mediante menú
 */
public class SistemaBancario {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Crear una cuenta bancaria (instanciar un objeto)
        CuentaBancaria cuenta = new CuentaBancaria("Juan García", "001234", 0);

        System.out.println("=== SISTEMA BANCARIO ===");
        System.out.println("Creando cuenta para: " + cuenta.getTitular());
        System.out.println("Número de cuenta: " + cuenta.getNumeroCuenta());

        int opcion;

        do {
            // Mostrar menú
            System.out.println("\n--- MENÚ ---");
            System.out.println("1. Depositar");
            System.out.println("2. Retirar");
            System.out.println("3. Consultar saldo");
            System.out.println("4. Ver información de la cuenta");
            System.out.println("5. Salir");
            System.out.print("Opción: ");

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1: // Depositar
                    System.out.print("\nIngrese cantidad a depositar: ");
                    double deposito = scanner.nextDouble();
                    cuenta.depositar(deposito);
                    System.out.printf("Nuevo saldo: $%.2f%n", cuenta.getSaldo());
                    break;

                case 2: // Retirar
                    System.out.print("\nIngrese cantidad a retirar: ");
                    double retiro = scanner.nextDouble();
                    cuenta.retirar(retiro);
                    System.out.printf("Saldo actual: $%.2f%n", cuenta.getSaldo());
                    break;

                case 3: // Consultar saldo
                    System.out.printf("\nSaldo actual: $%.2f%n", cuenta.getSaldo());
                    break;

                case 4: // Ver información
                    cuenta.mostrarInformacion();
                    break;

                case 5: // Salir
                    System.out.println("\n¡Gracias por usar nuestro sistema bancario!");
                    break;

                default:
                    System.out.println("\nOpción no válida. Por favor, seleccione 1-5.");
            }

        } while (opcion != 5);

        scanner.close();
    }
}

