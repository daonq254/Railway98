package com.vti.backend.datalayer;

import java.sql.SQLException;
import java.util.List;

import com.vti.entiy.Employee;

public interface IUserRepository {

	List<Employee> getEmployeeByProjectId(int projectId) throws ClassNotFoundException, SQLException;

}
