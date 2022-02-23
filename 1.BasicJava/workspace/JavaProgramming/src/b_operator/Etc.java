package b_operator;

import java.util.Scanner;


public class Etc {

	public static void main(String[] args) {
		/*
		 * 비트연산자(비트:컴퓨터가 표현할 수 있는 가장작은 단위)
		 * - |, &, ^, ~, <<, >>
		 * -비트 단위로 연산한다.
		 * 
		 * 기타연산자
		 * - .(참조연산자): 특정 범위 내에 속해 있는 멤버를 지정할 때 사용한다.
		 * - ?:(삼항연산자): ex-(조건식? 조건식이 참일 경우 수행할 문장: 조건식이 거짓일 경우 수행할 문장)
		 */
		
		//1byte=01010101, bit=0,1(숫자 하나하나)
		
		//System.out.println(10|15); // |:둘다 0 그외 1
		//10 : 00001010
		//15 : 00001111
		// |:  00001111
		//System.out.println(10&15);
		//10 : 00001010
	    //15 : 00001111
		// & : 00001010
		//System.out.println(10^15);
		//10 : 00001010
		//15 : 00001111
		// ^ : 00000101
		
		/*int x=10;
		int y=20;
		int result = x<y ? x:y;
		System.out.println(result);
		
		//주민등록번호 뒷자리의 첫번째 숫자가 1이면 남자 2면 여자
		int regNo=3;
		String gender = regNo==1 ? "남자":"여자";
		System.out.println("당신의 성별은 "+gender+" 입니다.");
		
		gender = regNo==1 ?"남자":(regNo==2?"여자":"확인불가");//삼항연산자 두번 쓰는법
		System.out.println("당신의 성별은 "+gender+" 입니다.");*/
		
		/*Scanner scr = new Scanner(System.in);
		System.out.print("숫자를 입력해 주십시오:");
		int a=Integer.parseInt(scr.nextLine());
		System.out.print("숫자를 입력해 주십시오:");
		int b=Integer.parseInt(scr.nextLine());
		
		int result = a>b ? a:b;
		System.out.print("더 큰 숫자는: "+result+" 입니다.");*/
		
		
		Scanner scr = new Scanner(System.in);
		System.out.print("숫자를 입력해 주십시오:");
		int a=Integer.parseInt(scr.nextLine());
	    String result = a==1||a==3? "남자":(a==2||a==4? "여자":"확인불가");
	    System.out.println(result);
		
		
		
		
	}
}


