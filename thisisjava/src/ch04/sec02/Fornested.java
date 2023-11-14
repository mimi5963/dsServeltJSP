package ch04.sec02;

public class Fornested {

	public static void main(String[] args) {
	
		
		for(int i=2; i<=9 ;i++) {
			System.out.println("몇 단");
			for(int j=1;j<=9;j++) {
				System.out.println(i+" * " +j+" = "+(i*j));
			}
		}
	}

}
