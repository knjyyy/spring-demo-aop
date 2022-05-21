package com.rk3.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAfterThrowing {

	// advice ordering
	@AfterThrowing(pointcut = "execution(* com.rk3.aopdemo.dao.AccountDAO.findAccounts(..))", throwing = "exc")
	public void afterThrowingFindAccounts(JoinPoint joinPoint, Throwable exc) {
		System.out.println("|>| " + getClass() + " Advice @AfterThrowing forDAOPackage");

		System.out.print("> Method Signature:");
		System.out.println(joinPoint.getSignature().toLongString());

		System.out.println("> Exception value:");
		System.out.println(exc);
	}
}
