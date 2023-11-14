package ch06.sec08.exam03;

public class StaticEx {
	static Car car;
	
	static void makeCar() {
		if(car == null) {
			car = new Car();
		}
	}
	//car에다가 그냥 초기화하는거랑 다른가?? 아니면 초기화 시점이 다른가?
	
	//* 하나의 메소드 영역에 클래스별 정적메소드 정보, 
	//인스턴스 메소드 정보를 저장하고, 객체 없이 사용하거나 못하거나를 제한 걸어 둔 것 ? 
}
