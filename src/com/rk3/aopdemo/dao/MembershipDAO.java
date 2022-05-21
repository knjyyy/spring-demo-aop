package com.rk3.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {
	public void addSilly() {
		System.out.println(getClass() + ": DB work - register a new membership account\n");
	}

	public int doWork() {
		System.out.println("Doing something in MembershipDAO\n");
		return 1;
	}
}
