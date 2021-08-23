package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DBConnector {
	
	static String fileName = "config.properties";

	private static String url = "jdbc:mysql://qa.db.eatigo.systems:3306";    
	private static String driverName = "com.mysql.cj.jdbc.Driver";   
	private static String username = PropertyReader.getProperty(fileName, "DB_username");   
	private static String password = PropertyReader.getProperty(fileName, "DB_password"); 
	private static Connection con;
	private static Statement stmt;
	private static ResultSet rs;


	static Logger log = LogManager.getLogger(DBConnector.class.getName());



	public static Connection getConnection() {
		try {
			Class.forName(driverName);
			try {
				con = DriverManager.getConnection(url, username, password);
			} catch (SQLException ex) {
				// log an exception. fro example:
				log.error("Failed to create the database connection."); 
				ex.printStackTrace();
			}
		} catch (ClassNotFoundException ex) {
			// log an exception. for example:
			log.error("Driver not found. \n" + ex.getStackTrace()); 
		}
		return con;
	}


	public static ResultSet executeQuery(String query) {
		con = getConnection();
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   	

		return rs;

	}

}
