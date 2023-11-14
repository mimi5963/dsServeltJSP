package thisisjava;

public class FixedOrderFactory  extends AbstractOrderFactory{

	@Override
	protected Order factoryOrder() {
		
		return new FixdDiscountOrder(new FixedDiscountPolicy());
	}

}
