package decorator;

public enum Size {
	VENTI,GRANDE,TALL;
	
	public boolean isVENTI() {
		return this==Size.VENTI;
	}
	public boolean isGrande() {
		return this==Size.GRANDE;
	}
	public boolean isTALL() {
		return this==Size.TALL;
	}
}
