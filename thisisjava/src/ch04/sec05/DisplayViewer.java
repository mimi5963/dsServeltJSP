package ch04.sec05;

public class DisplayViewer implements Viewer {
	
	Bank bnk;
	private int bal;
	public DisplayViewer(Bank bnk) {
		this.bnk = bnk;
		bnk.addViewer(this);
	}

	@Override
	public void showMoney(int bal) {
		// TODO Auto-generated method stub
		this.bal = bal;
		System.out.println("bal!"+bal);
		System.out.println("bal!"+bal);
	}

}
