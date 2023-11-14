package thisisjava;

public abstract class AbstractOrderFactory {
	
	 public Order createOrder() {
		 Order returnorder = factoryOrder();
		 return returnorder;
	 }

	protected abstract Order factoryOrder();

}
