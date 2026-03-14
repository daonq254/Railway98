package com.vti.frontend;

import java.util.Scanner;

public class DemoDepartment {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		DepartmentFunction departmentFunction = new DepartmentFunction();
		while (true) {
			System.out.println("CHương trình quản lý phòng ban..");
			System.out.println("Mời bạn nhập vào chức năng muốn sử dụng");
			System.out.println("1. Lấy danh sách tất cả các phòng ban trên hệ thống");
			System.out.println("2. Tìm phòng ban theo ID");
			System.out.println("3. Tìm phòng ban theo Name");
			System.out.println("4. Tạo mới 1 phòng");
			System.out.println("5. Thoát");
			int choose = scanner.nextInt();
			switch (choose) {
			case 1:
//				
				System.out.println("Danh sách phòng ban trên hệ thống");
				departmentFunction.showListDepartment();
				break;
			case 2:
				System.out.println("Nhập vào ID của phòng ban");
				departmentFunction.getDepartmentById();
				break;
			case 3:
				System.out.println("Nhập vào tên phòng ban cần tìm kiếm");

				break;

			case 4:

				break;
			default:
				break;
			}

		}
	}
}
