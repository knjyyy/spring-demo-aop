package com.rk3.aopdemo.aspect.ordered;

import org.aspectj.lang.annotation.Before;

//@Aspect
//@Component
//@Order(3)
public class MyDemoLoggingAspect {

	// advice ordering
	@Before("com.rk3.aopdemo.aspect.ordered.SharedAdvice.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice() {
		System.out.println("|>| " + getClass() + " Advice @Before forDAOPackage");
	}
}
