package ch04.sec05;

public class MuteViewer implements Viewer {
	private Bank bnk;
	private int bal;
	public MuteViewer(Bank bnk) {
		this.bnk = bnk;
		bnk.addViewer(this);
	}
	@Override
	public void showMoney(int bal) {
		// TODO Auto-generated method stub
		this.bal = bal;
		System.out.println("조용---"+bal);
	}

}
