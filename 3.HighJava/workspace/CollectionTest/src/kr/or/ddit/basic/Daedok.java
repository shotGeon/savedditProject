package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Daedok {

	public static void main(String[] args) {
		List<Student> li = new ArrayList<Student>();
		
		li.add(new Student("20152222", "강건",90,90,90));
		li.add(new Student("20151111", "하기재",90,90,90));
		li.add(new Student("20154444", "이민영",60,70,80));
		li.add(new Student("20153333", "석기현",50,60,75));
		li.add(new Student("20155555", "이희현",80,85,90));
		li.add(new Student("20156666", "이광효",40,50,65));
		
		for(int i=0; i<li.size(); i++) {
			int sum=li.get(i).getEng()+li.get(i).getKor()+li.get(i).getMath();
			li.get(i).setSum(sum);
		}
		
		for(int i=0; i<li.size(); i++) {
			int rank=1;
			for(int j=0; j<li.size(); j++) {
				if(li.get(i).getSum()<li.get(j).getSum()) {
					li.get(i).setRank(++rank);;
					
				}
			}
		}
		Collections.shuffle(li);
		System.out.println("-------------정렬전------------");
		for(int i=0; i<li.size(); i++) {
			System.out.println(li.get(i));
		}
		System.out.println("-------------------------------");
		
		System.out.println();
		
		System.out.println("-------------학번의 오름차순 정렬------------");
		Collections.sort(li);
		for(Student stu:li) {
			System.out.println(stu);
		}
		System.out.println("-------------------------------");
		
		System.out.println();
		
		System.out.println("------------총점의 내림차순 정렬--------------");
		Collections.sort(li,new JumsuSort()) ;
		for(Student stu:li) {
			System.out.println(stu);
		}
		System.out.println("----------------------------------------");
	}
}

class Student implements Comparable<Student>{
	private String bon;
	private String name;
	private int kor;
	private int eng;
	private int math;
	private int sum;
	private int rank=1;
	
	public Student(String bon, String name, int kor, int eng, int math) {
		super();
		this.bon = bon;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		//this.sum=kor+eng+math;
	}
	
	

	public String getBon() {
		return bon;
	}

	public void setBon(String bon) {
		this.bon = bon;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}


	@Override
	public int compareTo(Student stu) {
		return getBon().compareTo(stu.getBon());
	}

	@Override
	public String toString() {
		return "Student [bon=" + bon + ", name=" + name + ", kor=" + kor + ", eng=" + eng + ", math=" + math + ", sum="
				+ sum + ", rank=" + rank + "]";
	}
	
	
}
class JumsuSort implements Comparator<Student>{

	@Override
	public int compare(Student stu1, Student stu2) {
		if(stu1.getSum()==stu2.getSum()) {
			return stu1.getBon().compareTo(stu2.getBon())*-1;
		}else {
			return ((Integer)(stu1.getSum())).compareTo(stu2.getSum())*-1;
		}
	}
	
}