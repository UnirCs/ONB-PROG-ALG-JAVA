package vehiculos;

import excepciones.VehiculoAntiguoException;
import interfaces.Combustion;

public class Coche extends Vehiculo implements Combustion {
    public Coche(String marca, int anio) throws VehiculoAntiguoException {
        super(marca, anio);
    }

    @Override
    public void revisar() {
        presentarse();
        cambiarAceite();
        System.out.println("Revisando frenos...");
        for (int i = 0; i < 3; i++) {
            System.out.println("Chequeo rueda " + (i + 1));
        }
    }

    @Override
    public void cambiarAceite() {
        System.out.println("Cambiando aceite del coche...");
    }
}
