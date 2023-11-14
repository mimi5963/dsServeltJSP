package decorator;

public abstract class Beverage {
	protected String description="제목없음";
	protected Size s;

	public String getDescription() {
		return this.description;
	}
	public Size getSize() {
		return s;
	}
	public abstract int cost();
	
}
