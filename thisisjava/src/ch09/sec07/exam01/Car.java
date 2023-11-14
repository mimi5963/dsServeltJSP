package ch09.sec07.exam01;

public class Car {
	private Tire tire1 = new Tire();
	
	private Tire tire2 = new Tire() {
		@Override
		public void roll() {
			System.out.println("익명 Tire 객체 1이 굴러가유");
		}
	};
	public void run1() {
		tire1.roll();
		tire2.roll();
	}
	public void run2() {
		Tire tire = new Tire() {
			@Override 
			public void roll() {
				System.out.println("익명 Tire객체 3이 굴러야유");
			}
		};
		tire.roll();
	}
	public void run3(Tire tire) {
		tire.roll();
	}
}
