import excepciones.VehiculoAntiguoException;
import vehiculos.BicicletaElectrica;
import vehiculos.Coche;
import vehiculos.Moto;
import vehiculos.Vehiculo;

public class Ejecucion {
    public static void main(String[] args) {
        try {
            Vehiculo v1 = new Coche("Toyota", 2015);
            Vehiculo v2 = new Moto("Yamaha", 2005);
            Vehiculo v3 = new BicicletaElectrica("Xiaomi", 2021);

            revisarVehiculo(v1);
            revisarVehiculo(v2);
            revisarVehiculo(v3);

        } catch (VehiculoAntiguoException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    // Función para revisar el vehículo y aplicar lógica condicional
    public static void revisarVehiculo(Vehiculo v) {
        System.out.println("\nIniciando revisión...");
        v.revisar();

        // Control de flujo con tipos de datos
        int edad = 2025 - v.getAnio();
        if (edad < 5) {
            System.out.println("Vehículo en buen estado.");
        } else if (edad <= 10) {
            System.out.println("Requiere revisión intermedia.");
        } else {
            System.out.println("Revisión completa recomendada.");
        }
    }
}
