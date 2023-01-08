package com.kusoduck.utils;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

public class EncryptUtils {

	private EncryptUtils() {

	}

	public static String encrypt(String pwd, String message) {
		StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
		encryptor.setPassword(pwd);
		String encryptedPassword = encryptor.encrypt(message);
		return encryptedPassword;
	}

	public static String decrypt(String pwd, String encryptedMessage) {
		StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
		encryptor.setPassword(pwd);
		String password = encryptor.decrypt(encryptedMessage);
		return password;
	}
}
