package com.account.Banking.service;

import java.util.Optional;

import com.account.Banking.model.Account;

public interface AccountService {

	public Account createAccount(Account account);

	public Optional<Account> getAccountById(String id);

	public Account updateAccount(Account account);

	public void deleteAccount(String id);
}
