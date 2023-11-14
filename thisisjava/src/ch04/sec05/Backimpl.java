package ch04.sec05;

import java.util.ArrayList;
import java.util.List;

public class Backimpl implements Bank {
	
	private List<Viewer> viewers;
	int bal;
	Backimpl(){
		viewers = new ArrayList<>();
	}
	
	public void setMoney(int bal) {
		this.bal= bal;
		subjectChanged();
	}
	
	private void subjectChanged() {
		notifyToViewer();
		
	}

	@Override
	public void addViewer(Viewer v) {
		// TODO Auto-generated method stub
		viewers.add(v); 
	}

	@Override
	public void removeViewer(Viewer v) {
		viewers.remove(v);

	}

	@Override
	public void notifyToViewer() {
		viewers.stream().forEach(v -> {
			v.showMoney(bal);
		});

	}

}
