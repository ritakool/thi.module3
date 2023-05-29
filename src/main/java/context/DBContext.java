package context;

import java.sql.*;

public class DBContext {
    private final String URL = "jdbc:mysql://localhost:3306/quanlynhansu";
    private final String USER = "root";
    private final String PASS = "123456";

    public Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(URL, USER, PASS);
    }
}
