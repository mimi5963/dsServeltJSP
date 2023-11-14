package ch07.sec08.exam01;

public class CarExample {

	public static void main(String[] args) {
		Car m = new Car();
		m.tire = new HanKookTire();
		m.run();
		
		m.tire = new Tire();
		m.run();
		
		m.tire = new KumhoTire();
		m.run();
		System.out.println(10.1%1);
		
	}

}
