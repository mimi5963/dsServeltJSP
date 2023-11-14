package ga.factory;

import ga.factory.interfaces.FlyWithWings;
import ga.factory.interfaces.Quack;

public class MallerDuck extends Duck{
	public MallerDuck() {
		super.flyable = new FlyWithWings();
		super.quackable = new Quack();
	}
	@Override
	public void display() {
		// TODO Auto-generated method stub
		System.out.println("maller");
	}

}
