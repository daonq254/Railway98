package com.vti.entity;

public class Student {
	public int id;
	public String name;

	public void goVTI() {
		System.out.println("Go to VTI To lean!!");
	}

	public void showInfo() {
		System.out.println("ID: " + this.id + " ,Name: " + this.name);
//		goVTI();
	}

//	Khai báo ra hàm tạo đối tượng
	public Student() {

	}

//  Hàm tạo có tham số
	public Student(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public Student(String name) {
		this.name = name;
	}

}
