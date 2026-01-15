package com.vti.frontend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vti.entity.Department;
import com.vti.utils.JdbcUtils;

public class DemoJDBCUtils {
	public static void main(String[] args)
			throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		JdbcUtils jdbcUtils = new JdbcUtils();
//		jdbcUtils.connnectionTestting();

		String sql_SelectDepartment = "SELECT * FROM department ORDER BY DepartmentID;";
		ResultSet resultSet = jdbcUtils.executeQuery(sql_SelectDepartment);

//		Chuyển đổi ResultSet sang list<Deparment>
		List<Department> listDepartments = new ArrayList();
		while (resultSet.next()) {
			Department department = new Department();
			department.setId(resultSet.getInt("DepartmentID"));
			department.setName(resultSet.getString("DepartmentName"));
			listDepartments.add(department);

//			int depId = resultSet.getInt("DepartmentID");
//			String depName = resultSet.getString("DepartmentName");
//			System.out.println(depId + "     " + depName);
		}

//		Hiển thị phòng ban đang có trong resultSet
		System.out.println("DepartmentID     DepartmentName");
		for (Department department : listDepartments) {
			System.out.println(department.toString());
		}
	}
}
