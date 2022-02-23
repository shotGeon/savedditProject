package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.List;

public class T04_WildCardTest {
/*
 * 와일드 카드에 대하여
 * 
 * 와일드카드(?)는 제너릭 타입을 이용한 타입 안전한 코드를 위해 사용되는 특별한 종류의
 * 인수로서, 변수선언, 객체생성 및 메서드 정의할 때 사용된다.(제너릭 타입 선언시에는 
 * 사용할 수 없다.)
 * 
 * <? extends T> => 와일드카드의 상한 제한. T와 그 자손들만 가능
 * <? super T> => 와일드카드의 하한 제한. T와 그 조상들만 가능
 * <?>         => 모든 타입 가능 <? extends Object>와 동일.
 * 
 */
	public static void main(String[] args) {
		
		FruitBox<Fruit> fruitBox= new FruitBox<>();
		FruitBox<Apple> appleBox= new FruitBox<>();
		
		fruitBox.add(new Apple());
		fruitBox.add(new Grape());
		
		appleBox.add(new Apple());
		appleBox.add(new Apple());
		//appleBox.add(new Grape()); 사과상자에 포도는 안담김
		Juice.makeJuice(fruitBox);
		Juice.makeJuice(appleBox); 
	}
}

//쥬스
class Juice{
//제한된 타입 파라미터 문법	
/*static<T extends Fruit> void makeJuice(FruitBox<T> Box) {
		
		String fruitListStr ="";//과일목록
		
		int cnt=0;
		for(Fruit f:Box.getFruitList()) {
		  if(cnt==0) {
			  
			  fruitListStr+=f;
		  }else {
			  fruitListStr+=","+f;
		  }
		  cnt++;
		}
		System.out.println(fruitListStr+" => 쥬스완성");
	}*/
	
	//와일드 카드 사용
	static void makeJuice(FruitBox<? extends Fruit> Box) {
		
		String fruitListStr ="";//과일목록
		
		int cnt=0;
		for(Fruit f:Box.getFruitList()) {
		  if(cnt==0) {
			  
			  fruitListStr+=f;
		  }else {
			  fruitListStr+=","+f;
		  }
		  cnt++;
		}
		System.out.println(fruitListStr+" => 쥬스완성");
	}
}

//과일
class Fruit {
	private String name;//과일이름

	public Fruit(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "과일("+name+")";
	}
	
}

//사과
class Apple extends Fruit{
	public Apple() {
		super("사과");
	}
}

//포도
class Grape extends Fruit{
	public Grape() {
		super("포도");
	}
}

//과일상자
class FruitBox<T>{
	private List<T> fruitList;
	
	public FruitBox() {
		fruitList = new ArrayList<>();
	}

	public List<T> getFruitList() {
		return fruitList;
	}

	public void setFruitList(List<T> fruitList) {
		this.fruitList = fruitList;
	}
	
	public void add(T fruit) {
		fruitList.add(fruit);
	}
}





























