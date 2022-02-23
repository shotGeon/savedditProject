package c_statement;

import java.util.Scanner;

public class ConditionalStatement {

	public static void main(String[] args) {
		/*
		 * 조건문 -if문 -switch문
		 * 
		 * if문-if(조건식){}:조건식의 결과가 true이면 블럭안의 문장을 수행한다.-else if(조건식){}:다수의 조건이
		 * 필요할때 if 뒤에 추가한다-else{}:조건식 이외의 경우를 위해 추가한다
		 */

		
		 /* int a=4;
		 * 
		 * if(a ==1){ System.out.println("a==1"); }else if(a==2){
		 * System.out.println("a==2"); }else if(a==3){
		 * 
		 * System.out.println("a==3"); }else{ System.out.println("false"); }
		 * 
		 * if(a<10){ System.out.println("a가 10보다 작다"); }else if(a<20){
		 * System.out.println("a가 20보다 작다"); }
		 * 
		 */  //정수가 60점 이상이면 합격 그렇지 않으면 불합격

		/*int score = 80;*/

		/*if (score >= 60) {
			System.out.println("합격");
		} else {
			System.out.println("불합격");
		}*/

		// 성적에 등급을 부여하는 프로그램
		/*score = 70;
		String grade = null;// 참조형은 기본값으로 null값을 가진다, 기본형은 0, boolean타입은 false,
							// 그외 0

		if (90 <= score) {
			grade = "A";

		} else if (80 <= score) {
			grade = "B";

		} else if (70 <= score) {
			grade = "C";

		} else if (60 <= score) {
			grade = "D";
		} else {
			grade = "F";
		}
		System.out.println(score + "점에 해당하는 등급은" + grade + "입니다");

		score = 90;
		grade = null;*/

		// 줄맞추기 단축키:crtl+shift+f
		/*if (90 <= score) {
			grade = "A";
			if (97 <= score) {
				grade += "+";
			} else if (score <= 93) {
				grade += "-";
			}
		} else if (80 <= score) {
			grade = "B";
			if (87 <= score) {
				grade += "+";
			} else if (score <= 83) {
				grade += "-";
			}
		} else if (70 <= score) {
			grade = "C";
			if (77 <= score) {
				grade += "+";
			} else if (score <= 73) {
				grade += "-";
			}
		} else if (60 <= score) {
			grade = "D";
			if (67 <= score) {
				grade += "+";
			} else if (score <= 63) {
				grade += "-";
			}

		} else {
			System.out.println("과락");
		}
		System.out.println(score + "점에 해당하는 등급은" + grade + "입니다");*/

		/*
		 * switch문 -switch(int/String){case 1:break;} -조건식의 결과는 정수와 문자열만
		 * (3DK1.7부터 문자열 허용)허용한다. -조건식가 일치하는 case문 이후의 문장을 수행한다.
		 */

		/*int a = 10;

		switch (a) {//switch문에서는 케이스 사이사이에 반드시 break가 있어야한다.
		case 10:
			System.out.println("a==10");
			break;
		case 20:
			System.out.println("a==20");
			break;
		default:
			System.out.println("default");
			

		}*/

		/*String b ="a";
		
		switch(b){
		case "a":
			System.out.println("b==\"a\"");
			break;
		case "b":
			System.out.println("b==\"b\"");
			break;
		default:
			System.out.println("default");
		}*/
		
		/*int month = 3;
		String season = null;

		switch (month) {
		case 3:
		case 4:
		case 5:
			season = "봄";
			break;
		case 6:
		case 7:
		case 8:
			season = "여름";
			break;
		case 9:
		case 10:
		case 11:
			season = "가을";
			break;
		case 12:
		case 1:
		case 2:
			season = "겨울";
			break;
		}
		System.out.println(month + "월은 " + season + "입니다.");
		
		score =90;
		grade=null;
		switch(score/10){
		case 10: case 9:
			grade="A";
			break;
		case 8:
			grade="B";
			break;
		case 7:
			grade="C";
			break;
		case 6:
			grade="D";
			break;
		default:
			grade="F";
			
		   
		}
		System.out.println(score+"점은 "+grade+"등급입니다");*/
		
	//숫자를 입력받아 그 숫자가 0인지 아닌지 출력해 주세요
		
		Scanner scr= new Scanner(System.in);
		
		/*System.out.print("숫자를 입력해주세요:");
		int num=Integer.parseInt(scr.nextLine());
		
		if (num==0){
			System.out.println("입력된 숫자는 "+num+"입니다.");
		}else{
			System.out.println("입력된 숫자는 0이 아닙니다.");
		}*/
		
		
		//숫자를 입력받아 그 숫자가 홀수인지 짝수인지 출력해주세요
		
		/*System.out.print("숫자를 입력해주세요:");
		int num=Integer.parseInt(scr.nextLine());
		if(num%2==0){
			System.out.println("입력된 숫자는 짝수입니다.");
		}else {
			System.out.println("입력된 숫자는 홀수입니다.");
		}*/
		
		//정수 3개를 입력받아 합계, 평균, 등급을 출력해주세요.
		
		/*System.out.print("점수를 입력해주세요:");
		double num=Double.parseDouble(scr.nextLine());
		System.out.print("점수를 입력해주세요:");
		double num2=Double.parseDouble(scr.nextLine());
		System.out.print("점수를 입력해주세요:");
		double num3=Double.parseDouble(scr.nextLine());
		
		double sum =num+num2+num3;
		double avg =Math.round(sum/3.0*10)/10;
		String grade2=null;
		
		if(avg>=90){
			grade2="A";
			if(avg>=95){
				grade2+="+";
			}
		}else if(avg>=80){
			grade2="B";
			if(avg>=85){
				grade2+="+";
			}
			
		}else if(avg>=70) {
			grade2="C";
			if(avg>=75){
				grade2+="+";
			}
		}else{
			grade2="F";
		}
		System.out.println("점수의 합계는"+sum+"입니다.");
		System.out.println("점수의 평균은"+avg+"입니다.");
		System.out.println("점수의 등급은"+grade2+"입니다.");*/
		
		//1~100 사이의 랜덤한 수를 3개 발생시키고 오름차순으로출력해주세요
		
		int random1 = (int) (Math.random() * 100) + 1;
		int random2 = (int) (Math.random() * 100) + 1;
		int random3 = (int) (Math.random() * 100) + 1;

		int fst = 0;
		int scd = 0;
		int thd = 0;

		if (random1 > random2 && random1 > random3) {
			thd += random1;
		 if (random2 > random3 ) {
				scd += random2;
				fst += random3;
	    
			}
		}else if (random2>random1&&random2>random3){
			thd+=random2;
			if(random1>random3){
				scd+=random1;
				fst+=random3;
			}
		}else if (random3>random1&&random3>random2){
			thd+=random3;
			if(random1>random2){
				scd+=random1;
				fst+=random2;
			}
		}
		System.out.println(fst);//sysout+ctrl+space(system.out 자동완성)
		System.out.println(scd);
		System.out.println(thd);
	}
}
