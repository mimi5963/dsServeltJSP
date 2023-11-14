package game;

public abstract class Character {
	protected int power;
	protected int hp;
	protected String name;
	public Character() {}
	public Character(int power,int hp, String name) {
		this.power = power;
		this.hp = hp;
		this.name = name;
	}
	
	public void attack(Character p) {
		if(p == this) return;
		
		if(p.isalive() && p.hp <= this.getDemage()) {
			p.hp = 0;
			System.out.println(p.name + " 사망");
			return;
		}
		p.setHp(p.hp - this.getDemage());
	}

	public void setHp(int i) {
		this.hp = i;
		
	}

	public boolean isalive() {
		if(this.hp == 0) return false; 
		return true;
	}
	
	public abstract int getDemage();
}
