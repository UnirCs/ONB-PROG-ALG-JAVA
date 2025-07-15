package funciones;

public class Volumenes {

    // Volumen de un cubo
    // Fórmula: V = lado³
    public static double volumenCubo(double lado) {
        return lado * lado * lado;
    }

    // Volumen de un prisma rectangular
    // Fórmula: V = largo * ancho * alto
    public static double volumenPrismaRectangular(double largo, double ancho, double alto) {
        return largo * ancho * alto;
    }

    // Volumen de una esfera
    // Fórmula: V = (4/3) * π * r³
    public static double volumenEsfera(double radio) {
        return (4.0 / 3.0) * Math.PI * Math.pow(radio, 3);
    }

    // Volumen de un cilindro
    // Fórmula: V = π * r² * h
    public static double volumenCilindro(double radio, double altura) {
        return Math.PI * radio * radio * altura;
    }

    // Volumen de un cono
    // Fórmula: V = (1/3) * π * r² * h
    public static double volumenCono(double radio, double altura) {
        return (Math.PI * radio * radio * altura) / 3.0;
    }

    // Volumen de una pirámide cuadrada
    // Fórmula: V = (1/3) * base² * altura
    public static double volumenPiramideCuadrada(double base, double altura) {
        return (base * base * altura) / 3.0;
    }

    public static void main(String[] args) {

        // Ejemplos de uso de las funciones
        double ladoCubo = 3.0;
        System.out.println("Volumen del cubo: " + volumenCubo(ladoCubo));

        double largoPrisma = 4.0, anchoPrisma = 5.0, altoPrisma = 6.0;
        System.out.println("Volumen del prisma rectangular: " + volumenPrismaRectangular(largoPrisma, anchoPrisma, altoPrisma));

        double radioEsfera = 2.0;
        System.out.println("Volumen de la esfera: " + volumenEsfera(radioEsfera));

        double radioCilindro = 3.0, alturaCilindro = 5.0;
        System.out.println("Volumen del cilindro: " + volumenCilindro(radioCilindro, alturaCilindro));

        double radioCono = 2.0, alturaCono = 4.0;
        System.out.println("Volumen del cono: " + volumenCono(radioCono, alturaCono));

        double basePiramide = 3.0, alturaPiramide = 6.0;
        System.out.println("Volumen de la pirámide cuadrada: " + volumenPiramideCuadrada(basePiramide, alturaPiramide));
    }
}
