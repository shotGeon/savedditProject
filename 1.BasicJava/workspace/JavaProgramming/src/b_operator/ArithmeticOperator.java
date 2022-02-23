package b_operator;

public class ArithmeticOperator {

	public static void main(String[] args) {
	/*
	 * 산술 연산자
	 * -사칙연산자: +,-,/,%(나머지)
	 * -복합연산자: +=,-=,*=,/=,%=
	 * -증강연산자:++,--
	 */
		
	
	//나머지 연산
		//int result =30;
		
	/*result = 10/3;
	System.out.println(result);
	result =10%3;
	System.out.println(result);*/
	 
	//5개의 산술연산자를 사용해 5개의 연산을 수행한 후 결과를 출력하시오
	
		/*result=1+2;
		System.out.println(result);
		result=1*1;
		System.out.println(result);
		result=2-1;
		System.out.println(result);
		result=2/1;
		System.out.println(result);
		result=2%1;
		System.out.println(result);*/
		
		//복합연산자
		//변수에 저장되어 있는 값에 연산을 수행할 때 수행할 연산자와 대입연산자를 결합해 사용할 수 있다.
		/*result+=3;
		System.out.println(result);
		result-=3;
		System.out.println(result);
		result/=3;
		System.out.println(result);
		result*=3;
		System.out.println(result);
		result%=3;
		System.out.println(result);*/
		
		
		//아래의 문장을 복합연산자를 사용한 문장으로 만들어주세요
		//result=result + 10
		/*result+=10;
		System.out.println(result);
		result%=5;
		System.out.println(result);
		result-=2*3;
		System.out.println(result);*/
		
		//증감연산자
		//증가연산자(++) : 변수의 값을 1증가시킨다.
		//감소연산자(--) : 변수의 값을 1감소시킨다.
		//int i=0;
		//i++;//후위형 변수의 값을 읽어온 후에 1을 증가시킨다.
		//++i;//전위형 변수의 값을 읽어오기 전에 1을 증가시킨다.
		//System.out.println(i);
		//i--;//후위형
		//--i;//전위형
		//System.out.println(i);
		
		//i=0;
		//System.out.println("i++=" + i++);
		//i=0;
		//System.out.println("++i=" + ++i);
		
		//피연산자(연산의 대상이 되는 값)의 타입이 서로 같아야만 연산이 가능하다.
		//int _int=10;
		//double _double=1.2;
		//double result2=_int+_double; //double result2=(double)a+b;표현범위가 더 큰 타입으로 하면 가능(int result2=a+b는 불가능)
		//System.out.println(result2);
		
		//byte _byte =5;
		//short _short=2;
		//int result3=_byte+_short; //int보다 작은 타입은 int로 형변환된다.
		//System.out.println(result3);
		
		//char _char='a';
		//char _char2='b';
		//_int=_char+_char2;
		//System.out.println(_int);
		
		//오버플로우, 언더플로우
		//표현범위를 벗어나는 값을 표현할 때 발생하는 현상
		
		//byte b= 127;
		//b++; 
		//System.out.println(b); //결과:-128(표현할 수 있는 범위를 벗어나게 되면 표현할 수 있는 범위에서 가장 작은 값을 나타낸다.)-오버플로우
		//b--;
		//System.out.println(b); //결과:127(표현할 수 있는 범위를 벗어나게 되면 표현할 수 있는 범위에서 가장 큰 값을 나타낸다.)-언더플로
		
		//다음을 한줄씩 계산해서 최종 결과값을 출력해주세요
		//1.123456+654321
		//2. 1번의 결과값 *123456
		//3. 2번의 결과값 /123456
		//4. 3번의 결과값 -654321
		//4. 4번의 결과값 %123456
		
		long result=123456+654321;
		result*=123456;
		result/=123456;
		result-=654321;
		result%=123456;
		System.out.println(result);
		
		/*long res = 123456+654321;
		res*=123456;
		res/=123456;
		res-=123456;
		res%=123456;
		System.out.println(res);*/
		
		int t=3;
		int y=6;
		int z=7;
		int sum=t+y+z;
		System.out.println(sum);
		double avg=sum/3.0;
		System.out.println("합계:"+sum+" 평균:"+avg);
		
		//반올림
		avg=Math.round(avg);//소수점 첫째자리까지 보고싶으면 10을 곱한후 다시10.0을 나눈다.
		System.out.println(avg);
		
		//랜덤
		//int random=(int)(Math.random()*100)+1;
		//System.out.println(random);
		//Math.random():0.0~1.0미만(0.999999...),Math.random은 double타입*/
		
	}

}
