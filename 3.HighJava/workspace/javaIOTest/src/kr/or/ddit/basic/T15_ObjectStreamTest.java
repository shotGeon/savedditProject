package kr.or.ddit.basic;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.invoke.CallSite;

public class T15_ObjectStreamTest {
	public static void main(String[] args) {
		//Member 인스턴스 생성 
		Member mem1 = new Member("홍길동", 20 , "대전");
		Member mem2 = new Member("일지매", 30 , "경기");
		Member mem3 = new Member("이몽룡", 40 , "강원");
		Member mem4 = new Member("성춘향", 20 , "광주");
		
		try {
			// 객체를 파일에 저장하기
			// 출력용 스트림 객체 생성
			ObjectOutputStream oos = 
					new ObjectOutputStream(
							new BufferedOutputStream(
							new FileOutputStream("d:/D_Other/memObj.bin")));
			// 쓰기 작업
			oos.writeObject(mem1); //직렬화가 일어나고 있다.
			oos.writeObject(mem2);
			oos.writeObject(mem3);
			oos.writeObject(mem4);
			
			System.out.println("쓰기작업 완료...");
			oos.close();
			
			//----------------------------------------------
			
			//저장된 객체를 읽어와 출력하기
			//입력용 스트림 객체 생성
			ObjectInputStream ois =
					new ObjectInputStream
					 (new BufferedInputStream(
					  new FileInputStream("d:/D_Other/memObj.bin")));//따로 객체를 생성하지 않고 바로 안에다 생성(간편함)
			
			Object obj = null;
			
			//마지막에 다다르면 EOF Exception 발생함.
			while((obj=ois.readObject())!=null) {//역직렬화가 일어나고 있다.
				//읽어온 데이터를 원래의 객체형으로 변환 후 사용한다.
				Member mem = (Member) obj;
				System.out.println("이름 : "+ mem.getName());
				System.out.println("나이 : "+ mem.getAge());
				System.out.println("주소 : "+ mem.getAddr());
				System.out.println("------------------------");
			}
			
			ois.close();
		}catch(ClassNotFoundException ex) {
			ex.printStackTrace();
		}catch(IOException ex) {
			ex.printStackTrace();//이걸 찍지 않으면 출력창에 exception내용이 안나옴
			System.out.println("출력끝...");
		}
	}
}

/**
 * 회원정보 VO
 * @author PC-04
 *
 */
//Serializable(표식인터페이스)
class Member implements Serializable{ //자바는 Serializable
    //인터페이스를 구현한 클래스만 직렬화 할 수 있도록 제한하고 있다.
    //구현하지 않으면 직렬화 작업시 예외발생(NonSerializableException)
    // transient => 직렬화 되지 않을 멤버변수에 지정한다.
    //               (static(객체의 값이 아니기때문) 필드도 직렬화가 되지 않는다.)
    //                직렬화가 되지 않는 멤버변수는 기본값으로 저장된다.
	//                (잠조변수: null, 숫자형변수: 0)
	private String name;
	private transient int age;
	private String addr;
	public Member(String name, int age, String addr) {
		super();
		this.name = name;
		this.age = age;
		this.addr = addr;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	
	
}