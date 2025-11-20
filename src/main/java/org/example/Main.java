package org.example;

import dao.*;
import dao.Interfaces.*;
import service.BibliotecaService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner t = new Scanner(System.in);
        int opcion;

        // Crear DAOs (implementaciones concretas)
        AutorDAO autorDAO = new AutorDAOImpl();
        LibroDAO libroDAO = new LibroDAOImpl();
        UsuarioDAO usuarioDAO = new UsuarioDAOImpl();
        PrestamoDAO prestamoDAO = new PrestamoDAOImpl();
        LibroAutorDAO libroAutorDAO = new LibroAutorDAOImpl();

        // Crear el servicio
        BibliotecaService service = new BibliotecaService(autorDAO, libroDAO, usuarioDAO, prestamoDAO, libroAutorDAO);

        boolean salir = false;
        while (!salir){
            System.out.println("""
                    ------ Menu  -----
                    1. Insertar Libro
                    2. Mostrar Libros
                    3. Actualizar Libro
                    4. Eliminar Libro
                    5. Insertar Autor
                    6. Mostrar Autores
                    7. Actualizar Autor
                    8. Eliminar Autor"
                    9. Insertar Libro-Autor
                    10. Mostrar Libro-Autor
                    11. Eliminar Libro-Autor
                    12. Insertar Préstamo
                    13. Mostrar Prestamos
                    14. Actualizar Préstamo
                    15. Eliminar Prestamo
                    16. Insertar Usuario
                    17. Mostrar Usuarios
                    18. Actualizar Usuario
                    19. Eliminar Usuario
                    0. Salir
                    ---------------------------
                    Elige una opcion:""");

            try {
                opcion = t.nextInt();

                switch (opcion) {
                    case 1 -> service.insertarLibro();
                    case 2 -> service.mostrarLibros();
                    case 3 -> service.actualizarLibro();
                    case 4 -> service.eliminarLibro();
                    case 5 -> service.insertarAutor();
                    case 6 -> service.mostrarAutores();
                    case 7 -> service.actualizarAutor();
                    case 8 -> service.eliminarAutor();
                    case 9 -> service.insertarLibroAutor();
                    case 10 -> service.mostrarULibroAutor();
                    case 11 -> service.eliminarLibroAutor();
                    case 12 -> service.insertarPrestamo();
                    case 13 -> service.mostrarPrestamos();
                    case 14 -> service.actualizarPrestamo();
                    case 15 -> service.eliminarPrestamo();
                    case 16 -> service.insertarUsuario();
                    case 17 -> service.mostrarUsuarios();
                    case 18 -> service.actualizarUsuario();
                    case 19 -> service.eliminarUsuario();
                    case 0 -> System.out.println("Saliendo del programa...");
                    default -> System.err.println("Opcion incorrecta.\n");
                }

            } catch (InputMismatchException e) {
                System.err.println("Solo se acepta números, y no se aceptan números tan largos.\n");
                salir = true;
            }
            System.out.println();
        }

        System.out.println("Ha terminado el menú.");
    }
}