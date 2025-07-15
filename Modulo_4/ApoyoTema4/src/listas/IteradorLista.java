package listas;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteradorLista {
    public static void main(String[] args) {
        List<Integer> numeros = new ArrayList<>();
        numeros.add(5);
        numeros.add(12);
        numeros.add(8);
        numeros.add(20);

        Iterator<Integer> iter = numeros.iterator();

        while (iter.hasNext()) {
            int valor = iter.next();
            if (valor < 10) {
                iter.remove(); // Elimina elementos menores que 10 de forma segura
            }
        }

        System.out.println("Lista después de eliminar los menores que 10: " + numeros);
    }
}

