package ch6;

public class MethodOrder {

	final static double COMMISION = 0.01; 
	void one() {
		two();
		System.out.println("one");
	}
	void two() {
		three();
		System.out.println("two");
	}
	void three() {
		System.out.println("three");
	}
	
	public static void main(String[] args) {
		MethodOrder mo = new MethodOrder();
		mo.one();
		System.out.println(mo.divide(mo.pow(mo.plus(4, 2))));
	}
	int plus(int x, int y) {
		return x+y;
	}
	int pow(int x) {
		return x*x;
	}
	int divide(int x) {
		return x/2;
	}
}
