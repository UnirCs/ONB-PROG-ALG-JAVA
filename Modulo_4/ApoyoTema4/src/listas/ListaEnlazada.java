package listas;

import java.util.LinkedList;
import java.util.List;

public class ListaEnlazada {
    public static void main(String[] args) {
        List<Integer> numeros = new LinkedList<>();

        numeros.add(10);
        numeros.add(20);
        numeros.add(30);

        numeros.add(1, 15); // Inserta el número 15 en la posición 1
        numeros.remove(2);  // Elimina el número en la posición 2

        for (int numero : numeros) {
            System.out.println(numero);
        }
    }
}

