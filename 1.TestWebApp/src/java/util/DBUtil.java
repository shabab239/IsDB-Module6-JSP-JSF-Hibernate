package util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Shabab-1281539
 */
public class DBUtil {

    final static String url = "jdbc:mysql://localhost:3306/test_web_app";
    final static String driver = "com.mysql.cj.jdbc.Driver";
    final static String username = "root";
    final static String password = "";

    private static Connection connection;

    public static Connection getConnection() {
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

}
