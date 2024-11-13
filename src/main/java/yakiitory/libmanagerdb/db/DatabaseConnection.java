package yakiitory.libmanagerdb.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    public static Connection connectToDatabase() {
        try {
        // Imports mySQL JDBC Driver
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        // Creates user credentials and url
        String url = "jdbc:mysql://localhost:3306/librarydb";
        String user = "root";
        String password = "";
        
        // Ends program with return credentials to connection
        return DriverManager.getConnection(url, user, password);
        } catch (SQLException e){
            // Error logging for fail to connect to database
            System.out.println("Database connection failed.");
            // Ends program
            return null;
        } catch (ClassNotFoundException e) {
            // Error logging for fail to find driver
            System.out.println("MySQL JDBC Driver is not found.");
            // Ends program
            return null;
        }
    }
}