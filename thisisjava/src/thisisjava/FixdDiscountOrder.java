package thisisjava;

public class FixdDiscountOrder extends Order{

	public FixdDiscountOrder(DiscountPolicy pd) {
		super(pd);
		
	}

	@Override
	public int calDiscount(int price) {
		
		return super.dp.CalculDiscountPolicy(price);
	}

	

}
