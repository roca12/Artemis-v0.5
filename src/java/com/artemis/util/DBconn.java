package com.artemis.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconn {

    private final String URL = "jdbc:mysql://localhost:3306/Artemis?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private final String USER = "root";
    private final String PASSWORD = "piroloco2112";

    public void testConnection() throws SQLException {
        Connection c = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Controlador detectado");
            System.out.println("Conectando...");
            c = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexión exitosa");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Conexión fallida ");
            e.printStackTrace();
        } finally {
            if (c != null) {
                c.close();
            }
        }
    }
}