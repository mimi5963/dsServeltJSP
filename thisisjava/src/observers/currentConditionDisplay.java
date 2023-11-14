package observers;

import observers.interfaces.DisplayElement;
import observers.interfaces.Observer;

public class currentConditionDisplay implements Observer,DisplayElement {

	 private float tem;
	 private float hum;
	 private WeatherData weather; //참조값 저장해두면, 탈퇴시 유용하대
	 
	 public currentConditionDisplay(WeatherData we) {
		 this.weather = we;
		 we.registerObserver(this);
	 }
	@Override
	public void display() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(float temp, float hum, float pre) {
		this.hum =hum;
		this.tem = tem;
		display();
	}

}
