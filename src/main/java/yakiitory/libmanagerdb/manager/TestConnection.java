package yakiitory.libmanagerdb.manager;

import yakiitory.libmanagerdb.db.DatabaseConnection;
import java.sql.Connection;


public class TestConnection {
    public static void main(String[] args) {
        Connection testConnect = DatabaseConnection.connectToDatabase();
        if (testConnect != null) {
            System.out.println("Database connected successfully!");
        } else {
            System.out.println("Database failed to connect. Something has gone wrong.");
        }
    }
}
