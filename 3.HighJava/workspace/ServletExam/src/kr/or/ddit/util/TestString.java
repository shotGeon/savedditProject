package kr.or.ddit.util;

public class TestString {
	
	public static void main(String[] args) {
		/*String beforeDay="21-1월-2022";
		String[] arrStr = beforeDay.split("-");
		for(int i=0; i<arrStr.length; i++) {
			System.out.println(arrStr[i]);
		}
		String day=arrStr[0];
		String month = arrStr[1];
		String year=arrStr[2];
		
		System.out.println(day);
		System.out.println(month);
		System.out.println(year);*/
		
		double wholeDeath =Double.parseDouble("6653");
		double millionPrs = wholeDeath/100000;
		System.out.println("millionPrs:"+millionPrs);
		String millionPrsStr = String.format("%.2f", millionPrs);
		System.out.println("millionPrsStr:"+millionPrsStr);
		
		
		
	}
}
