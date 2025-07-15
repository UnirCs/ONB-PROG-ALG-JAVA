package lambda;

@FunctionalInterface
interface Operacion {
    int aplicar(int a, int b);
}

public class LambdaEjemplo1 {
    public static void main(String[] args) {
        Operacion suma = (a, b) -> a + b;
        Operacion producto = (a, b) -> a * b;

        System.out.println("Suma: " + suma.aplicar(4, 5));
        System.out.println("Producto: " + producto.aplicar(4, 5));
    }
}

