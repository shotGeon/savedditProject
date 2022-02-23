package j_collection;

import java.util.ArrayList;

public class ArrayListClass {

	public static void main(String[] args) {
		/*
		 * List
		 * Map 값을 저장할때 인덱스에 저장하지 않고 키에 저장한다.
		 * Set 중복된 값은 저장되지 않는다.
		 * 
		 * 
		 * boolean add(Object obj) : 마지막 위치에 객체를 추가 후 성공여부를 반환한다.
		 * void add(int index, Object obj) : 지정된 위치에 객체를 추가한다.
		 * Object set(int index, Object obj) : 지정된 위치에 객체를 저장 후 기존 객체를 반환한다.
		 * Object get(int index):지정된 위치의 객체를 반환한다.
		 * int size():지정된 객체의 수를 반환한다.
		 * Object remove(int index):지정된 위치를 객체를 제거 후 반환한다.
		 */
		
		ArrayList sample =new ArrayList();
		
		sample.add("abc");
		sample.add(100);
		
		//제네릭을 지정하지 않으면 넣을때는 편하나 꺼낼때는 타입을 예측하기 힘들다.
		//따라서 제네릭의 사용이 권장된다.
		ArrayList<Integer> list1 = new ArrayList<>();
		list1.add(10);
		list1.add(20);
		System.out.println(list1.add(30));
		System.out.println(list1);//list안에 값을 보기위한 출력문
		list1.add(1,40);//1번위치에 40이 들어가고 뒤에 값들은 한칸씩 밀려난다.,범위를 벗어난 인덱스에는 저장 불가
		System.out.println(list1);
		
		/* wrapper class
		 * byte : Byte
		 * int : Integer
		 * long : Long
		 * float : Float
		 * double: Double
		 * char : Character
		 * boolean : Boolean
		 * 기본형 타입이 자동으로 형변환 된다.
		 */
		Integer before=list1.set(2,50);//2번위치에 20대신에 50저장후 before에 20을 리턴
		System.out.println(list1);
		System.out.println(before);
		System.out.println("after"+list1.get(2));

		/*for(int i=0; i<list1.size(); i++){//size()!!
			System.out.println(i+" :"+list1.get(i));
			list1.remove(i);
		}*/
		System.out.println(list1);
		//삭제할때마다 사이즈도 같이 줄기때문에 온전히 삭제가 불가능하다.
		
		for(int i=list1.size()-1; i>=0; i--){
			System.out.println(i+" : "+list1.remove(i));
		}
		System.out.println(list1);
		
		//list1에 1~100사이의 랜덤값을 10개 저장해주세요
		
		for(int i=0; i<10; i++){
			//list1.add((int)(Math.random()*100)+1);
			int num=(int)(Math.random()*100)+1;
			list1.add(num);
		}
		System.out.println(list1);
		
		//list1에 저장된 값의 합계와 평균을 구해주세요
		int sum=0;
		double avg=0;
		for(int i=0; i<list1.size(); i++){
			sum+=list1.get(i);
			avg=(double)sum/list1.size();
		}
		System.out.println("sum: "+sum);
		System.out.println("avg: "+avg);
		//list1에서 최소값과 최대값을 구해주세요
	
		for(int i=1; i<list1.size(); i++){
			int temp=list1.get(i);
			int j=0;
			for(j=i-1; j>=0; j--){
				if(temp<list1.get(j)){
					list1.set(j+1, list1.get(j));
				}else{
					break;
				}
				
			}
			list1.set(j+1,temp);
		}
		System.out.println(list1);
		
		
		//2차원
		ArrayList<ArrayList<Integer>> list2= new ArrayList<>();
		list1 = new ArrayList<>();
		list1.add(10);
		list1.add(20);
		list1.add(30);
		list2.add(list1);
		System.out.println(list2);
		list1 = new ArrayList<>();
		list1.add(40);
		list1.add(50);
		list1.add(60);
		list2.add(list1);
		System.out.println(list2);
		
		for(int i=0; i<list2.size(); i++){
			ArrayList<Integer>li=list2.get(i);
			for(int j=0; j<li.size(); j++){
				System.out.println(li.get(j));
			}
		}
		
		int num=list2.get(0).get(1);
		int num2=list2.get(0).get(2);
		int num3=list2.get(1).get(0);
		System.out.println("num: "+num);
		System.out.println("num2: "+num2);
		System.out.println("num3: "+num3);
	}

}


























