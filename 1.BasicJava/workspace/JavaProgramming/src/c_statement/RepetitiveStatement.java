package c_statement;


		import java.util.Scanner;

		public class RepetitiveStatement {
			

			
			public static void main(String[] args) {
				/*
				 * 반복문
				 * :for 문
				 * :while 문
				 * :do while 문
				 * 
				 * for 문
				 * -for(초기화; 조건식; 증감식){}
				 * -포함하고 있는 문장들을 정해진 횟수만큼 반복하는 문장
				 */
			
				for(int i=1; i<=10; i++){
					//초기화: 조건식과 증감식에 사용할 변수 초기화
					//조건식: 연산결과가 true이면 블럭안의 내용을 수행
					//증감식: 변수를 증가/감소시켜 반복문을 제어
					System.out.println(i+ "번째 반복");
				}
				
				int sum =0;//1부터 10까지의 합계를 저장
				for(int i=1; i<=100; i++){
					sum+=i;	
				}
				System.out.println(sum);
				
				sum =0;
				for(int i=100; i>0; i--){
					sum+=i;	
				}
				System.out.println(sum);
				
				//1부터 100까지 짝수의 합을 출력해주세요
				
				sum=0;
				for(int i=0; i<=100; i+=2){
					sum+=i;
				}
				System.out.println(sum);
				sum=0;
				for(int i=1; i<=100; i++){
					if(i%2==0){
						sum+=i;
					}
				}
				System.out.println(sum);
				
				//1부터 100까지 홀수의 합
				//ball%100*100/10
				//  ball%100*100%10
				sum=0;
				for(int i=1; i<=100; i++){
					if(i%2==1){
						sum+=i;
					}
				}
				System.out.println(sum);
				
				/*
				 * 구구단 출력
				 * 2*1=2
				 * 2*2=4
				 * -
				 * -
				 * */
				
				
				/*for(int i=1; i<=9; i++){
					System.out.println(2+"*"+i+"="+i*2);
				}
				for(int i=1; i<=9; i++){
					System.out.println(8+"*"+i+"="+8*i);
				}*/
				
			    for(int i=1; i<=9; i++){
			    	for(int j=2; j<=9; j++){
			    	System.out.print(j+"*"+i+"="+i*j+"\t");   	
			    	}
			    	System.out.println();
			    }
			 
			    /*
			     * while 문
			     * -while(조건식){}
			     * -포함하고 있는 문장들을 조건식이 막족하는 동안 반복하는 문장
			     * -반복횟수가 정확하지 않은 경우에 주로 사용한다.
			     */
			    
			    int a =1;
			    //a에 2씩 곱해서 1000이상이 되려면 몇번을 곱해야 하는가
			    int count=0;
			    while(a<1000){
			    	a*=2;
			    	count++;
			    	System.out.println(count+":"+a);
			    	    	
			    }
			    
			    /*
			     * do while 문
			     * -do{}while(조건식);
			     * -최소한 한번의 수행을 보장한다.
			     */
			    //숫자 맞추기 게임
			    /*int answer =(int)(Math.random()*100)+1;
			    
			    int input=0;
			    Scanner s = new Scanner(System.in);
			    
			    do{
			    	System.out.println("1~100사이에 수를 입력해주세요:");
			    	input=Integer.parseInt(s.nextLine());
			    	
			    	if(answer < input){
			    		System.out.println(input+"보다 작습니다.");
			    		
			    	}
			    	else if(input<answer){
			    		System.out.println(input+"보다 큽니다.");
			    	}else{
			    		System.out.println("정답입니다");	
			  
			    	}
			    }while(input !=answer);*/
			    
			    //이름붙은 반복문
			    outer : for(int i=2; i<=9; i++){
			    	for(int j=1; j<=9; j++){
			    		if(j==5){
			    			//break;//가장 가까운 반복문 하나를 빠져나간다.
			    			//break outer; //outer라는 이름의 반복문을 빠져나간다.
			    			//continue; //가장 가까운 반복문의 현재 반복회차를 빠져나간다.
			    			continue outer; //outer라는 이름의 현재 반복회차를 빠져나간다.
			    		}
			    		System.out.println(i+"*"+j+"="+i*j);
			    	}
			    	System.out.println();
			    }
			    
			    
			    
			      for(int i=5; i>=1; i--){
				    for(int j=1; j<=i; j++){
					  System.out.print("*");
					 
				  }
				  System.out.println();
			  }
			   
			}
		}


	
