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

//	Hiển thị danh sách Account
	public void showListAccount() {

//		Lấy danh sách Account
		List<Account> listAccounts = accountRepository.getAllAccount();
		String leftAlignFormat = "| %-2d | %-21s | %-15s | %-21s | %-14s | %-14s | %-16s | %n";
		System.out.format(
				"+----+-----------------------+-----------------+-----------------------+----------------+----------------+------------------------+%n");
		System.out.format(
				"|ID  | Email                 | Username        |   FullName            | Department     | Possition      | Create Date            |%n");
		System.out.format(
				"+----+-----------------------+-----------------+-----------------------+----------------+----------------+------------------------+%n");

		for (Account acc : listAccounts) {
			System.out.format(leftAlignFormat, acc.getId(), acc.getEmail(), acc.getUsername(), acc.getFullname(),
					acc.getDepartment().getName(), acc.getPosition().getName(), acc.getCreateDate());
		}
		System.out.format(
				"+----+-----------------------+-----------------+-----------------------+----------------+----------------+------------------+%n");

	}

	public void getAccountById() {
		System.out.println("Tìm kiếm Account theo ID: ");
		System.out.println("Nhập vào ID cần tìm kiếm: ");
		short id = scanner.nextShort();

		Account acc = accountRepository.getAccountByID(id);

		if (acc != null) {
			String leftAlignFormat = "| %-2d | %-21s | %-15s | %-21s | %-14s | %-16s | %n";
			System.out.format(
					"+----+-----------------------+-----------------+-----------------------+----------------+------------------------+%n");
			System.out.format(
					"|ID  | Email                 | Username        |   FullName            | Department     | Create Date            |%n");
			System.out.format(
					"+----+-----------------------+-----------------+-----------------------+----------------+------------------------+%n");

			System.out.format(leftAlignFormat, acc.getId(), acc.getEmail(), acc.getUsername(), acc.getFullname(),
					acc.getDepartment().getName(), acc.getCreateDate());

			System.out.format(
					"+----+-----------------------+-----------------+-----------------------+----------------+------------------------+%n");
		} else {
			System.out.println("Không tồn tại account này trên HT");
		}

	}

//	Tạo mới phòng ban
}
