package com.rk3.aopdemo.aspect.ordered;

import org.aspectj.lang.annotation.Before;

//@Aspect
//@Component
//@Order(2)
public class MyCloudLogging {
	@Before("com.rk3.aopdemo.aspect.ordered.SharedAdvice.forDaoPackageNoGetterSetter()")
	public void logToCloudAsync() {
		System.out.println("|>| " + getClass() + " Log to cloud in async");
	}
}
