package com.spring.chart;

public class TestMakePassword {
	
	public static void main(String[] args) {
		String tel ="042-111-222";
		String pwd=tel.replaceAll("-", "");
		
		System.out.println(pwd);
		String test ="대전시 성모병원";
		String test2 = test.replaceAll(" ", "");
		
		System.out.println(test2);
	}
}
