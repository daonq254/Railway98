package com.vti.backend.datalayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vti.entity.Department;
import com.vti.utils.JdbcUtils;

public class DepartmentRepository implements IDepartmentRepository {
	private JdbcUtils jdbcUtils;

	public DepartmentRepository() throws FileNotFoundException, IOException {
		super();
		jdbcUtils = new JdbcUtils();
	}

	@Override
	public List<Department> getAllDepartment() throws ClassNotFoundException, SQLException {
//		Tạo kết nối tới DB Server
		String sql_SelectDepartment = "SELECT * FROM Department ORDER BY DepartmentID;";
//		Chạy lệnh SQL 
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

}
