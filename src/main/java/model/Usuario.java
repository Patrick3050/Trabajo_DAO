package model;

public class Usuario {
    private int id;
    private String nombre;

    public Usuario(String nombre, int id) {
        this.nombre = nombre;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String toString() {
        return String.format("Usuario[ id=%d, nombre=%s ]",
                id,
                nombre
        );
    }
}
