package decorator;

public abstract class CondimentDecorator extends Beverage{
	protected int decoratorCostPerSize;
	protected Beverage br;
	public abstract String getDescription();
	//getDescription()을 강제하기 위해 abstract로 추가 
//	public Size getSize() {
//		return br.getSize();
//	}
}
