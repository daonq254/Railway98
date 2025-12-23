package com.vti.entity;

public class Staff {
	private String name;
	private int age;
	private Gender gender;
	private String address;

	public Staff() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Staff(String name, int age, Gender gender, String address) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.address = address;
	}

	@Override
	public String toString() {
		return "Staff [name=" + name + ", age=" + age + ", gender=" + gender + ", address=" + address + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
