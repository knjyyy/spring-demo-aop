package com.rk3.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.rk3.aopdemo.Account;

@Aspect
@Component
public class MyDemoLoggingAfterReturning {
	// advice ordering
	@AfterReturning(pointcut = "execution(* findAccounts(..))", returning = "accountsList")
	public void afterReturningFindAccounts(JoinPoint joinPoint, List<Account> accountsList) {
		System.out.println("|>| " + getClass() + " Advice @AfterReturning forDAOPackage");

		System.out.print("> Method Signature:");
		System.out.println(joinPoint.getSignature().toLongString());

		System.out.print("> Return value:");
		accountsList.stream().forEach(acc -> System.out.println("Account: " + acc));

		// Modify result by adding object in list:
		Account account = new Account("Soybomb", "iambomb");
		System.out.println("> Insert Account record in the result: " + account + "\n");
		accountsList.add(account);
	}
}
