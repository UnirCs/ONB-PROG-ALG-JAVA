package funciones;

public class AreasPoligonos {

    // Método para calcular el área de un cuadrado
    public static double areaCuadrado(double lado) {
        return lado * lado;
    }

    // Método para calcular el área de un rectángulo
    public static double areaRectangulo(double base, double altura) {
        return base * altura;
    }

    // Método para calcular el área de un triángulo
    public static double areaTriangulo(double base, double altura) {
        return (base * altura) / 2;
    }

    // Método para calcular el área de un círculo
    public static double areaCirculo(double radio) {
        return Math.PI * radio * radio;
    }

    // Método principal
    public static void main(String[] args) {
        System.out.println("Cálculo de áreas de polígonos:");

        // Cuadrados
        double cuadrado1 = areaCuadrado(4);
        double cuadrado2 = areaCuadrado(6.5);
        System.out.println("Área de cuadrado de lado 4: " + cuadrado1);
        System.out.println("Área de cuadrado de lado 6.5: " + cuadrado2);

        // Rectángulos
        double rectangulo1 = areaRectangulo(5, 3);
        double rectangulo2 = areaRectangulo(10, 2.5);
        System.out.println("Área de rectángulo 5x3: " + rectangulo1);
        System.out.println("Área de rectángulo 10x2.5: " + rectangulo2);

        // Triángulos
        double triangulo1 = areaTriangulo(6, 2);
        double triangulo2 = areaTriangulo(8.5, 3.3);
        System.out.println("Área de triángulo base 6 altura 2: " + triangulo1);
        System.out.println("Área de triángulo base 8.5 altura 3.3: " + triangulo2);

        // Círculos
        double circulo1 = areaCirculo(3);
        double circulo2 = areaCirculo(7.1);
        System.out.println("Área de círculo radio 3: " + circulo1);
        System.out.println("Área de círculo radio 7.1: " + circulo2);
    }
}

