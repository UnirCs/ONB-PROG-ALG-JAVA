import java.util.Scanner;

/**
 * Validador de contraseñas que verifica los requisitos de seguridad.
 *
 * Este ejercicio demuestra:
 * - Manipulación de Strings
 * - Uso de bucles for para recorrer caracteres
 * - Métodos de la clase Character
 * - Uso de banderas booleanas para validación
 */
public class ValidadorContrasenas {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Mostrar título y solicitar contraseña
        System.out.println("=== VALIDADOR DE CONTRASEÑAS ===");
        System.out.print("Ingrese una contraseña para validar: ");
        String contrasena = scanner.nextLine();

        // Verificar longitud mínima (8 caracteres)
        boolean longitudValida = contrasena.length() >= 8;

        // Inicializar banderas para los demás requisitos
        boolean tieneMayuscula = false;
        boolean tieneMinuscula = false;
        boolean tieneDigito = false;

        // Recorrer la contraseña carácter por carácter
        for (int i = 0; i < contrasena.length(); i++) {
            char c = contrasena.charAt(i);

            // Verificar si es mayúscula
            if (Character.isUpperCase(c)) {
                tieneMayuscula = true;
            }

            // Verificar si es minúscula
            if (Character.isLowerCase(c)) {
                tieneMinuscula = true;
            }

            // Verificar si es dígito
            if (Character.isDigit(c)) {
                tieneDigito = true;
            }
        }

        // Determinar si la contraseña cumple todos los requisitos
        boolean esValida = longitudValida && tieneMayuscula && tieneMinuscula && tieneDigito;

        // Mostrar resultado
        if (esValida) {
            System.out.println("\n✓ La contraseña es válida y cumple todos los requisitos.");
        } else {
            System.out.println("\n✗ La contraseña NO es válida. Problemas encontrados:");

            if (!longitudValida) {
                System.out.println("  - Debe tener al menos 8 caracteres (tiene " + contrasena.length() + ")");
            }
            if (!tieneMayuscula) {
                System.out.println("  - Debe contener al menos una letra mayúscula");
            }
            if (!tieneMinuscula) {
                System.out.println("  - Debe contener al menos una letra minúscula");
            }
            if (!tieneDigito) {
                System.out.println("  - Debe contener al menos un dígito numérico");
            }
        }

        scanner.close();
    }
}

