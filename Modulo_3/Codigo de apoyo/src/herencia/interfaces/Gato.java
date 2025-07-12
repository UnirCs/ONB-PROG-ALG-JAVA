package herencia.interfaces;

public class Gato implements Autonomo, Rastreable {
    @Override
    public void ejecutarTarea() {
        System.out.println("El gato está cazando sin instrucciones.");
    }

    @Override
    public String obtenerUbicacion() {
        return "Ubicación desconocida: el gato es impredecible.";
    }
}

