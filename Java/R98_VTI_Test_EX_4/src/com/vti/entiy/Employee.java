package com.vti.entiy;

public class Employee extends User {
	private String proSkill;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(int id, String fullName, String email, String password, int projectId, Role role, String proSkill) {
		super(id, fullName, email, password, projectId, role);
		this.proSkill = proSkill;
	}

	public String getProSkill() {
		return proSkill;
	}

	public void setProSkill(String proSkill) {
		this.proSkill = proSkill;
	}

}
