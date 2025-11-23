package dao.Interfaces;

import model.LibroAutor;

import java.util.ArrayList;

public interface LibroAutorDAO {
    void addLibroAutor(LibroAutor libroAutor) throws Exception;
    void deleteLibroAutor(int idLibro, int idAutor) throws Exception;
    ArrayList<LibroAutor> getLibroAutors() throws Exception;
}
