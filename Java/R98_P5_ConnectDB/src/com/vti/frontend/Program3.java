package com.vti.frontend;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

// Thêm mới phòng ban
public class Program3 {
	public static void main(String[] args) throws FileNotFoundException, IOException {

//		JDBC
//		Cần có kết nối
//		String url = "jdbc:mysql://localhost:3306/testingsystem?autoReconnect=true&useSSL=false&characterEncoding=latin1";
//		String user = "root";
//		String password = "root";
//
		Properties properties = new Properties();
		try {
//			
			properties.load(new FileInputStream(
					"C:\\Users\\ThinkPad\\eclipse-workspace\\Railway98\\Java\\R98_P5_ConnectDB\\src\\com\\vti\\resources\\database.properties"));
			String url = properties.getProperty("url");
			String user = properties.getProperty("username");
			String password = properties.getProperty("password");

			Scanner scanner = new Scanner(System.in);
			System.out.println("Mời bạn nhập vào tên phòng ban cần thêm mới");
			String depName = scanner.next(); // mkt

//			Tạo kết nối tới DB Server
			Connection connection = DriverManager.getConnection(url, user, password);
			String sql_SelectDepartment = "INSERT INTO department(DepartmentName) VALUE(?);";
			PreparedStatement preparedStatement = connection.prepareStatement(sql_SelectDepartment);
			preparedStatement.setString(1, depName); // INSERT INTO department(DepartmentName) VALUE('depName');

//			Chạy lệnh SQL 
			int resultInsert = preparedStatement.executeUpdate(); // 1

			if (resultInsert == 1) {
				System.out.println("Thêm mới thành công");
			} else {
				System.out.println("Thêm mới không thành công");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
