package BeautyIt.BP.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    public static Connection getConnectionToDatabase() {
        Connection connection = null;

        try {
            // load the driver class
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Class.forName(com.mysql.jdbc.Driver);");
            // get hold of the DriverManager
            //Humus Database
            //connection = (Connection) DriverManager.getConnection("jdbc:mysql://mysql3000.mochahost.com:3306?user=humusam_root&password=root123&serverTimezone=UTC");
            connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/humusam_root","root","YLf{}cJ,Kvd%");
            System.out.println("connection : " + connection);
        } catch (ClassNotFoundException e) {
            System.out.println("Where is your MySQL JDBC Driver?");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
        }
        if (connection != null) {
            System.out.println("Connected ");
        }
        return connection;
    }
}
