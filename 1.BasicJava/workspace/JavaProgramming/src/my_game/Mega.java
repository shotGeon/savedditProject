package my_game;
import java.util.Scanner;
public class Mega {
	Scanner s = new Scanner(System.in);
	Pokemon pikachu= new Pokemon("피카츄",30,30,1);
	Pokemon ggobuk= new Pokemon("꼬부기",40,30,1);
	Pokemon pyri = new Pokemon("파이리",50,50,1);
	

	String[] name={"아메리카노","아이스라떼","고무마라떼","녹차라떼"};
	int att=20;
	int def=20;
	int hp=70;
	int mp=70;
	

	void stage(int input) {
		int i;
		i=(int)(Math.random()*4);
		Mega mon1= new Mega();
		mon1.name[i]=name[i];
		System.out.println("메가커피에 입장하셨습니다.");
		System.out.println(mon1.name[i]+"가 나타났습니다.");
	battle : while(true) {
		System.out.println("1.전투  2.도망");
		int eng = Integer.parseInt(s.nextLine());
		if(eng==1&&input==1) {
			pikachu.attack(input,mon1,i);
			if(mon1.hp>0){
			mon1.attack(input,mon1,i);
			}
			if(mon1.hp<=0) {
				System.out.println(mon1.name[i]+"을 처치하였습니다.");
				pikachu.getexp(150,input);
				System.out.println();
				System.out.println("계속사냥하시겠습니까?(y/n)");
				String conti = s.nextLine();
				if(conti.equals("y")) {
					stage(input);
				}else {
				new Mygame().start(input);
				break ;
				}
			}
		}
		if(eng==1&&input==2) {
			ggobuk.attack(input,mon1,i);
			if(mon1.hp>0){
			mon1.attack(input,mon1,i);
			}
			if(mon1.hp<=0) {
				System.out.println(mon1.name[i]+"을 처치하였습니다.");
				ggobuk.getexp(150,input);
				System.out.println();
				System.out.println("계속사냥하시겠습니까?(y/n)");
				String conti = s.nextLine();
				if(conti.equals("y")) {
					stage(input);
				}else {
				new Mygame().start(input);
				break ;
				}
			}
		}
		if(eng==1&&input==3) {
			pyri.attack(input,mon1,i);
			if(mon1.hp>0){
			mon1.attack(input,mon1,i);
			}
			if(mon1.hp<=0) {
				System.out.println(mon1.name[i]+"을 처치하였습니다.");
				pyri.getexp(150,input);
				System.out.println();
				System.out.println("계속사냥하시겠습니까?(y/n)");
				String conti = s.nextLine();
				if(conti.equals("y")) {
					stage(input);
				}else {
				new Mygame().start(input);
				break ;
				}
			}
		}
		if(eng==2) {
			new Mygame().start(input);
			break battle;
		}
	}
		
		
	}
	
	void attack(int input, Mega mon1,int i) {
		if(input==1) {
		int damage = att-pikachu.def;
		damage = damage <=0? 1:damage;
		pikachu.hp = pikachu.hp<damage ? 0:pikachu.hp-damage;
		System.out.println(mon1.name[i]+"가"+pikachu.name+"에게 공격합니다");
	    System.out.println(pikachu.name+"의 남은 HP: "+pikachu.hp);
	    if(pikachu.hp<70){
	    	new Store().recovery(input);
	    }
		}
		if(input==2) {
			int damage = att-ggobuk.def;
			damage = damage <=0? 1:damage;
			ggobuk.hp = ggobuk.hp<damage ? 0:ggobuk.hp-damage;
			System.out.println(mon1.name[i]+"가"+ggobuk.name+"에게 공격합니다");
		    System.out.println(ggobuk.name+"의 남은 HP: "+ggobuk.hp);
		    if(ggobuk.hp<70){
		    	new Store().recovery(input);
		    }
		}
		if(input==3) {
			int damage = att-pyri.def;
			damage = damage <=0? 1:damage;
			pyri.hp = pyri.hp<damage ? 0:pyri.hp-damage;
			System.out.println(mon1.name[i]+"가"+pyri.name+"에게 공격합니다");
		    System.out.println(pyri.name+"의 남은 HP: "+pyri.hp);
		    if(pyri.hp<70){
		    	new Store().recovery(input);
		    }
		}
	}

}
