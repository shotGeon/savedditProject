import java.util.Scanner;


public class LoveTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		LoveChoose lc = new LoveChoose();
		
		
		
		

		String eng = lc.check1();
		String eng2 =lc.check2();
		String eng3 =lc.check3();
		String eng4=lc.check4();
		
		
		System.out.println("나의 연애 스타일은?");
		
		System.out.print("나는 금사빠다(yes/no):");
		String check=sc.nextLine();
		if(check.equals("yes")){
			System.out.print(eng);
			String check2=sc.nextLine();
			if(check2.equals("yes")){ 
				System.out.println(eng3);
				String check4=sc.nextLine();
			}
		}
        
		
		if(check.equals("no")){
			System.out.print(eng2);
			String check3=sc.nextLine();
			if(check3.equals("yes")){
				System.out.print(eng4);
			}
		}
	
				
		
		
		
		
		
		

	}

}
