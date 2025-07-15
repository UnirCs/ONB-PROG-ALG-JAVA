package matrices;

public class SumaMatriz {
    public static void main(String[] args) {

        // Declaración e inicialización de la matriz
        int[][] matrizNumeros = {
                {2, 4, 6},
                {1, 3, 5}
        };

        int sumaTotal = 0;

        // Recorrido de la matriz para calcular la suma total
        for (int i = 0; i < matrizNumeros.length; i++) {
            for (int j = 0; j < matrizNumeros[i].length; j++) {
                sumaTotal += matrizNumeros[i][j];
            }
        }

        // Mostrar el resultado
        System.out.println("La suma total es: " + sumaTotal);
    }
}

