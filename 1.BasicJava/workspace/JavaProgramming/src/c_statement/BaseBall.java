package c_statement;

import java.util.Scanner;

public class BaseBall {

	public static void main(String[] args) {
		
		
		
		Scanner sc = new Scanner(System.in);
		int ball1=(int)(Math.random()*9)+1;
		int ball2=(int)(Math.random()*9)+1;
		int ball3=(int)(Math.random()*9)+1;
		
		
		while(ball1 == ball2|| ball1 == ball3){
			
			ball1=(int)(Math.random()*9)+1;
		}
		
        while(ball2 == ball3){
			
			ball2=(int)(Math.random()*9)+1;
		}
        
        int input1;
		int input2;
		int input3;
		
		int count1; //strike 
		int count2; //ball 
		int count3; //out
			 
		do{
			
			System.out.println(ball1+", "+ball2+", "+ball3); 
			
			System.out.print("첫번째 숫자를 입력해주세요:");
	        input1 =Integer.parseInt(sc.nextLine());
	        System.out.print("두번째 숫자를 입력해주세요:");
	        input2 =Integer.parseInt(sc.nextLine());
	        System.out.print("세번째 숫자를 입력해주세요:");
	        input3 =Integer.parseInt(sc.nextLine());
	        
	        count1=0;
	        count2=0;
	        count3=0;
	        
	      if(input1==ball1){
	    	  count1++;
	      }else if(input1==ball2 || input1==ball3){
	    	  count2++;
	      }else if(input1!=ball2 || input1!=ball3){
	    	  count3++;
	      }
	      
	      if(input2==ball2){
	    	  count1++;
	      }else if(input2==ball1 || input2==ball3){
	    	  count2++;
	      }else if(input2!=ball1 || input2!=ball3){
	    	  count3++;
	      }
	      
	      if(input3==ball3){
	    	  count1++;
	      }else if(input3==ball1 || input3==ball2){
	    	  count2++;
	      }else if(input3!=ball1 || input3!=ball2){
	    	  count3++;
	      }
	       	       
	        System.out.println(count1+"Strike "+count2+"Ball "+count3+"Out");
	        
		}while(count1!=3);
            
		    System.out.println("게임종료!!!");
	}

}
