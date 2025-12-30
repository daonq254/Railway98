package com.vti.entity;

public class Student {
	private int id;
	private String name;
	public static String className; // quản lý ở lớp Student
	private static int genId = 1;

	public Student() {
		super();
		this.id = genId;
		genId++;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", className=" + className + "]";
	}

}
