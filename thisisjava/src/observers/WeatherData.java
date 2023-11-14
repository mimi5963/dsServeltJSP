package observers;

import java.util.ArrayList;
import java.util.List;

import observers.interfaces.Observer;
import observers.interfaces.Subjet;

public class WeatherData  implements Subjet{
	
	private List<Observer> observers;
	private float temp;
	private float hum;
	private float pre;
	
	public WeatherData() {
		observers = new ArrayList<>();
	}
	
	public void measurementsChanged() {
		this.notigyObserver(); //값 갱신시 옵저버에게 알림 
	
		
	}
	public void serMesurements(float tem, float hum, float pre) {
		this.hum=hum;
		this.temp = temp;
		this.pre = pre;
		this.measurementsChanged();
	}


	@Override
	public void registerObserver(Observer o) {
		observers.add(o);
		
	}

	@Override
	public void removeOberver(Observer o) {
		observers.remove(o);
	}

	@Override
	public void notigyObserver() {
		observers.stream().forEach(ob->{
			ob.update(temp, hum, pre);
		});
		
	}
	
	

}
