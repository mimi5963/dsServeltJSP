package thisisjava;

public class Hello {

	public static void main(String[] args) {
		
		System.out.println("Hello Java"); //컴파일 시점은 저장하는 순간 컴파일 함 
		                                 // run은 class파일 jvm에 로딩하는해서 실행하는 것
		
		System.out.println("Hello Java"); // .(온점)은 왼쪽 객체가 가진 필드에 접근하기 위해 찍는 기호 
		System.out.println("Hello Java"); 
		
		// 행주석
		/* 범위 주석 */ 
	    /**
	     * 도규먼트 주석 javadoc 명령어로 API 도큐먼트 생성할 때 사용
	     * @author User
	     */
		
		Hello h = new Hello();
		
		int x = 1; // ;(세미콜론)이 있어야 컴파일 가능 
		int y = 2;
		int result = x+y;
		System.out.println(result);
		
		
		int age;
		age =20;
		
		System.out.println(age);
		System.out.println(age);
		System.out.println(age);
		
		//정책이 바뀜 age = 21 
		age = 21;
		System.out.println(age);
		System.out.println(age);
		System.out.println(age);
		//변수의 유용성 
		
		
		
		
	}//main 메서드 끝 

	private int sum() {
		return 1;
	}
}
