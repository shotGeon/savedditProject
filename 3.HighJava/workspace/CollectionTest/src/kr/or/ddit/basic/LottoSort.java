package kr.or.ddit.basic;

import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class LottoSort {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		while(true) {
		System.out.println("=================");
		System.out.println("Lotto프로그램");
		System.out.println("------------------");
		System.out.println("1.Lotto 구입");
		System.out.println("2.프로그램 종료");
		System.out.println("======================");
		System.out.print("메뉴선택:");
		int check = Integer.parseInt(s.nextLine());
		switch (check) {
		case 1:
			System.out.println("(1000원에 로또번호 하나입니다.)");
			System.out.print("금액입력:");
			int price = Integer.parseInt(s.nextLine());
			System.out.println();
			int jule=price/1000;
			int name=price%1000;
			System.out.println("행운의 로또번호는 아래와 같습니다.");
			rotto(jule);
			System.out.println();
			System.out.println("받은 금액은 "+price+"이고 거스름돈은 "+name+"원입니다.");
			System.out.println();
			break;

		case 2:
			System.out.println();
			System.out.println("감사합니다.");
			System.exit(0);
			break;
		}
		}
		
	}

	private static void rotto(int jule) {
		for(int i=0; i<jule; i++) {
			String tmp="";
			TreeSet<Integer> ts = new TreeSet<Integer>();
			while(ts.size()<6) {
				int num=(int)(Math.random()*45)+1;
				ts.add(num);
			}
			Iterator it= ts.iterator();
			while(it.hasNext()) {
				tmp+=String.valueOf(it.next())+",";
			}
			System.out.println("로또번호"+(i+1)
					            +" : "+tmp.substring(0, tmp.length()-1));			
		}
	}
}
