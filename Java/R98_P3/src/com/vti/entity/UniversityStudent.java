package com.vti.entity;

public class UniversityStudent extends Student {

	public UniversityStudent(String code) {
		super(code);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void showInfo() {
		super.showInfo();
		System.out.println("==========");
	}
}
