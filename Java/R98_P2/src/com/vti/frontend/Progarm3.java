package com.vti.frontend;

import com.vti.entity.Student;

public class Progarm3 {
	public static void main(String[] args) {

//		Student student1 = new Student(1, "NAM");
//		id = 1;
//		name= "NAM"
//		System.out.println("ID: " + student1.id + " ,name:" + student1.name);
//
//		Student student2 = new Student(2, "MAI");
////		id = 2;
////		name= "MAI"
//		student2.id = 20;
//
//		Student student3 = new Student(3, "ABC");
//
//		student1.showInfo();
//		student2.showInfo();
//		student3.showInfo();
//
//		Student student4 = new Student("DAONQ");
//		student4.id = 40;
//		student4.showInfo();
//
//		Student student5 = new Student();

		Student student1 = new Student(1, "Nguyen Dao");
//		student1.id;
//		student1.name;
//		student1.getId(); // id
//		student1.getName();

		student1.setId(100); // 150
		System.out.println("ID: " + student1.getId()); // 1001
		System.out.println("Name: " + student1.getName());// VTI + Nguyen Dao
	}
}
