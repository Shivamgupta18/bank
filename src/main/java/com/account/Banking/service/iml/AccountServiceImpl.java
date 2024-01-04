package com.account.Banking.service.iml;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.account.Banking.model.Account;
import com.account.Banking.repository.AccountRepository;
import com.account.Banking.service.AccountService;
@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository accountrepo;

	@Override
	public Account createAccount(Account account) {
		// TODO Auto-generated method stub
		return accountrepo.save(account);
	}

	@Override
	public Optional<Account> getAccountById(String id) {
		// TODO Auto-generated method stub
		return accountrepo.findById(id);
	}

	@Override
	public Account updateAccount(Account account) {
		// TODO Auto-generated method stub
		return accountrepo.save(account);
	}

	@Override
	public void deleteAccount(String id) {
		// TODO Auto-generated method stub
		accountrepo.deleteById(id);
	}

}
