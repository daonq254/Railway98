package com.vti.dao;

import java.util.List;

import com.vti.entiy.Account;

public interface IAccountDAO {
	public List<Account> getAllAccount();

	public Boolean createNew_Account(Account account);
}
