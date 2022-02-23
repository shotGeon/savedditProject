package d_array;

import java.util.Arrays;

public class memo {

	public static void main(String[] args) {
		
		String []student = new String[]{"이단비","김노을","정현욱","박소현","김수진","이희현",
                "강건","이민영","허기재","이윤우","김미희","김혜윤",
                "신승철","이광효","김진혁","마창수","양기옥","이동근", 
                "석기현", "류인성", "이미정", "임나리", "송민섭","김지윤", "조명석"};
		String [] subject = new String[]{"국어","영어","수학","사회","과학","오라클","자바"};
		
	    int[][] scores= new int [student.length][subject.length];
	    int[]sum= new int [student.length];
	    float[]avg= new float [student.length];    
	    int[]rank=  new int [student.length];
	    int[] allsum= new int[subject.length];
	    int[] allavg= new int[subject.length];
	    
	    for(int i=0; i<scores.length; i++){
	    	for(int j=0; j<scores[i].length; j++){
	    		 int random = (int)(Math.random()*101);
	    		 scores[i][j]=random;
	    		 sum[i]+=scores[i][j];
	    		 
	    	}
	    	avg[i]=sum[i]/subject.length;
	    	
	    }
	    int count=0;
	    for(int i=0; i<rank.length; i++){
	    	int max=i;
	    	int j=0;
	    	for(j=i+1; j<rank.length; j++){
	    		if(sum[max]<sum[j]){
	    			max=j;
	    		}
	    	}
	    	int temp=0;
	    	temp=sum[max];
	    	sum[max]=sum[i];
	    	sum[i]=temp;
	    	    	   
	    }
	    System.out.println(Arrays.toString(rank));
	    System.out.println("이름\t국어\t영어\t수학\t사회\t과학\t오라클\t자바\t합계\t평균\t석차");
	    
	    
	    for(int i=0; i<scores.length; i++){
	    	System.out.print(student[i]);
	    	for(int j=0; j<scores[i].length; j++){
	    		System.out.print("\t"+scores[i][j]);
	    	}
	    	System.out.println();
	    }
	    
	    
	    
	    
	    
	    
	    
	    
	  
	}

}
