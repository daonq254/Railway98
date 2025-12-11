package com.vti.frontend;

import com.vti.entity.Student;

public class Program4 {
//	Hàm main
	public static void main(String[] args) {
// Tạo ra các bạn học viên trong chương trình
		Student student1 = new Student();
		student1.name = "Sơn";
		student1.age = 20;

//		học viên 2
		Student student2 = new Student();
		student2.name = "Đức";
		student2.age = 24;

//		học viên 3
		Student student3 = new Student();
		student3.name = "Lâm";
		student3.age = 22;

		System.out.println("Thông tin bạn học viên 1, name: " + student1.name + " , age: " + student1.age);
		System.out.println("Thông tin bạn học viên 2, name: " + student2.name + " , age: " + student2.age);
		System.out.println("Thông tin bạn học viên 3, name: " + student3.name + " , age: " + student3.age);

//		
		System.out.println("-------------------------");
		student1.goToVTI(); // Sơn: Go to VTI to Study!!
		student2.goToVTI(); // Đức: Go to VTI to Study!!
		student3.goToVTI();

		System.out.println("-------------------------");
		System.out.println(student1.toString());
		System.out.println(student2.toString());
		// Student [name= Sơn ,age= 20 ]
		// Student [name= Đức ,age= 24 ]

	}

//	
}
