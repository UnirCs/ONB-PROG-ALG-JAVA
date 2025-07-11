package operadores;

public class OperadoresRelacionales {
    public static void main(String[] args) {
        int x = 10;
        int y = 20;

        System.out.println("Comparaciones entre x = " + x + " e y = " + y);
        System.out.println();

        // Operador de igualdad
        boolean esIgual = (x == y);
        System.out.println("x == y: " + esIgual); // false

        // Operador de desigualdad
        boolean esDistinto = (x != y);
        System.out.println("x != y: " + esDistinto); // true

        // Operador mayor que
        boolean esMayor = (x > y);
        System.out.println("x > y: " + esMayor); // false

        // Operador menor que
        boolean esMenor = (x < y);
        System.out.println("x < y: " + esMenor); // true

        // Operador mayor o igual que
        boolean esMayorIgual = (x >= y);
        System.out.println("x >= y: " + esMayorIgual); // false

        // Operador menor o igual que
        boolean esMenorIgual = (x <= y);
        System.out.println("x <= y: " + esMenorIgual); // true
    }
}

