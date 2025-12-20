package com.vti.frontend;

import com.vti.entity.Mentor;
import com.vti.entity.Trainee;

public class Program5 {
	public static void main(String[] args) {
// tạo ra trainee
		Trainee trainee1 = new Trainee();
		trainee1.setId(1);
		trainee1.setEmail("trainee1@vti.com");
		trainee1.setUserName("trainee1");
		trainee1.setFullName("Trainee1");
		trainee1.setUniversity("BKHN");

//		Tạo Mentor

		Mentor mentor1 = new Mentor();
		mentor1.setId(1);
		mentor1.setEmail("mentor1@vti.com");
		mentor1.setUserName("mentor1");
		mentor1.setFullName("Mentor1");
		mentor1.setYearsOfExperience(15);

//		Hiển thị thông tin của trainee
//		System.out.println("ID: " + trainee1.getId() + " ,username: " + trainee1.getUserName() + " ,University: "
//				+ trainee1.getUniversity());
//		trainee1.showInfo();
//		trainee1.getUniversity();
		trainee1.showInfotrainee();
		System.out.println("------------------");

//		mentor1.showInfo();
	}
}
