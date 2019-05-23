package pukhtaweb.api;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

    private static final String DB_CONNECTION = "jdbc:postgresql://localhost:5432/pukhtaweb_db";
    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "qwe12345";


    public ConnectionManager() {
    }

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
            throw new RuntimeException(e);
        }
    }
}