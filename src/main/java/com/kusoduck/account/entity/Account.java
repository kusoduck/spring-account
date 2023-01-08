package com.kusoduck.account.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

// Set this class to an entity named t_account
@Entity(name = "t_account")
@Table(name = "t_account")
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "account")
	private String account;
	@Column(name = "username")
	private String username;
	@Column(name = "password")
	private String password;

	public Account() {
	}

	public Account(String account, String username, String password) {
		this.account = account;
		this.username = username;
		this.password = password;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", account=" + account + ", username=" + username + ", password=" + password + "]";
	}

}
