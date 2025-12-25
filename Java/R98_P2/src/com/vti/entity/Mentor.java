package com.vti.entity;

public class Mentor extends Person implements IToDoPerson, ITodoMentor {

	private int yearsOfExperience;

	public Mentor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Mentor(int id, String email, String userName, String fullName) {
		super(id, email, userName, fullName);
		// TODO Auto-generated constructor stub
	}

	public int getYearsOfExperience() {
		return yearsOfExperience;
	}

	public void setYearsOfExperience(int yearsOfExperience) {
		this.yearsOfExperience = yearsOfExperience;
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

	@Override
	public void reviewAssignment() {
		// TODO Auto-generated method stub

	}

	@Override
	public void createLesson() {
		// TODO Auto-generated method stub

	}

	@Override
	public void supportTrainee() {
		// TODO Auto-generated method stub

	}

//	@Override
//	public void showInfo() {
//		System.out.println("Thông tin của mentor là: ");
////		System.out.println("ID: " + super.getId());
//		System.out.println("ID: " + super.id + " " + super.email);
//		System.out.println("YearsOfExperience: " + this.yearsOfExperience);
//	}

}
