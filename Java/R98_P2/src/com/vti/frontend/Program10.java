package com.vti.frontend;

import java.util.Scanner;

import com.vti.backend.MathManagement;

public class Program10 {
	public static void main(String[] args) throws Exception {

		Scanner scanner = new Scanner(System.in);
		MathManagement mathManagement = new MathManagement();
		System.out.println("Mời bạn nhập số thứ 1: ");
		int number1 = scanner.nextInt();

		System.out.println("Mời bạn nhập số thứ 2: ");
		int number2 = scanner.nextInt();
//		float result_devide;
//		try {
//			result_devide = mathManagement.divide(number1, number2);
//			System.out.println("Kết quả phép chia là: " + result_devide);
//		} catch (Exception e) {
//			System.out.println("Không thể thực hiện phép chia này");
//		}

//		float result_devide = mathManagement.divide(number1, number2);
//		try {
//			float result_devide = mathManagement.divide(number1, number2);
//			System.out.println("Kết quả phép chia là: " + result_devide);
//
//		} catch (Exception e) {
//			System.out.println("Không thể thực hiện phép tính");
//		}
		float result_devide = mathManagement.divide(number1, number2);
//		
		System.out.println("Next Code!!");
	}
}
