package control;

public class SwitchCase {
    public static void main(String[] args) {
        int opcion = 2;

        switch (opcion) {
            case 1:
                System.out.println("Has elegido la opción 1: Ver perfil");
                break;
            case 2:
                System.out.println("Has elegido la opción 2: Editar perfil");
                break;
            case 3:
                System.out.println("Has elegido la opción 3: Cerrar sesión");
                break;
            default:
                System.out.println("Opción no válida");
        }
    }
}

