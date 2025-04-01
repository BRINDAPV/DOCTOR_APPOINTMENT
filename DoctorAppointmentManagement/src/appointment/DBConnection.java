package appointment;

import java.sql.*;

public class DBConnection {
	 private static final String URL = "jdbc:mysql://127.0.0.1:3306/appointment_db";
	 private static final String USER = "root"; 
	 private static final String PASS = "root";
	 
	 public static Connection getConnection() throws SQLException {
	        Connection conn = DriverManager.getConnection(URL, USER, PASS);
	        return conn;
	 }
}
