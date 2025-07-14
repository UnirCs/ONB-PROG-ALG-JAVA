package arrays;

public class MediaTemperaturas {
    public static void main(String[] args) {
        double[] temperaturas = {21.5, 22.0, 19.8, 23.1, 20.0, 18.7, 21.9};
        double suma = 0;

        for (int i = 0; i < temperaturas.length; i++) {
            suma += temperaturas[i];
        }

        double media = suma / temperaturas.length;
        System.out.println("La temperatura media de la semana es: " + media + "°C");
    }
}

