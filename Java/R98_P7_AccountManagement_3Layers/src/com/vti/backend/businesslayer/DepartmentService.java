package com.vti.backend.businesslayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.backend.datalayer.DepartmentRepository;
import com.vti.backend.datalayer.IDepartmentRepository;
import com.vti.entity.Department;

public class DepartmentService implements IDepartmentService {
	private IDepartmentRepository departmentRepository;

	public DepartmentService() throws FileNotFoundException, IOException {
		super();
		departmentRepository = new DepartmentRepository();
	}

	@Override
	public List<Department> getAllDepartment() throws ClassNotFoundException, SQLException {
//		
//		
		List<Department> listDepartments = departmentRepository.getAllDepartment();
		return listDepartments;
	}

//	
}
