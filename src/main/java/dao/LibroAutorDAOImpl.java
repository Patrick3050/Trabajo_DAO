package dao;

import dao.Interfaces.LibroAutorDAO;
import model.LibroAutor;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class LibroAutorDAOImpl implements LibroAutorDAO {
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
    public void addLibroAutor(LibroAutor libroAutor) throws Exception {
        String sql = "INSERT INTO Libro_Autor (idLibro, idAutor) VALUES (" + libroAutor.getIdLibro() + ", " + libroAutor.getIdAutor() + ")";
        st.executeUpdate(sql);
        System.out.println("CORRECTO: libroAutor insertado");
    }

    @Override
    public void deleteLibroAutor(int idLibro, int idAutor) throws Exception {
        String sql = "DELETE FROM Libro_Autor WHERE idLibro = " + idLibro + " AND  idAutor = " + idAutor;
        st.executeUpdate(sql);
        System.out.println("CORRECTO: libroAutor eliminado");
    }

    @Override
    public ArrayList<LibroAutor> getLibroAutors() throws Exception {
        ArrayList<LibroAutor> libroAutors = new ArrayList<>();
        String sql = "SELECT * FROM Libro_Autor";
        ResultSet rs = st.executeQuery(sql);

        while (rs.next()) {
            int idLibro = rs.getInt("idLibro");
            int idAutor = rs.getInt("idAutor");
            libroAutors.add(new LibroAutor(idLibro, idAutor) );
        }

        return libroAutors;
    }

}
