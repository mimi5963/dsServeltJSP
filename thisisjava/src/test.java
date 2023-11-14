
public class test {

	public static void main(String[] args) {
		int num = 40; 
		System.out.println(solution(num));
	}
	
	   public static int solution(int nums) {
	        int answer = 0;

	       for(int i=1; i<=nums; i++) {
	    	   answer++;
	    	   while(answer % 3 == 0 || answer % 10 == 3 ) {
	    		   answer++;
	    	   }
	       }
	        
	        
	        return answer;
	    }
}
