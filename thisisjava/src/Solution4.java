import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class Solution4 {

	public static void main(String[] args) {
		
		int[] amounts = {30000, 70000, 10000};
		int[] result = solution(6,amounts);
		System.out.println(Arrays.toString(result));

	}
    public static int[] solution(int n, int[] amounts) {
        int[] answer = new int[n];


        // 1~n까지 서로 다른 번호를 가진 경매 물품 n개아와
        // 1~m까지 서로 다른 번호를 가진 참가자 m명있다.
        //m명은 각자 자신의 자본을 가지고 경매에 참가합니다.


        //경매는 1~n번 품목 (물품번호 낮은 순으로 진행)
        // 입찰 단위는 만원, (참자가들은 모든 자본 투자해서 낙찰받으려함)
        // 자본이 가장 많이 남은 참가자가 여러명 if 번호 가장 낮은 참가자가 낙찰됨

        //case1 자본이 가장 많은 1번 참가자가 두번째로 많은 참가자보다 만원 더줌
        //case2 자본이 가장 많이 남은 참가자중 번호가 낮은 사람
        //참가자 자본이 모두 0원일 때 경매 낙찰금액은 0원이다.**

        //경매별로 일단 돈 가장 많이 남은 참가자 찾기 (번호순)
        // 1명 이상일 경우 번호순 , 1명이면 2번째 낙찰금액에 +1만원
        // 경매는 계속 진행되고, 모두 0원이면 낙찰 금액은 0원

        //낙찰 금액을 돌려주면됨

        int[] index = new int[amounts.length];
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<n;i++) {

            int maxValue = Integer.MIN_VALUE;

            //최대값 찾기
            for(int j=0; j<amounts.length;j++) {
                if(maxValue < amounts[j])
                    maxValue = amounts[j];
            }
            //맥스값이 0이면 컨티뉴 > 다들 0원
            if(maxValue == 0) {
                answer[i]=0;
                continue;
            }
            //최대값 가진 list 담기
            for(int k=0; k<amounts.length;k++) {
                if(maxValue == amounts[k]) {
                    list.add(k);
                }
            }
            //max가 1개라면,
            if(list.size() == 1) {
                int sMv=Integer.MIN_VALUE; //2번쨰로 큰 값 찾아야함
                for(int h=0; h<amounts.length;h++) {
                    if(h!=list.get(0)&&amounts[h]>sMv) {
                        sMv = amounts[h];
                    }
                }
                answer[i] = sMv+10000;
                amounts[list.get(0)] -=sMv+10000;

            }else {
                answer[i] = amounts[list.get(0)];
                amounts[list.get(0)] =0;
            }

            list.clear();
        }


        return answer;
    }

//	public static int[] solution(int n, int[] amounts) {
//		int[] answer = new int[n];
//		
//		
//		// 1~n까지 서로 다른 번호를 가진 경매 물품 n개아와
//		// 1~m까지 서로 다른 번호를 가진 참가자 m명있다.
//		//m명은 각자 자신의 자본을 가지고 경매에 참가합니다.
//		
//		
//		//경매는 1~n번 품목 (물품번호 낮은 순으로 진행) 
//		// 입찰 단위는 만원, (참자가들은 모든 자본 투자해서 낙찰받으려함)
//		// 자본이 가장 많이 남은 참가자가 여러명 if 번호 가장 낮은 참가자가 낙찰됨
//		
//		//case1 자본이 가장 많은 1번 참가자가 두번째로 많은 참가자보다 만원 더줌
//		//case2 자본이 가장 많이 남은 참가자중 번호가 낮은 사람 
//		//참가자 자본이 모두 0원일 때 경매 낙찰금액은 0원이다.**
//		
//		//경매별로 일단 돈 가장 많이 남은 참가자 찾기 (번호순)
//        // 1명 이상일 경우 번호순 , 1명이면 2번째 낙찰금액에 +1만원 
//		// 경매는 계속 진행되고, 모두 0원이면 낙찰 금액은 0원
//		
//		//낙찰 금액을 돌려주면됨
//		
//		int[] index = new int[amounts.length];
//		List<Integer> list = new ArrayList<>();
//		for(int i=0; i<n;i++) {
//			
//			int maxValue = Integer.MIN_VALUE;
//			
//			//최대값 찾기
//			for(int j=0; j<amounts.length;j++) {
//				if(maxValue < amounts[j])
//					maxValue = amounts[j];
//			}
//			//맥스값이 0이면 컨티뉴 > 다들 0원
//			if(maxValue == 0) {
//				answer[i]=0;
//				continue;
//			}
//			//최대값 가진 list 담기
//			for(int k=0; k<amounts.length;k++) {
//				if(maxValue == amounts[k]) {
//					list.add(k);
//				}
//			}
//			
//			if(list.size() == 1) {
//				int sMv=Integer.MIN_VALUE;
//				for(int h=0; h<amounts.length;h++) {
//					if(h!=list.get(0)&&amounts[h]>sMv) {
//						sMv = amounts[h];
//					}
//				}
//				answer[i] = sMv+10000;
//				amounts[list.get(0)] = amounts[list.get(0)]-sMv+10000>=0 ?amounts[list.get(0)]-sMv+10000:0 ;
//				
//				
//			}else {
//				answer[i] = amounts[list.get(0)];
//				amounts[list.get(0)] =0;
//				
//			}
//			
//			list.remove(0);
//		}
//		
//		
//		return answer;
//	}
}	
