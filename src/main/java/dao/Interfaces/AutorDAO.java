package dao.Interfaces;

import model.Autor;


import java.util.ArrayList;

public interface AutorDAO {
    void addAutor(Autor autor) throws Exception;

    void updateAutor(Autor autor) throws Exception;

    void deleteAutor(int id) throws Exception;

    Autor getAutorById(int id) throws Exception;

    ArrayList<Autor> getAutores() throws Exception;
}
