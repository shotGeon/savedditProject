package a_variabe;

import java.util.Scanner;

public class join {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("==========회원가입=========");
		System.out.print("아이디>");
		String id = sc.nextLine();
		System.out.print("비밀번호(4자리숫자)>");
		int pwd = Integer.parseInt(sc.nextLine());
		System.out.print("이름>");
		String name = sc.nextLine();
		System.out.print("나이>");
		int age = Integer.parseInt(sc.nextLine());
		System.out.print("키>");
		double tall = Double.parseDouble(sc.nextLine());
		System.out.println("=======================");
		System.out.println("회원가입 완료!!");
		System.out.println("==========내정보=========");
		System.out.println("아이디:"+id);
		System.out.println("비밀번호:"+pwd);
		System.out.println("이름:"+name);
		System.out.println("나이:"+age);
		System.out.println("키"+tall+"cm");
		System.out.println("=======================");
			    		
				
	}

}









