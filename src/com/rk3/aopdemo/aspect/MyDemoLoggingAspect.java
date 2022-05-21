package com.rk3.aopdemo.aspect;

import org.aspectj.lang.annotation.Before;

//@Aspect
//@Component
public class MyDemoLoggingAspect {

	// Advice for all methods named updateAccount(), on any class
	@Before("execution(public void updateAccount())")
	public void beforeUpdateAccountAdvice() {
		System.out.println(">>>>>>>>>>AOP @Before advice execution updateAccount()");
	}

	// Advice for addAccount() specific package>class
	@Before("execution(public void com.rk3.aopdemo.dao.AccountDAO.addAccount())")
	public void beforeAddAccountForAClass() {
		System.out.println(">>>>>>>>>>AOP @Before advice execution addAccount()");
	}

	// Advice for methods starting with add*()
	@Before("execution(public void add*())")
	public void beforeAdviceOnAnyAdd() {
		System.out.println(">>>>>>>>>>AOP @Before advice execution addAccount()");
	}

	// Advice on method starting with add*() with any return type, and Account
	// parameter plus any other parameters
	@Before("execution(* add*(com.rk3.aopdemo.Account, ..))")
	public void beforeAddAccountAdvice1() {
		System.out.println(">>>>>>>>>>AOP @Before advice execution addAccount()");
	}

	// Advice on any add method, for any return type, with an Account parameter plus
	// 2 more parameters of any type
	@Before("execution(* add*(com.rk3.aopdemo.Account, *, *))")
	public void beforeAddAccountAdvice2() {
		System.out.println(">>>>>>>>>>AOP @Before advice execution addAccount()");
	}

	// Advice on any add method, for any return type, with an Account plus int plus
	// String parameter
	@Before("execution(* add*(com.rk3.aopdemo.Account, int, String))")
	public void beforeAddAccountAdvice3() {
		System.out.println(">>>>>>>>>>AOP @Before advice execution addAccount()");
	}

	// Advice on any class/method in com.rk3.aopdemo.dao, with any return type, and
	// any parameter
	@Before("execution(* com.rk3.aopdemo.dao.*.*(..))")
	public void beforeAddAccountAdvice4() {
		System.out.println(">>>>>>>>>>AOP @Before advice execution addAccount()");
	}
}
