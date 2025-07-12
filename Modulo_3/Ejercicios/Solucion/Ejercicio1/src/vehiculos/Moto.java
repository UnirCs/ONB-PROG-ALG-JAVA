package vehiculos;

import excepciones.VehiculoAntiguoException;
import interfaces.Combustion;

public class Moto extends Vehiculo implements Combustion {
    public Moto(String marca, int anio) throws VehiculoAntiguoException {
        super(marca, anio);
    }

    @Override
    public void revisar() {
        presentarse();
        cambiarAceite();
        int nivelAceite = 3;
        while (nivelAceite > 0) {
            System.out.println("Drenando aceite restante... " + nivelAceite + "L");
            nivelAceite--;
        }
    }

    @Override
    public void cambiarAceite() {
        System.out.println("Cambiando aceite de la moto...");
    }
}
