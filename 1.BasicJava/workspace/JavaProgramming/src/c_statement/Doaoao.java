package c_statement;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class Doaoao {
	public static void main(String[] args) {
		Scanner s= new Scanner(System.in);
		TreeSet<Object> ts= new TreeSet<>();
		int[] num2= new int[3];
		int strike=0;
		int ball=0;
		int out=0;
		while(ts.size()<3){
			int num=(int)(Math.random()*100)+1;
			ts.add(num);
			
		}
		System.out.println(ts);
		Iterator it=ts.iterator();
		while(it.hasNext()){
			for(int i=0; i<num2.length; i++){
				int num3=(int)it.next();
				num2[i]=num3;
			}
		}
		while(strike<3){
			System.out.println(Arrays.toString(num2));
			System.out.print("1숫자입력:");
			int input=Integer.parseInt(s.nextLine());
			System.out.print("2숫자입력:");
			int input2=Integer.parseInt(s.nextLine());
			System.out.print("3숫자입력:");
			int input3=Integer.parseInt(s.nextLine());
			int [] num4 = new int[3];
			num4[0]=input;
			num4[1]=input2;
			num4[2]=input3;
			
			for(int i=0; i<num2.length; i++){
				for(int j=0; j<num4.length; j++){
					if(i==j){
						if(num2[i]==num4[j]){
							strike++;
						}
					}else if(num2[i]==num4[j]){
						ball++;
					}else{
						out++;
					}
				}
			}
			System.out.println(strike+"스트라이크");
			System.out.println(ball+"볼");
			System.out.println(out+"아웃");
			strike=0;
			ball=0;
			out=0;
			
		}
		
	}




}

