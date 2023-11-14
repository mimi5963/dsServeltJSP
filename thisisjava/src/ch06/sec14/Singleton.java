package ch06.sec14;

public class Singleton {
	private static Singleton si; //이런 패턴을 사용하면 조금이라도 아낄 수 있다.**
	
	private Singleton() {
		System.out.println("생성자");
	}
	public static Singleton getInstance() {
	 if(si == null) {
		 si =new Singleton();
	 }	
	 return si;
	}
}
