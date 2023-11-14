package design.decorator;

public class Americano implements Basic{
	private int shot;
	private int price;
	
	public Americano(int shot,int price) {
		this.shot = shot;
		this.price = price;
	}
	
	@Override
	public int getShot() {
		// TODO Auto-generated method stub
		return shot;
	}

	@Override
	public int getPrice() {
		// TODO Auto-generated method stub
		return price;
	}

}
