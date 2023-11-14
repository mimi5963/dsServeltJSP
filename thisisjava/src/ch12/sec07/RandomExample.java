package ch12.sec07;

import java.util.Arrays;
import java.util.Random;

public class RandomExample {

	public static void main(String[] args) {
		
		int[] selectNumber = new int[6];
		Random rand = new Random(3);
		System.out.println("선택번호 : ");
		for(int i=0 ;i<6 ;i++) {
			selectNumber[i] = rand.nextInt(45)+1;
			System.out.print(selectNumber[i]+" ");
		}
		System.out.println();
		
		//당첨번호
		int[] winnerNumber = new int[6];
		rand = new Random(3); //seed설정
		System.out.println("당첨번호 : ");
		for(int i=0 ;i <6; i++) {
			winnerNumber[i] = rand.nextInt(45)+1;
			System.out.print(winnerNumber[i]+" ");
			
		}
		System.out.println();
		Arrays.sort(selectNumber);
		Arrays.sort(winnerNumber);
		
		boolean result = Arrays.equals(selectNumber, winnerNumber);
		System.out.print("당점여부: ");
		if(result) {
			System.out.println("1등 당첨");
		}else {
			System.out.println("당첨 안됨");
		}

	}

}
