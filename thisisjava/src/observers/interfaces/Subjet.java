package observers.interfaces;

public interface Subjet {
	
	public void registerObserver(Observer o);
	public void removeOberver(Observer o);
	public void notigyObserver();

}
