import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class 17_02_25 {
    public static void main(String[] args) {
        DatabaseOperations dbOps = new DatabaseOperations();
        
        // Insert data
        dbOps.createData("1", "jinu", "jinu@gmail.com");
        dbOps.createData("2", "jawad", "jawad@gmail.com");
        
        // Read data
        dbOps.readData();
        
        // Update data
        dbOps.updateData("2", "22", "jawad2", "jawad2@gmail.com");
        
        // Delete data
        dbOps.deleteData("1");
    }

    public void createData(String slNo, String name, String email) {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement("INSERT INTO user(sl_no, name, email) VALUES (?, ?, ?)") ) {
            
            ps.setString(1, slNo);
            ps.setString(2, name);
            ps.setString(3, email);
            
            ps.executeUpdate();
            System.out.println("Data inserted successfully: " + name);
        } catch (Exception e) {
            System.out.println("Error inserting data: " + e.getMessage());
        }
    }

    public void readData() {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement("SELECT * FROM user");
             ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {
                System.out.println("Sl No: " + rs.getString("sl_no") + ", Name: " + rs.getString("name") + ", Email: " + rs.getString("email"));
            }
        } catch (Exception e) {
            System.out.println("Error reading data: " + e.getMessage());
        }
    }

    public void updateData(String slNo, String newSlNo, String name, String email) {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement("UPDATE user SET sl_no=?, name=?, email=? WHERE sl_no=?")) {
            
            ps.setString(1, newSlNo);
            ps.setString(2, name);
            ps.setString(3, email);
            ps.setString(4, slNo);
            
            ps.executeUpdate();
            System.out.println("Data updated for Sl No: " + slNo);
        } catch (Exception e) {
            System.out.println("Error updating data: " + e.getMessage());
        }
    }

    public void deleteData(String slNo) {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement("DELETE FROM user WHERE sl_no=?")) {
            
            ps.setString(1, slNo);
            ps.executeUpdate();
            System.out.println("Data deleted for Sl No: " + slNo);
        } catch (Exception e) {
            System.out.println("Error deleting data: " + e.getMessage());
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