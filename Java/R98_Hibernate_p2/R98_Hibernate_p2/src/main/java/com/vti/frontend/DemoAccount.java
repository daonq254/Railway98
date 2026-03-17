package com.vti.frontend;

import java.util.Scanner;

public class DemoAccount {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		AccountFunction accountFunction = new AccountFunction();
		while (true) {
			System.out.println("------MỜI BẠN CHỌN CHỨC NĂNG------");
			String leftAlignFormat = "| %-72s |%n";
			System.out.format("+--------------------------------------------------------------------------+%n");
			System.out.format("|                        Choose please                                     |%n");
			System.out.format("+--------------------------------------------------------------------------+%n");
			System.out.format(leftAlignFormat, "1. Danh sách Account trên hệ thống");
			System.out.format(leftAlignFormat, "2. Tìm Account Theo ID");
			System.out.format(leftAlignFormat, "3. Tạo mới Account");
			System.out.format(leftAlignFormat, "4. Xóa Account");
			System.out.format(leftAlignFormat, "5. Update Account");
			System.out.format(leftAlignFormat, "6.  Exit");
			System.out.format("+--------------------------------------------------------------------------+%n");
			int choose = scanner.nextInt();
			switch (choose) {
			case 1:
				accountFunction.showListAccount();
				break;
			case 2:
				accountFunction.getAccountById();
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
			case 6:
				return;
			default:
				System.out.println("Nhập lại:");
				break;
			}
		}

	}
}
