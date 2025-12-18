package com.vti.entity;

public class Department {
	public int id;
	public String name;

	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + "]";
	}

// Alt + Shift + S
//	Hàm tạo không tham số
	public Department() {

	}

//	Hàm tạo có tham số
	public Department(String name) {
		this.name = name;
		this.id = 0;
	}

}
