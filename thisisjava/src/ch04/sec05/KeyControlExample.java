package ch04.sec05;

import java.util.Scanner;

public class KeyControlExample {
	
	public KeyControlExample () {
		
	}
	
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		boolean run = true;
		int speed =0;
		
		Speeds sfc = new Speeds();
		Car car = new Car(sfc);
		car.start();
		
		while(run) {
			System.out.println("-------------");
			System.out.println("1. 증속 | 2. 감속 | 중지");
			System.out.println("-------------");
			System.out.println("선택: ");
			
			String strNum = sc.nextLine();
			
			if(strNum.equals("1")) {
				sfc.speedUp();
			}else if(strNum.equals("2")) {
				sfc.speedDown();
			}else if(strNum.equals("3"))
				{run = false;
				car.stops();
				}
		
			}
	}
	
	
}


class  Speeds {
	private int speed=0;
	
	
	public synchronized void speedUp() {
		this.speed++;
	}
	public synchronized void speedDown() {
		speed--;
	}
	public int getSpeed() {
		return speed;
	}
}

class Car extends Thread{
	private Speeds sfc;
	private boolean runner = true;
	
	public Car(Speeds spc) {
		this.sfc = spc;
	}
	@Override
	public void run() {
		while(runner) {
		System.out.println("현재속도 : "+sfc.getSpeed());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			
		}
		}
	}
	public void stops() {this.runner =!this.runner;}

}
