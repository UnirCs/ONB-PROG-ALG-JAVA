package operadores;

public class OperadoresAritmeticos {
    public static void main(String[] args) {
        int a = 15;
        int b = 4;

        System.out.println("Operaciones aritméticas básicas:");
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println();

        // Suma
        int suma = a + b;
        System.out.println("a + b = " + suma); // 19

        // Resta
        int resta = a - b;
        System.out.println("a - b = " + resta); // 11

        // Multiplicación
        int multiplicacion = a * b;
        System.out.println("a * b = " + multiplicacion); // 60

        // División
        int division = a / b;
        System.out.println("a / b = " + division); // 3 (división entera)

        // Módulo
        int modulo = a % b;
        System.out.println("a % b = " + modulo); // 3

        // Incremento
        int x = 5;
        System.out.println("\nValor original de x: " + x);
        x++;
        System.out.println("Después de x++: " + x); // 6
        ++x;
        System.out.println("Después de ++x: " + x); // 7

        // Decremento
        int y = 10;
        System.out.println("\nValor original de y: " + y);
        y--;
        System.out.println("Después de y--: " + y); // 9
        --y;
        System.out.println("Después de --y: " + y); // 8
    }
}

