package herencia.interfaces;

public class Avion implements Volador {
    @Override
    public void volar() {
        System.out.println("El avión vuela a gran altitud.");
    }
}

