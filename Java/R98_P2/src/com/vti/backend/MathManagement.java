package com.vti.backend;

public class MathManagement {
//	Hàm tính tổng 2 số nguyên
	public int sum(int number1, int number2) {
		int result = number1 + number2 + 50;

		return result;
	}

//	Hàm tính tổng 3 số nguyên
	public int sum(int number1, int number2, int number3) {
		int result = number1 + number2 + number3;

		return result;
	}

//	Hàm tính tổng 2 số thực
	public float sum(float number1, float number2) {
		float result = number1 + number2;

		return result;
	}

//	Hàm tính phép chia 2 số
	public float divide(int num1, int num2) throws Exception {
//		float result = 0;
//		try {
//			result = num1 / num2;
//			return result;
//		} catch (ArithmeticException e) {
//			System.out.println("Không thể thực hiện phép chia cho số )");
//		}
		try {
			float result = num1 / num2;
			return result;
		} catch (ArithmeticException e) {
//			Không xử lý
//			Thông báo cho chỗ sử dụng hàm biết có exception
			throw new Exception();

		}

	}

}
