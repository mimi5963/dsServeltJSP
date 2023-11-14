package design.decorator;

public class Espresso implements Basic{
	
	private Basic basic;
	private int upShot;
	private int upPrice;
	
	public Espresso (Basic basic, int upShot, int upPrice) {
		this.basic = basic;
		this.upShot = upShot;
		this.upPrice = upPrice;
	}
	@Override
	public int getShot() {
		// TODO Auto-generated method stub
		return basic.getShot() + upShot;
	}

	@Override
	public int getPrice() {
		// TODO Auto-generated method stub
		return basic.getPrice() + upPrice;
	}

}
