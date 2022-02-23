package kr.or.ddit.basic;

class Util{
	/*
	 * 제너릭 메서드<T,R> R(리턴) method(T t)(파라미터)
	 * 
	 * 파라미터 타입과 리턴타입으로 타입 파라미터를 가지는 메서드
	 * 선언방법: 리턴타입 앞에 <> 기호를 추가하고 타입파라미터를 기술 후 사용함.
	 *  
	 */
	public static<K,V> boolean compare(Pair<K,V> p1,Pair<K,V>p2) {
		
		boolean keyCompare = p1.getKey().equals(p2.getKey());
		boolean valueCompare = p1.getValue().equals(p2.getValue());
		
		return keyCompare&&valueCompare;
	}
}
/*
 * 멀티타입<K,V>를 가지는 제너릭 클래스
 */

class Pair<K,V>{
	private K key;
	private V value;
	
	public Pair(K key, V value) {
		super();
		this.key = key;
		this.value = value;
	}
	public K getKey() {
		return key;
	}
	public void setKey(K key) {
		this.key = key;
	}
	public V getValue() {
		return value;
	}
	public void setValue(V value) {
		this.value = value;
	}
	
	// key와 value 모두 출력하기
	public <K,V> void displayAll(K key, V val) {//위에 선언한 제너릭에 있는 타입이 아닌 사용할 때 쓴 타입으로 사용할 수 있다.
		System.out.println(key.toString()+" : "+val.toString());
	}
	
}
public class T02_GenericMethodTest {
	public static void main(String[] args) {
		Pair<Integer,String> p1=new Pair<Integer, String>(1,"홍길동");
		Pair<Integer,String> p2=new Pair<Integer, String>(1,"홍길동");
		
		boolean result1=Util.<Integer,String>compare(p1, p2);
		
		if(result1) {
			System.out.println("논리(의미)적으로 동일한 객체임");
		}else {
			System.out.println("논리(의미)적으로 동일한 객체아님");
		}
		
		Pair<String,String> p3= new Pair<String,String>("001","홍길동");
		Pair<String,String> p4= new Pair<String,String>("002","홍길동");
		
		boolean result2=Util.compare(p3, p4);
		if(result2) {
			System.out.println("논리(의미)적으로 동일한 객체임");
		}else {
			System.out.println("논리(의미)적으로 동일한 객체 아님");
		}
		
		//제너릭 메서드 테스트
		p1.<String,Integer>displayAll("키",180);
		//일반 메서드로 만들시 밑에는 타입이 틀려지기 때문에 에러(Integer,String)
		//p1.<String,Integer>displayAll("키",180);
	}
}






































