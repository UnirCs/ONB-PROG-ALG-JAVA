package herencia.interfaces;

public class Drone implements Volador, Recargable, Rastreable {
    @Override
    public void volar() {
        System.out.println("El dron está volando con rotores.");
    }

    @Override
    public void recargar() {
        System.out.println("El dron se está recargando vía USB.");
    }

    @Override
    public String obtenerUbicacion() {
        return "Latitud: 40.4168, Longitud: -3.7038";
    }
}

