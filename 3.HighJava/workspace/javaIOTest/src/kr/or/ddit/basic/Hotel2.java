package kr.or.ddit.basic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Hotel2 {
	static  Map<Integer,Personer> person= new HashMap<>();
	
	public static void main(String[] args) {
		try {
			FileInputStream fis = new FileInputStream("d:/D_Other/hotel2.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			Object obj =null;
			while((obj=ois.readObject())!=null) {
				Personer p = (Personer)obj;
			    person.put(p.getRoom(), p);
			}
			ois.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			//e.printStackTrace();
		}
		new Hotel2().start();
		
	}
	
	
	
	public void start(){
		Scanner s = new Scanner(System.in);
		System.out.println("=================");
		System.out.println("호텔 문을 열었습니다.");
		System.out.println("=================");
		System.out.println();
		while(true) {
			System.out.println("====================================");
			System.out.println("어떤 업무를 하시겠습니까?");
			System.out.println("1.체크인  2.체크아웃  3.객실상태  4.업무종료");
			System.out.println("====================================");
			System.out.print("메뉴선택 =>");
			int check = Integer.parseInt(s.nextLine());
			System.out.println();
			switch(check) {
			case 1:
				checkin();
				break;
			case 2:
				checkout();
				break;
			case 3:
				roomInfo();
				break;
			case 4:
				try {
					System.out.println("==============");
					System.out.println("호텔 문을 닫았습니다.");
					System.out.println("================");
					FileOutputStream fos = new FileOutputStream("d:/D_Other/hotel2.txt");
					ObjectOutputStream oos = new ObjectOutputStream(fos);
					Set<Integer> keySet = person.keySet();
					Iterator<Integer> it = keySet.iterator();
					while(it.hasNext()) {
						Personer p = person.get(it.next());
						oos.writeObject(p);
					}
					oos.close();
					
				}catch(IOException e) {
					e.printStackTrace();
				}
				System.exit(0);
			}
			
		}
		
	}

	private  void roomInfo() {
		Set<Integer> keySet=person.keySet();
		if(keySet.size()==0) {
			System.out.println("체크인된 객실이 없습니다.");
		}else {
			
			Iterator<Integer> it = keySet.iterator();
			while(it.hasNext()) {
			    int room= it.next();
				Personer p=person.get(room);
				System.out.println("방번호 : "+p.getRoom()+", 투숙객: "+p.getName());
			}
		}
		
	}

	private  void checkout() {
		Scanner s=new Scanner(System.in);
		System.out.println("어느방을 체크아웃 하시겠습니까?");
		System.out.print("방번호 입력=>");
		int room=Integer.parseInt(s.nextLine());
		if(person.remove(room)==null) {
			System.out.println(room+"방은 체크인된 방이 아닙니다.");
		}else {
			System.out.println(room+"방 체크아웃 되었습니다.");
		}
		System.out.println("==============================");
		
	}

	private  void checkin() {
		Scanner s = new Scanner(System.in);
		System.out.println("어느방에 체크인 하시겠습니까?");
		System.out.print("방번호 입력=>");
		int room=Integer.parseInt(s.nextLine());
		System.out.println();
		if(person.get(room)!=null) {
			System.out.println(room+"방에는 이미 사람이 있습니다.");
		}else {
			System.out.println("누구를 체크인 하시겠습니까?");
			System.out.print("이름입력=>");
			String name=s.nextLine();
			
			person.put(room, new Personer(room,name));
			System.out.println("체크인 되었습니다.");
			System.out.println();
		}
		
	}
	
}


class Personer implements Serializable{
	
	private int room;
	private String name;
	public Personer(int room, String name) {
		super();
		this.room = room;
		this.name = name;
	}
	public int getRoom() {
		return room;
	}
	public void setRoom(int room) {
		this.room = room;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Person [room=" + room + ", name=" + name + "]";
	}
	
}

























