package e_oop;
//클래스 이름만들때는 반드시 앞글자는 대문자
public class SampleClass {

	public static void main(String[] args) {
		int local=10;//지역변수(매서드 안에서만 사용하는 변수)
		
	}
	int field; //전역변수:클래스 전체 영역에서 사용하는 변수//전역변수는 초기화를 안해도 기본값으로 자동으로 초기화된다.
	
	/*
	 * -메서드:변수를 가지고 할 일
	 * -선언 방법: 리턴타입 메서드명(파라미터)
	 * -파라미터(매개변수):실행에 필요한 정보
	 * -리턴타입(반환타입):실행 후 돌려줘야하는 결과물
	 */
	
	String method1(int parameter){
		return parameter + "를 받아 명령을 수행하고 결과물을 리턴하는 메서드";
	}
	
	void method2(){
		System.out.println("파라미터도 리턴타입도 없는 메서드");
	}
	
	
	
	void flowTest1(){
		System.out.println("flowTest1 시작: 1");
		flowTest3();
		System.out.println("flowTest3 종료: 6");
	}
	void flowTest2(){
		System.out.println("flowTest2 시작: 3");
		System.out.println("flowTest2 종료: 4");
	}
	void flowTest3(){
		System.out.println("flowTest3 시작: 2");
		flowTest2();
		System.out.println("flowTest3 종료: 5");
	}	
	
}














































