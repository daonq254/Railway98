package com.vti.frontend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.vti.entity.Department;

// Lấy danh sách phòng ban theo id
public class Program2 {
	public static void main(String[] args) {

//		JDBC
//		Cần có kết nối
		String url = "jdbc:mysql://localhost:3306/testingsystem?autoReconnect=true&useSSL=false&characterEncoding=latin1";
		String user = "root";
		String password = "root";

		try {
//			
			Scanner scanner = new Scanner(System.in);
			System.out.println("Mời bạn nhập vào phòng ban cần tìm kiếm");
			int depID = scanner.nextInt(); // 2

//			Tạo kết nối tới DB Server
			Connection connection = DriverManager.getConnection(url, user, password);
//			Statement statement = connection.createStatement();
			String sql_SelectDepartment = "SELECT * FROM department WHERE DepartmentID = ?;";
			PreparedStatement preparedStatement = connection.prepareStatement(sql_SelectDepartment);
			preparedStatement.setInt(1, depID); // SELECT * FROM department WHERE DepartmentID = depID;

//			Chạy lệnh SQL 
			ResultSet resultSet = preparedStatement.executeQuery();
			Department department = null;

			if (resultSet.next()) {
				department = new Department();
				department.setId(resultSet.getInt("DepartmentID"));
				department.setName(resultSet.getString("DepartmentName"));
			}

//			Hiển thị
			if (department != null) {
				System.out.println(department.toString());

			} else {
				System.out.println("Không có phòng ban này");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

//		Tạo câu lệnh SQL để lấy danh sách phòng ban

//		Hiển thị

	}
}
