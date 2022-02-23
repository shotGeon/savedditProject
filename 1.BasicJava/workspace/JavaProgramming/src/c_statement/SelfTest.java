package c_statement;

import java.util.Scanner;

public class SelfTest {

	public static void main(String[] args) {
		
		Scanner scr = new Scanner(System.in);
		
		int check = 0;
		
		System.out.println("'탄수화물 중독' 자가진단하기");
		
		System.out.println("1.아침을 배불리 먹은 후 점심시간 전에 배가 고프다.");
		System.out.print("그렇다(1) 아니다(0):");
		int chec1 = Integer.parseInt(scr.nextLine());
		if (chec1==1) check+=1;//if문 블럭안에 문장이 한 문장이라면 블럭을 생략할 수 있다.		
		
		
		System.out.println("2.밥, 빵, 과자 등의 음식을 먹기 시작하면 끝이 없다.");
		System.out.print("그렇다(1) 아니다(0):");
		int chec2 = Integer.parseInt(scr.nextLine());
		if (chec2==1){
			check+=1;			
		}
		System.out.println("3.음식을 금방 먹은 후에도 만족스럽지 못하고 더 먹는다.");
		System.out.print("그렇다(1) 아니다(0):");
		int chec3 = Integer.parseInt(scr.nextLine());
		if (chec3==1){
			check+=1;			
		}
		System.out.println("4.정말 배가 고프지 않더라도 먹을 대가 있다.");
		System.out.print("그렇다(1) 아니다(0):");
		int chec4 = Integer.parseInt(scr.nextLine());
		if (chec4==1){
			check+=1;			
		}
		System.out.println("5.저녁을 먹고 간식을 먹지 않으면 잠이 오지 않는다.");
		System.out.print("그렇다(1) 아니다(0):");
		int chec5 = Integer.parseInt(scr.nextLine());
		if (chec5==1){
			check+=1;			
		}
		System.out.println("6.스트레스를 받으면 자꾸 먹고 싶어진다.");
		System.out.print("그렇다(1) 아니다(0):");
		int chec6 = Integer.parseInt(scr.nextLine());
		if (chec6==1){
			check+=1;			
		}
		System.out.println("7.책상이나 식탁 위에 항상 과자, 초콜릿 등이 놓여있다.");
		System.out.print("그렇다(1) 아니다(0):");
		int chec7 = Integer.parseInt(scr.nextLine());
		if (chec7==1){
			check+=1;			
		}
		System.out.println("8.오후 5시가 되면 피곤함과 배고픔을 느끼고 일이 손에 안 잡힌다.");
		System.out.print("그렇다(1) 아니다(0):");
		int chec8 = Integer.parseInt(scr.nextLine());
		if (chec8==1){
			check+=1;			
		}
		System.out.println("9.과자, 초콜릿 등의 단 음식은 상상만 해도 먹고 싶어진다.");
		System.out.print("그렇다(1) 아니다(0):");
		int chec9 = Integer.parseInt(scr.nextLine());
		if (chec9==1){
			check+=1;			
		}
		System.out.println("10.다이어트를 위해 식이조절을 하는데 3일도 못 간다.");
		System.out.print("그렇다(1) 아니다(0):");
		int chec10 = Integer.parseInt(scr.nextLine());
		if (chec10==1){
			check+=1;			
		}
			
		if(check==3){
			System.out.println("\n"+check+"개 \n주의단계:위험한 수준은 아니지만 관리가 필요함");
		}
		else if(check>=4&&check<=6){
			System.out.println("\n"+check+"개 \n위험단계:탄수화물 섭취를 줄이기 위한 식습관 개선이 필요함");
			
		}
		else if(check>=7){
			System.out.println("\n"+check+"개 \n중독단계:전문의 상담이 필요함");
		}else{
			System.out.println("\n"+check+"개 \n이상없음");
		}
	}

}
