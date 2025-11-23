package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    // 1. Conexión única
    private static Connection con = null;
    private static final String URL = "jdbc:mysql://localhost/";
    private static final String USER = "root";
    private static final String PASS = "";

    public ConnectionManager() {}

    // 2. Metodo para obtener la única instancia de Connection
    public static Connection devolverConnection(String baseDeDatos) {
        if (con == null) { // Solo se conecta si 'con' es nulo
            try {
                // Se conecta una sola vez
                con = DriverManager.getConnection(URL + baseDeDatos, USER, PASS);

                // Solo se imprime el mensaje de éxito la primera vez
                if (baseDeDatos.equalsIgnoreCase("")) {
                    System.out.println("CORRECTO: la conexion a MySQL fue exitosa\n");
                } else {
                    System.out.println("CORRECTO: la conexion a la base de datos " + baseDeDatos + " fue exitosa");
                }

            } catch (SQLException e) {
                System.err.println("❌ ERROR: No se pudo establecer la conexión a la base de datos.");
                // Lanzar una RuntimeException para detener la ejecución y propagar el error
                throw new RuntimeException();
            }
        }
        // Devuelve la conexión existente
        return con;

    }
}
