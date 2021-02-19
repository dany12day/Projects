package ConexiuneBazaDate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
public class ConexiuneBazaDate {
	private static final Logger LOGGER = Logger.getLogger(ConexiuneBazaDate.class.getName());
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String DBURL = "jdbc:mysql://79.114.234.218:3306/Piscicola";
	//:3306 192.168.1.199
	private static final String USER = "daniel";
	private static final String PASS = "daniel";
	private static ConexiuneBazaDate singleInstance = new ConexiuneBazaDate();
	private ConexiuneBazaDate() {
		try {
			Class.forName(DRIVER);
		}catch(ClassNotFoundException e) {
			
		}
	}
	
	private Connection createConnection() {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(DBURL, USER, PASS);
		} catch (SQLException e) {
			System.out.println("conectare esuata");
		}
		return connection;
		
	}
	public static Connection getConnection() {
		return singleInstance.createConnection();
	}
	public static void close(Connection connection) {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				
			}
		}
	}
	public static void close(Statement statement) {
		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				
			}
		}
	}
	public static void close(ResultSet resultSet) {
		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				
			}
		}
	}
}
