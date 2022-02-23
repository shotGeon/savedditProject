package c_statement;

import java.util.Scanner;


public class practice {

	public static void main(String[] args) {
		
		int random1=0;
		int random2=0;
		int random3=0;
       		
		Scanner sc = new Scanner(System.in);
		
		random1 = (int)(Math.random()*9)+1;
		
		
		random2 = (int)(Math.random()*9)+1;
		
		
		random3 = (int)(Math.random()*9)+1;
		
		
		while (random1 == random2 || random1 == random3) {

			random1 = (int) (Math.random() * 9) + 1;
		}

		while (random2 == random3) {

			random2 = (int) (Math.random() * 9) + 1;
		}
		
		System.out.print("첫번째 숫자를 입력해주세요:");
	    int num1 = Integer.parseInt(sc.nextLine());
		System.out.print("두번째 숫자를 입력해주세요:");
		int num2 = Integer.parseInt(sc.nextLine());
		System.out.print("세번째 숫자를 입력해주세요:");
		int num3 = Integer.parseInt(sc.nextLine());
		
		int strike=0;
		int ball=0;
		int out=0;	
		
		while(strike!=3){
			
		strike=0;
		ball=0;
		out=0;
		
		System.out.print("첫번째 숫자를 입력해주세요:");
		num1 = Integer.parseInt(sc.nextLine());
		System.out.print("두번째 숫자를 입력해주세요:");
	    num2 = Integer.parseInt(sc.nextLine());
		System.out.print("세번째 숫자를 입력해주세요:");
		num3 = Integer.parseInt(sc.nextLine());
				
		if(num1==random1 || num2==random2){
			strike++;
		}else if(num3==random3){
			strike++;
		}
		
		if(num1==random2 ||num1==random3){
			ball++;
		}else if(num2==random3){
			ball++;
		}
		
		if(num1!=random1 && num1 !=random2 && num1 != random3){
			out++;
		}else if(num2!=random1 && num2 !=random2 && num2 != random3){
			out++;
		}else if(num3!=random1 && num3 !=random2 && num3 != random3){
			out++;
		}
		
		System.out.println(strike+"Strike "+ball+"ball "+out+"out");
			
        
		}
		
		   		
	}
}

		
		
	


