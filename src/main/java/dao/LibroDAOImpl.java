package dao;

import dao.Interfaces.LibroDAO;
import model.Libro;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class LibroDAOImpl implements LibroDAO {
    private static Connection connection = ConnectionManager.devolverConnection("Biblioteca");
    private static Statement st;

    static {
        try {
            st = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void addLibro(Libro libro) throws Exception {
        String sql = "INSERT INTO Libro (titulo, isbn) VALUES (\"" + libro.getTitulo() + "\", \"" + libro.getIsbn() + "\")";
        st.executeUpdate(sql);
        System.out.println("CORRECTO: libro insertado");
    }

    @Override
    public ArrayList<Libro> getLibros() throws Exception {
        ArrayList<Libro> libros = new ArrayList<>();
        String sql = "SELECT * FROM Libro";
        ResultSet rs = st.executeQuery(sql);

        while (rs.next()) {
            int id = rs.getInt("id");
            String titulo = rs.getString("titulo");
            String isbn = rs.getString("isbn");
            libros.add(new Libro(id, titulo, isbn));
        }

        return libros;
    }

    @Override
    public Libro getLibroById(int id) throws Exception {
        String sql = "SELECT * FROM Libro WHERE id = " + id;
        ResultSet rs = st.executeQuery(sql);
        Libro libro = null;
        if (rs.next()) {
            libro = new Libro(rs.getInt("id"), rs.getString("titulo"), rs.getString("isbn"));
        }
        return libro;
    }

    @Override
    public void deleteLibro(int id) throws Exception {
        String sql = "DELETE FROM Libro WHERE id = " + id;
        st.executeUpdate(sql);
        System.out.println("CORRECTO: libro eliminado");
    }

    @Override
    public void updateLibroTitulo(Libro libro) throws Exception {
        String sql = "UPDATE Libro SET titulo = \"" + libro.getTitulo() + "\" WHERE id = " + libro.getId();
        st.executeUpdate(sql);
        System.out.println("CORRECTO: libro actualizado");
    }

    @Override
    public void updateLibroIsbn(Libro libro) throws Exception {
        String sql = "UPDATE Libro SET isbn = \"" + libro.getIsbn() + "\" WHERE id = " + libro.getId();
        st.executeUpdate(sql);
        System.out.println("CORRECTO: libro actualizado");
    }
}
