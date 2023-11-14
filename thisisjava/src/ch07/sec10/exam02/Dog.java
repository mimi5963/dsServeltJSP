package ch07.sec10.exam02;

import java.util.Arrays;

public class Dog extends Animal {

	@Override
	public void sound() {
		System.out.println("멍뭉");

	}
	public static void main(String[] args) {
		int[] arr = {1,2};
		Arrays.stream(arr).reduce((a,b) -> {return a+b;}).getAsInt();
	}
}
