package com.vti.entity;

public class Trainee<T, H> {
	private T code; // Mã học viên: int String Generic T: type
	private H name;

	public T getCode() {
		return code;
	}

	public void setCode(T code) {
		this.code = code;
	}

	public H getName() {
		return name;
	}

	public void setName(H name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Trainee [code=" + code + ", name=" + name + "]";
	}

}
