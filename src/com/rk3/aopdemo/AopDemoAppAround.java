package com.rk3.aopdemo;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import com.rk3.aopdemo.service.TrafficFortuneService;

public class AopDemoAppAround {
	
	private static Logger logger = Logger.getLogger(AopDemoAppAround.class.getName());

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		logger.info("Main app: AopDemoAppAround");
		TrafficFortuneService fortune = context.getBean("trafficFortuneService", TrafficFortuneService.class);
		logger.info("Fortune Service:" + fortune);

		try {
			String data = fortune.getFortune(false);
			logger.info("getFortune() :" + data);					
		}
		catch(Exception ex) {
			ex.printStackTrace();			
		}

		logger.info("Finished: AopDemoAppAround");
		
		context.close();

	}

}
