package com.rk3.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.rk3.aopdemo.dao.AccountDAO;
//import com.rk3.aopdemo.dao.MembershipDAO;

public class AopDemoAppBefore {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		AccountDAO account = context.getBean("accountDAO", AccountDAO.class);
		account.addAccount(new Account("testuser", "testpass"), 1, "hello");
		account.gotoWork(0);
		account.setCode("test");
		account.getCode();

		// MembershipDAO membership = context.getBean("membershipDAO",
		// MembershipDAO.class);
		// membership.addSilly();
		// membership.doWork();

		context.close();
	}
}
