package i_api;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import e_oop.ScanUtil;


public class RegularExpression {

	public static void main(String[] args) {
		/*
		 * 정규표현식: 문자열의 패턴을 검사하는 표현식
		 * 
		 *  ^ 뒷 문자로 시작
		 *  $ 앞 문자로 종료
		 *  . 임의의 문자(줄바꿈 제외)
		 *  * 앞 문자가 0개 이상
		 *  + 앞 문자가 1개 이상
		 *  ? 앞 문자가 없거나 1개
		 *  [] 문자의 집합이나 범위([a-z]:a부터 z까지, [^a-z]:a부터 z가 아닌것) 알파벳이나 숫자 문자가 올 수 있다.
		 *  {} 앞 문자의 개수({2}:2개 , {2,4}:2개 이상 4개 이하)
		 *  () 그룹화(1개의 문자처럼 인식)
		 *  | OR연산
		 *  \s 공백, 탭 , 줄바꿈
		 *  \S 공백, 탭, 줄바꿈이 아닌 문자
		 *  \w 알파벳이나 숫자
		 *  \W 알파벳이나 숫자가 아닌 문자
		 *  \d 숫자
		 *  \D 숫자가 아닌 문자
		 *  (?i) 뒷 문자의 대소문자 구분 안함
		 *  \ 정규표현식에서 사용되는 특수문자 표현(탈출문자)
		 */
		
		String str="abc123";
		//String regex="[a-z]{3}[0-9]{1,3}";
		//String regex="[a-z0-9]+";
		String regex="\\w*";
		Pattern p = Pattern.compile(regex);//정규표현식을 해석해서 패턴을 만들어냄
		Matcher m = p.matcher(str);//만들어진 패턴을 가지고 문자열과 비교해서 결과를 줌
		System.out.println(m.matches());
		
		//String password="[a-z]{4,8}\\W+";
		//아이디, 전화번호, 이메일주소의 유효성을 검사하는 정규표현식을 만들어주세요.
		String id="[a-z0-9_-]{5,20}";//영소문자와숫자를사용해5개에서20개사이의 아이디를 만들어라특수문자는_와-를 사용할수있다.
		String call="^0\\d{1,3}-\\{3,4}-\\d{4}";//앞의 0-1까지 숫자 3개 뒤에 0-9까지 숫자 4개 마지막도 0-9까지 숫자 4개
		String email="[a-z0-9_-]{5,20}@[a-zA-Z]+\\.(?i)(com|net|org|([a-z]{2}\\.kr))$"; 
		
		System.out.println("아이디입력>");
		String usid=ScanUtil.nextLine();	
		Pattern p1 = Pattern.compile(id);
		Matcher m1 = p1.matcher(usid);
		System.out.println(m1.matches());
		
		System.out.println("전화번호입력>");
		String uscall=ScanUtil.nextLine();	
		Pattern p2 = Pattern.compile(call);
		Matcher m2 = p1.matcher(uscall);
		System.out.println(m1.matches());
		
		System.out.println("이메일입력>");
		String usmail=ScanUtil.nextLine();	
		Pattern p3 = Pattern.compile(email);
		Matcher m3 = p1.matcher(usmail);
		System.out.println(m1.matches());
	}

}
