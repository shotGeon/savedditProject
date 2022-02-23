package kr.or.ddit.basic;

import java.awt.Toolkit;

public class BeepPrintExample {

	public static void main(String[] args) {
		Runnable rb = new BeepTask();
		Thread th = new Thread(rb);
		th.start();
		
		for(int i=0; i<5; i++) {
			System.out.println("띵");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}





class BeepTask implements Runnable{
	@Override
	public void run() {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		for(int i=0; i<5; i++) {
			toolkit.beep();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}