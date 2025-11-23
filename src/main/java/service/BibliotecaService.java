package service;

import dao.ConnectionManager;
import dao.Interfaces.*;
import model.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class BibliotecaService {
    Scanner sc = new Scanner(System.in);

    private AutorDAO autorDAO;
    private LibroDAO libroDAO;
    private LibroAutorDAO libroAutorDAO;
    private PrestamoDAO prestamoDAO;
    private UsuarioDAO usuarioDAO;

    public BibliotecaService(AutorDAO autorDAO, LibroDAO libroDAO, UsuarioDAO usuarioDAO, PrestamoDAO prestamoDAO, LibroAutorDAO libroAutorDAO) {
        this.autorDAO = autorDAO;
        this.libroDAO = libroDAO;
        this.usuarioDAO = usuarioDAO;
        this.prestamoDAO = prestamoDAO;
        this.libroAutorDAO = libroAutorDAO;
    }

    // ==============================================
    // Metodos de Libro

    public void insertarLibro() {
        try {
            System.out.println("== Insertar Libro ==");
            System.out.print("Ingresa el titulo del libro: ");
            String titulo = sc.nextLine().trim();
            System.out.print("Ingresa el isbn del libro: ");
            String isbn = sc.nextLine().trim();
            Libro libro = new Libro(0, titulo, isbn);
            libroDAO.addLibro(libro);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void mostrarLibros() {
        try {
            System.out.println("== Mostrar Libros ==");
            ArrayList<Libro> libros = libroDAO.getLibros();
            for (Libro libro : libros) {
                System.out.println(libro);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void eliminarLibro() {
        try {
            System.out.println("== Eliminar Libro ==");
            System.out.print("Ingresa el id del libro a eliminar: ");
            String idAux = sc.nextLine().trim();
            int id = Integer.parseInt(idAux);
            libroDAO.deleteLibro(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void actualizarLibro() {
        try {
            System.out.println("== Actualizar Libro ==");
            System.out.print("Ingresa el id del libro a actualizar: ");
            String idAux = sc.nextLine().trim();
            int id = Integer.parseInt(idAux);
            Libro libro = libroDAO.getLibroById(id);

            System.out.println("¿Que campo deseas actualizar?");
            System.out.println("1. titulo");
            System.out.println("2. isbn");
            System.out.print("Ingresa tu opcion: ");
            String opcion = sc.nextLine().trim();

            switch (opcion) {
                case "1": {
                    System.out.print("Ingresa el nuevo titulo del libro: ");
                    String titulo = sc.nextLine().trim();
                    libro.setTitulo(titulo);
                    libroDAO.updateLibroTitulo(libro);
                }
                break;
                case "2": {
                    System.out.print("Ingresa el nuevo isbn del libro: ");
                    String isbn = sc.nextLine().trim();
                    libro.setIsbn(isbn);
                    libroDAO.updateLibroIsbn(libro);
                }
                break;
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // ==============================================
    // Metodos de Autor

    public void insertarAutor() {
        try {
            System.out.println("== Insertar Autor ==");
            System.out.print("Ingresa el nombre del autor: ");
            String nombre = sc.nextLine().trim();
            Autor autor = new Autor(0, nombre);
            autorDAO.addAutor(autor);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void mostrarAutores() {
        try {
            System.out.println("== Mostrar Autores ==");
            ArrayList<Autor> libros = autorDAO.getAutores();
            for (Autor autor : libros) {
                System.out.println(autor);
            }
        } catch (Exception e) {
            System.err.println("Autores no encontrados.");
        }
    }

    public void eliminarAutor() {
        try {
            System.out.println("== Eliminar Autor ==");
            System.out.print("Ingresa el id del autor a eliminar: ");
            String idAux = sc.nextLine().trim();
            int id = Integer.parseInt(idAux);
            autorDAO.deleteAutor(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void actualizarAutor() {
        try {
            System.out.println("== Actualizar Autor ==");
            System.out.print("Ingresa el id del autor a actualizar: ");
            String idAux = sc.nextLine().trim();
            int id = Integer.parseInt(idAux);
            Autor autor = autorDAO.getAutorById(id);
            System.out.print("Ingresa el nuevo valor para nombre: ");
            String nombre = sc.nextLine().trim();
            autor.setNombre(nombre);
            autorDAO.updateAutor(autor);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // ==============================================
    // Metodos de LibroAutor

    public void insertarLibroAutor() {
        try {
            System.out.println("== Insertar Libro-Autor ==");

            System.out.print("Ingresa el idLibro del Libro-Autor: ");
            String idLibroAux = sc.nextLine().trim();
            int idLibro = Integer.parseInt(idLibroAux);

            System.out.print("Ingresa el idAutor del Libro-Autor: ");
            String idAutorAux = sc.nextLine().trim();
            int idAutor = Integer.parseInt(idAutorAux);

            LibroAutor libroAutor = new LibroAutor(idLibro, idAutor);
            libroAutorDAO.addLibroAutor(libroAutor);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void mostrarULibroAutor() {
        try {
            System.out.println("== Mostrar Libro-Autor ==");
            ArrayList<LibroAutor> libroAutors = libroAutorDAO.getLibroAutors();
            for (LibroAutor libroAutor : libroAutors) {
                System.out.println(libroAutor);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void eliminarLibroAutor() {
        try {
            System.out.println("== Eliminar Libro-Autor ==");
            System.out.print("Ingresa el idLibro del Libro-Autor: ");
            String idLibroAux = sc.nextLine().trim();
            int idLibro = Integer.parseInt(idLibroAux);

            System.out.print("Ingresa el idAutor del Libro-Autor: ");
            String idAutorAux = sc.nextLine().trim();
            int idAutor = Integer.parseInt(idAutorAux);
            libroAutorDAO.deleteLibroAutor(idLibro, idAutor);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // ==============================================
    // Metodos de Prestamo

    public void insertarPrestamo() {
        try {
            System.out.println("== Insertar Prestamo ==");
            System.out.print("Ingresa el fechaInicio del Prestamo: ");
            String fechaInicio = sc.nextLine().trim();
            System.out.print("Ingresa el fechaFin del Prestamo: ");
            String fechaFin = sc.nextLine().trim();
            Prestamo prestamo = new Prestamo(0, fechaInicio, fechaFin);
            prestamoDAO.addPrestamo(prestamo);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void mostrarPrestamos() {
        try {
            System.out.println("== Mostrar Prestamos ==");
            ArrayList<Prestamo> prestamos = prestamoDAO.getPrestamos();
            for (Prestamo prestamo : prestamos) {
                System.out.println(prestamo);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void eliminarPrestamo() {
        try {
            System.out.println("== Eliminar Prestamo ==");
            System.out.print("Ingresa el id del prestamo a eliminar: ");
            String idAux = sc.nextLine().trim();
            int id = Integer.parseInt(idAux);
            prestamoDAO.deletePrestamo(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void actualizarPrestamo() {
        try {
            System.out.println("== Actualizar Prestamo ==");
            System.out.print("Ingresa el id del prestamo a actualizar: ");
            String idAux = sc.nextLine().trim();
            int id = Integer.parseInt(idAux);
            Prestamo prestamo = prestamoDAO.getPrestamoById(id);

            System.out.println("¿Que campo deseas actualizar?");
            System.out.println("1. fechaInicio");
            System.out.println("2. fechaFin");
            System.out.print("Ingresa tu opcion: ");
            String opcion = sc.nextLine().trim();

            switch (opcion) {
                case "1": {
                    System.out.print("Ingresa el nuevo fechaInicio del prestamo: ");
                    String fechaInicio = sc.nextLine().trim();
                    prestamo.setFechaInicio(fechaInicio);
                    prestamoDAO.updatePrestamoFechaInicio(prestamo);
                }
                break;
                case "2": {
                    System.out.print("Ingresa el nuevo fechaFin del prestamo: ");
                    String fechaFin = sc.nextLine().trim();
                    prestamo.setFechaFin(fechaFin);
                    prestamoDAO.updatePrestamoFechaInicio(prestamo);
                }
                break;
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // ==============================================
    // Metodos de Usuario

    public void insertarUsuario() {
        try {
            System.out.println("== Insertar Usuario ==");
            System.out.print("Ingresa el nombre del usuario: ");
            String nombre = sc.nextLine().trim();
            Usuario usuario = new Usuario(nombre, 0);
            usuarioDAO.addUsuario(usuario);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void mostrarUsuarios() {
        try {
            System.out.println("== Mostrar Usuarios ==");
            ArrayList<Usuario> usuarios = usuarioDAO.getUsuarios();
            for (Usuario usuario : usuarios) {
                System.out.println(usuario);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void eliminarUsuario() {
        try {
            System.out.println("== Eliminar Usuario ==");
            System.out.print("Ingresa el id del usuario a eliminar: ");
            String idAux = sc.nextLine().trim();
            int id = Integer.parseInt(idAux);
            usuarioDAO.deleteUsuario(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void actualizarUsuario() {
        try {
            System.out.println("== Actualizar Usuario ==");
            System.out.print("Ingresa el id del usuario a actualizar: ");
            String idAux = sc.nextLine().trim();
            int id = Integer.parseInt(idAux);
            Usuario usuario = usuarioDAO.getUsuarioById(id);
            System.out.print("Ingresa el nuevo valor para nombre: ");
            String nombre = sc.nextLine().trim();
            usuario.setNombre(nombre);
            usuarioDAO.updateUsuario(usuario);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
