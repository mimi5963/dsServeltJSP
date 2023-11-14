package game;

public class Warrier extends Character {
	
	public Warrier(String name, int power, int hp) {
		super(power,hp,name);
	}
	@Override
	public int getDemage() {
		
		return this.power;
	}

}
