package dao.Interfaces;

import model.Prestamo;

import java.util.ArrayList;

public interface PrestamoDAO {
    void addPrestamo(Prestamo prestamo) throws Exception;

    void deletePrestamo(int id) throws Exception;

    Prestamo getPrestamoById(int id) throws Exception;

    ArrayList<Prestamo> getPrestamos() throws Exception;

    void updatePrestamoFechaInicio(Prestamo prestamo) throws Exception;

    void updatePrestamoFechaFin(Prestamo prestamo) throws Exception;
}
