package iteracion.ejemplos;

public class MultiplosDeTres {

    public static void main(String[] args) {

        int n = 100; // Definimos el límite hasta donde queremos contar los múltiplos de 3

        int contadorFor = 0;
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0) {
                contadorFor++;
            }
        }

        System.out.println("Total de múltiplos de 3 entre 1 y " + n + " (usando for): " + contadorFor);

        //Lo mismo, pero con un bucle while
        int contadorWhile = 0;
        int j = 1;
        while (j <= n) {
            if (j % 3 == 0) {
                contadorWhile++;
            }
            j++;
        }

        System.out.println("Total de múltiplos de 3 entre 1 y " + n + " (usando while): " + contadorWhile);
    }
}
