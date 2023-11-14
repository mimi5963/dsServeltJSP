
public class Solution {

	public static void main(String[] args) {
		int[] arr = {10000,-13000,-4000,-2000,6500,-20000};
		int[] arr2 = {-34152,-4000,-5000};
		int result =solution(5000,arr);
		System.out.println(result);
	}
	
	public static int solution(int m, int[] ledger) {
		int account =0;
		for(int i: ledger) {
			if(i<0) {
				if( account + i >= -m) {
					account +=i;
				}
			}else {
				account += i;
			}
		}
		
		return account;
	}
}
