package com.spring.sub;

public class SummationImpl implements Summation{

	@Override
	public int sum(int a, int b) {
		int sum = a+b;
		return sum;
	}

	@Override
	public int sum(int a, int b, int c) {
		int sum = a+b+c;
		return sum;
	}

}
