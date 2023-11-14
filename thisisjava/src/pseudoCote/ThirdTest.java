package pseudoCote;

import java.util.Arrays;

public class ThirdTest {
	public int[] solution(int[] periods, int[][] payments, int[] estimates) {
		int postVIP = 0;
		int preVIP = 0;
		
		int index = 0;
		
		for(index =0; index<periods.length; index++) {
			int period = periods[index];
			//System.out.println(""+(index+1)+"손님은 "+period+"기간동안 구독했네요");
			if(period < 23) {
				//System.out.println("죄송하지만 고객님은 아직 young 합니다");
				continue;
			}
			//이전12개월
			int last12monthpay = Arrays.stream(payments[index]).sum();
			int present12monthpay = last12monthpay - payments[index][0] + estimates[index];
			//System.out.println("고객님은 이전달까지 "+last12monthpay+"원을 지불하셨습니다.");
			//연간 90만원 이상 고객?
			boolean isPreVIP = false;
			
			
			if(last12monthpay >= 900000 && (period > 23)) {
				isPreVIP = true;
			}
			else if( (last12monthpay >= 600000) &&(period > 59)) {
				isPreVIP = true;
			}
			
			
			boolean isPostVIP = false;
			

			if(present12monthpay >= 900000 && (period+1 > 23)) {
				isPostVIP = true;
			}
			else if( (present12monthpay >= 600000) &&(period+1 > 59)) {
				isPostVIP = true;
			}
			
			if((!isPreVIP) && (isPostVIP))
				postVIP ++;
			if(isPreVIP && (!isPostVIP))
				preVIP ++;
			
		}
		int[] answer = { postVIP, preVIP };
		
		
		
		
		
		
		return answer;
	}
}
