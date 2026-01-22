package com.vti.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcUtils {
	private Properties property;
	private Connection connection;

	public JdbcUtils() throws FileNotFoundException, IOException {
		property = new Properties();
		property.load(new FileInputStream(
				"C:\\Users\\ThinkPad\\eclipse-workspace\\Railway98\\Java\\R98_P7_AccountManagement_3Layers\\src\\com\\vti\\resources\\database.properties"));
	}

	public void connnectionTestting() throws ClassNotFoundException, SQLException {
		String url = property.getProperty("url");
		String username = property.getProperty("username");
		String password = property.getProperty("password");
		String dirver = property.getProperty("driver");

		Class.forName(dirver);
		connection = DriverManager.getConnection(url, username, password);
		System.out.println("Connect Success");
	}

	public Connection getConnection() throws ClassNotFoundException, SQLException {
		String url = property.getProperty("url");
		String Username = property.getProperty("username");
		String password = property.getProperty("password");
		String dirver = property.getProperty("driver");
		Class.forName(dirver);
		connection = DriverManager.getConnection(url, Username, password);
		return connection;
	}

	public void disConnection() throws SQLException {
		connection.close();
	}

	public ResultSet executeQuery(String sql) throws ClassNotFoundException, SQLException {
		Connection connnection = getConnection();
		Statement statement = connnection.createStatement();
		ResultSet result = statement.executeQuery(sql);
		return result;
	}

	public PreparedStatement createPrepareStatement(String sql) throws ClassNotFoundException, SQLException {
		Connection connnection = getConnection();
		PreparedStatement preStatement = connnection.prepareStatement(sql);
		return preStatement;
	}

}
