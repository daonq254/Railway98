package com.vti.backend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import com.vti.dao.DepartmentDAO;
import com.vti.entity.Department;

public class DepartmentManagement {
	private DepartmentDAO departmentDAO;

// Hàm xử lý hiển thị danh sách phòng ban
	public DepartmentManagement() throws FileNotFoundException, IOException {
		departmentDAO = new DepartmentDAO();
	}

	public void showListDepartment() throws ClassNotFoundException {

		List<Department> listDepartments = departmentDAO.getListDepartment();

		for (Department department : listDepartments) {
			System.out.println(department.toString());
		}
	}

//	Hàm hiển thị danh sách phòng ban theo id
	public void showDepartmentByID() {
		// TODO Auto-generated method stub

	}

//	Hàm Thêm mới phòng ban
	public void createNewDepartment() {
		// TODO Auto-generated method stub

	}

}
