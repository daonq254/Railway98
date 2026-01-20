package com.vti.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
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

	public List<Department> getListDepartment() throws ClassNotFoundException {
		try {
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

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

}
