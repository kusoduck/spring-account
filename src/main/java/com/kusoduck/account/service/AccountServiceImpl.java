package com.kusoduck.account.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kusoduck.account.dao.AccountRepository;
import com.kusoduck.account.entity.Account;
import com.kusoduck.utils.EncryptUtils;

@Service
public class AccountServiceImpl implements AccountService {

	private AccountRepository accountRepository;

	@Autowired
	public AccountServiceImpl(AccountRepository accountDAO) {
		this.accountRepository = accountDAO;
	}

	@Override
	public List<Account> findAll() {
		return accountRepository.findAll();
	}

	@Override
	public Account findById(int id) {
		Optional<Account> result = accountRepository.findById(id);

		if (result.isPresent()) {
			return result.get();
		}else {
			throw new RuntimeException("Account id not found - " + id);
		}
	}

	@Override
	public void save(Account account) {
		String password = account.getPassword();
		account.setPassword(EncryptUtils.encrypt("tp6u4vm0", password));
		accountRepository.save(account);
	}

	@Override
	public void deleteById(int id) {
		accountRepository.deleteById(id);
	}

}
