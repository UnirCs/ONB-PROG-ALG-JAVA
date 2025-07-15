package lambda;

import java.util.Arrays;
import java.util.List;

public class LambdaEjemplo2 {
    public static void main(String[] args) {
        List<String> palabras = Arrays.asList("java", "stream", "lambda", "api");

        palabras.sort((a, b) -> a.length() - b.length());

        System.out.println("Palabras ordenadas por longitud: " + palabras);
    }
}

