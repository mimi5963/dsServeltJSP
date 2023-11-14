import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;


public class ArrayEx {
	
	public static void main(String[] args) throws IOException{
		
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));
	    
	    String[] input = br.readLine().split(" ");
	    int x = Integer.parseInt(input[0]);
	    int xd = Integer.parseInt(input[1]);
	    input = br.readLine().split(" ");
	    
	    int y = Integer.parseInt(input[0]);
	    int yd = Integer.parseInt(input[1]);
	    
	    int divide = x*yd + y*xd;
	    int divisor = xd*yd;
	    
	    int GCD = getGcd(divide,divisor);
	    
	    divide = ((double)divide/GCD)%1==0 ? divide/GCD:divide ;
	    divisor = ((double)divisor/GCD)%1==0 ? divisor/GCD:divisor ;
	    //최대공약수만 구하면됨 
		bw.write(divide+" ");
		bw.write(divisor+"");
		bw.flush();
		bw.close();
		
}

	private static int getGcd(int a, int b) {
		int temp,n;
		if(a<b) {
			temp = a;
			a = b;
			b= temp;
		}
		while(b!=0) {
			n = a%b;
			a = b;
			b = n;
		}
		return a;
	}
	private static int getGcds(int a, int b) {
		if(a%b == 0)return a;
		else return getGcds(b,a%b);
	}
}

