package com.kusoduck.account.service;

import java.util.List;

import com.kusoduck.account.entity.Account;

public interface AccountService {

	public List<Account> findAll();

	public Account findById(int id);

	public void save(Account account);

	public void deleteById(int id);
}
