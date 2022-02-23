package com.jsp.action.common;

public class StringTest {
	public static void main(String[] args) {
		
		String[] test = {"안녕","뭐해","배고파"};
		
		for(String tt : test) {
			tt+="바보";
			System.out.println("test1"+tt);
		}
		
		for(int i=0; i<test.length; i++) {
			System.out.println("test2"+test[i]);
		}
	}
}
