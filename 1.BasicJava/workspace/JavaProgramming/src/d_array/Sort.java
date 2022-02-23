package d_array;

import java.util.Arrays;

public class Sort {

	public static void main(String[] args) {
		/*
		 * -석차구하기: 점수를 비교해 작은 점수의 등수를 증가시키는 방식
		 * -선택정렬: 가장 작은 숫자를 찾아서 앞으로 보내는 방식
		 * -버블정렬: 바로 뒤의 숫자와 비교해서 큰 수를 뒤로 보내는 방식
		 * -삽입정렬: 두번째 숫자부터 앞의 숫자들과 비교해서 큰수는 뒤로 밀고 중간에 삽입하는 방식
		 */
		/*int[] arr= new int[10];
		for(int i=0; i<arr.length; i++){
			arr[i]=(int)(Math.random()*100)+1;
		}
		System.out.println(Arrays.toString(arr));
		
		int[] rank =new int[arr.length];
		for(int i=0; i<rank.length; i++){
			rank[i]=1;
		}
		for(int i=0; i<arr.length; i++){
			for(int j=0;j<arr.length; j++){
				if(arr[i]<arr[j]){
					rank[i]++;
				}
			}
		}
		System.out.println(Arrays.toString(rank));*/
		
		//선택정렬:가장 작은 숫자를 찾아서 앞으로 보내는 방식
		
		//int[] a = new int[10];
		
		
		//for (int i = 0; i < a.length; i++) {
			//a[i] = (int) (Math.random() * 100) + 1;
		//}
		//System.out.println(Arrays.toString(a));
		/*int min = 0;
		for(int i=0; i<a.length; i++){
			min=a[i];
			for(int j=i+1; j<a.length; j++){
			if(a[min]>a[j]){
				min=a[j];
			}
			
		}
	}*/
		/*for(int i=0; i<a.length-1; i++){
			int min=i;
			int j=0;
			for(j=i+1; j<a.length; j++){
				if(a[min]>a[j]){
					min=j;
				}
			}
			int temp =0;
			temp=a[min];
			a[min]=a[i];
			a[i]=temp;
		}
		
		System.out.println(Arrays.toString(a));*/
		
		
		int[] arr= new int[10];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * 100) + 1;
		}
		System.out.println(Arrays.toString(arr));
		
		/*for(int i=1; i<arr.length; i++){
			int num=arr[i];
			int j=0;
			for(j=i-1; j>=0; j--){
				if(num<arr[j]){
					arr[j+1]=arr[j];
				}else
					break;
			}
			arr[j+1]=num;
		
		}
			
		
		
		System.out.println(Arrays.toString(arr));*/
	
		
		for(int i=0; i<arr.length-1; i++){
			boolean flag =true;
			for(int j=0; j<arr.length-i-1;j++){
			    if(arr[j+1]<arr[j]){
				int temp =arr[j];
				arr[j]=arr[j+1];
				arr[j+1]=temp;	
				flag=false;
				}
				
			}
			if(flag==true){
				break;
			}
		}
		System.out.println(Arrays.toString(arr));
		
		
		
	}
}

