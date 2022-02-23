package my_game;
import java.util.Scanner;
public class Mygame {
	static User jiwoo;
	static Pokemon pikachu;
	static Pokemon ggobuk;
	static Pokemon pyri;
	
	Mygame(){
		pikachu= new Pokemon("피카츄",30,30,1);
		ggobuk = new Pokemon("꼬부기",40,30,1);
		pyri = new Pokemon("파이리",50,50,1);	
	}
	            
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int input=0;
		System.out.print("사용할 이름을 입력해주세요:");
		String name = s.nextLine();
		jiwoo = new User(name);
		System.out.println("포켓몬을 선택해 주세요");
		System.out.println("1.피카츄  2.꼬부기  3.파이리");
		input = Integer.parseInt(s.nextLine());
		new Mygame().start(input);

	}
	void start(int input) {
		Scanner s = new Scanner(System.in);
		int input2=0;
	    int input3=0;	
		System.out.println("1.내정보   2.포켓몬 정보   3.던전  4.상점  5.종료");
		input2 = Integer.parseInt(s.nextLine());
		geon :while (true) {
			switch(input2) {
			case 1:
				if(input==1) {
					jiwoo.showinfo(input);
				}else if(input==2){
					jiwoo.showinfo(input);
				}else if(input==3){
					jiwoo.showinfo(input);
				}
				break;
			case 2:
				if(input==1) {
					jiwoo.showpokeinfo(input);
				}else if(input==2){
					jiwoo.showpokeinfo(input);
				}else if(input==3){
					jiwoo.showpokeinfo(input);
				}
				break;
				
			case 3:
				System.out.println("던전을 선택해 주세요");
				System.out.println("1.대덕인재개발원  2.메가커피  3.맥도날드");
				input3=Integer.parseInt(s.nextLine());
				if(input3==1) {
					new Daedok().stage(input);
					
				}
				if(input3==2) {
					new Mega().stage(input);
				}
				if(input3==3) {
					new Macdo().stage(input);
				}
				break;
			case 4:
				new Store().showstore(input);
				
			case 5:
				System.out.println("게임을 종료하겠습니다.");
				System.exit(0);
				break geon;
				
			}
		}
	}

}
