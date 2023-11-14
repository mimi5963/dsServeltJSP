import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ssssss {

	public static void main(String[] args) {
	
		System.out.println(solution("\"3people unFollowed me\""));
		int a =2;
		Integer.toBinaryString(a >> 1);
		

	}
	  public static String solution(String s) {
	        String answer = "";
	        String[] splitWord = s.split("\\s+");
	        
	        if(splitWord[0].equals("")) {
	        	String[] temp = new String[splitWord.length-1];
	        	System.arraycopy(splitWord, 1, temp, 0, splitWord.length-1);
	        	splitWord = temp;
	        }
	        //변환된 단어를 담을 그릇
	        StringBuilder sb =new StringBuilder();
	        //공백을 포함한 결과 단어를 담을 그릇 
	        StringBuilder result = new StringBuilder();
	        
	        
	        for(String val : splitWord){
	        	
	            //단어소문자화
	            for(int i=1; i<val.length(); i++){
	                char ch = val.charAt(i);
	                
	                if(ch >='A' && ch <='Z'){
	                    val = val.replace(ch,(char)(ch-'A'+'a'));
	                }
	            }
	            //첫단어 대문자 
	            char firstCh = val.charAt(0);
	            if(firstCh >='a' && firstCh <='z')
	                val = val.replaceFirst(firstCh+"",(char)(firstCh-'a'+'A')+"");
	            
	            sb.append(val);
	        }
	        int idx=0;
	        for(int i=0; i<s.length(); i++){
	            char ch = s.charAt(i);
	            if(ch == ' '){
	                result.append(ch+"");
	            }else{
	                result.append(sb.charAt(idx++)+"");
	            }
	        }
	        
	        answer = result.toString();
	        
	        return answer;
	    }

}

class ex<T>{
	
	T ss;
	
	public <R> R mt1 (T val1, R val2) {
		return val2;
	}
	public static <R> R mt2(R val2){
		return val2;
	}
}
