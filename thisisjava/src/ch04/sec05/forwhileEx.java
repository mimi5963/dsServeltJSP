package ch04.sec05;

import java.util.Scanner;

public class forwhileEx {

	public static void main(String[] args) {

		//3번
//		int sum=0;
//		
//		for(int i=1 ;i<=100;i++) {
//			if(i%3 ==0) {
//				sum+=i;
//			}
//		}
//		System.out.println(sum);

		
		//4번
//		while(true) {
//			int n1 = (int)(Math.random()*6)+1;
//			int n2 = (int)(Math.random()*6)+1;
//			
//			System.out.println("("+n1+","+n2+")");
//			
//			if(n1+n2 == 5) 
//				break;
//			
//			
//		}
//		
		
//		//5번
//		for(int x =1 ; x<=10;x++) {
//			for(int y=1;y<=10;y++) {
//				if((4*x) + (5*y) == 60) {
//					System.out.println("("+x+","+y+")");
//				}
//			}
//		}
		
//		//6번
//		for(int i=0; i<5;i++) {
//			for(int j=0;j<=i;j++) {
//				System.out.print("*");
//			}
//			System.out.println();
//		}
		
		//7번
		
		boolean start = true;
		Scanner sc = new Scanner(System.in);
		int balance=0;
		while(start) {
			System.out.println();
			System.out.println("----------------------------");
			System.out.println("1.에금 | 2.출금 | 3.잔고 |4.종료");
			System.out.println("-----------------------------");
			System.out.print("선택 >");
			String input =sc.nextLine();
			
			if("1".equals(input)) {
				System.out.print("예금액 > ");
				balance = Integer.parseInt(sc.nextLine());
			}else if("2".equals(input)) {
				System.out.print("출금액 > ");
				int temp = Integer.parseInt(sc.nextLine());
				if(balance - temp <0 ) {
					System.out.println("잔액이 부족합니다");
				}else {
					balance -=temp;
				}
			}else if("3".equals(input)) {
				System.out.println(balance);
			}else {
				break;
			}
			
			
		}
		System.out.println("프로그램종료");
		
	}

}
