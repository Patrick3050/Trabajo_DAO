package dao;

import dao.Interfaces.PrestamoDAO;
import model.Prestamo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class PrestamoDAOImpl implements PrestamoDAO {
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
    public void addPrestamo(Prestamo prestamo) throws Exception {
        String sql = "INSERT INTO Prestamo (fechaInicio, fechaFin, usuarioId, libroId) VALUES (\"" +
                prestamo.getFechaInicio() + "\", \"" +
                prestamo.getFechaFin() + "\", " +
                prestamo.getUsuarioId() + ", " +
                prestamo.getLibroId() + ")";
        st.executeUpdate(sql);
        System.out.println("CORRECTO: prestamo insertado");
    }

    @Override
    public void deletePrestamo(int id) throws Exception {
        String sql = "DELETE FROM Prestamo WHERE id = " + id;
        st.executeUpdate(sql);
        System.out.println("CORRECTO: prestamo eliminado");
    }

    @Override
    public Prestamo getPrestamoById(int id) throws Exception {
        String sql = "SELECT * FROM Prestamo WHERE id = " + id;
        ResultSet rs = st.executeQuery(sql);
        Prestamo prestamo = null;

        while (rs.next()) {
            prestamo = new Prestamo(
                    rs.getInt("id"),
                    rs.getString("fechaInicio"),
                    rs.getString("fechaFin"),
                    rs.getInt("usuarioId"),
                    rs.getInt("libroId")
            );
        }

        return prestamo;
    }

    @Override
    public ArrayList<Prestamo> getPrestamos() throws Exception {
        ArrayList<Prestamo> prestamos = new ArrayList<>();
        String sql = "SELECT * FROM Prestamo";
        ResultSet rs = st.executeQuery(sql);

        while (rs.next()) {
            int id = rs.getInt("id");
            String fechaInicio = rs.getString("fechaInicio");
            String fechaFin = rs.getString("fechaFin");
            int usuarioId = rs.getInt("usuarioId");
            int libroId = rs.getInt("libroId");

            prestamos.add(new Prestamo(id, fechaInicio, fechaFin, usuarioId, libroId));
        }

        return prestamos;
    }

    @Override
    public void updatePrestamoFechaInicio(Prestamo prestamo) throws Exception {
        String sql = "UPDATE Prestamo SET fechaInicio = \"" + prestamo.getFechaInicio() + "\" WHERE id = " + prestamo.getId();
        st.executeUpdate(sql);
        System.out.println("CORRECTO: prestamo actualizado");
    }

    @Override
    public void updatePrestamoFechaFin(Prestamo prestamo) throws Exception {
        String sql = "UPDATE Prestamo SET fechaFin = \"" + prestamo.getFechaFin() + "\" WHERE id = " + prestamo.getId();
        st.executeUpdate(sql);
        System.out.println("CORRECTO: prestamo actualizado");
    }
}
