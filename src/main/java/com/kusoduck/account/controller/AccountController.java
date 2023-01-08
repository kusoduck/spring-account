package com.kusoduck.account.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kusoduck.account.entity.Account;
import com.kusoduck.account.service.AccountService;

@RestController
@RequestMapping("/api")
public class AccountController {

	private AccountService accountService;

	@Autowired
	public AccountController(AccountService accountService) {
		this.accountService = accountService;
	}

	@GetMapping("/accounts")
	public List<Account> findAll() {
		return accountService.findAll();
	}

	@GetMapping("/accounts/{accountId}")
	public Account getAccount(@PathVariable int accountId) {
		Account account = accountService.findById(accountId);
		if (account == null) {
			throw new RuntimeException("Account id not found - " + accountId);
		}
		return account;
	}

	@PostMapping("/accounts")
	public Account addAccount(@RequestBody Account account) {
		account.setId(0);
		accountService.save(account);
		return account;
	}

	// add mapping for PUT /accounts - update existing account
	@PutMapping("/accounts")
	public Account updateAccount(@RequestBody Account account) {
		accountService.save(account);
		return account;
	}

	@DeleteMapping("/accounts/{accountId}")
	public String deleteAccount(@PathVariable int accountId) {
		Account account = accountService.findById(accountId);
		if (account == null) {
			throw new RuntimeException("Account id not found - " + accountId);
		}
		accountService.deleteById(accountId);
		return "Delete account id - " + accountId;
	}
}
