package game;

public class IceWarrier extends Job {

	public IceWarrier(Character origin) {
		super(origin);
		// TODO Auto-generated constructor stub
	}
	@Override
	public int getDemage() {
		int originD = this.origin.getDemage();
		originD += additionalAttack();
		return originD;
	}
	private int additionalAttack() {
		System.out.println("아이스에이지");
		return 3;
	}
}
