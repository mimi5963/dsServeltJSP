package ch04.sec02;

public class ifElseIfElseExample {

	public static void main(String[] args) {
		
		int score = 75;
		
		if(score >= 90) {
			System.out.println("점수가 100-90입니다.");
			System.out.println("등급은 A입니다.");
		}else if (score >=80) {
			System.out.println("점수가 80-89입니다.");
			System.out.println("등급은 B입니다.");
		}else if(score >= 70) {
			System.out.println("점수가 70 - 79 입니다.");
			System.out.println("등급은 C입니다.");
		}else {
			System.out.println("점수가 70 미만입니다.");
			System.out.println("등급은 D입니다.");
		}
		
		double r = Math.random();
		
		int dice = (int)(Math.random()*6)+1;
		System.out.println(dice);
		int lotto = (int)(Math.random() * 45) +1;
		System.out.println(lotto);
		int coin = (int)(Math.random() * 2);
		System.out.println(coin);
	}

}
