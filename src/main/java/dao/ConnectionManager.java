package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    public ConnectionManager() {}

    public static Connection devolverConnection(String baseDeDatos) {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/" + baseDeDatos, "root", "");
            if (baseDeDatos.equalsIgnoreCase("")) {
                System.out.println("CORRECTO: la coneccion a MySQL fue exitosa\n");
            } else {
                System.out.println("CORRECTO: la coneccion a la base de datos " + baseDeDatos + " fue exitosa");
            }

            return con;
        } catch (SQLException e) {
            System.err.println("❌ ERROR: No se pudo establecer la conexión a la base de datos.");
            // **Lanzar una RuntimeException para detener la ejecución y propagar el error**
            throw new RuntimeException();
        }

    }
}
