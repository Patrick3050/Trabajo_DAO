package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    public ConnectionManager() {}

    public Connection devolverConnection(String baseDeDatos) {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/" + baseDeDatos, "root", "");
            if (baseDeDatos.equalsIgnoreCase("")) {
                System.out.println("CORRECTO: la coneccion a MySQL fue exitosa\n");
            } else {
                System.out.println("CORRECTO: la coneccion a la base de datos " + baseDeDatos + " fue exitosa");
            }

            return con;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


}
