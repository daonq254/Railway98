package com.vti.frontend;

import com.vti.entity.Student;

public class Program2 {
	public static void main(String[] args) {
		Student.className = "Railway98";

		Student student1 = new Student("VTI001");
		student1.setId(1);
//		student1.setCode("VTI001");
		student1.setName("Lâm");

		Student student2 = new Student("VTI002");
		student2.setId(2);
//		student2.setCode("VTI002");
		student2.setName("Nam");

//		
//		
//		student1.setCode("001");
//		student2.setCode("002");

		System.out.println(student1);
		System.out.println(student2);
	}
}
