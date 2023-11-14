package game;

public class Player {
	private int power;
	private int hp;
	String name;
	public Player (String name, int power,int hp) {
		this.power = power;
		this.hp = hp;
		this.name = name;
	}
	
	
	public void attack(Player p) {
		if(p == this) return;
		
		if(p.isalive() && p.hp <= this.power) {
			p.hp = 0;
			System.out.println(p.name + " 사망");
			return;
		}
		p.setHp(p.hp - this.power);
		
	}


	public boolean isalive() {
		if(this.hp == 0) return false; 
		return true;
	}
	
	public void setHp(int hp) {
		this.hp = hp;
	}
	public void setPower(int power) {
		this.power = power;
	}
	public int getHp() {
		return this.hp;
	}
	public int getPower() {
		return this.power;
	}
	
}
