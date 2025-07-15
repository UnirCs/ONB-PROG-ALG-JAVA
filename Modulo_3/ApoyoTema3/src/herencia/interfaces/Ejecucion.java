package herencia.interfaces;

public class Ejecucion {
    public static void main(String[] args) {
        // Instancias
        Drone d = new Drone();
        Gato g = new Gato();
        Avion a = new Avion();
        Robot r = new Robot();

        System.out.println("--- Capacidad de volar ---");
        Volador[] voladores = { d, a };
        for (Volador v : voladores) {
            v.volar();
        }

        System.out.println("\n--- Capacidad autónoma ---");
        Autonomo[] autonomos = { g, r };
        for (Autonomo au : autonomos) {
            au.ejecutarTarea();
        }

        System.out.println("\n--- Dispositivos recargables ---");
        Recargable[] recargables = { d, r };
        for (Recargable re : recargables) {
            re.recargar();
        }

        System.out.println("\n--- Ubicación rastreable ---");
        Rastreable[] rastreables = { d, g };
        for (Rastreable rs : rastreables) {
            System.out.println("Ubicación: " + rs.obtenerUbicacion());
        }
    }
}

