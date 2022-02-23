package d_array;
import java.util.Arrays;
public class MultiDimensionalArray {

	public static void main(String[] args) {
	   /*
	    * 다차원 배열
	    * -배열안에 배열리 저장디어 있는 형태이다.
	    */
		
		//2차원 배열
		//int[][] array1;
		
		//3차원 배열
		//int[][][] array3;
		

		/*
		 * 변수 =100번지 (주소
		 * 
		 * 100번지
		 * {200번지, 300번지}
		 * 
		 * 200번지
		 * {0,0,0}
		 * 
		 * 300번지
		 * {0,0,0}*/
		//int[][] arr= new int[][]{{1,2,3},{5,6,7,}};
		
		//int[] arr2[]={{1,2,3}
		              //,{4,5,6}
		              //,{7,8,9}};
		
		//int[][] arr3 = new int[3][]; //가변배열
		//arr3[0]=new int[3];//0번인덱스의 길이는3으로 바뀜
		//arr3[1]=new int[5];
		//arr3[2]=new int[10];
		
		//System.out.println(arr2[0][1]);
		//arr2[0]=10;1차원 배열이기 때문에 값을 저장할 수 없다.
		/*arr[0]=new int[5];//1차원 배열은 배열만 저장가능
		arr[0][0]=10;
		arr[0][1]=20;
		arr[0][2]=30;		
		System.out.println(arr2[0][0]);*/
		
		/*for(int i=0; i<arr.length; i++){//2차원배열의 길이는 1차원배열을 적도 쓴다.
			for(int j=0; j<arr[i].length; j++){
				System.out.println(arr[i][j]);
			}
		}*/
		
		int[][] scores =new int[3][5];   //1차원은 학생수 2차원은 과목수
		int[] sum = new int[scores.length];
		double[] avg = new double[scores.length];
		
		for(int i=0; i<scores.length; i++){
			for(int j=0; j<scores[i].length; j++){ 
				scores[i][j]=(int)(Math.random()*101);
				sum[i]+=scores[i][j];	
			}
			    avg[i]=(double)sum[i]/scores[i].length;
			    
			    System.out.println(Arrays.toString(scores[i]));
			System.out.println("합계: "+sum[i]+"/ 평균: "+avg[i]);
		}
		
		   
		   
		
		
	}
	}


