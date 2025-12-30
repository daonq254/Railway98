package com.vti.entity;

public class Student {
	private int id;

	private final String code; // Sau khi đã được cấp thì sẽ không thay đổi VTI001

	private String name;
	public static String className; // quản lý ở lớp Student
	private static int genId = 1;

	public Student(String code) {
		super();
		this.code = code;
		this.id = genId;
		genId++;
	}

	public final void showInfo() {
		System.out.println("....................");
	}

	public String getCode() {
		return code;
	}

//	public void setCode(String code) {
//		this.code = code;
//	}

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
		return "Student [id=" + id + ", code=" + code + ", name=" + name + "]";
	}

}
