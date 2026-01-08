package com.vti.frontend;

import java.util.LinkedHashSet;
import java.util.Set;

import com.vti.entity.Student;

public class Program5_Hashset {
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

		Set<Student> studentsHasSet = new LinkedHashSet<Student>();
		studentsHasSet.add(student1);
		studentsHasSet.add(student2);
		studentsHasSet.add(student3);
		studentsHasSet.add(student3);
		studentsHasSet.add(student3);
		studentsHasSet.add(student3);
		studentsHasSet.add(student4);
		for (Student student : studentsHasSet) {
			System.out.println(student.toString());
		}
	}
}
