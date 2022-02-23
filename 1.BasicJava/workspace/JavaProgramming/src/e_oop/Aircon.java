package e_oop;

import java.util.Scanner;

public class Aircon {
	
	public static Scanner s = new Scanner(System.in);
	
	String power;
	String control;
	String control2;
	String control3;
	
	static int temper=25;
	
	
	public static String nextLine(){
		return s.nextLine();
	}
	public static int nextInt(){
		return Integer.parseInt(s.nextLine());
	
	}
	
	Aircon power (String check){	
		Aircon temp=new Aircon();
    	temp.power=check;
    	if(temp.power!=null){
    		System.out.println("에어컨이 작동됩니다.");
    		System.out.println("현재온도는"+temp.temper+"입니다.");
    	}
    	return temp;
	}
	Aircon control(String check2){
		Aircon temp2=new Aircon();
		temp2.control=check2;
		if(temp2.control.equals("+")){
			temp2.temper++;
		}else{
			temp2.temper--;
		}
		return temp2;
	}
	void control3(String check5){
	    if(check5.equals("up")){
	    	System.out.println("up");
	    }else if(check5.equals("down")){
	    	System.out.println("down");
	    }else if(check5.equals("auto")){
	    	System.out.println("auto");
	    }
	}
	
	void control2(String check3){
		if(check3!=null){
			System.out.println("에어컨이 꺼집니다.");
		}
	}
	
	
	

}
