package ch05.sec07;

public class MainStringArrayArgument {

	public static void main(String[] args) {
		
		if(args.length != 2) {
			System.out.println("프로그램 입력값 부족");
			System.exit(0);
		}
		
		String strNum = args[0];
		String strNum2 = args[1];
		
		int num = Integer.parseInt(strNum2);
		int num2 = Integer.parseInt(strNum);
		
		int result = num+num2;
		System.out.println(result);
		
		
		//thisisJava -> 프로젝트 루트
		//thisisjava/bin -> 클래스들 모여있음 
	}

}
