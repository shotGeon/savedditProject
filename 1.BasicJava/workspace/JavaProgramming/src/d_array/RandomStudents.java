package d_array;

import java.util.Scanner;

public class RandomStudents {

	public static void main(String[] args) {
		// 숫자를 입력받아 입력받은 숫자만큼 403호 학생들중 랜덤으로 출력해주세요.,25명//3이라고 입력하면 25명준에 랜덤을3며을 뽑는다. 단 중복되지 않게
		
		String[] array=new String[]{"이단비","김노을","정현욱","박소현","김수진","이희현","강건","이민영","허기재",
				                    "이윤우","김미희","김혜윤","신승철","이광효","김진혁","마창수","양기옥","이동근", 
				                    "석기현", "류인성", "이미정", "임나리", "송민섭","김지윤", "조명석"};
		
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자를 입력해주세요:");
		int num = Integer.parseInt(sc.nextLine());
		
		int[] student;
		student=new int[array.length];
		
		for(int i=0; i<num; i++){
			
			while(true){
				int random =(int)(Math.random()*25);
				if(student[random]==0){
					student[random]=1;
					break;
				}
			}
		}
	   for(int i=0; i<array.length; i++){
		   if(student[i]==1){
			   System.out.println(array[i]);
		   }
	   }
	   
	   

		}
		
	}


