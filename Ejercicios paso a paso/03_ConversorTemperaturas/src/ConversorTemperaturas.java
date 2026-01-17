import java.util.Scanner;

/**
 * Conversor de temperaturas entre diferentes unidades.
 *
 * Este ejercicio demuestra:
 * - Definición y uso de métodos
 * - Parámetros y valores de retorno
 * - Bucle do-while
 * - Formateo de salida con printf
 */
public class ConversorTemperaturas {

    /**
     * Convierte temperatura de Celsius a Fahrenheit.
     * Fórmula: F = (C × 9/5) + 32
     */
    public static double celsiusAFahrenheit(double celsius) {
        return (celsius * 9.0 / 5.0) + 32;
    }

    /**
     * Convierte temperatura de Fahrenheit a Celsius.
     * Fórmula: C = (F - 32) × 5/9
     */
    public static double fahrenheitACelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5.0 / 9.0;
    }

    /**
     * Convierte temperatura de Celsius a Kelvin.
     * Fórmula: K = C + 273.15
     */
    public static double celsiusAKelvin(double celsius) {
        return celsius + 273.15;
    }

    /**
     * Convierte temperatura de Kelvin a Celsius.
     * Fórmula: C = K - 273.15
     */
    public static double kelvinACelsius(double kelvin) {
        return kelvin - 273.15;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String continuar;

        System.out.println("=== CONVERSOR DE TEMPERATURAS ===");

        do {
            // Mostrar menú de opciones
            System.out.println("\nSeleccione el tipo de conversión:");
            System.out.println("1. Celsius → Fahrenheit");
            System.out.println("2. Fahrenheit → Celsius");
            System.out.println("3. Celsius → Kelvin");
            System.out.println("4. Kelvin → Celsius");
            System.out.println("5. Salir");
            System.out.print("Opción: ");

            int opcion = scanner.nextInt();

            // Si elige salir, terminar el bucle
            if (opcion == 5) {
                System.out.println("\n¡Hasta luego!");
                break;
            }

            double temperatura, resultado;

            switch (opcion) {
                case 1: // Celsius a Fahrenheit
                    System.out.print("\nIngrese la temperatura en Celsius: ");
                    temperatura = scanner.nextDouble();
                    resultado = celsiusAFahrenheit(temperatura);
                    System.out.printf("Resultado: %.2f°C = %.2f°F%n", temperatura, resultado);
                    break;

                case 2: // Fahrenheit a Celsius
                    System.out.print("\nIngrese la temperatura en Fahrenheit: ");
                    temperatura = scanner.nextDouble();
                    resultado = fahrenheitACelsius(temperatura);
                    System.out.printf("Resultado: %.2f°F = %.2f°C%n", temperatura, resultado);
                    break;

                case 3: // Celsius a Kelvin
                    System.out.print("\nIngrese la temperatura en Celsius: ");
                    temperatura = scanner.nextDouble();
                    resultado = celsiusAKelvin(temperatura);
                    System.out.printf("Resultado: %.2f°C = %.2fK%n", temperatura, resultado);
                    break;

                case 4: // Kelvin a Celsius
                    System.out.print("\nIngrese la temperatura en Kelvin: ");
                    temperatura = scanner.nextDouble();
                    resultado = kelvinACelsius(temperatura);
                    System.out.printf("Resultado: %.2fK = %.2f°C%n", temperatura, resultado);
                    break;

                default:
                    System.out.println("\nOpción no válida. Por favor, seleccione 1-5.");
            }

            // Preguntar si desea continuar
            scanner.nextLine(); // Limpiar buffer
            System.out.print("\n¿Desea realizar otra conversión? (s/n): ");
            continuar = scanner.nextLine();

        } while (continuar.equalsIgnoreCase("s"));

        if (!continuar.equalsIgnoreCase("s")) {
            System.out.println("\n¡Gracias por usar el conversor!");
        }

        scanner.close();
    }
}

