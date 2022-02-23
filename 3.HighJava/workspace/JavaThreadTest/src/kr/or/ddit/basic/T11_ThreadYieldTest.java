package kr.or.ddit.basic;

public class T11_ThreadYieldTest {
/*
 * yield() 메서드에 대하여...
 * 
 * 1.현재 실행 대기중인 동등한 우선순위 이상의 다른 스레드에게 실행기회를 제공한다.
 * 2.현재 실행중인 스레드의 상태를 Runnable 상태로 바꾼다.
 * 3.yield()메서드를 실행한다고 해서 현재 실행중인 스레드가 곧바로 runnable
 *   상태로 전이된다고 확신할 수 없다.
 */
	public static void main(String[] args) {
		Thread th1 = new YieldThreadEx1();
		Thread th2 = new YieldThreadEx2();
		
		th1.start();
		th2.start();
	}
}

class YieldThreadEx1 extends Thread{
	//부모클래스의 생성자 호출(스레드 클래스)
	//스레드 생성자에 사용하고 싶은 이름을 부여하면 스레드이름이 바뀐다.
	public YieldThreadEx1() {
		super("YieldThreadEx1");
	}
	
	@Override
	public void run() {
		for(int i=0; i<10; i++) {
			System.out.println(Thread.currentThread().getName()+" : "+i);
			Thread.yield();//양보하기
		}
	}
}

class YieldThreadEx2 extends Thread{
	public YieldThreadEx2() {
		super("YieldThreadEx2");
	}
	
	@Override
	public void run() {
		for(int i=0; i<10; i++) {
			System.out.println(Thread.currentThread().getName()+" : "+i);
		}
	}
}