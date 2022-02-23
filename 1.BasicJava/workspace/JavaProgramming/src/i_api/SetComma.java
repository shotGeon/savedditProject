package i_api;

import e_oop.ScanUtil;

public class SetComma {

	public static void main(String[] args) {
		//숫자를 입력받아 입력받은 숫자에 3자리 마다 콤마(,)를 붙여 출력해주세요.
		//1,234,567
		 //String num2=null;
		System.out.print("숫자를 입력해주세요:");
		String num=ScanUtil.nextLine();
		
		String rev ="";
		int count=0;
		for(int i=num.length()-1;0<=i; i--){
			rev=num.charAt(i)+rev;
			count++;
			System.out.println(rev);
			if(count%3==0&&count!=num.length()){
				rev=","+rev;		
			}
		}
		System.out.println(rev);
		
				
		
		
		
	}

}
