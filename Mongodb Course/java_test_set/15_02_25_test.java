import java.sql.Connection;
import java.sql.PreparedStatement;

public class 15_02_25_test{
    public static void main(String[] args) {
        DatabaseOperations dbOps = new DatabaseOperations();

        // Insert data
        dbOps.createData("1", "Shubham", "shubham@gmail.com");
        dbOps.createData("2", "Shubham", "shubhamraj@gmail.com");
    }

    public void createData(String slNo, String name, String email) {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement("INSERT INTO user(sl_no, name, email) VALUES (?, ?, ?)") ) {
            
            ps.setString(1, slNo);
            ps.setString(2, name);
            ps.setString(3, email);
            
            ps.executeUpdate();
            System.out.println("Data inserted: " + name);
        } catch (Exception e) {
            System.out.println("Error inserting data: " + e.getMessage());
        }
    }
}

class DatabaseConnection {
    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/crud", "root", "root");
        } catch (Exception e) {
            System.out.println("Database connection error: " + e.getMessage());
        }
        return conn;
    }
}
