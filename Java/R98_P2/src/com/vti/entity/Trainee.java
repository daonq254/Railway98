package com.vti.entity;

public class Trainee extends Person {
	private String university;

	public String getUniversity() {
		return university;
	}

	public void setUniversity(String university) {
		this.university = university;
	}

//	public void showInfotrainee() {
////		System.out.println("ID: " + super.getId());
////		System.out.println("Email: " + super.getEmail());
////		System.out.println("UserName" + super.getUserName());
////		System.out.println("FullName" + super.getFullName());
//
//		super.showInfo();
//		System.out.println("University: " + this.university);
//
//	}
	@Override
	public void showInfo() {
		System.out.println("Thông tin trainee: ");
		System.out.println("ID: " + super.getId());
		System.out.println("Email: " + super.getEmail());
		System.out.println("UserName" + super.getUserName());
		System.out.println("FullName" + super.getFullName());
		System.out.println("University: " + this.university);
	}
}
