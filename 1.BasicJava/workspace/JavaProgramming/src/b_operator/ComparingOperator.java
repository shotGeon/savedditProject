package b_operator;


public class ComparingOperator {

	public static void main(String[] args) {
		/*
		 * 비교연산자
		 * - <, >, <=, >=, ==, != (=는 대입연산자)
		 * - 문자열 비교:equals()
		 */
		
		
		int x =10;
	    int y =20;
		int b;//비교연산자의 연산결과는 boolean이다.
		//System.out.println(b);
		//b=x<=y-15;//산술연산자가 비교연산자보다 우선순위가 높다.
		//System.out.println(b);
		
		String str1="abc";
		//String str2="ABC";
		//b=str1==str2; //참조형 타입은 내용이 아닌 주소를 비교한 것이다.
		//System.out.println(b);
		
		//String의 내용을 비교하기 위해서는 equals()매서드를 사용한다.
		b=str1.equals("abc")? x+y:x*y;
		System.out.println(b);
		
		//다음의 문장들을 코드를 작성해주세요
		
		//x는 y보다 작거나 같다.	
		//x+5와 y는 같다
		//y는 홀수이다.
		//"기본형"과 "참조형"은 다르다.
		
		/*int x=10;
		int y=20;
		boolean care = x<=y;
		System.out.println(care);
		care= x+5==y;
		System.out.println(care);
		care= y%2==1;
		System.out.println(care);
		
		String str1="기본형";
		String str2="참조형";
		care=str1.equals(str2);
		System.out.println(care);*/
		
		
		

	
		
	}

}
