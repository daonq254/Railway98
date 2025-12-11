package com.vti.entity;

public class Student {
//	Property- Thuộc tính
	public String name;
	public int age;

//	Có hành động tới VTI để học tập
	public void goToVTI() {
		System.out.println(this.name + ": Go to VTI to Study!!");
	}

	@Override
	public String toString() {

		goToVTI();
		return "name=" + name + ", age=" + age;
	}

//	Phương thức giới thiệu thông tin của mỗi bạn học viên
//	Tôi là: Sơn, tôi 20 tuổi
//	Phương thức hiển thị thông tin chi tiết của 1 đối tượng
//	@Override
//	public String toString() {
////		System.out.println("Student [name= " + this.name + " ,age= " + this.age + " ]");
//
//		return "Student [name= " + this.name + " ,age= " + this.age + " ]";
//	}

}
