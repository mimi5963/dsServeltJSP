package pseudoCote;

import java.util.Arrays;

public class SecondTest {
	public boolean knapsackmod = false;
	public int solution (int tickets, int[][] requests) {
		int soldTickets = 0;
		int resttickects = tickets;		
		//2d array to ArrayList
		
		Arrays.sort(requests, (o1, o2) -> {
			if(o1[0] == o2[0]) {
				return o2[1] - o1[1];
			}
			return o1[0] - o2[0];
			
		} );
		if(knapsackmod) {
			
			
		}
		for( int[] request : requests) {
			
			//System.out.println(""+(i++)+" "+request[0] +" "+ request[1]);
			//그리디로 내려간다
			if(request[1] > resttickects)
				continue;
			soldTickets += request[1];
			resttickects -= request[1];
		}
		return soldTickets;
	}
	
	
	
	public void KnapSackCount() {
		
	}
	
	
	
	
	
	
	
}
