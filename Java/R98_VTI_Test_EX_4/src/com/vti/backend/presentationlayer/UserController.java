package com.vti.backend.presentationlayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.backend.businesslayer.IUserService;
import com.vti.backend.businesslayer.UserService;
import com.vti.entiy.Employee;

public class UserController {
	private IUserService userService;

	public UserController() throws FileNotFoundException, IOException {
		super();
		userService = new UserService();
	}

	public List<Employee> getEmployeeByProjectId(int projectId) throws ClassNotFoundException, SQLException {

		return userService.getEmployeeByProjectId(projectId);
	}

}
