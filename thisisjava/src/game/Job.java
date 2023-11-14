package game;

public abstract class Job extends Character{
	protected Character origin;
	
	public Job(Character origin) {
		this.origin = origin;
	}
	@Override
	public int getDemage() {
		
		return origin.getDemage();
	}

}
