package decorator;

public class Soy extends CondimentDecorator {
	public Soy(Beverage br) {
	this.br = br;
	}
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return br.getDescription() +", 두유";
	}

	@Override
	public int cost() {
		if(br.getSize().isGrande()) {
			this.decoratorCostPerSize = 2;
		}
		if(br.getSize().isTALL()) {
			this.decoratorCostPerSize =1;
		}
		if(br.getSize().isVENTI()) {
			this.decoratorCostPerSize =3;
		}
		return br.cost()+decoratorCostPerSize;
	}

}
