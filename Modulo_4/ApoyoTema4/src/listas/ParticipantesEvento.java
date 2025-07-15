package listas;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ParticipantesEvento {
    public static void main(String[] args) {
        List<String> participantes = new ArrayList<>();
        participantes.add("Ana");
        participantes.add("Luis");
        participantes.add("Carlos");
        participantes.add("Marta");

        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce el nombre a buscar: ");
        String nombreBuscado = sc.nextLine();

        if (participantes.contains(nombreBuscado)) {
            System.out.println(nombreBuscado + " está inscrito en el evento.");
        } else {
            System.out.println(nombreBuscado + " no figura entre los participantes.");
        }

        sc.close();
    }
}

