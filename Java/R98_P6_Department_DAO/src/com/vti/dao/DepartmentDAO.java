package com.vti.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vti.entity.Department;
import com.vti.utils.JdbcUtils;

public class DepartmentDAO {
	private JdbcUtils jdbcUtils;

	public DepartmentDAO() throws FileNotFoundException, IOException {
		jdbcUtils = new JdbcUtils();
	}

	public List<Department> getListDepartment() throws ClassNotFoundException, SQLException {

//			Tạo kết nối tới DB Server
		String sql_SelectDepartment = "SELECT * FROM Department ORDER BY DepartmentID;";
//			Chạy lệnh SQL 
		ResultSet resultSet = jdbcUtils.executeQuery(sql_SelectDepartment);

		List<Department> listdeDepartments = new ArrayList<Department>();
		while (resultSet.next()) {
			Department department = new Department();
			department.setId(resultSet.getInt(1));
			department.setName(resultSet.getString(2));

			listdeDepartments.add(department);
		}
		return listdeDepartments;

	}

	public Department getDepartmentByID(int idFind) throws ClassNotFoundException, SQLException {
		String sql_SelectDepartmentbyID = "SELECT * FROM department WHERE DepartmentID=?;";
		PreparedStatement preparedStatement = jdbcUtils.createPrepareStatement(sql_SelectDepartmentbyID);
		preparedStatement.setInt(1, idFind);

		ResultSet resultSet = preparedStatement.executeQuery();

		if (resultSet.next()) {
			Department department = new Department();
			department.setId(resultSet.getInt(1));
			department.setName(resultSet.getString(2));

			return department;
		}

		return null;
	}

	public Boolean createNewDepartment(String dep_name) throws SQLException, ClassNotFoundException {

		String sql_InsertDepartment = "INSERT INTO department (`DepartmentName`) VALUES (?);";
		PreparedStatement preparedStatement = jdbcUtils.createPrepareStatement(sql_InsertDepartment);
		preparedStatement.setString(1, dep_name);

		int result = preparedStatement.executeUpdate(); // 0 1
		if (result == 1) {
			return true;
		}
		return false;
	}

}
