import java.util.Scanner;

/**
 * Sistema de registro de calificaciones de estudiantes.
 *
 * Este ejercicio demuestra:
 * - Declaración y uso de arrays
 * - Recorrido de arrays con bucles for
 * - Algoritmos de búsqueda (máximo/mínimo)
 * - Algoritmo de ordenamiento burbuja
 * - Paso de arrays a métodos
 */
public class RegistroCalificaciones {

    /**
     * Encuentra la calificación más alta del array.
     */
    public static double encontrarMaximo(double[] notas) {
        double maximo = notas[0];

        for (int i = 1; i < notas.length; i++) {
            if (notas[i] > maximo) {
                maximo = notas[i];
            }
        }

        return maximo;
    }

    /**
     * Encuentra la calificación más baja del array.
     */
    public static double encontrarMinimo(double[] notas) {
        double minimo = notas[0];

        for (int i = 1; i < notas.length; i++) {
            if (notas[i] < minimo) {
                minimo = notas[i];
            }
        }

        return minimo;
    }

    /**
     * Calcula el promedio de todas las calificaciones.
     */
    public static double calcularPromedio(double[] notas) {
        double suma = 0;

        for (int i = 0; i < notas.length; i++) {
            suma += notas[i];
        }

        return suma / notas.length;
    }

    /**
     * Cuenta cuántos estudiantes aprobaron (calificación >= 6).
     */
    public static int contarAprobados(double[] notas) {
        int contador = 0;

        for (int i = 0; i < notas.length; i++) {
            if (notas[i] >= 6) {
                contador++;
            }
        }

        return contador;
    }

    /**
     * Ordena el array de menor a mayor usando el algoritmo burbuja.
     * Nota: Este método MODIFICA el array original.
     */
    public static void ordenarBurbuja(double[] notas) {
        int n = notas.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                // Si el elemento actual es mayor que el siguiente, intercambiar
                if (notas[j] > notas[j + 1]) {
                    double temp = notas[j];
                    notas[j] = notas[j + 1];
                    notas[j + 1] = temp;
                }
            }
        }
    }

    /**
     * Convierte un array a String para mostrarlo de forma legible.
     */
    public static String arrayToString(double[] notas) {
        StringBuilder sb = new StringBuilder("[");

        for (int i = 0; i < notas.length; i++) {
            sb.append(notas[i]);
            if (i < notas.length - 1) {
                sb.append(", ");
            }
        }

        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== REGISTRO DE CALIFICACIONES ===\n");

        // Solicitar cantidad de estudiantes
        System.out.print("¿Cuántos estudiantes tiene la clase? ");
        int cantidad = scanner.nextInt();

        // Crear el array para almacenar las calificaciones
        double[] calificaciones = new double[cantidad];

        // Leer las calificaciones de cada estudiante
        System.out.println();
        for (int i = 0; i < calificaciones.length; i++) {
            System.out.print("Ingrese la calificación del estudiante " + (i + 1) + ": ");
            calificaciones[i] = scanner.nextDouble();
        }

        // Mostrar las calificaciones ingresadas
        System.out.println("\n=== RESULTADOS ===");
        System.out.println("Calificaciones: " + arrayToString(calificaciones));

        // Calcular y mostrar estadísticas
        System.out.println("Calificación más alta: " + encontrarMaximo(calificaciones));
        System.out.println("Calificación más baja: " + encontrarMinimo(calificaciones));
        System.out.printf("Promedio de la clase: %.1f%n", calcularPromedio(calificaciones));

        // Contar aprobados y reprobados
        int aprobados = contarAprobados(calificaciones);
        int reprobados = calificaciones.length - aprobados;
        System.out.println("Aprobados: " + aprobados);
        System.out.println("Reprobados: " + reprobados);

        // Ordenar y mostrar las calificaciones ordenadas
        ordenarBurbuja(calificaciones);
        System.out.println("\nCalificaciones ordenadas: " + arrayToString(calificaciones));

        scanner.close();
    }
}

