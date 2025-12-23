package com.vti.entity;

public class Engineer extends Staff {
	private String specialized;

	public Engineer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Engineer(String specialized) {
		super();
		this.specialized = specialized;
	}

	@Override
	public String toString() {
		return "Engineer [specialized=" + specialized + "]";
	}

}
