import java.sql.*;  

public class 14_02_25{
    public static void main(String[] args) {
        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            System.out.println("Driver Loaded Successfully");
            
            try ( // Establishing Connection
                    Connection connection = DriverManager.getConnection(
                            "jdbc:mysql://localhost:3306/friday", "root", "root"
                    )) {
                System.out.println("Connected to Database");
                // Creating Statement Object
                Statement statement = connection.createStatement();
                System.out.println("Statement Created");
                // Executing Query
                ResultSet resultSet = statement.executeQuery("SELECT * FROM student");
                // Processing Results
                while (resultSet.next()) {
                    System.out.println(
                            resultSet.getInt(1) + " " + resultSet.getString(2) + " " + resultSet.getString(3)
                    );
                }
                // Closing Resources
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error Occurred: Check Your Code");
        }
    }
}
