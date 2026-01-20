package com.vti.backend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.dao.DepartmentDAO;
import com.vti.entity.Department;
import com.vti.utils.ScannerUtils;

public class DepartmentManagement {
	private DepartmentDAO departmentDAO;

// Hàm xử lý hiển thị danh sách phòng ban
	public DepartmentManagement() throws FileNotFoundException, IOException {
		departmentDAO = new DepartmentDAO();
	}

	public void showListDepartment() throws ClassNotFoundException, SQLException {

		List<Department> listDepartments = departmentDAO.getListDepartment();

		System.out.println("+-----------+--------------------------------------+");
		System.out.format("|    %-7s|      %-32s|%n", "ID", "Department Name");

		System.out.println("+-----------+--------------------------------------+");

		for (Department department : listDepartments) {
			System.out.format("|    %-7d|      %-32s|%n", department.getId(), department.getName());
		}

		System.out.println("+-----------+--------------------------------------+");
	}

//	Hàm hiển thị danh sách phòng ban theo id
	public void showDepartmentByID() throws ClassNotFoundException, SQLException {
		System.out.println("Mời bạn nhập vào ID của phòng ban cần tìm kiếm");
		int idFind = ScannerUtils.inputIntPositive();
		Department department = departmentDAO.getDepartmentByID(idFind);
		if (department != null) {
			System.out.println("+-----------+--------------------------------------+");
			System.out.format("|    %-7s|      %-32s|%n", "ID", "Department Name");
			System.out.println("+-----------+--------------------------------------+");
			System.out.format("|    %-7d|      %-32s|%n", department.getId(), department.getName());
			System.out.println("+-----------+--------------------------------------+");
		} else {
			System.out.println("Không có phòng ban cần tìm kiếm!!!");
		}
	}

//	Hàm Thêm mới phòng ban
	public void createNewDepartment() throws ClassNotFoundException, SQLException {
		System.out.println("Mời bạn nhập vào tên phòng ban cần tạo mới");
		String dep_name = ScannerUtils.inputString();
		Boolean resultCreateDepartment = departmentDAO.createNewDepartment(dep_name);
		if (resultCreateDepartment) {
			System.out.println("Đã thêm mới phòng ban thành công");
			showListDepartment();
		} else {
			System.out.println("Đã có lỗi xảy ra, hãy kiểm tra lại");
		}
	}

}
