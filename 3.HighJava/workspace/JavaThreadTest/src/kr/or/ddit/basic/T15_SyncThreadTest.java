package kr.or.ddit.basic;

public class T15_SyncThreadTest {
	public static void main(String[] args) {
		ShareObject sObj = new ShareObject();
		
		WorkThread wth1 = new WorkThread(sObj);
		WorkThread wth2 = new WorkThread(sObj);
		
		wth1.start();
		wth2.start();
	}
}

//공통으로 사용할 객체
class ShareObject {
	
	private int sum = 0;
	
	 //동기화 하는 방법1 : 메서드 자체에 동기화 설정하기
	 //public synchronized void add() {
		public  void add() {
			
		//동기화 처리하는 방법2: 동기화 블럭으로 설정하기
		//synchronized (this) {
		//}
		for(int i=0; i<1000000000; i++) {}//동기화전까지 시간벌기용
			int n =sum;
			n+=10;
			sum=n;
			System.out.println(Thread.currentThread().getName()+" 합계: "+sum);
		}	
	
	public int getSum() {
		return sum;
	}
	
}

//작업을 수행하는 스레드
class WorkThread extends Thread{
	ShareObject sObj;
	
	public WorkThread(ShareObject sObj) {
		this.sObj =sObj;
	}
	
	@Override
	public void run() {
		for(int i=1; i<=10; i++) {
			synchronized (sObj) {
				sObj.add();
				
			}
		}
	}
}



























































