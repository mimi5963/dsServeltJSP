package observers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class SwingObserverExample {
JFrame frame;

public static void main(String[] args) {
	SwingObserverExample ex = new SwingObserverExample();
	ex.go();
	
}

private void go() {
	frame = new JFrame();
	JButton button = new JButton("할 말?");
	button.addActionListener(new AngelListener()); //버튼을 누르면 반응하는 천사와 악마 리스너 
	button.addActionListener(new DevilListener());
	frame.show();
}
	
}

class AngelListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("하지마");
		
	}
	
}

class DevilListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("go");
		
	}
	
}
