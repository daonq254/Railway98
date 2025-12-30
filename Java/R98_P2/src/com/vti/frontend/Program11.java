package com.vti.frontend;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Program11 {

//	MAIN
	public static void main(String[] args) {
		System.out.println("Mời bạn nhập vào tuổi của bạn:");
		int age = inputAge();

		System.out.println("Tuổi bạn là: " + age);
	}

//	Viết hàm inputAge
// Viết phương thức để người dùng nhập vào 1 số nguyên
	public static int inputAge() {
		Scanner scanner = new Scanner(System.in);
		while (true) {

			try {
				int age = scanner.nextInt(); //
//				Nhập vào 1 số nguyên ==> 1. Số >=0, Số <0
				if (age >= 0) {
					return age;
				} else {
					System.out.println("Bạn phải nhập vào 1 số nguyên dương");
					System.out.println("Nhập lại");
				}
			} catch (InputMismatchException e) {
				System.out.println("Không đúng định dạng số");
//				e.printStackTrace();
				scanner.nextLine();
				System.out.println("Nhập lại");
			}

		}

	}
}
