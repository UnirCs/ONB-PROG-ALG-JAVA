package operadores;

public class OperadoresLogicos {
    public static void main(String[] args) {
        int edad = 25;
        boolean tieneCarnet = true;
        boolean tieneMultasPendientes = false;

        // Ejemplo con AND: ambas condiciones deben ser verdaderas
        if (edad >= 18 && tieneCarnet) {
            System.out.println("Puede conducir legalmente.");
        } else {
            System.out.println("No cumple con los requisitos para conducir.");
        }

        // Ejemplo con OR: basta con que una condición sea verdadera
        if (tieneMultasPendientes || edad < 18) {
            System.out.println("No puede renovar el carnet.");
        } else {
            System.out.println("Puede renovar el carnet.");
        }
    }
}

