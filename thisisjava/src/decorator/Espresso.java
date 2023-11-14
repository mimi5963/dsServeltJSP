package decorator;

public class Espresso extends Beverage{
	public Espresso(Size s) {
		this.description = "에스프레소";
		this.s =s;
	}
	@Override
	public int cost() {
		if(s.isGrande())
		return 2;
		if(s.isTALL())
		return 1;
		
		return 3;
	}
}
