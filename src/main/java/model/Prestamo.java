package model;

public class Prestamo {
    private int id;
    private String fechaInicio;
    private String fechaFin;
    private int usuarioId;
    private int libroId;

    public Prestamo(int id, String fechaInicio, String fechaFin, int usuarioId, int libroId) {
        this.id = id;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.usuarioId = usuarioId;
        this.libroId = libroId;
    }

    public int getId() {
        return id;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public int getLibroId() {
        return libroId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public void setLibroId(int libroId) {
        this.libroId = libroId;
    }

    public String toString() {
        return String.format("Prestamo[ id=%d, fecha de inicio=%s, fecha de fin=%s, usuarioId=%d, libroId=%d ]",
                id,
                fechaInicio,
                fechaFin,
                usuarioId,
                libroId
        );
    }
}
