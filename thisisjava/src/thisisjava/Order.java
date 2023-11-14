package thisisjava;

public abstract class Order {
	protected DiscountPolicy dp;
	private int price;
	public Order(DiscountPolicy pd) {
		this.dp = pd;
	}
	
	public abstract int calDiscount(int price);
	
}
