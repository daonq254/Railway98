package com.vti.frontend;

import java.util.LinkedList;

import com.vti.entity.Student;

public class Program3_LinkedList {
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

		LinkedList<Student> studentsLinkedList = new LinkedList<Student>();

//		Thêm phần tử vào linkedlist
		studentsLinkedList.add(student1);
		studentsLinkedList.add(student2);
		studentsLinkedList.add(student3);
		studentsLinkedList.add(student4);

//		Hiển thị danh sách phần tử 

		for (Student student : studentsLinkedList) {
			System.out.println(student.toString());
		}
//		truy xuất phần tử
		System.out.println("------get---------");
		System.out.println(studentsLinkedList.get(2));
//		Xóa phần tử
		System.out.println("---------------");
		studentsLinkedList.removeFirst();
		studentsLinkedList.removeLast();
		for (Student student : studentsLinkedList) {
			System.out.println(student.toString());
		}
	}
}
