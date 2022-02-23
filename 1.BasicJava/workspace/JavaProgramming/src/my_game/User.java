package my_game;
import java.util.Scanner;
public class User {
	String name;
	static int recov=0;
	static int ball=0;
	User(String name){
		this.name=name;	
	}
	
	static Pokemon pikachu= new Pokemon("피카츄",30,30,1);
	static Pokemon ggobuk= new Pokemon("꼬부기",40,40,1);
	static Pokemon pyri= new Pokemon("파이리",50,30,1);
	
	Store st = new Store();
	
	void showpokeinfo(int input){
		Scanner s = new Scanner(System.in);
		System.out.println("--------------포켓몬 정보-----------");
		if(input==1){
		    System.out.println("포켓몬: "+pikachu.name);
		    System.out.println("공격력: "+pikachu.att);
		    System.out.println("방어력: "+pikachu.def);
		    System.out.println("레벨: "+pikachu.level);
		}else if(input==2){
			System.out.println("포켓몬: "+ggobuk.name);
			System.out.println("공격력: "+ggobuk.att);
		    System.out.println("방어력: "+ggobuk.def);
		    System.out.println("레벨: "+ggobuk.level);
		}else if(input==3){
			System.out.println("포켓몬: "+pyri.name);
			System.out.println("공격력: "+pyri.att);
		    System.out.println("방어력: "+pyri.def);
		    System.out.println("레벨: "+pyri.level);
		}
		System.out.println("------------------------------");
		System.out.println("나가기(1)");
		int num = Integer.parseInt(s.nextLine());
		if(num!=0) {
			new Mygame().start(input);
		}
	}
		
	void showinfo(int input) {
		Scanner s = new Scanner(System.in);
		
		System.out.println("------------내정보------------");
		System.out.println("이름:"+name);	
		if(input==1) {
			System.out.println("보유포켓몬:"+pikachu.name);
		}else if(input==2){
			System.out.println("보유포켓몬:"+ggobuk.name);
		}else if(input==3){
			System.out.println("보유포켓몬:"+pyri.name);
		}

		System.out.println("회복약: "+recov+"개");
		System.out.println("몬스터볼: "+ball+"개");
		System.out.println("----------------------------");
		System.out.println();
		System.out.println("나가기(1)");
		int num = Integer.parseInt(s.nextLine());
		if(num!=0) {
			new Mygame().start(input);
		}
		
	}



}
