package dao.Interfaces;

import model.LibroAutor;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface LibroAutorDAO {
    void addLibroAutor(LibroAutor libroAutor) throws Exception;
    void deleteLibroAutor(int idLibro, int idAutor) throws Exception;
    ArrayList<LibroAutor> getLibroAutors() throws Exception;
}
