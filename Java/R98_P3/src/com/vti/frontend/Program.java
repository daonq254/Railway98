package com.vti.frontend;

import com.vti.backend.MathManagement;

public class Program {
//
	public static void main(String[] args) {

		abc();

		int number1 = 10;
		int number2 = 20;

		MathManagement mathManagement1 = new MathManagement();
		mathManagement1.sum(number1, number2);

		System.out.println("Tổng của 2 số là: " + MathManagement.sum(number1, number2));
		System.out.println("Tích của 2 số là: " + MathManagement.multiply(number1, number2));
	}

//	

	public static void abc() {
		System.out.println("abc");
	}
}
