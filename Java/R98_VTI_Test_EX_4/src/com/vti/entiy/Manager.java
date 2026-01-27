package com.vti.entiy;

public class Manager extends User {
	private int expInYear;

	public Manager() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Manager(int id, String fullName, String email, String password, int projectId, Role role, int expInYear) {
		super(id, fullName, email, password, projectId, role);
		this.expInYear = expInYear;

	}

	public int getExpInYear() {
		return expInYear;
	}

	public void setExpInYear(int expInYear) {
		this.expInYear = expInYear;
	}

}
