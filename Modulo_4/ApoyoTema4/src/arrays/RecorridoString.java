package arrays;

public class RecorridoString {
    public static void main(String[] args) {
        String palabra = "Java";

        for (int i = 0; i < palabra.length(); i++) {
            System.out.println("Carácter en la posición " + i + ": " + palabra.charAt(i));
        }
    }
}

