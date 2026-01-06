package com.vti.frontend;

import java.util.Stack;

import com.vti.entity.Student;

public class Program2 {
	public static void main(String[] args) {
		// Lan, Thủy, Sơn, Tiến
		Student student1 = new Student();
		student1.setId(1);
		student1.setName("Lan");

		Student student2 = new Student();
		student2.setId(2);
		student2.setName("Thủy");

		Student student3 = new Student();
		student3.setId(3);
		student3.setName("Sơn");

		Student student4 = new Student();
		student4.setId(4);
		student4.setName("Tiến");

//		Lưu trữ 4 bạn học viên vào Stack

		Stack<Student> studentstStack = new Stack<Student>();
		studentstStack.push(student1);
		studentstStack.push(student2);
		studentstStack.push(student3);
		studentstStack.push(student4);

		for (Student student : studentstStack) {
			System.out.println(student);
		}

//		
		System.out.println("----------peek-------------");
		System.out.println(studentstStack.peek()); // student4
		System.out.println(studentstStack.peek()); // student4

		for (Student student : studentstStack) {
			System.out.println(student);
		}

		System.out.println("----------pop-------------");
		System.out.println(studentstStack.pop()); // student4
		System.out.println(studentstStack.pop());// student3
		// student 1 , 2 ,3
		System.out.println("------------------");
		for (Student student : studentstStack) {
			System.out.println(student);
		}

	}
}
