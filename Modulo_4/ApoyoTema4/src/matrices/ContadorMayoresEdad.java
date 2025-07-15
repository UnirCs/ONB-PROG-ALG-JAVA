package matrices;

public class ContadorMayoresEdad {
    public static void main(String[] args) {

        // Declaración e inicialización de la matriz
        int[][] matrizEdades = {
                {18, 22, 16},
                {40, 17, 21}
        };

        int contadorMayores = 0;

        // Recorrer la matriz y contar mayores de edad (>= 18)
        for (int i = 0; i < matrizEdades.length; i++) {
            for (int j = 0; j < matrizEdades[i].length; j++) {
                if (matrizEdades[i][j] >= 18) {
                    contadorMayores++;
                }
            }
        }

        // Mostrar el resultado
        System.out.println("Número de mayores de edad: " + contadorMayores);
    }
}

