package d_array;

import java.util.Scanner;

public class ArrayRandomStudent {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] a=new String[]{"이단비","김노을","정현욱","박소현","김수진","이희현",
				                "강건","이민영","허기재","이윤우","김미희","김혜윤",
				                "신승철","이광효","김진혁","마창수","양기옥","이동근", 
                                "석기현", "류인성", "이미정", "임나리", "송민섭","김지윤", "조명석"};
		
		String[] b= new String[a.length];
		
		
		
		for(int i=0; i<a.length; i++){
			while(true){
				int random =(int)(Math.random()*25);
				if(b[random]==null){
					b[random]=a[i];
					break;
				}
			}
		}
		System.out.print("숫자를 입력해주세요:");
		int input = Integer.parseInt(sc.nextLine());
		
		for(int i=0; i<input; i++){	
			System.out.println(i+1+b[i]);
		
		}
		
		//do while 로 해보기 boolean을 사용한다.
           
	}

}
