package com.vti.frontend;

public class Program1 {
	public static void main(String[] args) {
		int a1 = 1;
//		Integer a2 = 1;

//		float f1 = 2.5f;
		Float f2 = 2.5f;

//		a2.intValue();
//		f2.floatValue();

//		System.out.println("a: " + a1);
//		System.out.println("f: " + f1);

//		Chuyển đổi primative sang wrapper class ==> Boxing
		Integer a1_w = Integer.valueOf(a1); // a1_w= a1
//		a1_w.compareTo(a1_w);

//		Chuyển đổi wrapper class sang primative==> UnBoxing
		float f2_p = f2.floatValue(); // 2.5f

//		datatype casting
		byte number1 = 10;

//		code
//		code
//		code
//		Ép kiểu dữ liệu: nhỏ--> lớn  ==> up casting
		float number1_f = number1; // 10

//Ép kiểu dữ liệu: lớn--> nhỏ  ==> down casting  ==> Dữ liệu có thể mất mát
		double number2 = 30.5;
		int numbe2_i = (int) number2; // 30

		System.out.printf("number1_f: %f", number1_f);
		System.out.printf("number2: %d", numbe2_i);
	}
}
