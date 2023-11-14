package ch06.sec07.exam02;

public class KoreanExample {

	public static void main(String[] args) {
		
		Korean k1 = new Korean("박자바","000101100-02020");
		System.out.println(k1.nation);
		System.out.println(k1.name);
		System.out.println(k1.ssn);
		
		Korean k2 = new Korean("김자바","20020202-20202");
		System.out.println(k2.nation);
		System.out.println(k2.name);
		System.out.println(k2.ssn);

	}

}
