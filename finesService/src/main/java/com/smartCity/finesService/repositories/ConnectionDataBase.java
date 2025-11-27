package com.smartCity.finesService.repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDataBase {

    public static Connection getConnection() throws SQLException {
        // Lire les variables d'environnement définies dans Docker Compose
        String url = System.getenv("DB_URL");
        String user = System.getenv("DB_USER");
        String pass = System.getenv("DB_PASSWORD");

        System.out.println("DB URL: " + url);
        System.out.println("DB User: " + user);

        int retries = 10;
        while (retries > 0) {
            try {
                return DriverManager.getConnection(url, user, pass);
            } catch (SQLException e) {
                retries--;
                System.out.println("DB not ready yet, waiting 5s...");
                try { Thread.sleep(8000); } catch (InterruptedException ignored) {}
            }
        }
        throw new SQLException("Cannot connect to DB after retries");
    }
}
