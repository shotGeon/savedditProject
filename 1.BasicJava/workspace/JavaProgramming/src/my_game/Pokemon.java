package my_game;
import java.util.Scanner;
public class Pokemon {
		String name;
		int hp=100;
		int mp=100;
		int Maxhp=hp;
		int Maxmp=mp;
		int level=1;
		int att;
		int def;
		int exp;
		
		Pokemon(String name,int att, int def,int level){
			this.name=name;
			this.att=att;
			this.def=def;
			this.level=level;
		}
		void attack(int input,Daedok mon1,int i) {
			Scanner s = new Scanner(System.in);
			if(input==1) {
			System.out.println("1.기본공격  2.몸통박치기 3.백만볼트");
			int skill=Integer.parseInt(s.nextLine());
			switch(skill) {
			case 1:
				int damage = att+10-mon1.def;
				damage = damage <=0? 1:damage;
				mon1.hp = mon1.hp<damage ? 0:mon1.hp-damage;
				System.out.println("기본공격으로 "+mon1.name[i]+"에게"
						             +damage+"만큼 데미지를 주었습니다.");
				System.out.println(mon1.name[i]+"의 남은 HP: "+mon1.hp);
				System.out.println();
			 break;
			case 2:
				int damage2 = att+20-mon1.def;
				damage2 = damage2 <=0? 1:damage2;
				mon1.hp = mon1.hp<damage2 ? 0:mon1.hp-damage2;
				System.out.println("몸통박치기로 "+mon1.name[i]+"에게"
						             +damage2+"만큼 데미지를 주었습니다.");
				System.out.println(mon1.name[i]+"의 남은 HP: "+mon1.hp);
				System.out.println();
				break;
			case 3:
				int damage3 = att+50-mon1.def;
				damage3 = damage3 <=0? 1:damage3;
				mon1.hp = mon1.hp<damage3 ? 0:mon1.hp-damage3;
				System.out.println("백만볼트로 "+mon1.name[i]+"에게"
						             +damage3+"만큼 데미지를 주었습니다.");
				System.out.println(mon1.name[i]+"의 남은 HP: "+mon1.hp);
				System.out.println();
				break;
			}
			}
			if(input==2) {
			System.out.println("1.기본공격  2.몸통박치기 3.물대포");
			int skill=Integer.parseInt(s.nextLine());
			switch(skill) {
			case 1:
				int damage = att+20-mon1.def;
				damage = damage <=0? 1:damage;
				mon1.hp = mon1.hp<damage ? 0:mon1.hp-damage;
				System.out.println("기본공격으로 "+mon1.name[i]+"에게"
						             +damage+"만큼 데미지를 주었습니다.");
				System.out.println(mon1.name[i]+"의 남은 HP: "+mon1.hp);
				System.out.println();
			 break;
			case 2:
				int damage2 = att+30-mon1.def;
				damage2 = damage2 <=0? 1:damage2;
				mon1.hp = mon1.hp<damage2 ? 0:mon1.hp-damage2;
				System.out.println("몸통박치기로 "+mon1.name[i]+"에게"
						             +damage2+"만큼 데미지를 주었습니다.");
				System.out.println(mon1.name[i]+"의 남은 HP: "+mon1.hp);
				System.out.println();
				break;
			case 3:
				int damage3 = att+50-mon1.def;
				damage3 = damage3 <=0? 1:damage3;
				mon1.hp = mon1.hp<damage3 ? 0:mon1.hp-damage3;
				System.out.println("물대포로 "+mon1.name[i]+"에게"
						             +damage3+"만큼 데미지를 주었습니다.");
				System.out.println(mon1.name[i]+"의 남은 HP: "+mon1.hp);
				System.out.println();
				break;
			}
			}
			if(input==3) {
			System.out.println("1.기본공격  2.몸통박치기 3.화염방사");
			int skill=Integer.parseInt(s.nextLine());
			switch(skill) {
			case 1:
				int damage = att+30-mon1.def;
				damage = damage <=0? 1:damage;
				mon1.hp = mon1.hp<damage ? 0:mon1.hp-damage;
				System.out.println("기본공격으로 "+mon1.name[i]+"에게"
						             +damage+"만큼 데미지를 주었습니다.");
				System.out.println(mon1.name[i]+"의 남은 HP: "+mon1.hp);
				System.out.println();
			 break;
			case 2:
				int damage2 = att+40-mon1.def;
				damage2 = damage2 <=0? 1:damage2;
				mon1.hp = mon1.hp<damage2 ? 0:mon1.hp-damage2;
				System.out.println("몸통박치기로 "+mon1.name[i]+"에게"
						             +damage2+"만큼 데미지를 주었습니다.");
				System.out.println(mon1.name[i]+"의 남은 HP: "+mon1.hp);
				System.out.println();
				break;
			case 3:
				int damage3 = att+70-mon1.def;
				damage3 = damage3 <=0? 1:damage3;
				mon1.hp = mon1.hp<damage3 ? 0:mon1.hp-damage3;
				System.out.println("화염방사로 "+mon1.name[i]+"에게"
						             +damage3+"만큼 데미지를 주었습니다.");
				System.out.println(mon1.name[i]+"의 남은 HP: "+mon1.hp);
				System.out.println();
				break;
			}
			}
					
		}
		void levelUp(int input) {
			level++;
			Maxhp+=10;
			Maxmp+=5;
			att+=5;
			def+=3;
			hp=Maxhp;
			mp=Maxmp;
			User.pikachu.level++;
			User.ggobuk.level++;
			User.pyri.level++;
			User.pikachu.att++;
			User.ggobuk.att++;
			User.pyri.att++;
			User.pikachu.def++;
			User.ggobuk.def++;
			User.pyri.def++;
			System.out.println("Level Up!!");
			System.out.println("현재 레벨: "+level);
			if(input==1&&level==5) {	
				User.pikachu.name="라이츄";
				System.out.println("라이츄로 진화하였습니다.");
			}
			if(input==2&&level==5) {
				User.ggobuk.name="어니부기";
				System.out.println("어니부기로 진화하였습니다.");
				
			}else if(input==2&&level==10) {
				User.ggobuk.name="거북왕";
				System.out.println("거북왕으로 진화하였습니다.");
			}
			if(input==3&&level==5) {
				User.pyri.name="리자드";
				System.out.println("리자드로 진화하였습니다.");
			}else if(input==3&&level==10) {
				User.pyri.name="리자몽";
				System.out.println("리자몽으로 진화하였습니다.");
			}
			
			

		}
		void getexp(int exp,int input) {
			System.out.println(exp+"의 경험치를 획득하였습니다.");
			this.exp+=exp;
			while(this.exp>=100) {
				levelUp(input);
				this.exp-=100;
			}
		}
		void attack(int input,Mega mon1,int i) {
			Scanner s = new Scanner(System.in);
			if(input==1) {
			System.out.println("1.기본공격  2.몸통박치기 3.백만볼트");
			int skill=Integer.parseInt(s.nextLine());
			switch(skill) {
			case 1:
				int damage = att+10-mon1.def;
				damage = damage <=0? 1:damage;
				mon1.hp = mon1.hp<damage ? 0:mon1.hp-damage;
				System.out.println("기본공격으로 "+mon1.name[i]+"에게"
						             +damage+"만큼 데미지를 주었습니다.");
				System.out.println(mon1.name[i]+"의 남은 HP: "+mon1.hp);
				System.out.println();
			 break;
			case 2:
				int damage2 = att+20-mon1.def;
				damage2 = damage2 <=0? 1:damage2;
				mon1.hp = mon1.hp<damage2 ? 0:mon1.hp-damage2;
				System.out.println("몸통박치기로 "+mon1.name[i]+"에게"
						             +damage2+"만큼 데미지를 주었습니다.");
				System.out.println(mon1.name[i]+"의 남은 HP: "+mon1.hp);
				System.out.println();
				break;
			case 3:
				int damage3 = att+50-mon1.def;
				damage3 = damage3 <=0? 1:damage3;
				mon1.hp = mon1.hp<damage3? 0:mon1.hp-damage3;
				System.out.println("백만볼트로 "+mon1.name[i]+"에게"
						             +damage3+"만큼 데미지를 주었습니다.");
				System.out.println(mon1.name[i]+"의 남은 HP: "+mon1.hp);
				System.out.println();
				break;
			}
			}
			if(input==2) {
			System.out.println("1.기본공격  2.몸통박치기 3.물대포");
			int skill=Integer.parseInt(s.nextLine());
			switch(skill) {
			case 1:
				int damage = att+20-mon1.def;
				damage = damage <=0? 1:damage;
				mon1.hp = mon1.hp<damage ? 0:mon1.hp-damage;
				System.out.println("기본공격으로 "+mon1.name[i]+"에게"
						             +damage+"만큼 데미지를 주었습니다.");
				System.out.println(mon1.name[i]+"의 남은 HP: "+mon1.hp);
				System.out.println();
			 break;
			case 2:
				int damage2 = att+30-mon1.def;
				damage2 = damage2 <=0? 1:damage2;
				mon1.hp = mon1.hp<damage2 ? 0:mon1.hp-damage2;
				System.out.println("몸통박치기로 "+mon1.name[i]+"에게"
						             +damage2+"만큼 데미지를 주었습니다.");
				System.out.println(mon1.name[i]+"의 남은 HP: "+mon1.hp);
				System.out.println();
				break;
			case 3:
				int damage3 = att+50-mon1.def;
				damage3 = damage3 <=0? 1:damage3;
				mon1.hp = mon1.hp<damage3 ? 0:mon1.hp-damage3;
				System.out.println("물대포로 "+mon1.name[i]+"에게"
						             +damage3+"만큼 데미지를 주었습니다.");
				System.out.println(mon1.name[i]+"의 남은 HP: "+mon1.hp);
				System.out.println();
				break;
			}
			}
			if(input==3) {
			System.out.println("1.기본공격  2.몸통박치기 3.화염방사");
			int skill=Integer.parseInt(s.nextLine());
			switch(skill) {
			case 1:
				int damage = att+30-mon1.def;
				damage = damage <=0? 1:damage;
				mon1.hp = mon1.hp<damage ? 0:mon1.hp-damage;
				System.out.println("할퀴기로 "+mon1.name[i]+"에게"
						             +damage+"만큼 데미지를 주었습니다.");
				System.out.println(mon1.name[i]+"의 남은 HP: "+mon1.hp);
				System.out.println();
			 break;
			case 2:
				int damage2 = att+40-mon1.def;
				damage2 = damage2 <=0? 1:damage2;
				mon1.hp = mon1.hp<damage2 ? 0:mon1.hp-damage2;
				System.out.println("몸통박치기로 "+mon1.name[i]+"에게"
						             +damage2+"만큼 데미지를 주었습니다.");
				System.out.println(mon1.name[i]+"의 남은 HP: "+mon1.hp);
				System.out.println();
				break;
			case 3:
				int damage3 = att+70-mon1.def;
				damage3 = damage3 <=0? 1:damage3;
				mon1.hp = mon1.hp<damage3 ? 0:mon1.hp-damage3;
				System.out.println("화염방사로 "+mon1.name[i]+"에게"
						             +damage3+"만큼 데미지를 주었습니다.");
				System.out.println(mon1.name[i]+"의 남은 HP: "+mon1.hp);
				System.out.println();
				break;
			}
			}
					
		}
		
		
		
		void attack(int input,Macdo mon1,int i) {
			Scanner s = new Scanner(System.in);
			if(input==1) {
			System.out.println("1.기본공격  2.몸통박치기 3.백만볼트");
			int skill=Integer.parseInt(s.nextLine());
			switch(skill) {
			case 1:
				int damage = att+10-mon1.def;
				damage = damage <=0? 1:damage;
				mon1.hp = mon1.hp<damage ? 0:mon1.hp-damage;
				System.out.println("할퀴기로 "+mon1.name[i]+"에게"
						             +damage+"만큼 데미지를 주었습니다.");
				System.out.println(mon1.name[i]+"의 남은 HP: "+mon1.hp);
				System.out.println();
			 break;
			case 2:
				int damage2 = att+20-mon1.def;
				damage2 = damage2 <=0? 1:damage2;
				mon1.hp = mon1.hp<damage2 ? 0:mon1.hp-damage2;
				System.out.println("몸통박치기로 "+mon1.name[i]+"에게"
						             +damage2+"만큼 데미지를 주었습니다.");
				System.out.println(mon1.name[i]+"의 남은 HP: "+mon1.hp);
				System.out.println();
				break;
			case 3:
				int damage3 = att+50-mon1.def;
				damage3 = damage3 <=0? 1:damage3;
				mon1.hp = mon1.hp<damage3 ? 0:mon1.hp-damage3;
				System.out.println("백만볼트로 "+mon1.name[i]+"에게"
						             +damage3+"만큼 데미지를 주었습니다.");
				System.out.println(mon1.name[i]+"의 남은 HP: "+mon1.hp);
				System.out.println();
				break;
			}
			}
			if(input==2) {
			System.out.println("1.기본공격  2.몸통박치기 3.물대포");
			int skill=Integer.parseInt(s.nextLine());
			switch(skill) {
			case 1:
				int damage = att+20-mon1.def;
				damage = damage <=0? 1:damage;
				mon1.hp = mon1.hp<damage ? 0:mon1.hp-damage;
				System.out.println("기본공격으로 "+mon1.name[i]+"에게"
						             +damage+"만큼 데미지를 주었습니다.");
				System.out.println(mon1.name[i]+"의 남은 HP: "+mon1.hp);
				System.out.println();
			 break;
			case 2:
				int damage2 = att+30-mon1.def;
				damage2 = damage2 <=0? 1:damage2;
				mon1.hp = mon1.hp<damage2 ? 0:mon1.hp-damage2;
				System.out.println("몸통박치기로 "+mon1.name[i]+"에게"
						             +damage2+"만큼 데미지를 주었습니다.");
				System.out.println(mon1.name[i]+"의 남은 HP: "+mon1.hp);
				System.out.println();
				break;
			case 3:
				int damage3 = att+50-mon1.def;
				damage3 = damage3 <=0? 1:damage3;
				mon1.hp = mon1.hp<damage3 ? 0:mon1.hp-damage3;
				System.out.println("물대포로 "+mon1.name[i]+"에게"
						             +damage3+"만큼 데미지를 주었습니다.");
				System.out.println(mon1.name[i]+"의 남은 HP: "+mon1.hp);
				System.out.println();
				break;
			}
			}
			if(input==3) {
			System.out.println("1.기본공격  2.몸통박치기 3.화염방사");
			int skill=Integer.parseInt(s.nextLine());
			switch(skill) {
			case 1:
				int damage = att+30-mon1.def;
				damage = damage <=0? 1:damage;
				mon1.hp = mon1.hp<damage ? 0:mon1.hp-damage;
				System.out.println("기본공격으로 "+mon1.name[i]+"에게"
						             +damage+"만큼 데미지를 주었습니다.");
				System.out.println(mon1.name[i]+"의 남은 HP: "+mon1.hp);
				System.out.println();
			 break;
			case 2:
				int damage2 = att+40-mon1.def;
				damage2 = damage2 <=0? 1:damage2;
				mon1.hp = mon1.hp<damage2 ? 0:mon1.hp-damage2;
				System.out.println("몸통박치기로 "+mon1.name[i]+"에게"
						             +damage2+"만큼 데미지를 주었습니다.");
				System.out.println(mon1.name[i]+"의 남은 HP: "+mon1.hp);
				System.out.println();
				break;
			case 3:
				int damage3 = att+70-mon1.def;
				damage3 = damage3 <=0? 1:damage3;
				mon1.hp = mon1.hp<damage3 ? 0:mon1.hp-damage3;
				System.out.println("화염방사로 "+mon1.name[i]+"에게"
						             +damage3+"만큼 데미지를 주었습니다.");
				System.out.println(mon1.name[i]+"의 남은 HP: "+mon1.hp);
				System.out.println();
				break;
			}
			}
					
		}
				


}
