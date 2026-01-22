package com.vti.backend.presentationlayer;

import java.util.List;

import com.vti.backend.businesslayer.DepartmentService;
import com.vti.backend.businesslayer.IDepartmentService;
import com.vti.entity.Department;

public class DepartmentController {
	private IDepartmentService departmentService;

	public DepartmentController() {
		super();
		departmentService = new DepartmentService();
	}

	public List<Department> getAllDepartment() {
		// Tiếp nhận yêu cầu từ Frontend đẩy về
		// Validate dữ liệu
		// Xử lý Exception
		List<Department> listDepartments = departmentService.getAllDepartment();
		return null;
	}

}
