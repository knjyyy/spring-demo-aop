package com.rk3.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.rk3.aopdemo.dao.AccountDAO;

public class AopDemoAppAfterReturning {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		AccountDAO account = context.getBean("accountDAO", AccountDAO.class);
		//account.addAccount(new Account("testuser", "testpass"), 1, "hello");

		List<Account> accounts = account.findAccounts(false);
		System.out.println("List of accounts:");
		accounts.stream().forEach(acc -> System.out.println("Account: " + acc));
		
		context.close();

	}
}
