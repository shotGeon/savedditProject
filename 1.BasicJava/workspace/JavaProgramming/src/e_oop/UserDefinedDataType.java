package e_oop;

public class UserDefinedDataType {

	public static void main(String[] args) {
	/*
	 * 사용자 정의 데이터 타입
	 * -데이터의 최종 진화 형태이다.(기본형->배열->클래스)
	 * -서로 다른 타입의 데이터를 묶어서 사용하는 것이다.
	 * -변수와 메서드로 구성할 수 있다.
	 */
	
	//기본형(1개의 변수에 1개의 데이터만 저장)
	  int kor;
	  int eng;
	  int math;
	  int sum;
	  double avg;
	  
	  //배열(같은 타입의 데이터를 여러개 저장)
	  int [] scores;
	  int sum2;
	  double avg2;
	  
	  //클래스(관련된 변수를 다 묶어서 저장)(클래스를 사용하기 위해서는 객체를 생성해야 한다.-Scanner 만드는 식으로)
	  Student student = new Student();  //클래스이름 변수이름 = new 예약어//변수를 통해서 만들어놓은 클래스를 사용한다
	  
	  student.kor = 80;//초기화
	  student.eng = 90;
	  student.math = 75;
	  student.sum=student.kor+student.eng+student.math;
	  student.avg=student.sum/3.0;
	  student.name ="홍길도";
	  student.rank = 1;
	  
	  System.out.println(student.name);
	  System.out.println(student.avg);
	  
	}

}

class Student{
	int kor;
	int eng;
	int math;
	int sum;
	double avg;
	String name;
	int rank;
}
