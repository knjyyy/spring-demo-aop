package com.rk3.aopdemo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.rk3.aopdemo.AopDemoAppAround;

@Aspect
@Component
public class MyDemoLoggingAround {

	private static Logger logger = Logger.getLogger(MyDemoLoggingAround.class.getName());
	
	@Around("execution(* com.rk3.aopdemo.service.*.getFortune(..))")
	public Object aroundGetFortune(ProceedingJoinPoint point) throws Throwable {
		logger.info("|>| @Around advice start: " + getClass());		

		logger.info("|>| Method Signature:" + point.getSignature().toLongString());
		
		long begin = System.currentTimeMillis();
		Object result = null;
		
		try {			
			result = point.proceed();
		}
		catch(Exception ex) {
			logger.warning("|>| Exception: " + ex.getMessage());
			result = "Major accident, help is on the way";
			
			//incase need to rethrow exception to main app:
			throw ex;
		}
		
		long end = System.currentTimeMillis();
		long duration = end - begin;
		logger.info("|>| Execution time of " + point.getSignature().toShortString() + ": " + (duration / 1000.0 )+ " seconds");		
		
		logger.info("|>| Around advice end: " + getClass());
		return result;
	}
}
