package com.vti.frontend;

import java.util.LinkedList;
import java.util.Queue;

import com.vti.entity.Student;

public class Program4_Queue {
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

		Queue<Student> studentsQueue = new LinkedList<Student>();
		studentsQueue.add(student1);
		studentsQueue.add(student2);
		studentsQueue.add(student3);
		studentsQueue.add(student4);

		for (Student student : studentsQueue) {
			System.out.println(student.toString());
		}
// peek 
		System.out.println("----peek-----");
		System.out.println(studentsQueue.peek());
		for (Student student : studentsQueue) {
			System.out.println(student.toString());
		}
// poll

		System.out.println("---poll------");
		System.out.println(studentsQueue.poll());
		for (Student student : studentsQueue) {
			System.out.println(student.toString());
		}
	}
}
