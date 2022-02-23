package kr.or.ddit.basic;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class Rotto {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int price=0;
		int sido=0;
		System.out.println("--------로또------");
		System.out.println("얼마 구매하시겠습니까?");
		System.out.print(">");
		int check = Integer.parseInt(s.nextLine());
		price=check;
		sido=price/1000;
		//System.out.println(sido);
		new Rotto().jule(sido);	
	}
	
	void jule(int sido) {
		int[] rotto = new int[7];
		int[][] dang = new int[sido][6];
		
		TreeSet<Integer> ts = new TreeSet<Integer>();
		
		while(ts.size()<7) {
			int num=(int)(Math.random()*45+1);
			ts.add(num);
		}
		//System.out.println("ts: "+ts);
		Iterator it=ts.iterator();
		while(it.hasNext()) {
			for(int i=0; i<rotto.length; i++) {
				rotto[i]=(int) it.next();
			}
		}
		System.out.println("rotto: "+Arrays.toString(rotto));
		
		for(int i=0; i<sido; i++) {
			for(int j=0; j<dang[i].length; j++) {
				dang[i][j]=(int)(Math.random()*45+1);
			}
			for(int k=0; k<dang[i].length; k++) {
				for(int l=0; l<k; l++) {
					if(dang[i][k]==dang[i][l]) {
						i--;
						break;
					}
				}
			}
		}
		for(int i=0; i<dang.length; i++) {
		  System.out.println(i+1+"번줄"+Arrays.toString(dang[i]));
		}
		
		dang(rotto,dang,sido);
		
	}

	private void dang(int[] rotto, int[][] dang,int sido) {
		int[] count=new int[sido];
		int[] check=new int[sido];
		for(int i=0; i<rotto.length; i++) {
			for(int k=0; k<dang.length; k++) {
				for(int j=0; j<dang[k].length; j++) {
					if(rotto[j]==dang[k][j]) {
						count[i]+=1;
						if(rotto[6]==dang[k][j]) {
							check[i]+=1;
						}
					}
				}
				
			}
		}
		for(int i=0; i<count.length; i++) {
			if(count[i]<3) {
				System.out.println("꽝!!");
			}else if(count[i]==3) {
				System.out.println("5000원 당첨!!");
			}else if(count[i]==4) {
				System.out.println("5만원 당첨!!");
			}else if(count[i]==5) {
				System.out.println("100만원 당첨!!");
			}else if(count[i]==5&&check[i]==1) {
				System.out.println("2000만원 당첨!!");
			}else if(count[i]==6) {
				System.out.println("20억당첨!!");
			}
			
		}
		
	}


}
