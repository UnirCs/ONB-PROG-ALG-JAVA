package iteracion.ejemplos;

public class SumaNumerosNaturales {
    public static void main(String[] args) {
        int N = 10; // Puedes cambiar este valor según necesites
        int suma = 0;

        for (int i = 1; i <= N; i++) {
            suma += i;
        }

        System.out.println("La suma de los primeros "
                + N + " números naturales es: " + suma);
    }
}
