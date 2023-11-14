package ch6;

public class Init {
	
	
	Init(){
		System.out.println("생성자");
	}
	//static 블럭
	static {
		System.out.println("static 블럭");
	}
	
	//인스턴스 블럭
	{
		System.out.println("instance 블럭");
	}
	
	public static void main(String[] args) {
		
		System.out.println("main 메서드 실행");
		System.out.println("Init 객체 생성");
		Init i = new Init();
		System.out.println("Init 객체 생성");
		Init i2 = new Init();
	}
	
}
