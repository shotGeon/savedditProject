package e_oop.restaurant;

import java.util.Arrays;

public class Boss {

	public static void main(String[] args) {
	
		Alba al= new Alba();
		
		String[] order =al.order();
		System.out.println(Arrays.toString(order));
		
		System.out.println("요리를 만드는중......완성!!");
		String[] foods={"완성된 짜장면","완성된 탕수육"};
		
		al.serving(foods);
		
		al.pay(order);

	}

}
