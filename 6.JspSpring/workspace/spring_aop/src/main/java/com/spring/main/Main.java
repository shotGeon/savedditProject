package com.spring.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.spring.aspects.Behavior;

public class Main {
	
	
	public static void main(String[] args) {
		
		ApplicationContext ctx =
							new GenericXmlApplicationContext
								("classpath:com/spring/context/application-context.xml");
		Behavior behavior = ctx.getBean("behavior", Behavior.class);
		
		behavior.잠자기();
		behavior.놀기();
		behavior.밥먹기();
		behavior.운동();
		behavior.데이트();
		
	}
	
	
}
