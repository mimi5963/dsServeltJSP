package pseudoCote;

import java.util.ArrayList;
import java.util.Arrays;

public class FourthTest {
	public int[] solution(int n, int[] amounts) {
		ArrayList<Integer> answer = new ArrayList<Integer>();
		
		ArrayList<Part> parts = new ArrayList<Part>();
		
		int i = 0;
		for(int amount : amounts) {
			parts.add(new Part(i++,amount));
		}
		
		for(i =0; i<n; i++) {
			parts.sort((o1, o2) ->{
				return o1.index - o2.index;} );
			parts.sort((o1, o2) ->{
				return o2.money - o1.money;} );
			//System.out.println(""+i+"번 째 경매입니다. 시작합니다.");
			if(parts.get(0).money == parts.get(1).money) {
				int paymoney = parts.get(0).money;
				parts.get(0).money -= paymoney;
				//System.out.println(parts.get(0).index+"번 참가자가 "+paymoney+"원씩이나 주고 이걸 샀습니다.");
				answer.add(paymoney);
				
				continue;
			}
			//자본금 안같은 케이스
			//무조건 0번맨이 1번 금액+10000 주고 삼
			int paymoney = parts.get(1).money + 10000;
			parts.get(0).money -= paymoney;
			//System.out.println(parts.get(0).index+"번 참가자가 "+paymoney+"원씩이나 주고 이걸 샀습니다.");
			answer.add(paymoney);
			continue;
		}
		
		
		
		return answer.stream().mapToInt(j->j).toArray();
	}
}
class Part{
	int index;
	int money;
	Part(int ind, int mon){this.index = ind;this.money = mon;}
}