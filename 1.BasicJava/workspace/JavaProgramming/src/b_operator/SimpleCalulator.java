package b_operator;

import java.util.Scanner;

public class SimpleCalulator {

	public static void main(String[] args) {
		
		
		//두개의 숫자와 연산자를입력받아 연산결과를 알려주는 프로그램을 만드시오
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("숫자를 입력하시오:");
		int a = Integer.parseInt(sc.nextLine());
		System.out.print("기호를 입력하시오:");
		String b = sc.nextLine();
		System.out.print("숫자를 입력하시오:");
		int c = Integer.parseInt(sc.nextLine());
		
		
		int result = b.equals("+")? a+c
				    :b.equals("-")? a-c
				    :b.equals("*")? a*c
				    :b.equals("/")? a/c
			        :b.equals("%")? a%c:0;
		System.out.println("답:"+result);
		
		
		
		

		
		
		
		
		
		

	}

}
