package thisisjava;

public class FixedDiscountPolicy implements DiscountPolicy{

	@Override
	public int CalculDiscountPolicy(int price) {
		System.out.println("fixed적용");
		return 0;
	}

}
