import java.util.Arrays;

public class Solution3 {

	public static void main(String[] args) {
		int[] periods = {24, 59, 59, 60};
		int[][] payments = {{50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000},
		                    {50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000},
		                    {350000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000},
		                    {50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000}};
		int[] estimate = {350000, 50000, 40000, 50000};
		int[] result = solution(periods,payments,estimate);
		System.out.println(Arrays.toString(result));
	}
    public static int[] solution(int[] periods, int[][] payments, int[] estimates) {
        int[] answer = { 0, 0 };
        int VIP24 = 900000;
        int VIP60 = 600000;
        for(int i=0; i<periods.length;i++){
            int dur = periods[i];
            int payments11 = sum11(payments[i]);
            int payments12 = (payments11-payments[i][0])+estimates[i];

            if(dur>=23 && dur < 59){
                if(payments12 >= VIP24){
                    if(dur == 23 || payments11 < VIP24)
                        answer[0]++;
                }else {
                    if(payments11 >= VIP24)
                        answer[1]++;
                }
            } else if (dur >=59) {
                if(payments12 >= VIP60){
                    if(dur == 59 || payments11 < VIP60)
                        answer[0]++;
                }else{
                    if(payments11 >= VIP60)
                        answer[1]++;
                }

            }
        }
        return answer;
    }

    private static int sum11(int[] payment) {
        return Arrays.stream(payment).sum();
    }

//
//    public static int solution (int tickets, int[][] requests) {
//        int soldTickets = 0;
//
//        Arrays.sort(requests,(a,b)->{
//            if(a[0]==b[0])
//                return b[1]-a[1];
//            return a[0] - b[0];
//        });
//
//        for(int i=0; i< requests.length;i++){
//            if(tickets - requests[i][1] >=0){
//                tickets -= requests[i][1];
//                soldTickets +=requests[i][1];
//            }
//        }
//
//        return soldTickets;
//    }
//
//	public static int[] solution(int[] periods, int[][] payments, int[] estimates) {
//		int[] answer = { 0, 0 };
//		
//		//연간 납부금액은 12개월간 납부금액 총합
//		//이번달에는 VIPx지만 다음달 VIP 혹은 이번달 VIP지만 다음달 아님
//		//알림을 보낼 것 
//		//고객들의 가입기간은 1차원 정수 배열 periods, 
//		//납부 내엽은 2차원 배열
//		// 고객 납부 예정금액은 다시 estimates로 주어짐 
//		
//		//다음날에 VIP 
//		
//		//이번달 VIP지만 다음달 VIP아님과
//		//이번달은 VIP가 아니지만, 다음달은 VIP인 고객 
//		
//		//가입기간 2년이상~5년미만 90이상
//		//가입기간 5년이상 60~90
//	
//		for(int i=0; i<periods.length;i++) {
//			int payments11 = sumAll(payments[i]);
//			int payments12 = (payments11-payments[i][0])+estimates[i];
//			
//			
//			
//			//기간 vip
//			if(periods[i] == 23 && payments12 >=900000) {
//				answer[0]++;
//			}else if(periods[i] == 59 && payments12 >=600000) {
//				answer[0]++;
//			}
//			
//			//돈vip
//			else if(periods[i] >=24 && periods[i]<60 ){	
//				if(payments11<900000 &&payments12>=900000) {
//					answer[0]++;
//				}else answer[1]++;
//			
//			}else if(periods[i] >59 && payments11<600000&&payments12 >=600000) {
//				if(payments11<600000&&payments12 >=600000)
//				answer[0]++;
//				else  answer[1]++;
//			}
//			
//			//vip탈퇴
//			
//			
//			
//		}
//		return answer;
//	}
//
//
//	private static int sumAll(int[] is) {
//		int result =Arrays.stream(is).sum();
//		return result;
//	}
	
	
}
