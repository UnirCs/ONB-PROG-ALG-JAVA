import java.util.Scanner;

/**
 * Calculadora básica que realiza las cuatro operaciones fundamentales.
 *
 * Este ejercicio demuestra:
 * - Uso de Scanner para entrada de datos
 * - Variables y tipos de datos primitivos
 * - Estructura switch-case
 * - Validación básica (división por cero)
 */
public class Calculadora {

    public static void main(String[] args) {
        // Crear el objeto Scanner para leer entrada del usuario
        Scanner scanner = new Scanner(System.in);

        // Mostrar el menú de opciones
        System.out.println("=== CALCULADORA BÁSICA ===");
        System.out.println("Seleccione una operación:");
        System.out.println("1. Suma");
        System.out.println("2. Resta");
        System.out.println("3. Multiplicación");
        System.out.println("4. División");
        System.out.print("Opción: ");

        // Leer la opción seleccionada
        int opcion = scanner.nextInt();

        // Solicitar los dos números
        System.out.print("\nIngrese el primer número: ");
        double numero1 = scanner.nextDouble();

        System.out.print("Ingrese el segundo número: ");
        double numero2 = scanner.nextDouble();

        // Variable para almacenar el resultado
        double resultado = 0;

        // Realizar la operación según la opción elegida
        switch (opcion) {
            case 1: // Suma
                resultado = numero1 + numero2;
                System.out.println("\nResultado: " + numero1 + " + " + numero2 + " = " + resultado);
                break;

            case 2: // Resta
                resultado = numero1 - numero2;
                System.out.println("\nResultado: " + numero1 + " - " + numero2 + " = " + resultado);
                break;

            case 3: // Multiplicación
                resultado = numero1 * numero2;
                System.out.println("\nResultado: " + numero1 + " * " + numero2 + " = " + resultado);
                break;

            case 4: // División
                // Verificar que no se divida por cero
                if (numero2 != 0) {
                    resultado = numero1 / numero2;
                    System.out.println("\nResultado: " + numero1 + " / " + numero2 + " = " + resultado);
                } else {
                    System.out.println("\nError: No se puede dividir por cero.");
                }
                break;

            default: // Opción no válida
                System.out.println("\nError: Opción no válida. Por favor, seleccione 1, 2, 3 o 4.");
        }

        // Cerrar el Scanner
        scanner.close();
    }
}

