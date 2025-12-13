package com.vti.frontend;

import java.util.Scanner;

public class Program8 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

//		System.out.println("Mời bạn nhập vào số thứ 1:");
//		int number1 = scanner.nextInt(); // 10
//
//		System.out.println("Mời bạn nhập vào số thứ 2:");
//		int number2 = scanner.nextInt(); // 5

//		So sánh 2 số
//		Nếu number1 > number2  ==> Số number1  lớn hơn number2
//		Nếu number1 < number2  ==> Số number1  nhỏ hơn number2
//		10 > 5   10 > 10  == false
//		if (number1 > number2) {
//			System.out.println("Số number1  lớn hơn number2");
//		} else if (number1 == number2) {
//			System.out.println("Sô number1 bằng number2");
//		} else {
//			System.out.println("Số number1  nhỏ hơn number2");
//		}

//		
		System.out.println("Mời bạn nhập vào tuổi");
		int age = scanner.nextInt(); // 10, -20

//		if (age > 0) {
//			System.out.println("Thông tin chính xác");
//		} else {
//			System.out.println("Thông tin chưa chính xác!!");
//		}

//		
		String ageInfo = (age > 0) ? "Thông tin chính xác" : "Thông tin chưa chính xác!!";
		System.out.println(ageInfo);
	}
}
