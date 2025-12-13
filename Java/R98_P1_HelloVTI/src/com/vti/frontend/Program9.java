package com.vti.frontend;

import java.util.Scanner;

public class Program9 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
// if else if else
//		Cho người dùng nhập 1 số từ 1 đến 7
//		Nếu nhập 1 ==> Chủ nhật
//		Nếu nhập 2 ==> Thứ 2hai
//		Nếu nhập 3 ==> Thứ ba
//		Nếu nhập 4 ==> Thứ tư
//		Nếu nhập 5 ==> Thứ năm
//		...
		System.out.println("Mời bạn nhập vào 1 số");
		int day = scanner.nextInt();
// Ctrl + /
//		if (day == 1) {
//			System.out.println("Chủ nhật");
//		} else if (day == 2) {
//			System.out.println("Thứ hai");
//		} else if (day == 3) {
//			System.out.println("Thứ ba");
//		} else if (day == 4) {
//			System.out.println("Thứ tư");
//		} else if (day == 5) {
//			System.out.println("Thứ năm");
//		} else if (day == 6) {
//			System.out.println("Thứ sáu");
//		} else if (day == 7) {
//			System.out.println("Thứ bảy");
//		} else {
//			System.out.println("Dữ liệu không chính xác");
//		}

		switch (day) {
		case 1: // day ==1
			System.out.println("Chủ nhật");
			break;
		case 2: // day ==2
			System.out.println("Thứ hai");
			break;
		case 3:
			System.out.println("Thứ ba");
			break;
		case 4:
			System.out.println("Thứ tư");
			break;
		case 5:
			System.out.println("Thứ năm");
			break;
		case 6:
			System.out.println("Thứ sáu");
			break;
		case 7:
			System.out.println("Thứ bảy");
			break;
		default:
			System.out.println("Dữ liệu chưa chính xác");
			break;
		}

//		
//		
	}
}
