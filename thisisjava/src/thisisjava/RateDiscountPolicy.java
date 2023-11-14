package thisisjava;

public class RateDiscountPolicy implements DiscountPolicy{

	@Override
	public int CalculDiscountPolicy(int price) {
	System.out.println("rate적용");
		return 0;
	}

}
