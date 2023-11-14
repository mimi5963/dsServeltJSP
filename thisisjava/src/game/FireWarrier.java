package game;

public class FireWarrier extends Job {

	public FireWarrier(Character origin) {
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
		System.out.println("파이어볼 추가 공격");
		return 2;
	}
}
