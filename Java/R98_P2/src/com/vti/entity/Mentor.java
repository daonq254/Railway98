package com.vti.entity;

public class Mentor extends Person {

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

}
