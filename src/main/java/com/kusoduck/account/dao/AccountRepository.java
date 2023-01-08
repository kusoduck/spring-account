package com.kusoduck.account.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kusoduck.account.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Integer> {

}
