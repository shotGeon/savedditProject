package e_oop;

public class ClassMaker {
   
	//전역변수 선언 및 초기화
	int num=1;
	//리턴타입과 파라미터가 없는 메서드 하나를 만들어주세요
	//메서드 안에서 전역변수를 출력해주세요
	  void not(){
		  System.out.println(num);
	  }
	
	  
	//전역변수와 동일한 타입의 리턴타입이 있고 파라미터는 없는 메서드 하나를 만들어주세요
	//메서드 안에서 전역변수를 리턴해수요
	  int number(){
		  return num;
		  
	  }
	
	
	//리턴타입은 없고 파라미터가 있는 메서드 하나를 만들어주세요
	//메서드 안에서 파라미터를 출력해주세요
	  void number2(int para,int para2){
		  System.out.println(para*para2);
	  }
	
	//int타입의 리턴타입과 int 타입의 파라미터 두개가 있는 메서드 하나를 만들어주세요.
	//메서드 안에서 두 파라미터를 곱한 결과를 리턴해주세요
	  
	  int multiply(int para2, int para3){
		  return para2*para3;
	  }
	
	

   
   
  
  
 
  
  
  
   
   
   
   
   
   
   
   
   
   
}

