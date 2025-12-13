package com.vti.frontend;

import java.util.Scanner;

public class Program7 {
	public static void main(String[] args) {
//		System.out.println("Chương trình tính tổng 2 số");

//		System.out.println("Mời bạn nhập vào số thứ 1: ");
//		Dừng lại, cho người dùng nhập liệu
		Scanner scanner = new Scanner(System.in);
//		int number1 = scanner.nextInt(); // Dừng chương trình lại, yêu cầu người dùng nhập vào số nguyên ==> lấy dữ liệu
//
//		System.out.println("Mời bạn nhập vào số thứ 2: ");
//		int number2 = scanner.nextInt();
//
//		int result = number1 + number2;
//		System.out.println("Tổng của 2 số là: " + result);

//		In thông tin tên + tuổi của người dùng
		System.out.println("Mời bạn nhập vào tên");
		String name = scanner.nextLine();// lấy cả dòng, đến khi nào có enter
//		String name = scanner.next(); 
		// Nguyen Dao ==> Nguyen
		// email, username, ...

		System.out.println("Name: " + name);

		scanner.close(); // Đóng Scanner ==> tránh rò rỉ bộ lớn

	}
}
