package iteracion.ejemplos;

public class DivisionPorDos {
    public static void main(String[] args) {
        double n = 100; // Puedes cambiar este número
        int contador = 0;

        System.out.println("Divisiones sucesivas de " + n + " entre 2:");

        while (n >= 1) {
            System.out.println("Valor actual: " + n);
            n = n / 2;
            contador++;
        }

        System.out.println("Se realizaron " + contador + " " +
                "divisiones hasta que el valor fue menor que 1.");
    }
}

