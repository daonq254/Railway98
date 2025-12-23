package com.vti.entity;

public class Worker extends Staff {
	private int rank;

	public Worker() {
		super();
	}

	public Worker(String name, int age, Gender gender, String address) {
		super(name, age, gender, address);
	}

	@Override
	public String toString() {
		return "Worker [rank=" + rank + "]";
	}

}
