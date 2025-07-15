package herencia.interfaces;

public class Robot implements Autonomo, Recargable {
    @Override
    public void ejecutarTarea() {
        System.out.println("El robot está ejecutando una tarea programada.");
    }

    @Override
    public void recargar() {
        System.out.println("El robot se recarga en su estación base.");
    }
}

