package com.vti.frontend;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Program9 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Code1");
		System.out.println("Code2");
		System.out.println("Code3");
		System.out.println("Code4");
		System.out.println("Code5");

//		int number1 = 0;
//		int number2 = 0;
//		try {
//			System.out.println("Mời bạn nhập số thứ 1: ");
//			number1 = scanner.nextInt();
//
//			System.out.println("Mời bạn nhập số thứ 2: ");
//			number2 = scanner.nextInt();
//		} catch (InputMismatchException e) {
//			System.out.println("Dữ liệu bạn nhập vào không chính xác");
//		}

		try {

			System.out.println("Mời bạn nhập số thứ 1: ");
			int number1 = scanner.nextInt();

			System.out.println("Mời bạn nhập số thứ 2: ");
			int number2 = scanner.nextInt();
//			
			float result_division = number1 / number2; // Exception: ArithmeticException ==> Dừng chương trình
			System.out.println("Kết quả phép tính là: " + (number1 / number2));

//			
			String myName = "daonq";
			System.out.println("Số ký tự trong tên của bạn là: " + myName.length());
//			
			int[] intArray = { 1, 2, 4, 6 };
			System.out.println(intArray[1]);
		} catch (ArithmeticException e) {
			System.out.println("Không thể thực hiện phép chia cho số )");
			System.out.println("Thông tin chi tiết Exception: ");
			e.printStackTrace();
		} catch (InputMismatchException e) {
			System.out.println("Dữ liệu bạn nhập vào không chính xác");
			e.printStackTrace();
		} catch (NullPointerException e) {
			System.out.println("Dữ liệu bị rỗng, hãy kiểm tra lại");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Chương trình không hợp lệ, hãy kiểm tra lại");
			e.printStackTrace();
		} finally {
			System.out.println("Đã hoàn thành đoạn Code 5!");
		}

		System.out.println("Code6");
		System.out.println("Code7");
		System.out.println("Code8");

	}
}
