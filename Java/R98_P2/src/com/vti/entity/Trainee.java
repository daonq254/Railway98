package com.vti.entity;

public class Trainee extends Person implements IToDoPerson {
	private String university;

	public String getUniversity() {
		return university;
	}

	public void setUniversity(String university) {
		this.university = university;
	}

	@Override
	public void showInfo() {
		// TODO Auto-generated method stub

	}

	@Override
	public void login() {
		// TODO Auto-generated method stub

	}

	@Override
	public void attendClass() {
		// TODO Auto-generated method stub

	}

	@Override
	public void viewSchedule() {
		// TODO Auto-generated method stub

	}

	@Override
	public void sentFeedBack() {
		// TODO Auto-generated method stub

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
//	@Override
//	public void showInfo() {
//		System.out.println("Thông tin trainee: ");
//		System.out.println("ID: " + super.getId());
//		System.out.println("Email: " + super.getEmail());
//		System.out.println("UserName" + super.getUserName());
//		System.out.println("FullName" + super.getFullName());
//		System.out.println("University: " + this.university);
//	}
}
