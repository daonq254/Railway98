package com.vti.frontend;

public class Program2 {
	public static void main(String[] args) {
		String name = "vti academy"; // mảng các ký tự
		System.out.println("Name: " + name.toUpperCase()); // VTI ACADEMY
		System.out.println("Name: " + name.toLowerCase());// vti academy

		// char c = Character.toUpperCase(name.charAt(1)); //T
		System.out.println("Ký tự tại ví trí thứ 2: " + Character.toUpperCase(name.charAt(1))); // T
		// hãy lấy ra ký tự tại vị trí thứ 2(t) và In hoa ký tự đó lên, nhưng sử dụng
		// phương thức của lớp String
//		String name1 = String.valueOf(name.charAt(1));
		System.out.println(String.valueOf(name.charAt(1)).toUpperCase());
		String secondChar = name.substring(1, 2).toUpperCase(); // "T"
		System.out.println("Ký tự tại vị trí thứ 2: " + secondChar); // T
//		System.out.println("substring: " + name.substring(1, 5));
//		
		System.out.println("Tổng số ký tự trong chuỗi trên là: " + name.length());

		System.out.println(name.equals("admin")); // "VTI Academy" vs "admin"
	}
}
