package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {

    private String driver = "com.mysql.cj.jdbc.Driver";

    private String url = "jdbc:mysql://localhost:3306/test_web_app";
    private String username = "root";
    private String password = "";

    private Connection connection;

    public Connection getConnection() {
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

}
