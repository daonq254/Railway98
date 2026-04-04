package com.vti.frontend;

import com.vti.backend.AccountBackend;
import com.vti.dao.AccountDAO_JPA;

public class Program2 {
	public static void main(String[] args) {
		AccountBackend accountBackend = new AccountBackend(new AccountDAO_JPA());
	}
}
