package arrays;

public class Soluciones {
    // 1. Suma de elementos
    public static int sumaElementos(int[] arr) {
        int suma = 0;
        for (int n : arr) suma += n;
        return suma;
    }

    // 2. Buscar un elemento
    public static boolean contiene(String[] arr, String palabra) {
        for (String s : arr) {
            if (s.equals(palabra)) return true;
        }
        return false;
    }

    // 3. Invertir un array
    public static int[] invertir(int[] arr) {
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[arr.length - 1 - i];
        }
        return res;
    }

    // 4. Encontrar el valor máximo
    public static int maximo(int[] arr) {
        if (arr.length == 0) throw new IllegalArgumentException("Array vacío");
        int max = arr[0];
        for (int n : arr) {
            if (n > max) max = n;
        }
        return max;
    }

    // 5. Contar elementos pares
    public static int contarPares(int[] arr) {
        int count = 0;
        for (int n : arr) {
            if (n % 2 == 0) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] numeros = {1, 2, 3, 4, 5, 6};
        String[] palabras = {"hola", "mundo", "java", "arrays"};

        System.out.println("Suma de elementos: " + sumaElementos(numeros));
        System.out.println("Contiene 'java': " + contiene(palabras, "java"));
        System.out.print("Array invertido: ");
        int[] invertido = invertir(numeros);
        for (int n : invertido) System.out.print(n + " ");
        System.out.println();
        System.out.println("Valor máximo: " + maximo(numeros));
        System.out.println("Cantidad de pares: " + contarPares(numeros));
    }
}