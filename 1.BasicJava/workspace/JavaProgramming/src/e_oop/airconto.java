package e_oop;

public class airconto {

	boolean power;
	
	void power(){
		power = !power;
		System.out.println(power ? "전원이 켜졌습니다.":"전원이 꺼졌습니다.");
	}
	
	int temperature=24;
	final int MIN_TEMP =18;//final사용할때는 이름을 전부 대문자로
	final int MAX_TEMP =30;
	
	void tempUp(){
		if(power){
			if(temperature<MAX_TEMP){
				temperature++;
				
			}
			System.out.println("설정 온도: "+temperature+"도");
		}
	}
	void tempDown(){
		if(power){
			if(temperature>MIN_TEMP){
				temperature--;
				
			}
			System.out.println("설정 온도: "+temperature+"도");
		}
	}
	
	String[] windArr={"미풍","약풍","강풍","터보","송풍"};
	int windIndex=2;
	
	void wind(){
		if(power){
			windIndex++;
			if(windArr.length<=windIndex){
				windIndex=0;
			}
			System.out.println("바람 세기:"+windArr[windIndex]);
		}
	}
	
	public static void main(String[] args) {
		airconto aircon=new airconto();
		while(true){
			System.out.println("1.전원\t2.온도+\t3.온도-\t4.바람세기\t0.종료");
			int input = ScanUtil.nextInt();
			switch(input){
			case 1:
				aircon.power();
				break;
			case 2:
				aircon.tempUp();
				break;
			case 3:
				aircon.tempDown();
				break;
			case 4:
				aircon.wind();
				break;
			case 0:
			   aircon.power();
			   System.exit(0);
			 
			}
		}
	}
	
	
	
	
	
	
	
}
