package ch05.sec05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MultidimensionalArrayex {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		boolean[] check = new boolean[2000001];
		int[] index = new int[2000001];
		Arrays.fill(index, -1);
		int num = Integer.parseInt(br.readLine());
		String[] input = br.readLine().split(" ");
		int findnum = Integer.parseInt(br.readLine());
		int cnt =0;
		
		
		for(int i=0; i<num ;i++) {
			check[Integer.parseInt(input[i])] = true;
			index[Integer.parseInt(input[i])] =i;
		}
		
		for(int i=0; i<num;i++) {
			int is = Integer.parseInt(input[i]);
			if(check[Math.abs(findnum-is)]==true
					&& index[is]<index[Math.abs(findnum-is)])cnt++;
		}
		System.out.println(cnt);
	}

}
