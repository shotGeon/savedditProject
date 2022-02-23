package i_api;

public class StringSpeedTest {

	public static void main(String[] args) {
		/*String str="a";
		long start = System.currentTimeMillis();//시간제는 메소드
		for(int i=0; i<200000; i++){
			str +="a";
		}
		long end = System.currentTimeMillis();
		System.out.println(end -start+"ms");*/
		
		StringBuffer sb = new StringBuffer("a");//string은 변경하기 위해서 객체를 새로 생성하기 때문에 비효율적이다 따라서 StringBuffer를 사용한다.
		long start = System.currentTimeMillis();
		for(int i=0; i<200000; i++){
			sb.append("a");
			
		}
		long end = System.currentTimeMillis();
		System.out.println(end-start+"ms");

	}
		
	

}
