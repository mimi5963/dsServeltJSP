package ch05.sec07;

import java.util.Scanner;

public class Exercise06 {

	
	
	public static void main(String[] args) {
		
		//7
		int[] array= {1,5,3,8,2};
		int maxVal = Integer.MIN_VALUE;
		for(int a : array) {
			if(maxVal < a)
				maxVal=a;
		}
		System.out.println(maxVal);
		
		
		//8
		int[][] arr2 = {
				
				{95,86},
				{83,92,96},
				{78,83,93,87,88}
		};
		int sum=0;
		int cnt=0;
		for(int i=0; i<arr2.length;i++) {
			for(int j=0; j<arr2[i].length;j++)
			{
				sum += arr2[i][j];
				cnt++;
			}
		}
		System.out.println(sum +", avg = "+(double)sum/cnt);
		
		//9 
		
		Scanner sc = new Scanner(System.in);
		boolean flag = true;
		int[] scoreArr = null;
		while(flag) {
			System.out.println("------------------------------------");
			System.out.println("1.학생수|2.점수입력|3.점수리스트|4.분석|5.종료");
			System.out.println("------------------------------------");
			
			System.out.print("선택: ");
			int choice = sc.nextInt();
			
			switch(choice) {
			case 1: 
				System.out.print("학생수 > ");
				int numofStudent = sc.nextInt();
				scoreArr = getAarray(numofStudent);
				break;
				
			case 2:
				
				getScore(scoreArr,sc);
				break;
			case 3:
				printAll(scoreArr);
				break;
			case 4:
				statistic(scoreArr);
				break;
				
			default: flag = false;
			         break;
			}
			
			if(choice ==1 ) {
				System.out.print("학생수 > ");
				int numofStudent = sc.nextInt();
				scoreArr = getAarray(numofStudent);
			}else if(validationCheck(scoreArr)) {
				if(choice == 2) {
					getScore(scoreArr,sc);
				}else if(choice==3) {
					printAll(scoreArr);
				}else if(choice ==4) {
					statistic(scoreArr);
				}else {
					flag = false;
				}
			}else {
				System.out.println("입력이 잘못됨");
			}
			
		}
	 System.out.println("프로그램종료");
	}

	private static void getScore(int[] scoreArr,Scanner sc) {
		
		for(int i=0; i<scoreArr.length;i++) {
			System.out.print("scores["+i+"] >");
			int score = sc.nextInt();
			scoreArr[i] = score;
		}
		
	}
	private static boolean validationCheck(int[] arr) {
		return arr != null;
	}

	private static int[] getAarray(int numofStudent) {
		
		return new int[numofStudent];
	}

	private static void statistic(int[] scoreArr) {
		int Maxval =Integer.MIN_VALUE;
		int sum =0;
		for(int s : scoreArr) {
			if(s>Maxval)Maxval=s;
			sum += s;
		}
		System.out.println("최고 점수 : " +Maxval);
		System.out.println("평균 점수 : "+ (double)sum/scoreArr.length);
		
	}

	private static void printAll(int[] scoreArr) {
		for(int i=0; i<scoreArr.length;i++) {
			System.out.println("score["+i+"] :" + scoreArr[i]);
		}
		
	}
}
