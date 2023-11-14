package ch02.sec01;

import java.util.Scanner;

public class LongExample {

	public static void main(String[] args) {
		long var1 =10;
		long var2 =20L;
		long var3 =1000000000;
		long var4 =10000000000L;//L을 안붙인 정수는 int 타입으로 간주 범위 넘어가면 에러뜸 
		System.out.println(var1);
		System.out.println(var2);
		System.out.println(var3);
		System.out.println(var4);
		
		
		int a = 10;
		long b =a;
		//int c =b; //대입불가 
		double c = b; //자동형변환
		
		double dd = 3.14; 
		int e = (int)dd; // 값이 3.14인게 문제가 아니라 타입이 double인게 문제
		
		Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        if(input == 0) {System.out.println("0");}
        else{
            while(input != 0){
                sb.append(Math.abs(input%-2));
                input = (int)Math.ceil((double)input/-2);
            }
           
            sb.reverse();
            System.out.println(sb);
        }

}
}
