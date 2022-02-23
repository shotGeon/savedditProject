//package d_array;

//import java.util.Arrays;

//public class Score {

	//public static void main(String[] args) {
		/*
		 * 403호 모두의 국어, 영어, 수학, 사회, 과학, Oracle, Java 점수를
		 * 0~100까지 랜덤으로 생성해주시고 아래와 같이 출력해주세요
		 * 
		 * 이름     국어     영여    수학     사회    과학    oracle   java    합계      평 균(double)   석차
		 * 
		 * 
		 * 
		 * 
		 * 과목합계
		 * 과목평균
		 * 
		 * */ 
		/*String []daedok = new String[]{"이단비","김노을","정현욱","박소현","김수진","이희현",
						                "강건","이민영","허기재","이윤우","김미희","김혜윤",
						                "신승철","이광효","김진혁","마창수","양기옥","이동근", 
		                                "석기현", "류인성", "이미정", "임나리", "송민섭","김지윤", "조명석"};
		int [][] jumsu= new int[daedok.length][7];//각 개인별 개인과목 점수
		int[] sum = new int[jumsu.length];//각 개인별 총점
		int[] allsum= new int[7];//전체과목합계
		double[]allavg= new double[7];//전체과목평균
		int[] rank= new int[jumsu.length];//석차
        float [] avg = new float[jumsu.length];//각 개인별 평균
        String []name = new String[]{"이름  ","국어","영여" ,"수학" ,"사회" , "과학", 
        		                            "Oracle" , "Java" ,"합계","평 균" ,"석차"};
   
        
        for(int i=0; i<jumsu.length; i++) {
        	for(int j=0; j<jumsu[i].length; j++){
        		int random =(int)(Math.random()*101);
        		jumsu[i][j]=random;
        		sum[i]+=jumsu[i][j];
        			
        	}
        	    avg[i]=(float)sum[i]/jumsu[i].length;
        	        	    
        }
      
        int min=0;
        for(int i=0; i<sum.length; i++){
        	min=i;
        	int j=0;
        	for(j=i+1; j<sum.length; j++){
        		if(sum[min]<sum[j]){
        			min=j;
        		
        		}
        	}
        	int temp=0;
        	temp=sum[min];
        	sum[min]=sum[i];
        	sum[i]=temp; 	
        	rank[i]=i+1;
        }
        
        for(int i=0; i<allsum.length; i++){
        	for(int j=0; j<jumsu[i].length; j++){
        		allsum[i]+=jumsu[i][j];
        	}
        	allavg[i]=(float)allsum[i]/jumsu[i].length;
        	
        }
        int real =0;
        for(int i=0; i<jumsu.length; i++){
        	for(int j=0; j<jumsu[i].length; j++){
        		real+=jumsu[i][j];
        		if(sum[i]==real){
        			
        		}
        	}
        }
        
        System.out.println("이름\t국어\t영여\t수학\t사회\t과학\tOracle\tJava\t합계\t평 균\t석차");
       
        for(int i=0; i<jumsu.length; i++){
        	System.out.print(daedok[i]);
          for(int j=0; j<jumsu[i].length; j++){
        	  System.out.print("\t"+jumsu[i][j]); 
        	  
         }
//          System.out.println("\t"+sum[i]+"\t"+avg[i]+"\t"+rank[i]);
          System.out.printf("\t%d\t%.2f\t%d\n",sum[i],avg[i],rank[i]);
          System.out.println();
            
        }
        System.out.println("전체과목합계");
        
        for(int i=0; i<allsum.length; i++){
        	System.out.print("\t"+allsum[i]);
        }
        System.out.println();
        System.out.println("전체과목평균");
        for(int i=0; i<allavg.length; i++){
        	System.out.printf("\t%.2f",allavg[i]);
        }
        
        
        
        
                  
        
                
        
           
        
     
        
        
	         
        
        
	}

}*/
