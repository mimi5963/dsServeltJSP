import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution2 {
	
	public static void main(String[] args) {
		int[][]arr = {{3,1},{2,5},{2,10},{3,8},{1,2}};
		int result =solution(20000,arr);
		System.out.println(result);
	}
	
	
    public static int solution (int tickets, int[][] requests) {
        int soldTickets = 0;

        Arrays.sort(requests,(a,b)->{
            if(a[0]==b[0])
                return b[1]-a[1];
            return a[0] - b[0];
        });

        for(int i=0; i< requests.length;i++){
            if(tickets - requests[i][1] >=0){
                tickets -= requests[i][1];
                soldTickets +=requests[i][1];
            }
        }

        return soldTickets;
    }

//	public static int sol(int tikets, int[][] requests) {
//		int soldTicktes =0;
//		//sortRequests(requests); //정렬
//		//System.out.println(Arrays.deepToString(requests));
//		//티켓을 한정판매 //구매자 회원등급 티켓 구매수량
//		
//		for(int i=1; i<=10;i++) {
//			List<Integer> list = new ArrayList<>();
//			for(int j=0; j<requests.length;j++) {
//				if(requests[j][0] == i) {
//					list.add(requests[j][1]);
//				}
//			}
//			Collections.sort(list,(a,b) -> {
//				return b-a;
//			});
//			for(int a : list) {
//				if(tikets - a >=0) {
//					tikets -=a;
//					soldTicktes +=a;
//				}
//			}
//			if(tikets == 0) break;
//		}
//		
//		//1 회원등급이 높은 사람에게 먼저 판매
//		//2 회원등급이 같은 사람에게 더 많은 티켓 신청자 먼저판매
//		//3 남은 티켓수보다 더 많은 티켓 구매요청은 거절 판매된 총 티켓수 리턴
//		//치켓 수는 1~100000, requests의 각 행에는 티켓 구마자 회원등급, 구매 티켓수 
//		
//		//막해보자 일단 등급별로 나누어야해 
//		
////		for(int i = 0; i<requests.length;i++) {
////			if(tikets - requests[i][1] >=0) {
////				tikets -= requests[i][1];
////				soldTicktes += requests[i][1];
////			}
////		}
//	
//		
//		
//		
//		return soldTicktes;
//	}
//	private static void sortRequests(int[][] requests) {
//			
//		for(int i=0; i<requests.length-1;i++) {
//			for(int j=0; j<requests.length-1-i;j++) {
//				if(requests[j][0] >requests[j+1][0]){
//					int[] temp = requests[j];
//					requests[j] = requests[j+1];
//					requests[j+1] = temp;
//				}else if(requests[j][0] == requests[j+1][0]) {
//					if(requests[j][1] < requests[j+1][1]) {
//						int[] temp = requests[j];
//						requests[j] = requests[j+1];
//						requests[j+1] = temp;
//					}
//				}
//				
//				}
//			}
//		
//		
//		}
//	
//		
//	private static void mergeSort(int[] arr, int left,int right) {
//		int mid;
//		if(left < right) {
//			mid = (left+right) /2;
//			mergeSort(arr,left,mid);
//			mergeSort(arr,mid+1,right);
//			mergesum(arr,mid,left,right);
//		}
//	}
//	private static void mergesum(int[] arr, int mid, int left, int right) {
//		int startLeft = left;
//		int startRight = mid+1;
//		int idx = left;
//		int[] newArr = new int[right+1];
//		
//		while(startLeft<=mid && startRight <= right) {
//			if(arr[startLeft] < arr[startRight]) {
//				newArr[idx] = arr[startRight++];
//			}else {
//				newArr[idx] = arr[startLeft++];
//			}
//			idx++;
//		}
//		if(startLeft > mid) {
//			for(int i = startRight; i<= right; i++) {
//				newArr[idx++] = arr[i];
//			}
//			
//			}else {
//				for(int j=startLeft;j<=mid;j++) {
//				newArr[idx++] = arr[j];
//				}
//		}
//		
//		for(int i = left;i<=right;i++) {
//			arr[i] = newArr[i];
//		}
//		
//	}
}
