package com.vti.frontend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.vti.entity.Department;

public class Program {
	public static void main(String[] args) {
		System.out.println("Hiển thị danh sách Department trên hệ thống");

//		Cần có danh sách phòng ban
//		JDBC
//		Cần có kết nối
		String url = "jdbc:mysql://localhost:3306/testingsystem?autoReconnect=true&useSSL=false&characterEncoding=latin1";
		String user = "root";
		String password = "root";

		try {
//			Tạo kết nối tới DB Server
			Connection connection = DriverManager.getConnection(url, user, password);
			Statement statement = connection.createStatement();

			String sql_SelectDepartment = "SELECT * FROM department ORDER BY DepartmentID;";
//			Chạy lệnh SQL 
			ResultSet resultSet = statement.executeQuery(sql_SelectDepartment);

//			Chuyển đổi ResultSet sang list<Deparment>
			List<Department> listDepartments = new ArrayList();
			while (resultSet.next()) {
				Department department = new Department();
				department.setId(resultSet.getInt("DepartmentID"));
				department.setName(resultSet.getString("DepartmentName"));
				listDepartments.add(department);

//				int depId = resultSet.getInt("DepartmentID");
//				String depName = resultSet.getString("DepartmentName");
//				System.out.println(depId + "     " + depName);
			}

//			Hiển thị phòng ban đang có trong resultSet
			System.out.println("DepartmentID     DepartmentName");
			for (Department department : listDepartments) {
				System.out.println(department.toString());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

//		Tạo câu lệnh SQL để lấy danh sách phòng ban

//		Hiển thị

	}
}
