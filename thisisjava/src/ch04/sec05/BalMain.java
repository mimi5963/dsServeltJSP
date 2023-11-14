package ch04.sec05;

public class BalMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Bank bnk = new Backimpl();
		Viewer v1 = new DisplayViewer(bnk);
		Viewer v2 = new MuteViewer(bnk);
		
		bnk.setMoney(10000);
	}


}
