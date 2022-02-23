package com.spring.qrtest;

import java.text.NumberFormat;

public class testparse {
	
	public static void main(String[] args) {
		NumberFormat numberformat = NumberFormat.getInstance();
		String test1 = "907214";
		String test2 = numberformat.format(Double.parseDouble(test1));
		
		System.out.println(test2);
		
		
	}
}
