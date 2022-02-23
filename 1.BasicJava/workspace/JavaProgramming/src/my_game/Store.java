package my_game;

import java.util.Scanner;

public class Store {
	Scanner s = new Scanner(System.in);
	User us;
	void showstore(int input){
		System.out.println("1.회복약   2.몬스터볼");
		System.out.print("구매하실 상품을 선택해주세요:");
		int choice = Integer.parseInt(s.nextLine());
		if(choice==1){
		System.out.print("몇개 구매하시겠습니까?");
		int num = Integer.parseInt(s.nextLine());
		    us.recov=num;
			System.out.println("보유 회복약: "+us.recov+"개");
			System.out.println("나가기(1)");
			int num2=Integer.parseInt(s.nextLine());
			if(num2==1){
				new Mygame().start(input); 
			}
		}
		if(choice==2){
			System.out.print("몇개 구매하시겠습니까?");
			int num3 = Integer.parseInt(s.nextLine());
			    us.ball=num3;
				System.out.println("보유 몬스터볼: "+us.ball+"개");
				System.out.println("나가기(1)");
				int num4=Integer.parseInt(s.nextLine());
				if(num4==1){
					new Mygame().start(input); 
				}
		}
	}
	
	void recovery(int input){
		Pokemon pikachu= new Pokemon("피카츄",30,30,1);
		Pokemon ggobuk= new Pokemon("꼬부기",40,40,1);
		Pokemon pyri = new Pokemon("파이리",50,30,1);
		if(input==1){
			System.out.println("회복약을 사용하시겠습니까?(y/n)");
			String eng =s.nextLine();
			if(eng.equals("y")){
		    us.recov--;
			System.out.println("피카츄에 체력이 올라갑니다.");
			pikachu.hp=pikachu.Maxhp;
			System.out.println(pikachu.name+"의 남은 HP"+pikachu.hp);
			System.out.println("남은 회복약: "+us.recov+"개");
			}	
		}else if(input==2){
			System.out.println("회복약을 사용하시겠습니까?(y/n)");
			String eng =s.nextLine();
			if(eng.equals("y")){
			us.recov--;
			System.out.println("꼬부기에 체력이 올라갑니다.");
			ggobuk.hp=ggobuk.Maxhp;
			System.out.println(ggobuk.name+"의 남은 HP"+ggobuk.hp);
			System.out.println("남은 회복약: "+us.recov+"개");
			}
		}else{
			System.out.println("회복약을 사용하시겠습니까?(y/n)");
			String eng =s.nextLine();
			if(eng.equals("y")){
		    us.recov--;
			System.out.println("파이리에 체력이 올라갑니다.");
			pyri.hp=pyri.Maxhp;
			System.out.println(pyri.name+"의 남은 HP"+pyri.hp);
			System.out.println("남은 회복약: "+us.recov+"개");
			
		}
		
	}
	}
	
	
	
	

}
