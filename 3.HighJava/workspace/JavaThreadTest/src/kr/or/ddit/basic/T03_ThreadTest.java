package kr.or.ddit.basic;

public class T03_ThreadTest {
	public static void main(String[] args) {
		// 스레드의 수행시간 체크해 보기
		Thread th = new Thread(new MyRunner());
		
		//UTC(Universal Time Coodinated 협정 세계 표준시)를 사용하여
		//1970년 1월1일 0시0분0초를 기준으로 경과한 시간을 밀리세컨드 단위로
		//나타낸다. => 유닉스 타임스탬프
		long startTime = System.currentTimeMillis();
		
		th.start();
		
		try {
			th.join();//현재 실행중인 스레드에서 작업 중인 스레드
				      //(지금은 th스레드)가 종료 될때까지 기다린다.
			
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
		long endTime = System.currentTimeMillis();
		System.out.println("경과시간: "+(endTime -startTime)+"ms");
	}
}
//다른 클래스를 이미 상속받은 클래스는 Thread클래스를 상속받아 사용할 수 없다.
//(다중 상속은 불가능 하기 때문에(그럴때 implements를 이용한 두번째 방법을 사용한다.))

/**
 *
 * 1~1000000000 까지의 합계를 구하는 스레드
 *
 */
class MyRunner implements Runnable{

	@Override
	public void run() {
		long sum=0;
		for(long i=1L; i<=1000000000; i++) {
			sum+=i;
		}
		System.out.println("합계: "+sum);
	}
	
}