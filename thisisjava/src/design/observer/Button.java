package design.observer;

public class Button {
	private ButtonListener buttonListener;
	private String name;
	
	public Button(String name) {
		this.name = name;
	}
	
	public void addListener(ButtonListener buttonListener) {
		this.buttonListener = buttonListener;
	}
	// 이벤트 발생
	public void click(String msg) {
		this.buttonListener.clickEvent(msg);
	}
}
