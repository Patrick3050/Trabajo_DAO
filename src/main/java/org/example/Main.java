package org.example;

import dao.*;
import dao.Interfaces.*;
import service.BibliotecaService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner t = new Scanner(System.in);
        int opcion, opcionTabla;

        // Crear DAO's y servicio
        AutorDAO autorDAO;
        LibroDAO libroDAO;
        UsuarioDAO usuarioDAO;
        PrestamoDAO prestamoDAO;
        LibroAutorDAO libroAutorDAO;

        BibliotecaService service;
        try {
            // Implementaciones concretas
            autorDAO = new AutorDAOImpl();
            libroDAO = new LibroDAOImpl();
            usuarioDAO = new UsuarioDAOImpl();
            prestamoDAO = new PrestamoDAOImpl();
            libroAutorDAO = new LibroAutorDAOImpl();
            service = new BibliotecaService(autorDAO, libroDAO, usuarioDAO, prestamoDAO, libroAutorDAO);
        } catch (ExceptionInInitializerError e)
        {
            return;
        }

        boolean salirTabla = false;
        while (!salirTabla){
            System.out.println("""
                    -------- Tablas -----------
                    1. Libro
                    2. Autor
                    3. Libro-Autor
                    4. Préstamo
                    5. Usuario
                    0. Salir
                    ---------------------------
                    Elige una tabla:""");

            try {
                opcionTabla = t.nextInt();


                String nombreTabla = "";
                switch (opcionTabla) {
                    case 1 -> nombreTabla = "Libro";
                    case 2 -> nombreTabla = "Autor";
                    case 3 -> nombreTabla = "Libro-Autor";
                    case 4 -> nombreTabla = "Préstamo";
                    case 5 -> nombreTabla = "Usuario";
                    case 0 -> {
                        System.out.println("Saliendo del programa...");
                        salirTabla = true;
                    }
                    default -> System.err.println("Opcion incorrecta.\n");
                }

                boolean salir = (opcionTabla == 0);

                while (!salir) {
                    if (nombreTabla.equals("Libro-Autor")) {
                            System.out.printf("""
                                    
                                    -------- %s -----------
                                    1. Insertar
                                    2. Mostrar
                                    3. Eliminar
                                    0. Salir
                                    ---------------------------
                                    Elige una tabla:
                                    """, nombreTabla);
                        }
                    else {
                        System.out.printf("""
                                  
                                  -------- %s -----------
                                   1. Insertar
                                   2. Mostrar
                                   3. Actualizar
                                   4. Eliminar
                                   0. Salir
                                  ---------------------------
                                  Elige una opción:
                                  """, nombreTabla);
                        }

                    opcion = t.nextInt();
                    switch (nombreTabla) {
                        case "Libro" -> {
                                switch (opcion) {
                                    case 1 -> service.insertarLibro();
                                    case 2 -> service.mostrarLibros();
                                    case 3 -> service.actualizarLibro();
                                    case 4 -> service.eliminarLibro();
                                    case 0 -> {
                                        System.out.printf("Saliendo de %s...\n", nombreTabla);
                                        salir = true;
                                    }
                                    default -> System.err.println("Opcion incorrecta.\n");
                                }
                            }
                        case "Autor" -> {
                                switch (opcion) {
                                    case 1 -> service.insertarAutor();
                                    case 2 -> service.mostrarAutores();
                                    case 3 -> service.actualizarAutor();
                                    case 4 -> service.eliminarAutor();
                                    case 0 -> {
                                        System.out.printf("Saliendo de %s...\n", nombreTabla);
                                        salir = true;
                                    }
                                    default -> System.err.println("Opcion incorrecta.\n");
                                }
                            }
                        case "Libro-Autor" -> {
                                switch (opcion) {
                                    case 1 -> service.insertarLibroAutor();
                                    case 2 -> service.mostrarULibroAutor();
                                    case 3 -> service.eliminarLibroAutor();
                                    case 0 -> {
                                        System.out.printf("Saliendo de %s...\n", nombreTabla);
                                        salir = true;
                                    }
                                    default -> System.err.println("Opcion incorrecta.\n");
                                }
                            }
                        case "Préstamo" -> {
                                switch (opcion) {
                                    case 1 -> service.insertarPrestamo();
                                    case 2 -> service.mostrarPrestamos();
                                    case 3 -> service.actualizarPrestamo();
                                    case 4 -> service.eliminarPrestamo();
                                    case 0 -> {
                                        System.out.printf("Saliendo de %s...\n", nombreTabla);
                                        salir = true;
                                    }
                                    default -> System.err.println("Opcion incorrecta.\n");
                                }
                            }
                        case "Usuario" -> {
                                switch (opcion) {
                                    case 1 -> service.insertarUsuario();
                                    case 2 -> service.mostrarUsuarios();
                                    case 3 -> service.actualizarUsuario();
                                    case 4 -> service.eliminarUsuario();
                                    case 0 -> {
                                        System.out.printf("Saliendo de %s...\n", nombreTabla);
                                        salir = true;
                                    }
                                    default -> System.err.println("Opcion incorrecta.\n");
                                }
                            }
                    }
                }

            } catch (InputMismatchException e) {
                t.next();
                System.err.println("Solo se acepta números, y no se aceptan números tan largos.\n");
            }
            System.out.println();
        }

        System.out.println("Ha terminado el menú.");
    }
}