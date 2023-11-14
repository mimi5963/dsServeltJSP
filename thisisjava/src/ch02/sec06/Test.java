package ch02.sec06;

public class Test {
	public static void main (String[] args) {
	//부동소수점 계산시 오차 발생할 수 있음
	double a = 10.03;
	double b =0.4;
	double c = a-b;
	System.out.println(c);
	//해결법 -> 정수로 고치기  
	int a2 = (int)(a*100); //부동소수점에서 원하는 자릿수만큼 *100 해서 int로 바꾸기 (1003)
	int b2 = (int)(b*100); //40
	double c2 = (a2-b2)/100.0; //뺀다음 곱해줬던 자릿수만큼 나눠줌 -> 이때  소수로 나눠줘야 정확하게 나옴
	System.out.println(c2);
	}

}
