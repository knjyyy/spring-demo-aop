package com.rk3.aopdemo.aspect;

import java.util.stream.Stream;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;

import com.rk3.aopdemo.Account;

//@Aspect
//@Component
//@Order(5)
public class MyDemoLoggingBefore {

	// advice ordering
	@Before("com.rk3.aopdemo.aspect.ordered.SharedAdvice.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint joinPoint) {
		System.out.println("|>| " + getClass() + " Advice @Before forDAOPackage");
		
		// Method signature
		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
		System.out.print("> Signature:");
		System.out.println(methodSignature.toString());

		// display method args
		Object[] args = joinPoint.getArgs();

		System.out.print("> Arguments:");
		Stream.of(args).forEach(a -> System.out.println("> Arg: " + (a instanceof Account ? (Account) a : a)));
	}
}
