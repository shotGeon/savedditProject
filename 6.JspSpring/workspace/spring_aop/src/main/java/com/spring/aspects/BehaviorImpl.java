package com.spring.aspects;

public class BehaviorImpl implements Behavior{

	@Override
	public void 잠자기() {
		System.out.println("잠을 잔다.");
	}

	@Override
	public void 공부하기() {
		
		System.out.println("공부한다.");
		
	}

	@Override
	public void 밥먹기() {
		System.out.println("밥먹는다.");
		
	}

	@Override
	public void 데이트() {
		System.out.println("데이트한다.");
		
	}

	@Override
	public void 운동() {
		System.out.println("운동한다.");
		
	}

	@Override
	public void 놀기() {
		System.out.println("논다.");
		
	}

	@Override
	public void 정신수양() {
		System.out.println("정신수양 한다.");
		
	}

}
