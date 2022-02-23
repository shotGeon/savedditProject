package kr.or.ddit.basic;

public class T14_ThreadShareDataTest {
/*
 * 스레드에서 데이터를 공통으로 사용하는 방법
 * 
 * 1. 공통으로 사용할 데이터를 클래스로 정의한다.
 * 2. 공통으로 사용할 클래스의 인스턴스를 만든다.
 * 3. 이 인스턴스를 각각의 스레드에 넘겨 준다.
 * 4. 각각의 스레드는  이 인스턴스의 참조값을 저장한 변수를 이용하여
 *    공통 데이터를 사용한다.
 *    
 * 예) 원주율을 계산하는 스레드가 있고, 계산된 원주율을 출력하는 스레드가 있다.
 *    원주율을 계산한 후 이 값을 출력하는 프로그램을 작성하시오.
 *    (이 때 원주율을 저장하는 객체가 필요하다.)
 */
	public static void main(String[] args) {
		//공통으로 사용할 객체의 인스턴스 생성
		ShareData sd = new ShareData();
		
		//처리할 스레드 객체 생성
		CalcPiThread cpt= new CalcPiThread(sd);
		PrintPiThread ppt = new PrintPiThread(sd);
		
		cpt.start();
		ppt.start();
	}
}

//원주율을 관리하는 클래스(공통으로 사용할 클래스)
class ShareData{
	public double result; //원주율이 저장될 변수
	/*
	 * volatile => 선언된 변수를 컴파일러의 최적화 대상에서 제외시킨다.
	 *     즉, 값이 변경되는 즉시 변수에 적용시킨다.
	 *     다중 스레드에서 하나의 변수가 완벽하게 한번에 작동하도록 보장하는 키워드(일종의 동기화)
	 */
	 
	//원주율이 계산되었는지를 나타내기 위한 변수
	//volatile 최적화 대상에서 제외 시켜준다.
	volatile public boolean isOk = false;	
}

// 원주율을 계산하는 스레드
class CalcPiThread extends Thread{
	private ShareData sd;
	
    public CalcPiThread(ShareData sd) {
    	this.sd=sd;
	// TODO Auto-generated constructor stub
   }
    @Override
    public void run() {
    	/*
    	 * 원주율 = (1/1 - 1/3 + 1/5 - 1/7 + 1/9 ....) +4;
    	 *         1   - 3   + 5   - 7   +  9 =>분모
    	 *         0     1     2     3      4 =>2로 나눈 몫
    	 */
    	double sum = 0.0;
    	
    	for(int i=1; i<=1500000; i+=2) {
    		if(((i/2)%2)==0) {//2로 나눈 몫이 짝수면..
    			sum +=(1.0/i);
    		}else {//2로 나눈 몫이 홀수면...
    			sum -=(1.0/i);
    		}
    	}
    	
    	sd.result = sum *4; //계산된 원주율을 공통객체의 멤버변수에 저장
    	sd.isOk = true; //계산이 완료됨을 나타냄.
    }
}

//계산된 원주율을 출력하는 스레드
class PrintPiThread extends Thread{
	private ShareData sd;
	public PrintPiThread(ShareData sd) {
		this.sd=sd;
	}
	
	@Override
	public void run() {
		while(true) {
			//원주율 계산이 완료될 때까지 기다린다.
			if(sd.isOk) {
				break;
				
			}
		}
		System.out.println();
		System.out.println("계산된 원주율: "+sd.result);
		System.out.println("      PI: "+Math.PI);
	}
}




























