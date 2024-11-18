package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Utility class for managing database connections.
 */
public class DBConnectionUtil {
    // Database URL, username, and password - update as per your configuration
    private static final String URL = "jdbc:mysql://localhost:3306/IndyWinners";
    private static final String USER = "root";
    private static final String PASSWORD = "Priya@125"; // 

    /**
     * Establishes and returns a connection to the database.
     * @return a Connection object.
     */
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace(); // Print error for debugging
            throw new RuntimeException("Error connecting to the database", e);
        }
    }
}
