package matrices;

public class MatrizEjemplo {
    public static void main(String[] args) {

        // Ejemplo 1: Creación literal (inicialización directa)
        int[][] matriz = {
                {1, 2},
                {3, 4}
        };

        // Ejemplo 2: Creación dinámica
        int filas = 2;
        int columnas = 3;
        int[][] matrizDinamica = new int[filas][columnas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                matrizDinamica[i][j] = i + j; // Asignación de valores
            }
        }

        // (Opcional) Mostrar la matriz dinámica por consola
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print(matrizDinamica[i][j] + " ");
            }
            System.out.println();
        }
    }
}

