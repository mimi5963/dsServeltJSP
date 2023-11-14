package ch03.sec11;

public class exam03 {

	public static void main(String[] args) {
		
		
		//1 
		int x =10;
		int y= 20;
		int z= (++x) + y--; // 
		System.out.println(z);
		
		//2 
		int score = 85;
		String result = (!(score>90))? "가":"나";
		System.out.println(result);
		
		//3
		int pencils = 534;
		int students = 30;
		
		int pencilsPerStudent = pencils/students;
		System.out.println(pencilsPerStudent);
		
		int pencilsLeft = pencils%students;
		System.out.println(pencilsLeft);
		
		
		//4 
		int value = 356;
		System.out.println((value/100)*100);
		int value2 = 123;
		System.out.println(value2%100);
		
		int price =187000;
		
		int counter50=0;
		int counter10=0;
		int counter5 =0;
		int counter1=0;
		
		if(price >= 50000) {
			counter50 = price/50000;
			price = price%50000;
		}
		if(price >= 10000) {
			counter10 = price/10000;
			price = price%10000;
		}
		if(price >= 5000) {
			counter5 = price/5000;
			price = price%5000;
		}
		if(price >= 1000) {
			counter1 = price/1000;
			price = price%1000;
		}
		
		System.out.println("총 지불 지폐 수 : "+(counter50+counter10+counter5+counter1));
		System.out.println("각 지폐 지불 수 : "+ "5만원 = "+counter50 
				+",만원 = "+ counter10 
				+",오천원 = " +counter5
				+",천원 = "+counter1);
			
	}

}
