package com.vti.frontend;

import java.util.Scanner;

import com.vti.backend.StaffManagement;

public class Program {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		StaffManagement staffManagement = new StaffManagement();
		while (true) {
			// Hiển thị menu cho người sử dụng
			System.out.println("======================================================================");
			System.out.println("=================Lựa chọn chức năng bạn muốn sử dụng==================");
			System.out.println("===              1. Thêm mới cán bộ.                               ===");
			System.out.println("===              2. Tìm kiếm theo họ tên.                          ===");
			System.out.println("===              3. Hiện thị thông tin về danh sách các cán bộ.    ===");
			System.out.println("===              4. Nhập vào tên của cán bộ và delete cán bộ đó    ===");
			System.out.println("===              5. Thoát khỏi chương trình.                       ===");
			System.out.println("======================================================================");

//			Dừng chương trình cho người dùng lựa chọn chức năng: 1 2 3 4 5 
			int menuChoose = scanner.nextInt();
			switch (menuChoose) {
			case 1:
				staffManagement.addNewStaff();
				break;
			case 2:

				staffManagement.findByName();
				break;
			case 3:
				staffManagement.showListStaff();

				break;
			case 4:
				staffManagement.deleteStaffByName();
				break;
			case 5:
				return;
			default:
				System.out.println("Lựa chọn không đúng, mời bạn nhập lại.");
				break;
			}
		}

	}
}
