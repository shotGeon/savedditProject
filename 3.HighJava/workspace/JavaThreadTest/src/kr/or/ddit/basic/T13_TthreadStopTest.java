package kr.or.ddit.basic;

public class T13_TthreadStopTest {
/*
 * Thread의 stop()메서드를 호출하면 스레드가 바로 멈춘다.
 * 이때 사용하던 자원을 정리하지 못하고 프로그램이 종료되어서
 * 나중에 실행되는 프로그램에 영향을 줄 수 있다.
 * 그래서 현재는 stop()메서드는 비추천으로 되어 있다.
 */
	public static void main(String[] args) {
		/*ThreadStopEx1 th = new ThreadStopEx1();
		th.start();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		th.setStop(true);
	}*/
		//interrupt()메서드를 이용한 스레드 멈추기
		ThreadStopEx2 th2 = new ThreadStopEx2();
		th2.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		th2.interrupt();//인터럽트걸기
	
	}
}

class ThreadStopEx1 extends Thread{
	private boolean stop;
	
	public void setStop(boolean stop) {
		this.stop=stop;
	}
	
	@Override
	public void run() {
		while(!stop) {
			System.out.println("스레드 처리 중...");
		}
		System.out.println("자원 정리 중...");
		System.out.println("실행 종료.");
	}
}

//interrupt( ) 이용하여 스레드를 멈추게 하는 방법
class ThreadStopEx2 extends Thread{
//	@Override
//	public void run() {
//		//방법 1: sleep() 메서드나 join()메서드 등을 사용할 때 interrupt()
//		//      메서드를 호출하면 interruptedException이 발생한다.
//		try {
//			while(true) {
//				System.out.println("스레드 처리중...");
//				Thread.sleep(1);
//			}
//		}catch(InterruptedException ex) {}
//		
//		System.out.println("자원 정리 중....");
//		System.out.println("실행 종료.");
//	}
	
	//방번 2=> interrupt() 메서드가 호출되었는지 검사하기
	@Override
	public void run() {
		
			while(true) {
				System.out.println("스레드 처리 중...");
				//검사방법1: 스레드의 인스턴스 객체용 메서드를 이용하는 방법
				if(isInterrupted()) {
					System.out.println("인스턴스용 isInterrupted() :"+isInterrupted());
					break;
				}
			}
		
	}
//	@Override
//	public void run() {
//		if(Thread.interrupted()) {
//			System.out.println("정적 메서드 Thread.interrupted()");
//			break;
//		}
//			
//		
//	}
	
}





















