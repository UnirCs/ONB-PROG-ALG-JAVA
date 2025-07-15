package tiposDeDatos;

public class Coche {
    // Atributos (también llamados propiedades o campos)
    private String marca;
    private String modelo;
    private int anio;
    private String color;

    /**
     * Constructor: se usa para crear instancias de la clase.
     * Permite inicializar los atributos del objeto.
     */
    public Coche(String marca, String modelo, int anio, String color) {
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.color = color;
    }

    // Métodos getter: permiten leer el valor de un atributo
    public String getMarca() {
        return marca;
    }

    // Métodos setter: permiten modificar el valor de un atributo
    public void setMarca(String marca) {
        this.marca = marca;
    }
}

