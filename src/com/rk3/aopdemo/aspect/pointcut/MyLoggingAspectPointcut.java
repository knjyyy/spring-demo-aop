package com.rk3.aopdemo.aspect.pointcut;

import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

//@Aspect
//@Component
public class MyLoggingAspectPointcut {

	@Pointcut("execution(* com.rk3.aopdemo.dao.*.*(..))")
	public void forDAOPackage() {	}

	@Pointcut("execution(* com.rk3.aopdemo.dao.*.get*(..))")
	public void daoGetter() {	}

	@Pointcut("execution(* com.rk3.aopdemo.dao.*.set*(..))")
	public void daoSetter() {	}

	// combo pointcuts
	@Pointcut("forDAOPackage() && !(daoGetter() || daoSetter())")
	public void forDaoPackageNoGetterSetter() {
	}

	// @Before("forDAOPackage()")
	public void beforeAddAccountAdvice() {
		System.out.println("|>| Advice @Before forDAOPackage");
	}

	// @Before("forDAOPackage()")
	public void performApiAnalytics() {
		System.out.println("|>| Advice Perform API Analytics");
	}

	@Before("forDaoPackageNoGetterSetter()")
	public void beforeAddAccountNoGetterSetter() {
		System.out.println("|>| Advice for Dao packages exclude getter/setter");
	}
}
