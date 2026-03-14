package com.vti.frontend;

import java.util.List;
import java.util.Scanner;

import com.vti.entity.Account;
import com.vti.repository.AccountRepository;

public class AccountFunction {
	AccountRepository accountRepository;
	Scanner scanner;

	public AccountFunction() {
		super();
		accountRepository = new AccountRepository();
		scanner = new Scanner(System.in);
	}

//	Hiển thị danh sách phòng ban
	public void showListDepartment() {

//		Lấy danh sách phòng ban
		List<Account> listAccounts = accountRepository.getAllAccount();
//		for (Department department : listDepartments) {
//			System.out.println("ID: " + department.getId() + " Name: " + department.getName());
//		}

	}

//	Tạo mới phòng ban
}
