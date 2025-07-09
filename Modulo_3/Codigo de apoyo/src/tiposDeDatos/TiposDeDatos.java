package tiposDeDatos;

public class TiposDeDatos {
    public static void main(String[] args) {
        // Tipos de datos primitivos
        int edad = 25;
        double altura = 1.82;
        float temperatura = 36.6f;
        boolean esEstudiante = true;
        char inicial = 'J';

        System.out.println("Ejemplo de tipos de datos primitivos:");
        System.out.println("Edad (int): " + edad);
        System.out.println("Altura (double): " + altura);
        System.out.println("Temperatura corporal (float): " + temperatura);
        System.out.println("¿Es estudiante? (boolean): " + esEstudiante);
        System.out.println("Inicial del nombre (char): " + inicial);
        System.out.println();

        // Tipos de datos no primitivos: objetos
        // Creamos un objeto de tipo Coche
        Coche miCoche = new Coche("Toyota", "Corolla", 2022, "Rojo");

        // Mostramos sus atributos usando getters
        System.out.println("Ejemplo de tipo de dato no primitivo (objeto):");
        System.out.println("Marca del coche: " + miCoche.getMarca());

        // Modificamos un valor usando un setter
        miCoche.setMarca("Azul");
        System.out.println("Color modificado del coche: " + miCoche.getMarca());



        int a = 10;
        int b = a;
        b = 20;
        System.out.println("a = " + a); // Imprime: a = 10
        System.out.println("b = " + b); // Imprime: b = 20


        Coche coche1 = new Coche("Toyota", "Yaris", 2020, "Negro");
        Coche coche2 = coche1;

        coche2.setMarca("Blanco");

        System.out.println("Color de coche1: " + coche1.getMarca()); // Imprime: Blanco
        System.out.println("Color de coche2: " + coche2.getMarca()); // Imprime: Blanco

    }
}

