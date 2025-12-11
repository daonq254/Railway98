package com.vti.frontend;

import java.time.LocalDate;

import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.entity.Group;
import com.vti.entity.Position;
import com.vti.entity.PositionName;

public class Program6 {
	public static void main(String[] args) {
//	Tạo ra các đối tượng Department
		Department department1 = new Department();
		department1.id = 1;
		department1.name = "Maketting";

		Department department2 = new Department();
		department2.id = 2;
		department2.name = "Sale";

		Department department3 = new Department();
		department3.id = 3;
		department3.name = "BOD";

//		Tạo ra các đối tượng Position
		Position position1 = new Position();
		position1.id = 1;
		position1.name = PositionName.Dev;

		Position position2 = new Position();
		position2.id = 2;
		position2.name = PositionName.PM;

		Position position3 = new Position();
		position3.id = 3;
		position3.name = PositionName.Scrum_Master;

//		Tạo ra các đối tượng Account
		Account account1 = new Account();
		account1.id = 1;
		account1.email = "daonq1@gmail.com";
		account1.userName = "daonq1";
		account1.fullName = "Nguyễn Đạo 1";
		account1.department = department2;
		account1.position = position2;
		account1.CreateDate = LocalDate.now();

		Account account2 = new Account();
		account2.id = 2;
		account2.email = "daonq2@gmail.com";
		account2.userName = "daonq2";
		account2.fullName = "Nguyễn Đạo 2";
		account2.department = department1;
		account2.position = position3;
		account1.CreateDate = LocalDate.now();

		Account account3 = new Account();
		account3.id = 3;
		account3.email = "daonq3@gmail.com";
		account3.userName = "daonq3";
		account3.fullName = "Nguyễn Đạo 3";
		account3.department = department1;
		account3.position = position3;
		account3.CreateDate = LocalDate.of(2020, 9, 23);

//		Tạo ra các đối tượng Group
		Group group1 = new Group();
		group1.id = 1;
		group1.name = "Football";
		group1.creator = account1;
		group1.createDate = LocalDate.of(2020, 9, 23);

		Group group2 = new Group();
		group2.id = 2;
		group2.name = "Trainee";
		group2.creator = account3;
		group2.createDate = LocalDate.now();

		Group group3 = new Group();
		group3.id = 3;
		group3.name = "Mentor";
		group3.creator = account3;
		group3.createDate = LocalDate.of(2024, 10, 20);

//		Khai báo group mà account tham gia
		Group[] groups_Account1 = { group1, group2 };
		account1.groups = groups_Account1;

		Group[] groups_Account2 = { group1, group2, group3 };
		account2.groups = groups_Account1;

		Group[] groups_Account3 = { group2 };
		account3.groups = groups_Account1;

//		Hiển thị thông tin phòng ban trên hệ thống
		System.out.println("--------Department----------");
		System.out.println("Department1: " + department1.id + "  " + department1.name);
		System.out.println("Department2: " + department2.id + "  " + department2.name);
		System.out.println("Department3: " + department3.id + "  " + department3.name);

		System.out.println("toString(): " + department1.toString());
	}
}
