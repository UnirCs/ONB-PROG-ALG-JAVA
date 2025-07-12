public class Funciones {

    public static void main(String[] args) {

        // Ejemplo de uso de las funciones
        System.out.println("¿Es 4 par? " + esPar(4));
        System.out.println("Área del círculo con radio 5: " + calcularAreaCirculo(5));
        System.out.println("Factorial de 5: " + calcularFactorial(5));
        System.out.println("¿Es 7 primo? " + esPrimo(7));
        System.out.println("Suma de los primeros 100 números pares: " + sumaPrimeros100Pares());
        System.out.println("Fibonacci hasta 21: ");
        generarFibonacci(21);

    }
    // 1. Saber si un número es par o impar
    public static boolean esPar(int numero) {
        return numero % 2 == 0;
    }

    // 2. Calcular el área de un círculo
    public static double calcularAreaCirculo(double radio) {
        return Math.PI * radio * radio;
    }

    // 3. Calcular el factorial de un número
    public static long calcularFactorial(int numero) {
        long resultado = 1;
        for (int i = 2; i <= numero; i++) {
            resultado *= i;
        }
        return resultado;
    }

    // 4. Comprobar si un número es primo
    public static boolean esPrimo(int numero) {
        if (numero <= 1) return false;

        //Atencion, dejamos de iterar cuando i es mayor que la raiz cuadrada del numero
        //Preguntate por qué... ¿tendria sentido iterar hasta el numero recibido?
        for (int i = 2; i <= Math.sqrt(numero); i++) {
            if (numero % i == 0) return false;
        }
        return true;
    }

    // 5. Suma de los 100 primeros números pares
    public static int sumaPrimeros100Pares() {
        int suma = 0;
        int contador = 0;
        int numero = 0;
        while (contador < 100) {
            if (esPar(numero)) {
                suma += numero;
                contador++;
            }
            numero++;
        }
        return suma;
    }

    // 6. Generar una secuencia de Fibonacci hasta un límite
    public static void generarFibonacci(int limite) {
        int a = 0, b = 1; //Definicion multiple: dos variables en una sola linea
        while (a <= limite) {
            System.out.print(a);
            int temp = a + b;
            a = b;
            b = temp;
        }
    }
}