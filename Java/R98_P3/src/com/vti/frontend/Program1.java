package com.vti.frontend;

import com.vti.entity.Student;

public class Program1 {
	public static void main(String[] args) {
// Tạo ra 1 số bạn học viên
		Student.className = "Railway98";

		Student student1 = new Student();
		student1.setId(1);
		student1.setName("Lâm");
//		student1.setClassName("Railway98");

		Student student2 = new Student();
		student2.setId(2);
		student2.setName("Nam");
//		student2.setClassName("Railway98");

		Student student3 = new Student();
		student3.setId(3);
		student3.setName("Thủy");
//		student3.setClassName("Railway98");

		Student student4 = new Student();
		student4.setId(4);
		student4.setName("Hoàng");
//		student4.setClassName("Railway98");
//
//		System.out.println(student1);
//		System.out.println(student2);
//		System.out.println(student3);
//		System.out.println(student4);

		System.out.println("Student1:  " + student1.getClassName());
//		System.out.println("Student2:  " + student2.getClassName());

//		Chuyển các bạn sang hệ lớp mới: Java Web Fullstack

		Student.className = "Java Web Fullstack"; // railway98 ==> Java Web Fullstack

		System.out.println(student1);
		System.out.println(student2);
		System.out.println(student3);
		System.out.println(student4);

//		Cho bạn học viên student1 chuyển lớp
		System.out.println("--------------------------");
		student1.setClassName("Java Backend");
		System.out.println("Student1:  " + student1.getClassName());

		System.out.println("Student2:  " + student2.getClassName()); // Java Backend
		System.out.println("Student3:  " + student3.getClassName()); // Java Backend

		student2.setClassName("Frontend");
	}
}
