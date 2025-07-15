package arrays;

public class EliminarEspacios {

    public static String eliminarEspacios(String texto) {
        char[] caracteres = texto.toCharArray();
        StringBuilder resultado = new StringBuilder();
        for (int i = 0; i < caracteres.length; i++) {
            if (caracteres[i] != ' ') {
                resultado.append(caracteres[i]);
            }
        }
        return resultado.toString();
    }

    // Ejemplo de uso
    public static void main(String[] args) {
        String original = "Hola mundo con espacios";
        String sinEspacios = eliminarEspacios(original);
        System.out.println(sinEspacios); // Salida: Holamundoconespacios
    }
}
