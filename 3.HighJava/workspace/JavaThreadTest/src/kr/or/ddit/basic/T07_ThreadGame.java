package kr.or.ddit.basic;

import javax.swing.JOptionPane;

public class T07_ThreadGame {

	public static boolean inputCheck =false;
	public static int num =0;
	public static int result = 0;
	public static void main(String[] args) {
		CountDown2 count2 = new CountDown2();
		count2.start();
		DataInput2 input2 = new DataInput2();
		input2.start();
	}
}





class DataInput2 extends Thread{
	@Override
	public void run() {
		T07_ThreadGame.num=(int)(Math.random()*3)+1;
		String str= JOptionPane.showInputDialog("가위/바위/보 중 하나를 입력하세요");
		
		T07_ThreadGame.inputCheck=true;
		
		if(str.equals("가위")) {
			T07_ThreadGame.result=1;
		}else if(str.equals("바위")) {
			T07_ThreadGame.result=2;
		}else if(str.equals("보")) {
			T07_ThreadGame.result=3;
		}
		
		System.out.println("----결과----");
		if(T07_ThreadGame.num==1) {
			System.out.println("컴퓨터:가위");
			System.out.println(T07_ThreadGame.num);
		}else if(T07_ThreadGame.num==2){
			System.out.println("컴퓨터:바위");
			System.out.println(T07_ThreadGame.num);
		}else if(T07_ThreadGame.num==3){
			System.out.println("컴퓨터 보");
			System.out.println(T07_ThreadGame.num);
		}
		if(T07_ThreadGame.result==1) {
			System.out.println("당신: 가위");
			System.out.println(T07_ThreadGame.result);
		}else if(T07_ThreadGame.result==2) {
			System.out.println("당신: 바위");
			System.out.println(T07_ThreadGame.result);
		}else {
			System.out.println("당신: 보");
			System.out.println(T07_ThreadGame.result);
		}
		
		
		if(T07_ThreadGame.result>T07_ThreadGame.num) {
			if(T07_ThreadGame.result==3&&T07_ThreadGame.num==1) {
				System.out.println("당신이 졌습니다.");
			}else {
				System.out.println("당신이 이겼습니다.");
			}
		}else if(T07_ThreadGame.result==T07_ThreadGame.num) {
			System.out.println("비겼습니다.");
		}else if(T07_ThreadGame.result<T07_ThreadGame.num) {
			if(T07_ThreadGame.result==1&&T07_ThreadGame.num==3) {
				System.out.println("당신이 이겼습니다.");
			}else {
				
				System.out.println("당신이 졌습니다.");
			}
		}
	}
}

class CountDown2 extends Thread{
	@Override
	public void run() {
		for(int i=5; i>=1; i--) {
			
			if(T07_ThreadGame.inputCheck==true) {
				return;
			}
			System.out.println(i);
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
		}
		System.out.println("5초가 지났습니다. 당신은 패배했습니다.");
		System.exit(0);
	}
}