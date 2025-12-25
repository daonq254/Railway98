package com.vti.entity;

public abstract class Person {
	protected int id;
	protected String email;
	private String userName;
	private String fullName;

	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Person(int id, String email, String userName, String fullName) {
		super();
		this.id = id;
		this.email = email;
		this.userName = userName;
		this.fullName = fullName;
	}

//	public abstract void showInfo();
//
//	public abstract void login();
//
//	public abstract void attendClass();
//
//	public abstract void viewSchedule();
//
//	public abstract void sentFeedBack();

//	
//	public void showInfo() {
//		System.out.println("ID: " + this.id);
//		System.out.println("email" + this.email);
//		System.out.println("userName: " + this.userName);
//		System.out.println("fullName: " + this.fullName);
//	}

//	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

}
