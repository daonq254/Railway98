package com.vti.frontend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.backend.presentationlayer.DepartmentController;
import com.vti.entity.Department;

public class DepartmentProgram {
	private DepartmentController departmentController;

	public DepartmentProgram() throws FileNotFoundException, IOException {
		super();
		departmentController = new DepartmentController();
	}

	// Hiển thị danh sách phòng ban
	public void getAllDepartment() throws ClassNotFoundException, SQLException {
// Cần có danh sách phòng ban
		List<Department> listDepartments = departmentController.getAllDepartment();

		System.out.println("+-----------+--------------------------------------+");
		System.out.format("|    %-7s|      %-32s|%n", "ID", "Department Name");

		System.out.println("+-----------+--------------------------------------+");

		for (Department department : listDepartments) {
			System.out.format("|    %-7d|      %-32s|%n", department.getId(), department.getName());
		}

		System.out.println("+-----------+--------------------------------------+");
	}

}
