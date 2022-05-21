package com.rk3.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.rk3.aopdemo.Account;

@Component
public class AccountDAO {
	String code;
	
	public String getCode() {
		System.out.println(getClass() +" in getCode()");
		return code;
	}

	public void setCode(String code) {
		System.out.println(getClass() +" in setCode()");
		this.code = code;
	}

	public String addAccount(Account account, int i, String s) {
		System.out.println(getClass() +" in addAccount()");
		setCode("set test");
		return "hello";
	}
	
	public String gotoWork(int i) {
		System.out.println(getClass() +" in gotoWork()");
		return "working";
	}
	
	public List<Account> findAccounts(boolean b){
		if(b) 
			throw new RuntimeException("There is an unrecoverable exception...");
		
		List<Account> accounts = new ArrayList<Account>();
		accounts.add(new Account("john123", "12345"));
		accounts.add(new Account("sam789", "378499"));
		accounts.add(new Account("jose822", "32487"));
		return accounts;
	}
}
