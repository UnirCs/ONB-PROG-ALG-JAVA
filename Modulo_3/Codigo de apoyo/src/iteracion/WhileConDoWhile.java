package iteracion;

public class WhileConDoWhile {
    public static void main(String[] args) {
        int valor1 = 5;

        System.out.println("Ejemplo con bucle WHILE:");
        while (valor1 < 5) {
            System.out.println("Valor1 es: " + valor1);
            valor1++;
        }

        int valor2 = 5;

        System.out.println("\nEjemplo con bucle DO-WHILE:");
        do {
            System.out.println("Valor2 es: " + valor2);
            valor2++;
        } while (valor2 < 5);
    }
}

