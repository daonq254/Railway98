package com.vti.entity;

public class Student {
	private int id; // 150
	private String name;

//	Lấy dữ liệu ra để sử dụng==> hàm
//	getter
	public int getId() {
		return 1000 + id;
	}

	public String getName() {
		return "VTI" + name;
	}

//	Thay đổi dữ liệu lưu trong các thuộc tính
//	Setter
	public void setId(int id) {
		this.id = id + 50; // thêm 50
	}

//	
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
