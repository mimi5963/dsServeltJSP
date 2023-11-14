package ga.factory;

import ga.factory.interfaces.Flyable;
import ga.factory.interfaces.Quackable;

public abstract class Duck {
	
	protected Flyable flyable;
	protected Quackable quackable;
	
	public Duck() {}
	
	public void fly() {
		flyable.fly();
	}
	public void quack() {
		quackable.quack();
	}
	
	public void swim() {
		System.out.println("수영중");
		
	}
	public void setFlyable(Flyable f) {
		this.flyable = f;
	}
	public void setQuackable(Quackable q) {
		this.quackable = q;
	}
	public abstract void display();

}
