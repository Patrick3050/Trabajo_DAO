package model;

public class Prestamo {
    private int id;
    private String fechaInicio;
    private String fechaFin;

    public Prestamo(int id, String fechaInicio, String fechaFin) {
        this.id = id;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
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

    public void setId(int id) {
        this.id = id;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String toString() {
        return String.format("Prestamo[ id=%d, fecha de inicio=%s, fecha de fin=%s ]",
                id,
                fechaInicio,
                fechaFin
        );
    }
}
