package com.vti.backend;

import java.util.List;

import com.vti.dao.IAccountDAO;
import com.vti.entiy.Account;

public class AccountBackend {
	private IAccountDAO accountDAO;

	public AccountBackend(IAccountDAO accountDAO_DB) {
		super();
		accountDAO = accountDAO_DB;
	}

	public List<Account> getAllAccount() {
//		AccountDAO_JDBC accountDAO_JDBC = new AccountDAO_JDBC();
//		AccountDAO_Hibernate accountDAO_Hibernate = new AccountDAO_Hibernate();
		List<Account> listAccounts = accountDAO.getAllAccount();
		return listAccounts;

	}

	public Boolean createNew_Account() {
//		AccountDAO_JDBC accountDAO_JDBC = new AccountDAO_JDBC();
//		AccountDAO_Hibernate accountDAO_Hibernate = new AccountDAO_Hibernate();

		Account account = new Account();
		account.setId(1);
		account.setName("Daonq");
		Boolean result = accountDAO.createNew_Account(account);

		return result;

	}

//	
}
