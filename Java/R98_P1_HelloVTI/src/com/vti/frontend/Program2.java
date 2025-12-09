package com.vti.frontend;

public class Program2 {
	public static void main(String[] args) {
//		Tạo nhanh hàm in thông tin: sout
//		Viết chương trình tính tổng 2 số
//		Cho người dùng nhập vào số thứ 1: 5
//		Cho người dùng nhập vào số thứ 2: 10
//		Chương trình lấy dữ liệu và tính toán
//		In ra: Tổng của 2 số là: 15

		System.out.println("CHƯƠNG TRÌNH TÍNH TỔNG 2 SỐ");
		System.out.println("Mời bạn nhập vào số thứ 1: ");
//		Bỏ qua: 5, lưu trữ dữ liệu người dùng nhập
//		int: số nguyên
		int number1;
		number1 = 5;

		System.out.println("Mời bạn nhập vào số thứ 2: ");
		int number2 = 10;

		int result = number1 + number2;

//		Hiển thị kết quả ra cho người sử dụng
		System.out.println("Kết quả phép tính: " + result);

	}

}
