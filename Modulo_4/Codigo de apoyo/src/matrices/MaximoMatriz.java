package matrices;

public class MaximoMatriz {
    public static void main(String[] args) {

        // Declaración e inicialización de la matriz
        int[][] matrizValores = {
                {10, 25, 7},
                {18, 2, 30}
        };

        // Inicialización del valor máximo con el primer elemento de la matriz
        int maximo = matrizValores[0][0];

        // Búsqueda del valor máximo
        for (int i = 0; i < matrizValores.length; i++) {
            for (int j = 0; j < matrizValores[i].length; j++) {
                if (matrizValores[i][j] > maximo) {
                    maximo = matrizValores[i][j];
                }
            }
        }

        // Mostrar el resultado
        System.out.println("El valor máximo es: " + maximo);
    }
}

