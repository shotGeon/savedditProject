package kr.or.ddit.basic;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class BaseBall {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		Set<Integer> ball = new HashSet<>();
		
		while(ball.size()<3) {
			int num=(int)(Math.random()*9+1);
			ball.add(num);
		}
		Iterator it =ball.iterator();
		System.out.print("볼: ");
		while(it.hasNext()) {
			System.out.print(it.next()+" ");
		}
		System.out.println();
		System.out.print("숫자입력(1~9):");
		int input = Integer.parseInt(s.nextLine());
		System.out.print("숫자입력(1~9):");
		int input2 = Integer.parseInt(s.nextLine());
		System.out.print("숫자입력(1~9):");
		int input3 = Integer.parseInt(s.nextLine());
		while(it.hasNext()) {
			
		}
		
		
	}
}
