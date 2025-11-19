package dao;

import dao.Interfaces.UsuarioDAO;
import model.Usuario;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class UsuarioDAOImpl implements UsuarioDAO {
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
    public void addUsuario(Usuario usuario) throws Exception {
        String sql = "INSERT INTO Usuario (nombre) VALUES (\"" + usuario.getNombre() + "\")";
        st.executeUpdate(sql);
        System.out.println("CORRECTO: usuario insertado");
    }

    @Override
    public void deleteUsuario(int id) throws Exception {
        String sql = "DELETE FROM Usuario WHERE id = " + id;
        st.executeUpdate(sql);
        System.out.println("CORRECTO: usuario eliminado");
    }

    @Override
    public void updateUsuario(Usuario usuario) throws Exception {
        String sql = "UPDATE Usuario SET nombre = \"" + usuario.getNombre() + "\" WHERE id = " + usuario.getId();
        st.executeUpdate(sql);
        System.out.println("CORRECTO: Autor actualizado");
    }

    @Override
    public Usuario getUsuarioById(int id) throws Exception {
        String sql = "SELECT * FROM Usuario WHERE id = " + id;
        ResultSet rs = st.executeQuery(sql);
        Usuario usuario = null;
        while (rs.next()) {
            usuario = new Usuario(rs.getString("nombre"), rs.getInt("id"));
        }
        return usuario;
    }

    @Override
    public ArrayList<Usuario> getUsuarios() throws Exception {
        ArrayList<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM Usuario";
        ResultSet rs = st.executeQuery(sql);

        while (rs.next()) {
            int id = rs.getInt("id");
            String titulo = rs.getString("nombre");
            usuarios.add(new Usuario(titulo, id));
        }

        return usuarios;
    }
}
