package com.vti.frontend;

import java.util.List;

import com.vti.backend.AccountBackend;
import com.vti.dao.AccountDAO_Hibernate;
import com.vti.entiy.Account;

public class Program {
	public static void main(String[] args) {
		System.out.println("Chương trình quản lý Account");
//		Chức năng hiển thị danh sách Account
		AccountBackend accountBackend = new AccountBackend(new AccountDAO_Hibernate());

		List<Account> listAccounts = accountBackend.getAllAccount();
		for (Account account : listAccounts) {
			System.out.println(account.getName());
		}

//		Chức năng thêm mới

		Boolean resultBoolean = accountBackend.createNew_Account();
		if (resultBoolean) {
			System.out.println("Thêm mới thành công");
		} else {
			System.out.println("Đã có lỗi xảy ra!");
		}
	}
}
