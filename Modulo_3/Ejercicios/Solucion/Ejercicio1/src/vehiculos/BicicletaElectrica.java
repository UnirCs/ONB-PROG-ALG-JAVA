package vehiculos;

import excepciones.VehiculoAntiguoException;
import interfaces.Electrico;

public class BicicletaElectrica extends Vehiculo implements Electrico {
    public BicicletaElectrica(String marca, int anio) throws VehiculoAntiguoException {
        super(marca, anio);
    }

    @Override
    public void revisar() {
        presentarse();
        recargarBateria();
        for (int i = 1; i <= 2; i++) {
            System.out.println("Chequeo electrónico módulo " + i);
        }
    }

    @Override
    public void recargarBateria() {
        System.out.println("Recargando batería de la bicicleta...");
    }
}
