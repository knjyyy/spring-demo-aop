package com.rk3.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.rk3.aopdemo.dao.AccountDAO;

public class AopDemoAppAfterThrowing {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		AccountDAO account = context.getBean("accountDAO", AccountDAO.class);

		List<Account> accounts = null;

		try {
			accounts = account.findAccounts(true);
		} catch (Exception exc) {
			System.out.println("Exception in main:");
			exc.printStackTrace();
		}

		System.out.println("Main: List of accounts:");
		accounts.stream().forEach(acc -> System.out.println("Account: " + acc));
		context.close();
	}
}
