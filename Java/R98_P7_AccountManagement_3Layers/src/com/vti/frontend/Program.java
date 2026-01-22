package com.vti.frontend;

import com.vti.utils.ScannerUtils;

public class Program {
	public static void main(String[] args) {
		while (true) {
			System.out.format("+--------------------------------------------------------------------------+%n");
			System.out.format("|                        Chọn chức năng                                    |%n");
			System.out.format("+--------------------------------------------------------------------------+%n");
			System.out.format("| %-72s |%n", "1. Hiển thị danh sách phòng ban theo ID");
			System.out.format("| %-72s |%n", "2. Tìm kiếm phòng ban theo ID");
			System.out.format("| %-72s |%n", "3. Kiểm tra tồn tại tên phòng ban");
			System.out.format("| %-72s |%n", "4. Tạo mới phòng ban");
			System.out.format("| %-72s |%n", "5. Cập nhật tên phòng ban");
			System.out.format("| %-72s |%n", "6. Xóa phòng ban");
			System.out.format("| %-72s |%n", "7. Thoát chương trình");
			System.out.format("+--------------------------------------------------------------------------+%n");

			int choose = ScannerUtils.inputIntPositive();

			switch (choose) {
			case 1:
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
			case 6:
				break;
			case 7:
				return;

			default:
				System.out.println("Nhập lại:");
				break;
			}
		}
	}
}
