package com.rk3.aopdemo.aspect.ordered;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class SharedAdvice {
	@Pointcut("execution(* com.rk3.aopdemo.dao.*.*(..))")
	public void forDAOPackage() {}
	
	@Pointcut("execution(* com.rk3.aopdemo.dao.*.get*(..))")
	public void daoGetter() {}
	
	@Pointcut("execution(* com.rk3.aopdemo.dao.*.set*(..))")
	public void daoSetter() {}

	@Pointcut("forDAOPackage() && !(daoGetter() || daoSetter())")
	public void forDaoPackageNoGetterSetter() {}
}
