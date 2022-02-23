package g_oop2;

public class SampleChild extends SampleParent {

	void childMethod(){
		System.out.println(var);//상속받은 변수
		System.out.println(method(7,13));//상속받은 메서드
	}
	
	//오버라이딩(부모클래스의 메소드를 물려받으면 그 기능을 바꾸는 것을 말한다.)
	//super, super()
	//다형성
	
	//오버라이딩: 상속받은 메서드의 내용을 재정의 하는 것
	@Override//어노테이션: 클래스, 변수, 메서드 등에 표시해 놓는 것
	int method(int a, int b){//리턴타입,메서드이름,파라미터는 동일하게 작성하고 내용만 바꿔준다.
		return a*b;
	}
	//super,super()
	int var;
	
	void test(double var){
		System.out.println(var);//지역변수
		System.out.println(this.var);//인스턴스 변수
		System.out.println(super.var);//부모 클래스의 인스턴스 변수
		
		//super: 부모 클래스의 멤버와 자식 클래스의 멤버가 이름이 중복될 때 둘을 구분하기 위해 사용한다.
		
		System.out.println(method(10,20));//자식 클래스 메서드
		System.out.println(super.method(10,20));//부모 클래스 메서드
		
	}
	
	SampleChild(){
		//자식 클래스의 생성자 안에서는 반드시 부모클래스의 생성자를 호출해야한다.,없어도 컴파일러가 넣어준다.
		super();//부모클래스의 생성자 호출
	}
	//다형성(형변환을 가능하게 하기 위해서)
		public static void main(String[] args) {
			SampleChild sc=new SampleChild();
			SampleParent sp=new SampleChild();
			
			sc=(SampleChild)sp;//형변환을 명시해주어야 한다.
			sp=sc;
			//자식타입->부모타입 형변환은 생략할 수 있다.
			SampleChild sc2 =(SampleChild) new SampleParent(); //사용불가
			
		}
              	
	
	
	
	
	
}















