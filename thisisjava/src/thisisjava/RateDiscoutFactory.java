package thisisjava;

public class RateDiscoutFactory extends AbstractOrderFactory {

	@Override
	protected Order factoryOrder() {
		return new RateDiscountOrder(new RateDiscountPolicy());
	}

}
