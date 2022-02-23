package com.spring.exe;

import com.spring.main.Calculator;
import com.spring.sub.Divide;
import com.spring.sub.DivideImpl;
import com.spring.sub.Minus;
import com.spring.sub.MinusImpl;
import com.spring.sub.Multiplex;
import com.spring.sub.MultiplexImpl;
import com.spring.sub.Summation;
import com.spring.sub.SummationImpl;

public class Main {
	private Calculator cal = new Calculator();
	
	{
		Summation sum = new SummationImpl();
		
		Multiplex multi = new MultiplexImpl();
		
		Divide divide = new DivideImpl();
		
		Minus minus = new MinusImpl();
		
		cal.setDivide(divide);
		cal.setMinus(minus);
		cal.setSummation(sum);
		cal.setMultiplex(multi);
	}
	
	public static void main(String[] args) {
		int a=10;
		int b=10;
		int c=10;
		
		Main main = new Main();
		
		System.out.println(main.cal.sum(a, b));
		System.out.println(main.cal.minus(a, b));
		System.out.println(main.cal.multi(a, b));
		System.out.println(main.cal.divide(a, b));
	}

}
