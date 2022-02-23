package b_operator;

public class LogicalOperator {

	public static void main(String[] args) {
		/*
		 * 논리연산자
		 * -&&(AND), ||(OR), !(NOT)-TRUE를FALSE로FALSE를TRUE로바꿔준다.
		 * -피연산자로 boolean만 허용한다.
		 */
		
		/*int x=10;
		int y=20;
		boolean b= 0 < x && x<10 ||x<y; //우선순위-AND-OR
		System.out.println(b);
		
		b=!(x<y);//()쳐야 boolean타입으로 된다.-(x<y)같이 
		System.out.println(b);
		
		//효율적 연산
		b=true&&true;//true
		b=true&&false;//false
		b=false&&true;//false
		b=false&&false;//false
		
		b=true || true;//true
		b=true || false;//true
		b=false || true;//true
		b=false || false;//false
		//왼쪽의 피연산자에서 결과가 정해지면 오른쪽은 수행하지 않는다.
		
		int a=10;
		b= a<5 && 0<a++;
		System.out.println(a);*///왼쪽이 이미false라 오른쪽을 실행하지 않아 a의값이 올라가지 않는다
		
		//x가y보다 크고 x가 10보다 작다.
		//x가 짝수이고 y보다 작거나같다.
		//x가 3의 배수이거나 5의배수이다.
		int x=10;
		int y=30;
		boolean chan=x>y&&x<10;
		System.out.println(chan);
		chan=x%2==0&&x<=y;
		System.out.println(chan);
		chan=x%3==0||x%5==0;
		System.out.println(chan);
		
		
		


	}

}
