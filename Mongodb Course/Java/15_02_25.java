import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class 15_02_25{
    public static void main(String[] args) {
        DatabaseConnection dbConnection = new DatabaseConnection();
        System.out.println(dbConnection.getConnection());
    }
}

class DatabaseConnection {
    public Connection getConnection() {
        Connection conn = null;
        try {
            // Load the JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Establish Database Connection
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/saturday", "root", "root");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Database Connection Failed: " + e.getMessage());
        }
        return conn;
    }
}


