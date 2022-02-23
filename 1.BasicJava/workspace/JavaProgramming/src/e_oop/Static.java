package e_oop;

public class Static {
	/*
	 * -static을 붙이면 프로그램 실행시 메모리에 올라간다.
	 * -객체생성을 하지 않아도 사용할 수 있다.
	 * -static을 붙인 변수는 객체간에 변수의 값을 공유한다.
	 * -static이 붙은 멤버의 명칭:클래스 변수, 클래스 메서드(전역변수에만 붙일 수 있음)
	 * -static이 붙지 않은 멤버의 명칭:인스턴스 변수,인스턴스 메서드
	 */
	
	//값을 공유하기 위해 static을 붙인다.
	static int var;

	public static void main(String[] args) {
		
		Saram s1 = new Saram();
		Saram s2 = new Saram();
		s1.name="철수";
		s2.name="영희";
		
		s1.saveMoney(10000);
		s2.saveMoney(20000);
		
		s1.saveDateMoney(10000);
		s2.saveDateMoney(10000);
		
		Saram.dateAccount=0;
		System.out.println(Saram.dateAccount);
		
		System.out.println("문자열 입력>");
		String str=ScanUtil.nextLine();
		System.out.println(str);
		System.out.println("숫자입력>");
		int num=ScanUtil.nextInt();
		System.out.println(num);
	}

}

class Saram{
	
	String name;
	int account;//계좌 잔고
	
	void saveMoney(int money){
		account+=money;
		System.out.println(name+"의 계좌 잔고 "+account);
	}
	
	static int dateAccount;
	
	void saveDateMoney(int money){
		dateAccount+=money;
		System.out.println("데이트 계좌 잔고: "+dateAccount);
	}
}