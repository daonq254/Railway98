package com.vti.frontend;

import java.util.List;

import com.vti.backend.presentationlayer.DepartmentController;
import com.vti.entity.Department;

public class DepartmentProgram {
	private DepartmentController departmentController;

	public DepartmentProgram() {
		super();
		departmentController = new DepartmentController();
	}

	// Hiển thị danh sách phòng ban
	public void getAllDepartment() {
// Cần có danh sách phòng ban
		List<Department> listDepartments = departmentController.getAllDepartment();
	}

}
