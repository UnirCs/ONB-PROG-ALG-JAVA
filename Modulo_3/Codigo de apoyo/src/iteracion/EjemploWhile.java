package iteracion;

public class EjemploWhile {
    public static void main(String[] args) {
        int contador = 1;

        System.out.println("Contando del 1 al 5 usando un bucle while:");

        while (contador <= 5) {
            System.out.println("Número: " + contador);
            contador++; // Incrementamos el contador para evitar un bucle infinito
        }
    }
}

