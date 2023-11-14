package ch14.sec03.exam01;

import java.awt.Toolkit;

public class BeepPrintExample2 {

	public static void main(String[] args) {
		Thread thread = new Thread() {
			Toolkit t = Toolkit.getDefaultToolkit();
			@Override 
			public void run() {
				for(int i=0; i<5;i++) {
					t.beep();
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						
				}
			}
		}
	};
		
	thread.start();
	for(int i=0; i<5;i++) {
		System.out.println("삡");
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			
		}
	}
}
}