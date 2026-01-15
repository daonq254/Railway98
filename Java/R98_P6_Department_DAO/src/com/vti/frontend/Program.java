package com.vti.frontend;

import com.vti.backend.DepartmentManagement;
import com.vti.utils.ScannerUtils;

public class Program {
	public static void main(String[] args) {
		DepartmentManagement departmentManagement = new DepartmentManagement();

		while (true) {
			System.out.println("Mời bạn chọn chức năng");
			System.out.println("1. Xem danh sách phòng ban");
			System.out.println("2. Tìm phòng ban theo ID");
			System.out.println("3. Thêm mới phòng ban");

			int choose = ScannerUtils.inputInt();

			switch (choose) {
			case 1:
//		1. Xem danh sách phòng ban
				departmentManagement.showListDepartment();
				break;
			case 2:
//		2. Tìm phòng ban theo ID
				departmentManagement.showDepartmentByID();
				break;
			case 3:
//		3. Thêm mới phòng ban
				departmentManagement.createNewDepartment();

				break;
			default:
				System.out.println("Nhập lại");
				break;
			}
		}

	}
}
