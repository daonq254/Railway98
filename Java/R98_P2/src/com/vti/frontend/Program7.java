package com.vti.frontend;

import java.util.Scanner;

import com.vti.backend.MathManagement;

public class Program7 {
	public static void main(String[] args) {
		MathManagement mathManagement = new MathManagement();
		Scanner scanner = new Scanner(System.in);

		System.out.println("Mời bạn nhập vào số thứ 1: ");
		int a = scanner.nextInt();
		System.out.println("Mời bạn nhập vào số thứ 2: ");

		int b = scanner.nextInt();

//	Tính tổng 2 số

		int sumResult = mathManagement.sum(a, b);

		System.out.println("Tổng của 2 số là: " + sumResult);

//		int result_sumInt = mathManagement.sumInt(a, b);
//
//		System.out.println("Kết quả phép cộng 2 số nguyên là: " + result_sumInt);
//		System.out.println("Kết quả phép cộng 3 số nguyên là: " + mathManagement.sum_3_Int(1, 2, 6));
// Phép tính tổng  ==> sum  ==> 3 cách
//		mathManagement.sumInt(1, 3);
//		mathManagement.sum_3_Int(1, 2, 6);
//		mathManagement.sum_float(1.2f, 2.5f);

//		mathManagement.sum(1, 3);
//
//		mathManagement.sum(1.3f, 4.5f);
//
//		mathManagement.sum(1, 2, 4);
	}

}
