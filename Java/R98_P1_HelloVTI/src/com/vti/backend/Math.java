package com.vti.backend;

public class Math {
//	

//	Tính tổng
	public void sum() {
		System.out.println("Nhập vào số thứ 1: ");
		int a = 5;
		System.out.println("Nhập vào số thứ 2: ");
		int b = 10;
		int result = a + b;
		System.out.println("Tổng của 2 số là: " + result);
	}

//	Tính hiệu
	public void minus() {
		System.out.println("Nhập vào số thứ 1: ");
		int a1 = 5;
		System.out.println("Nhập vào số thứ 2: ");
		int b1 = 10;
		int result_minus = a1 - b1;
		System.out.println("Hiệu của 2 số là: " + result_minus);
	}

//	Tính phép nhân
	public int multiply(int number1, int number2) {
		int result_Multiply = number1 * number2;

		return result_Multiply;
	}

}
