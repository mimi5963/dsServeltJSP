package ch05.sec07;

import java.util.Arrays;

public class ArrayCopyByForExample {

	public static void main(String[] args) {
		
		int[] oldIntArray = {1,2,3};
		
		int[] newArray = new int[5];
		
		for(int i=0;i<oldIntArray.length;i++) {
			newArray[i] = oldIntArray[i];
		}
		
		int[] newIntArray2 = Arrays.copyOf(oldIntArray,10 );
		System.arraycopy(oldIntArray,0,newIntArray2,0,oldIntArray.length);
	}

}
