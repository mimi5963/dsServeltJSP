package ch09.sec07.exam01;

public class CarExample {

	public static void main(String[] args) {
		
		  long answer = 0;
	        answer = longToarray(118372);
	        System.out.println(answer);
	}
	 public static long longToarray(long n){
	        //숫자변환
	        int idx =0;
	        long[] array = new long[10];
	        while(n != 0){
	            array[idx++] = n%10;
	            n /=10;
	        }
	        long answer = sortArray(array,idx);
	        return answer;
	    }
	    public static long sortArray(long[] array, int idx){
	        //정렬
	        for(int i=0; i<idx-1;i++){
	            for(int j=0; j<idx-1-i;j++){
	                if(array[j] < array[j+1]){
	                    long temp = array[j];
	                    array[j] = array[j+1];
	                    array[j+1] = temp;
	                }
	            }
	        }
	        //다시 long으로 바꾸기 
	        long result =0;
	        
	        for(int i=0; i<idx;i++){
	            result = result*10+array[i];
	        }
	        return result;
	    }
}
