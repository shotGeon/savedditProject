package e_oop;

public class Variableinit {

	//명시적 초기화
	int var=10;
	static int classVar=20;
	
	//초기화 블럭
	{
		var =30;//인스턴스 변수를 초기화함
	}
	
	static{
		classVar=30;//클래스 변수를 초기화함
	}
	
	/*
	 * 생성자
	 * -클래스와 같은 이름의 메서드
	 * -인스턴스 변수를 초기화하기 위해 사용한다.
	 * -클래스에 생성자는 반드시 하나 이상 존재해야 한다.
	 * -직접 선언해주지 않으면 컴파일러가 기본 생성자를 만들어준다.
	 * -생성자는 리턴타입이 없다.
	 */
	
	Variableinit(){
		var = 50;
		
		//생성자 사용 이유
		//초기화에 여러줄의 코드가 필요할 때
		//초기화에 파라미터가 필요할 때
		
	}
	public static void main(String[] args) {
		Init i = new Init();
		i.a=10;
		i.b=20;
		i.c=30;
		
		Init i2 = new Init();
		i2.a=40;
		i2.b=50;
		i2.c=60;
		
		Init i3 =  new Init(70,80,90);
		
	  
	}
	
}

class Init{
	int a;
	int b;
	int c;
	
	
	
	Init(int a,int b, int c){
		this.a=a;
		this.b=b;
		this.c=c;
		//this:인스턴스 변수와 지역변수의 이름이 같을 때 둘을 구분하기 위해 사용한다.
	}
	//오버로딩:같은 이름의 메서드를 여러개 정의하는 것,파라미터로 구별한다.
	Init(){
		/*a=10;이런식은 권장하지 않음
		b=20;
		c=30;*/
		this(10,20,30);//생성자에서 다른 생성자를 호출할 때 사용한다.()붙으면 생성자안에서 다른 생성자를 호출할때 사용한다.//첫줄에 사용해야함
		
	}
}













