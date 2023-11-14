package pseudoCote;

public class FirstTest {
	public int solution (int m, int[] ledger) {
		int account = 0;
		
		
		for(int request : ledger) {
			if(account + request < -1 * m) {
				//System.out.println("요청 거절: "+request+"원 처리 현재 잔고: "+account);
				continue;
			}
			//System.out.println("요청 "+request+"원. 현재 잔고: "+(account+request)+"원");
			account += request;
		}
		
		
		return account;
	}
}
