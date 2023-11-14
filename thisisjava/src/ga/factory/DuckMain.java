package ga.factory;

import ga.factory.interfaces.FlyWithWings;

public class DuckMain {

	public static void main(String[] args) {
		Duck d1 = new DecoyDuck();
		Duck d2= new MallerDuck();
		
		 d1.fly();
		 d1.quack();
		 
		 d2.fly();
		 d2.quack();
		
	}

}
