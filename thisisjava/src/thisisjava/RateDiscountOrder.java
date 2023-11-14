package thisisjava;

public class RateDiscountOrder extends Order{

	public RateDiscountOrder(DiscountPolicy pd) {
		super(pd);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int calDiscount(int price) {
		
		return super.dp.CalculDiscountPolicy(price);
	}

}
