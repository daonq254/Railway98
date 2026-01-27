package com.vti.backend.businesslayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.backend.datalayer.IUserRepository;
import com.vti.backend.datalayer.UserRepository;
import com.vti.entiy.Employee;

public class UserService implements IUserService {
	private IUserRepository userRepository;

	public UserService() throws FileNotFoundException, IOException {
		super();
		userRepository = new UserRepository();
	}

	@Override
	public List<Employee> getEmployeeByProjectId(int projectId) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return userRepository.getEmployeeByProjectId(projectId);
	}

}
