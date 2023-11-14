package decorator;

public class Mocha extends CondimentDecorator{
	public Mocha(Beverage br) {
		this.br = br;
	}
	@Override
	public String getDescription() {
		
		return br.getDescription()+", 모카";
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
		return br.cost()+this.decoratorCostPerSize;
	}

}
