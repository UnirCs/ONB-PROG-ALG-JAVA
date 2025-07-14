package arrays;

public class RecorridoStringComoArray {
    public static void main(String[] args) {
        String texto = "Programar";
        char[] caracteres = texto.toCharArray();

        for (int i = 0; i < caracteres.length; i++) {
            System.out.println("Carácter en la posición " + i + ": " + caracteres[i]);
        }
    }
}

