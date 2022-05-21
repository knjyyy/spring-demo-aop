package com.rk3.aopdemo.aspect.ordered;

import org.aspectj.lang.annotation.Before;

//@Aspect
//@Component
//@Order(1)
public class MyApiAnalytics {
	@Before("com.rk3.aopdemo.aspect.ordered.SharedAdvice.forDaoPackageNoGetterSetter()")
	public void performApiAnalytics() {
		System.out.println("|>| " + getClass() + " Advice Perform API Analytics");
	}
}
