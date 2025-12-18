package com.vti.entity;

import java.time.LocalDate;

public class Account {
	public int id;
	public String email;
	public String userName;
	public String fullName;
	public Department department;
	public Position position;
	public LocalDate CreateDate;

	public Group[] groups; // mảng các group

//	Không có tham số
	public Account() {
	}

//	Không có tham số
//	Có các parameter là id, Email, Username, FirstName,
//	LastName (với FullName = FirstName + LastName)
	public Account(int id, String email, String userName, String firstName, String lastName) {
		this.id = id;
		this.email = email;
		this.userName = userName;
		this.fullName = firstName + " " + lastName; // Nguyen Dao ==>> NguyenDao
	}
}
