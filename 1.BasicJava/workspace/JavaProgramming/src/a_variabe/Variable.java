package a_variabe;  //패키지: 클래스의 위치
import java.util.Scanner;

//import:다른 패키지에 위치한 클래스의 위치를 알려주는 것, 반드시 패키지아 클래스 사이에 위치해 있어야 한다.
//import 단축키: Ctrl + o(알파벳)
//import (패키지이름)(클래스이름)

public class Variable { //클래스: 데이터와 기능의 집합
	

	//public static void main(String[] args) { //매서드:명령문의 집합
		//main메서드: 프로그램의 시작과 끝
		//주석: 프로그램 코드로 인식되지 않는 문장(주로 코드를 설명하는데 사용)
        
		
		/*
		 * 데이터
		 * 1.기본형
		 * -숫자
		 * -문자
		 * -논리
		 * 
		 * 2.참조형(데이터가 위치한 주소를 저장)
		 * -배열(형태가 같은 여러개의 데이터를 묶어서 사용)
		 * -클래스(형태가 다른 여러개의 데이터와 기능을 묶어서 사용) 
		 */
		
		/*기본형 타입
		 * -정수: byte(1), short(2), *int(4), long(8)
		 * -실수: float(4/7자리), *double(8/15자리)
		 * -문자: char(2)
		 * -논리: boolean(1)
		 * 
		 *참조형 타입
		 *-문자열: String(4)
		 *
		 *명명규칙
		 *-영문자 대소문자, 한글, 숫자, 특수문자('_', '$')를 사용할 수 있다.
		 *-숫자로 시작 할 수 없다.
		 *-예약어는 사용할 수없다.
		 *-[낙타식 표기법을 사용한다.(mySampeVariable)]
		 *-[클래스명의 첫글자는 대문자로 한다.(MySamplClass)]
		 */
		
		//변수 선언(값을 저장할 공간을 만드는 것)
	    //;(세미클론):문장의 마침표		
		// {(중괄호)안에서만 변수이름이 중복이 되지 않으면 된다.
		
		//9가지 타입을 모두 사용해9개의 변수를 선언해주세요
		/*byte x; //(1)
		short y; //(2)		
		int z; //(4)
		long t; //(8)
		float e; //(4)
		double w; //(8)
		char abc; //(2)
		boolean bool; //(1)
		String name; //(4)
		*/
		
		//초기화(변수에 처음으로 값을 저장하는 것)
		//=(대입연산자) : 오른쪽의 값을 왼쪽의 변수에 저장한다.
		//변수를 선언한 이후에는 변수의 이름을 가지고 변수를 사용한다.
		/*int x;
		x=10;//타입에 맞는 값을 저장해야 한다.
		long y;
		y=20L;//접미사 L을 붙여야 long타입이 된다.
		float z;
		z=3.14f;//접미사 f를 붙여야 float타입이 된다., 그냥쓰면 double타입이다.
		char abc;
		abc='가';//따옴표안에 반드시 한글자를 넣어야 한다.
		boolean bool;
		bool=true;//true, false 둘중에 하나만 저장할 수 있다.
		String name;
		name="가나다라마바사"; //쌍따움표로 문자열을표현한다.
		*/
		
		//위에서 선언한 9개의 변수들을 초기화해라
		/*byte x=1;
		short y=2;		
		int z=4;
		long t=300L;
		float e=3.14f;
		double w=3.2333;
		char abc='건';
		boolean bool=false;
		String name="강건입니다.";*/
		//변수에 새로운 값을 저장하면 기존의 값은 사라진다. ex int a=10; a=20;
		
		//형변환(데이터의 타입을 다른 타입을 변경하는 것)
		/*int _int=10;
		long _long=20L;
		
		_int=(int)_long;
		_long=_int;//표현범위(byte로 판단해서는 안됨)가 작은 타입에서 큰 타입으로의 형변한은 생략할 수 있다.
		
		_int=_int+_long;//서로 다른 타입은 연산할 수 없다.
		_int=_int+(int)_long;*/
		
		//변수 3개를 선언해 변수의 타입과 다른 타입으 값으로 초기하 해라
		/*int x=(int)3.14;
		float y=(float)3.15;
		char ab=(char)x;*/
		
		//출력(콘솔)
		/*System.out.println("x");
		System.out.print(x);
		System.out.println(x);
		System.out.printf("출력 포맷 지정");*/
		
		//탈출 문자(Escape문자(\))
		/*System.out.println("탭은\t4칸에 맞춰 띄워줍니다.");
		System.out.println("줄바꿈을\n해줍니다.");
		System.out.println("\"쌍따움표를 넣어줍니다.\"");
		System.out.println("\\역슬래시를 넣어줍니다.");*/
		
		//입력
		//Scanner sc = new Scanner(System.in);//입력받기위한 클래스
		
		/*System.out.println("아무거나 입력해 주세요:");
		String str=sc.nextLine();//nextLine매서드를 써야 입력을 받는다.
		System.out.println("입력받은 내용:" +str);*/
	
		/*System.out.print("숫자를 입력해주세요:");
		int nextInt=sc.nextInt();오류발생함 사용 ㄴㄴㄴ
		System.out.println("입력받은 숫자:" + nextInt);
		System.out.print("문자를 다시입력:")
		String nextLine = sc.nextLine();
		System.out.println("입력받은 문자열:"+ nextLine);*/
		
		/*System.out.print("숫자를 입력해 주세요");
		int number = Integer.parseInt(sc.nextLine());
		System.out.println("입력받은 숫자:" + d);*/
		//double d = Double.parseDouble(sc.NextLine());
		
		//자신의 이름을 저장할 변수를 선언하고 Scanner를 사용해 이름을 저장해주세요.
		/*Scanner sc = new Scanner(System.in);
		System.out.print("이름을 입력해 주세요:");
		String str=sc.nextLine();
		System.out.print("나이를 입력해 주세요:");
		int age = Integer.parseInt(sc.nextLine());
		System.out.println("이름은 "+str+" 나이는"+age);*/
		
		//2021_07_06과제 
		
		
		
		
		
		
		
		
		
	
		
	}


