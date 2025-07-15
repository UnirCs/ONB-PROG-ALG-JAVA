package arrays;

public class PalindromoSinBreak {
    public static void main(String[] args) {
        String palabra = "reconocer";
        char[] letras = palabra.toCharArray();
        boolean esPalindromo = true;
        int i = 0;

        while (i < letras.length / 2 && esPalindromo) {
            if (letras[i] != letras[letras.length - 1 - i]) {
                esPalindromo = false;
            }
            i++;
        }

        if (esPalindromo) {
            System.out.println("La palabra \"" + palabra + "\" es un palíndromo.");
        } else {
            System.out.println("La palabra \"" + palabra + "\" no es un palíndromo.");
        }
    }
}


