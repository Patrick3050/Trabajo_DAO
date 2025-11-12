package model;

public class Libro {
    private int id;
    private String titulo;
    private String isbn;

    public Libro(int id, String titulo, String isbn) {
        this.id = id;
        this.titulo = titulo;
        this.isbn = isbn;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getIsbn() {
        return isbn;
    }

    public String toString() {
        return String.format("Libro[ id=%d, titulo=%s, isbn=%s ]",
                id,
                titulo,
                isbn
        );
    }
}
