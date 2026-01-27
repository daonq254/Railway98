package com.vti.backend.datalayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vti.entiy.Employee;
import com.vti.entiy.Role;
import com.vti.utils.JdbcUtils;

public class UserRepository implements IUserRepository {
	private JdbcUtils jdbcUtils;

	public UserRepository() throws FileNotFoundException, IOException {
		jdbcUtils = new JdbcUtils();
	}

	@Override
	public List<Employee> getEmployeeByProjectId(int projectId) throws ClassNotFoundException, SQLException {
		String sql = "SELECT * FROM users WHERE project_id =? AND role = 'EMPLOYEE'";
		PreparedStatement preparedStatement = jdbcUtils.createPrepareStatement(sql);
		preparedStatement.setInt(1, projectId);
		ResultSet resultSet = preparedStatement.executeQuery();
		List<Employee> listEmployees = new ArrayList<>();

		while (resultSet.next()) {
			Employee employee = new Employee(resultSet.getInt("id"), resultSet.getString("full_name"),
					resultSet.getString("email"), resultSet.getString("password"), resultSet.getInt("project_id"),
					Role.valueOf(resultSet.getString("role")), resultSet.getString("pro_skill"));

			listEmployees.add(employee);
		}

		return listEmployees;
	}

}
