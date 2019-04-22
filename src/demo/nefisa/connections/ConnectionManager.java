package demo.nefisa.connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.TimeZone;

public class ConnectionManager {
	
	private static ConnectionManager instance = null;
	
	private final String userName = "root";
	private final String password = "sodabikarbona";
	private final String CONN_STRING = "jdbc:mysql://localhost/phonebookdb?serverTimezone=" + TimeZone.getDefault().getID();
	
	private Connection conn = null;
	
	private ConnectionManager() {
		
	}
	
	public static ConnectionManager getInstance() {
		if ( instance == null)
			instance = new ConnectionManager();
		return instance;
	}
	
	private boolean openConnection() {
		try {
			conn = DriverManager.getConnection(CONN_STRING, userName, password);
			return true;
		} catch (SQLException e) {
			System.err.println(e);
			return false;
		}
	}
	
	public Connection getConnection() {
		if (conn == null) {
			if (openConnection())
				return conn;
			else
				return null;
		}
		return conn;
	}
	
	public void closeConnection() {
		try {
			conn.close();
			conn = null;
		} catch (SQLException e) {
			System.err.println(e);
		}
	}
}