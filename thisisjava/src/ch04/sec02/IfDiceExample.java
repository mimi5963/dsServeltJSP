package ch04.sec02;

public class IfDiceExample {

	public static void main(String[] args) {
		
		int num = (int)(Math.random() * 6) +1;
		
		if(num == 1) {
			System.out.println("1");
		}else if( num == 2) {
			System.out.println("2");
		}else if (num == 3) {
			System.out.println("3");
		}else if (num == 4) {
			System.out.println("4");
		}else if(num == 5) {
			System.out.println("5");
		}else {
			System.out.println("6");
		}
		
		
		int score = (int)(Math.random()*20) + 81;
		String grade;
		
		if(score >=90) {
			if(score >= 95) {
				grade="A+";
			}else {
				grade = "A";
			}
		}else {
			if(score >= 85) {
				grade = "B+";
				
			}else {
				grade = "B";
			}
			
		}
		System.out.println(grade);
	}

}
