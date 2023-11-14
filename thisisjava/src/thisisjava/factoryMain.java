package thisisjava;

public class factoryMain {

	public static void main(String[] args) {
		AbstractOrderFactory aof = new FixedOrderFactory();
		AbstractOrderFactory aofs = new RateDiscoutFactory();
		
		Order a1 =aof.createOrder();
		Order a2 = aofs.createOrder();
		
		a1.calDiscount(1000);
		a2.calDiscount(2000);
	}

}
