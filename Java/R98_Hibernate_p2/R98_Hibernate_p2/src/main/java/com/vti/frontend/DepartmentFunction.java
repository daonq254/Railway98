package com.vti.frontend;

import java.util.List;
import java.util.Scanner;

import com.vti.entity.Department;
import com.vti.repository.DepartmentRepository;

public class DepartmentFunction {
	DepartmentRepository departmentRepository = new DepartmentRepository();
	Scanner scanner = new Scanner(System.in);

//	Hiển thị danh sách phòng ban
	public void showListDepartment() {

//		Lấy danh sách phòng ban
		List<Department> listDepartments = departmentRepository.getListDepartments();
		for (Department department : listDepartments) {
			System.out.println("ID: " + department.getId() + " Name: " + department.getName());
		}

	}

	public void getDepartmentById() {
		System.out.println("Mời bạn nhập vào Id của phòng ban cần tìm");
		short id = scanner.nextShort();
		Department department = departmentRepository.getDepartmentByID(id);
		System.out.println("ID: " + department.getId() + " Name: " + department.getName());

	}

//	Tạo mới phòng ban
}
