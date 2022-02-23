package d_array;



import java.util.Arrays;
import java.util.Scanner;

public class rotto {

	public static void main(String[] args) {
		int charge=0;
		int purchase;
		
		Scanner sc = new Scanner(System.in); 	
  		
  		System.out.print("얼마 사시겠습니까?");
  		purchase =Integer.parseInt(sc.nextLine());
  		charge+=purchase;
		
		int count=charge/1000;
		
		int[][] rotto=new int[count][6];
		
	
		for (int i = 0; i < count; i++) {
			for (int j = 0; j < rotto[i].length; j++) {
				rotto[i][j] = (int) (Math.random() * 45) + 1;
			}
				for(int k=0; k<rotto[i].length; k++){
					for(int l=0; l<k; l++){
						if(rotto[i][k]==rotto[i][l]){
							i--;
							break;
						}
					}
				}
		}
		int temp=0;
		for (int i = 0; i < rotto.length; i++) {
			for (int j = 1; j < rotto[i].length; j++) {
				temp=rotto[i][j];
				int k;
				for (k =j-1; k >=0; k--) {
					if(temp<rotto[i][k]){
						rotto[i][k+1]=rotto[i][k];
						rotto[i][k]=temp;		
					}else{
						break;
					}
				}
				
			}
		}
	
		for(int i=0; i<rotto.length; i++){
			System.out.println(i+1+Arrays.toString(rotto[i]));
		}
		
		int bonus =(int)(Math.random()*45)+1;
		
		int[]rotto2=new int[6];
		for(int i=0; i<rotto2.length; i++){
			rotto2[i]=(int)(Math.random()*45)+1;	
			for(int j=0; j<i; j++){
				if(rotto2[i]==rotto2[j]||rotto2[i]==bonus){
					i--;
					break;
				}
			}
		
		}
		int temp2=0;
		for(int i=0; i<rotto2.length-1; i++){	
			boolean flag=true;
			for(int j=0;j<rotto2.length-i-1;j++){
				if(rotto2[j+1]<rotto2[j]){
					temp=rotto2[j];
					rotto2[j]=rotto2[j+1];
					rotto2[j+1]=temp;
					flag=false;
				}	
			}
			if(flag){
				break;
			}
		
			
		}
		System.out.println("당첨번호:"+Arrays.toString(rotto2)+"보너스 번호:"+bonus); 
		
		int[] check= new int[count];
		int[] bonuscheck=new int[count];
		
		for (int i = 0; i <rotto.length; i++) {
			for (int j = 0; j < rotto[i].length; j++) {
				for (int k = 0; k < rotto2.length; k++) {
					if (rotto[i][j] == rotto2[k]) {
						check[i]+=1;
						if(check[i]==5&&check[i]==bonus){
							bonuscheck[i]+=3;
							
						}
					}
							
			}
		}
			
			
	}	
		
		for(int i=0; i<check.length; i++){
				switch(check[i]){
				case 0:
				case 1:
				case 2:
//					System.out.println("꽝!!!!!");
					break;
				case 3:
					System.out.println("당첨금5천원");
					break;
				case 4:
					System.out.println("당첨금50000원");
					break;
				case 5:
					System.out.println("당첨금100만원");
					break;
				case 6:
					System.out.println("당첨금100억원");
					break;
				case 8:
					System.out.println("당첨금1000만원");
					break;
				}
		}
				
	       System.out.println(Arrays.toString(check));
  		
  		
  		
  		
	}
 		
 		
 		

	}


