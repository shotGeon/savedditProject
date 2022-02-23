
public class ParentExample {
		
		static void method1(Parent parent){
			if(parent instanceof Child){
				Child child = (Child) parent;
				System.out.println("method1 child로 형변환 성공");
			}else{
				System.out.println("형변환 실패");
			}
			
		}
		static void method2(Parent parent){
			Child child =(Child) parent;
			System.out.println("Child로 형변환 성공");
		}
		
		public static void main(String[] args) {
			Parent parentA = new Child();
			method1(parentA);
			method2(parentA);
			
			Parent parentB = new Parent();
			
			method1(parentB);
//			method2(parentB);
			
		}
		
		
}
