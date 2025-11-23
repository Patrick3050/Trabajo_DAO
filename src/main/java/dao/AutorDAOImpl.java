package dao;

import dao.Interfaces.AutorDAO;
import model.Autor;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class AutorDAOImpl implements AutorDAO {
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
    public void addAutor(Autor autor) throws Exception {
        String sql = "INSERT INTO Autor (nombre) VALUES (\"" + autor.getNombre() + "\")";
        st.executeUpdate(sql);
        System.out.println("CORRECTO: autor insertado");
    }

    @Override
    public void updateAutor(Autor autor) throws Exception {
        String sql = "UPDATE Autor SET nombre = \"" + autor.getNombre() + "\" WHERE id = " + autor.getId();
        st.executeUpdate(sql);
        System.out.println("CORRECTO: Autor actualizado");
    }

    @Override
    public void deleteAutor(int id) throws Exception {
        String sql = "DELETE FROM Autor WHERE id = " + id;
        st.executeUpdate(sql);
        System.out.println("CORRECTO: Autor eliminado");
    }

    @Override
    public Autor getAutorById(int id) throws Exception {
        String sql = "SELECT * FROM Autor WHERE id = " + id;
        ResultSet rs = st.executeQuery(sql);
        Autor autor = null;
        while (rs.next()) {
            autor = new Autor(rs.getInt("id"), rs.getString("nombre"));
        }
        return autor;
    }

    @Override
    public ArrayList<Autor> getAutores() throws Exception {
        ArrayList<Autor> autors = new ArrayList<>();
        String sql = "SELECT * FROM Autor";
        ResultSet rs = st.executeQuery(sql);

        while (rs.next()) {
            int id = rs.getInt("id");
            String titulo = rs.getString("nombre");
            autors.add(new Autor(id, titulo));
        }

        return autors;
    }
}
