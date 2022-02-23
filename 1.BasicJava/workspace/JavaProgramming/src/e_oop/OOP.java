package e_oop;

public class OOP {

	public static void main(String[] args) {
		/*
		 * 객체지향 프로그래밍(Object Oriented Programming)
		 * -프로그래밍을 단순히 코드의 연속으로 보는것이 아니라 객체간의 상호작용으로 보는것
		 * -코드의 재사용성이 높고 유지보수가 용이하다
		 */
		
		
		SampleClass sc=new SampleClass();
		
		System.out.println(sc.field);
		String returnValue=sc.method1(10);
		System.out.println(returnValue);
		
		sc.method2();
		sc.flowTest1();
		
		
		
		ClassMaker cl = new ClassMaker();
		
		
		
		cl.not();	
		
		int b=cl.number();//반환값 o
		System.out.println(b);
		
 		int returnply=cl.multiply(10,10);//반환값o
		System.out.println(returnply);
		
		cl.number2(20,30);
		
	   Calculator cal = new Calculator();
	   
	   double result=cal.plus(123456, 654321);
	   result=cal.gop(result, 123456);
	   result=cal.naa(result, 123456);
	   result=cal.minus(result, 654321);
	   result=cal.nae(result, 123456);
	   System.out.println(result);
	  
	  
	}

}


