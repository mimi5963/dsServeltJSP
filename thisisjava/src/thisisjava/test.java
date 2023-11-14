package thisisjava;

import java.util.Scanner;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int input = sc.nextInt();
		
		if (input == 0) System.out.println("0");
		else {
		while(input != 0) {
			
			sb.append(Math.abs(input%-2));
			
			if((input % -2) >= 0 ) {
				input = input / -2;
			}else if((input % -2 )<0) {
				input = (input / -2)+1;
			}
			
		}
		sb.reverse();
		System.out.println(sb);
		}

	}

}
