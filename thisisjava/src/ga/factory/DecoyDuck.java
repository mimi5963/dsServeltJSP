package ga.factory;

import ga.factory.interfaces.BiiBii;
import ga.factory.interfaces.FlyNOWay;

public class DecoyDuck extends Duck{
	
	public DecoyDuck() {
		super.flyable = new FlyNOWay();
		super.quackable = new BiiBii();
	}
	@Override
	public void display() {
		System.out.println("Decoy");
		
	}

}
