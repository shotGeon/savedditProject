package j_collection;


import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Set;

public class HashMapClass {

	public static void main(String[] args) {
		/*
		 * Object put(Object key, Object value) : 지정된 키와 값을 저장한다.
		 * Object remove(Object key):지정된 키로 저장된 값을 제거한다.
		 * Object get(Object key) : 지정된 키의 값(없으면 null)을 반환한다.
		 * Set keySet() : 저장된 모든 키를 Set으로 반환한다.,키를 모를때 사용한다.
		 * key는 보통 String
		 * index값이 없기때문에 순서가 정해져 있지 않다.
		 * 하나의 키에 하나의 값만 저장된다.
		 * 값의 타입은 지정할때의 타입
		 * 테이블 형태를 만들때 주로 사용한다.
		 * 테이블에 행하나를 표현할 수 있다.
		 */
		
		HashMap<String,Object> map = new HashMap<>(); 
		
		map.put("age", 10);
		map.put("name", "홍길동");
		map.put("date", new Date());
		
		map.put("name","강건");//값을 수정하기 위해서는 다시한번 같은 키로 바꿀 값을 적는다.
		map.remove("age");
		System.out.println(map);
		
		Object object=map.get("name");
		System.out.println(object);
		
		((String)object).charAt(0);//형변환후 그 타입에 맞는 메소드를 불러오기 위해서는 괄호를 한번 더 묶는다.
		System.out.println(((String)object).charAt(0));
		
		Set<String> keys = map.keySet();//저장된 모든 키
		
		for(String key : keys){
			System.out.println(key+" : "+map.get(key));
		}
		
		Object[] arr=map.values().toArray();
		
		//회원 테이블
		/*
		 * 아이디   :admin
		 * 비밀번호 :admin123
		 * 이름 :관리자
		 * 전화번호 :010-1234-5678
		 */
		
		 HashMap<String,String>user =new HashMap<>();
		 
		 user.put("id", "admin");
		 user.put("password", "admin123");
		 user.put("name", "관리자");
		 user.put("tel", "010-1234-5678");
		  
		 HashMap<String,String>user2 = new HashMap<>();
		 
		 user2.put("id", "ak1233");
		 user2.put("password", "ak1234");
		 user2.put("name", "강건");
		 user2.put("tel", "010-3941-7733");
		 
		 ArrayList<HashMap<String, String>> table = new ArrayList<>();
		 table.add(user);		
		 table.add(user2);
		 
		 for(int i=0; i<table.size(); i++){
			 System.out.println(table.get(i));
		 }
		 
		 HashMap<String, Object>lprod= new HashMap<>();
		 lprod.put("LPROD_ID",1);
		 lprod.put("LPROD_GU","P101");
		 lprod.put("LPROD_NM","컴퓨터제품");
		 
		 ArrayList<HashMap<String, Object>> table2 = new ArrayList<>();
		 table2.add(lprod);
		 
		 lprod= new HashMap<>();
		 lprod.put("LPROD_ID",2);
		 lprod.put("LPROD_GU","P102");
		 lprod.put("LPROD_NM","전자제품");
		 
		 table2.add(lprod);
		 
		 
		 lprod= new HashMap<>();
		 lprod.put("LPROD_ID",3);
		 lprod.put("LPROD_GU","P201");
		 lprod.put("LPROD_NM","여성캐주얼");
		 
		 table2.add(lprod);
		 
		 lprod= new HashMap<>();
		 lprod.put("LPROD_ID",4);
		 lprod.put("LPROD_GU","P202");
		 lprod.put("LPROD_NM","남성캐주얼");
		 
		 table2.add(lprod);
				 
		lprod= new HashMap<>();
		 lprod.put("LPROD_ID",5);
		 lprod.put("LPROD_GU","P301");
		 lprod.put("LPROD_NM","피혁삽화");
		 
		 table2.add(lprod);
		 
		 lprod= new HashMap<>();
		 lprod.put("LPROD_ID",6);
		 lprod.put("LPROD_GU","P302");
		 lprod.put("LPROD_NM","화장품");
		 table2.add(lprod);
		 		 
		 lprod= new HashMap<>();
		 lprod.put("LPROD_ID",7);
		 lprod.put("LPROD_GU","P401");
		 lprod.put("LPROD_NM","음반/CD");
		 
		 table2.add(lprod);
		 
		 lprod= new HashMap<>();
		 lprod.put("LPROD_ID",8);
		 lprod.put("LPROD_GU","P402");
		 lprod.put("LPROD_NM","도서");
		 table2.add(lprod);
				 
		 lprod= new HashMap<>();
		 lprod.put("LPROD_ID",9);
		 lprod.put("LPROD_GU","P403");
		 lprod.put("LPROD_NM","문구류");
		 
		 table2.add(lprod);
		 
		 lprod= new HashMap<>();
		 lprod.put("LPROD_ID",10);
		 lprod.put("LPROD_GU","P501");
		 lprod.put("LPROD_NM","농산물");
		 
		 table2.add(lprod);	
		

		 
		 
		System.out.println("LPROD_ID\tLPROD_GU\tLPROD_NM");
		
		for(int i=0; i<table2.size(); i++){
			System.out.println(table2.get(i).get("LPROD_ID")
					+"\t\t"+table2.get(i).get("LPROD_GU")
					+"\t\t"+table2.get(i).get("LPROD_NM"));
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
