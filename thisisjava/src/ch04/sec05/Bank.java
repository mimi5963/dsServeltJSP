package ch04.sec05;

public interface Bank {

	public void addViewer(Viewer v);
	public void removeViewer(Viewer v);
	public void notifyToViewer();
	public void setMoney(int bal);
	
}
