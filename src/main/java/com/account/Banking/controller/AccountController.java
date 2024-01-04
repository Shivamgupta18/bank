package com.account.Banking.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.account.Banking.Exception.AccountNotFoundException;
import com.account.Banking.model.Account;
import com.account.Banking.service.AccountService;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

	@Autowired
	private AccountService accountservice;

	@PostMapping()
	public ResponseEntity<Account> createAccount(@RequestBody Account account) {
		Account createaccount = accountservice.createAccount(account);
		return new ResponseEntity<Account>(createaccount, HttpStatus.CREATED);
	}
	@GetMapping
	public ResponseEntity<Account> getAccountById(@PathVariable String id){
	Optional<Account> accountId=accountservice.getAccountById(id);
     return accountId.map(value->new ResponseEntity<>(value,HttpStatus.OK)).
    		 orElseThrow(()-> new AccountNotFoundException("Account not Found with this id"+ id));
	}
	
	@PutMapping
	public ResponseEntity<Account> updateAccount(@PathVariable String id, @RequestBody Account account){
		 Account updateAccount= accountservice.getAccountById(id).
				 map(existingAccount-> {
					 existingAccount.setAccountHolder(account.getAccountHolder());
					 existingAccount.setBalance(account.getBalance());
					return accountservice.updateAccount(existingAccount);
				 }).orElseThrow(()-> new AccountNotFoundException("Account not foound"+id));
				 return new ResponseEntity<>(updateAccount, HttpStatus.OK);	
	}

	@DeleteMapping
	public ResponseEntity<Void> deleteAccount(@PathVariable String id){
		accountservice.deleteAccount(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
