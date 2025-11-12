package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner t = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("""
                    ------ Menu  -----
                    1. Leer registro.
                    2. Insertar registro.
                    3. Actualizar registro.
                    4. Borrar registro.
                    5. Salir.
                    ---------------------------
                    Elige una opcion:""");

            try {
                opcion = t.nextInt();

                switch (opcion) {
                    case 1 -> System.out.println();
                    case 2 -> System.out.println();
                    case 3 -> System.out.println();
                    case 4 -> System.out.println();
                    case 5 -> System.out.println();
                    default -> System.err.println("Opcion incorrecta.\n");
                }

            } catch (InputMismatchException e) {
                System.err.println("Solo se acepta números, y no se aceptan números tan largos.\n");
                t.next();
                opcion = 0;
            }
            System.out.println();

        } while (opcion != 5);

        System.out.println("Ha terminado el menú.");
    }
}