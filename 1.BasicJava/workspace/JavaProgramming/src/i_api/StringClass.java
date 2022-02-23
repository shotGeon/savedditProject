package i_api;

import java.util.Arrays;

import org.omg.CORBA.StringHolder;

public class StringClass {

	public static void main(String[] args) {
		/*
		 * String
		 * 여러개의 문자를 사용하기 쉽게 만들어 놓은 클래스
		 * 
		 *  String의 주요 메서드
		 *  equals() : 문자열의 내용이 같은지 반환된다.
		 *  length() : 문자열의 길이를 반환한다.
		 *  charAt() : 특정 인덱스의 위치한 문자를 반환한다.
		 *  substring() : 문자열의 특정 부분을 잘라서 반환한다.
		 *  indexOf() : 문잘열 내의 특정 문자의 인덱스를 반환한다.
		 *  contains() : 문자열이 특정 문자열을 포함하고 있는지 여부를 반환한다.
		 *  split(): 문자열을 특정 문자를 기준으로 나누어 배열형태로 반환한다.
		 *  trim(): 문자열 앞뒤의 공백을 제거해 반환한다.
		 *  valueOf(): 다른 타입의 데이터를 문자열로 반환해 반환한다.
		 */
		
		boolean equals ="문자열".equals("문자열");
		System.out.println(equals);
		
		String str1 ="문자열";
		String str2 =null;
		System.out.println(str1.equals(str2));
		//System.out.println(str2.equals(str1));
		
		String str ="12345";
		int length=str.length();
		for(int i=0; i<length; i++){
			char charAt=str.charAt(i);
			System.out.println(charAt);
		}
		//문자열 뒤집기
		String rev ="";
		for(int i=str.length()-1;0<=i; i--){
			rev+=str.charAt(i);
		}
		System.out.println(rev);
		
		str ="0123456789";
		String sub1 = str.substring(length-3);
		System.out.println(sub1);
		String sub2=str.substring(9,1);//5번부터 8번 전까지
		System.out.println(sub2);
		str="수박 오렌지 귤 블루베리";
		int index=str.indexOf("오렌지");
		System.out.println(index);
		
		//substring과 indesOf를 조합해서 문자열 자르기
		String[] menu = {
				"수박 20000원",
				"오렌지 100000원",
				"귤 500원",
				"블루베리 3000원"
		};
		
		
		
		for(int i=0; i<menu.length; i++){
			String name=menu[i].substring(0, menu[i].indexOf(" "));
			System.out.println(name);
		}
		for(int i=0; i<menu.length; i++){
			int price=Integer.parseInt(menu[i].substring(menu[i].indexOf(" ")+1,menu[i].length()-1));
			System.out.println(price);
		}
		
		str="abcd";
		boolean contains=str.contains("c");//여러글자여도 상관없다.
		System.out.println(contains);
		for(int i=0; i<menu.length; i++){
			if(menu[i].contains("오렌지")){
				System.out.println("오렌지는"+i+"번 인덱스에 있습니다.");
			}
		}
		
		str ="a/b/c";
		String[] split=str.split("/");// '/'는 포함되지 않는다.나누는 것에만 사용
		System.out.println(Arrays.toString(split));
		
		for(int i=0;i<menu.length; i++){
			String[] s=menu[i].split(" ");
			System.out.println("이름 "+s[0]+"/ 가격"+s[1]);
		}
		
		str=" 문자열 ";
		String trim=str.trim();//앞뒤에 있는 공백만 제거, 사이에있는 공백은 제거하지 않는다.
		System.out.println("["+str+"]->["+trim+"]");
		
		String id =" myid";
		String password="mypassword ";
		System.out.println(id);
		System.out.println(password);
		System.out.println(id.trim());
		System.out.println(password.trim());
		
		//string 타입으로 형변환
		int num =10;
		str = num+"";
		str = String.valueOf(num);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}   

}
