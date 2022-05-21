package com.rk3.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAfterFinally {

	@After("execution(* findAccounts(..))")
	public void afterFinallyFindAccounts(JoinPoint joinPoint) {
		System.out.println("|>| " + getClass() + " Advice @AfterFinally forDAOPackage");

		System.out.print("> Method Signature:");
		System.out.println(joinPoint.getSignature().toLongString());
		
	}
}
