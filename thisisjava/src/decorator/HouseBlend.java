package decorator;

public class HouseBlend extends Beverage{
	public HouseBlend(Size s) {
		this.description = "하우스 블랜드 커피";
		this.s=s;
	}
	@Override
	public int cost() {
		// TODO Auto-generated method stub
		if(s.isGrande())
		return 2;
		if(s.isTALL())
		return 1;
		
		return 3;
	}

}
