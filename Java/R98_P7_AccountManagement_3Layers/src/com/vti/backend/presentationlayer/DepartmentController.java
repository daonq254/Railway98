package com.vti.backend.presentationlayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.backend.businesslayer.DepartmentService;
import com.vti.backend.businesslayer.IDepartmentService;
import com.vti.entity.Department;

public class DepartmentController {
	private IDepartmentService departmentService;

	public DepartmentController() throws FileNotFoundException, IOException {
		super();
		departmentService = new DepartmentService();
	}

	public List<Department> getAllDepartment() throws ClassNotFoundException, SQLException {
		// Tiếp nhận yêu cầu từ Frontend đẩy về
		// Validate dữ liệu
		// Xử lý Exception
		List<Department> listDepartments = departmentService.getAllDepartment();
		return listDepartments;
	}

}
