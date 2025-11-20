package dao.Interfaces;

import model.Usuario;

import java.util.ArrayList;

public interface UsuarioDAO {
    void addUsuario(Usuario usuario) throws Exception;

    void deleteUsuario(int id) throws Exception;

    void updateUsuario(Usuario usuario) throws Exception;

    Usuario getUsuarioById(int id) throws Exception;

    ArrayList<Usuario> getUsuarios() throws Exception;

}
