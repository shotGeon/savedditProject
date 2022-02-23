package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class HorseRace {
	static int realrank =1;
	static String[] hrname = new String[10];
	static int[] rank = new int[10];
	
	public static void main(String[] args) {
		Horse[] hr = new Horse[] {
			new Horse("1번말",1),	
			new Horse("2번말",1),	
			new Horse("3번말",1),	
			new Horse("4번말",1),	
			new Horse("5번말",1),	
			new Horse("6번말",1),	
			new Horse("7번말",1),	
			new Horse("8번말",1),	
			new Horse("9번말",1),
			new Horse("10번말",1),
		};
		
		for(Horse hs:hr) {
			hs.start();
		}
		for(Horse hs:hr) {
			try {
				hs.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	//System.out.println(Arrays.toString(rank));
	//System.out.println(Arrays.toString(hrname));
	
	List<Horse> lh =new ArrayList<Horse>();
	
	for(int i=0; i<hrname.length; i++) {
		lh.add(new Horse(hrname[i],rank[i]));
	}
	Collections.sort(lh);
	System.out.println("==========경기종료=========");
	System.out.println("===========순위==========");
	for(int i=0; i<lh.size(); i++) {
		System.out.println(lh.get(i).getRank()+"등: "+lh.get(i).getName2());
	}

		
	}
	
}


class Horse extends Thread implements Comparable<Horse> {
	public String name;
	public int rank;
	
	public  int getRank() {
		return rank;
	}
	public String getName2() {
		return name;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public Horse(String name, int rank) {
		this.name=name;
		this.rank=rank;
	}
	
	
	@Override
	public void run() {
		int i=0;
		String str ="";
		String str2="";
		for(i=0; i<50; i++) {
			if(i!=0) {
				str+="-";
			}
			try {
				Thread.sleep((int)(Math.random()*301+200));
				for(int j=0; j<50-i-1; j++) {
					str2+="-";
				}
				System.out.println(name+":"+str+">"+str2);
				str2="";
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	
		}
		
		System.out.println(name+"완주");
		System.out.println("******************");
		for(int k=0; k<HorseRace.rank.length; k++) {
			if(HorseRace.rank[k]==0) {
				HorseRace.rank[k]=HorseRace.realrank;
				HorseRace.realrank++;
				break;
			}
		}
		for(int m=0; m<HorseRace.hrname.length; m++) {
			if(HorseRace.hrname[m]==null) {
				HorseRace.hrname[m]=name;
				break;
			}
		}
		
	}

	@Override
	public int compareTo(Horse lh) {
		return ((Integer)getRank()).compareTo(lh.getRank());
	}

	
}
	


































	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


