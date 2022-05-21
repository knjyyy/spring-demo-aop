package com.rk3.aopdemo.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

@Component
public class TrafficFortuneService {
	public String getFortune(boolean tripwire) {
		if(tripwire)
			throw new RuntimeException("Major accident in the highway, road is closed.");
		
		//simulate delay
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//return fortune
		return "Expect heavy traffic..";
	}
}
