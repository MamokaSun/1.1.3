package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Util {
    static String url = "jdbc:mysql://localhost/userbase?useSSL=false";
    static String userName = "your login here";
    static String password = "your password";

    public static Statement getConection() {
        try {
            Class.forName("com.mysql.jdbc.Driver").getDeclaredConstructor().newInstance();
            try {
                Connection conn = DriverManager.getConnection(url, userName, password);
                Statement statement = conn.createStatement();
                return statement;
            } catch (Exception e) {
                System.out.println("Connection failed");
                e.printStackTrace();
            }
        } catch (Exception e) {
            System.out.println("Connection failed");
            e.printStackTrace();
        }
        return null;
    }

}
