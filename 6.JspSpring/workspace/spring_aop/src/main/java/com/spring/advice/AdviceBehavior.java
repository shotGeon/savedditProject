package com.spring.advice;

import org.aspectj.lang.ProceedingJoinPoint;

public class AdviceBehavior {
	
	public void chikachika() {
		System.out.println("양치를 한다.");
	}
	
	public void chikachikaAround(ProceedingJoinPoint joinPoint) throws Throwable{
		System.out.println("한번 닦았는데...");
		
		joinPoint.proceed();
		System.out.println("또 닦아요");
	}
	
}
