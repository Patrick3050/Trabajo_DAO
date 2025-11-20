package dao.Interfaces;

import model.Libro;

import java.sql.SQLException;
import java.util.ArrayList;

public interface LibroDAO {
    void addLibro(Libro libro) throws Exception;

    ArrayList<Libro> getLibros() throws Exception;

    Libro getLibroById(int id) throws Exception;

    void deleteLibro(int id) throws Exception;

    void updateLibroTitulo(Libro libro) throws Exception;

    void updateLibroIsbn(Libro libro) throws Exception;
}
