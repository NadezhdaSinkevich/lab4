package by.application.javaWeb.repository.config;

import java.sql.Connection;
import java.sql.DriverManager;

public abstract class DBConnection {

    private final static String USER = "root";
    private final static String PASS = "root123456";
    private final static String DBNAME = "automarketdb";
    private final static String URL = "jdbc:mysql://localhost:3306/"+DBNAME;

    public static Connection getConnection(){
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            con = DriverManager.getConnection(URL, USER, PASS);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return con;
    }

}
