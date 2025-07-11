package control;

public class IfElse {

    public static void main(String[] args) {

        // Estructura if-else simple
        int edad = 20;
        if (edad >= 18) {
            System.out.println("Es mayor de edad.");
        }

        // Estructura if-else anidada
        boolean tieneCarnet = false;
        if (tieneCarnet) {
            System.out.println("Puede conducir.");
        } else {
            System.out.println("No puede conducir.");
        }

        // Estructura if-else con múltiples condiciones
        int nota = 7;
        if (nota >= 9) {
            System.out.println("Sobresaliente");
        } else if (nota >= 7) {
            System.out.println("Notable");
        } else if (nota >= 5) {
            System.out.println("Aprobado");
        } else {
            System.out.println("Suspenso");
        }

    }
}
