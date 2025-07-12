package vehiculos;

import excepciones.VehiculoAntiguoException;

public abstract class Vehiculo {
    protected String marca;
    protected int anio;

    public Vehiculo(String marca, int anio) throws VehiculoAntiguoException {
        if (anio < 2000) {
            throw new VehiculoAntiguoException("Vehículo demasiado antiguo: " + marca);
        }
        this.marca = marca;
        this.anio = anio;
    }

    public abstract void revisar();

    public void presentarse() {
        System.out.println("Vehículo: " + marca + " (" + anio + ")");
    }

    public int getAnio() {
        return anio;
    }
}
