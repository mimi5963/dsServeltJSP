package thisisjava;

import java.util.HashMap;
import java.util.Map;

public class Ex039 {

	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();
		map.put("blue", 96);
		map.put("hong", 86);
		map.put("white", 92);
		
		String name =null;
		int maxScore = Integer.MIN_VALUE;
		int totalScore =0;
		int num =0;
		for(String s : map.keySet()) {
			int va = map.get(s);
			if(maxScore < va) {
				name =s;
				maxScore = va;
			}
			totalScore += va;
			num++;
		}
		System.out.println("최고점수 : " + maxScore +"이름 : "+name);
		System.out.println("총 점수 : "+totalScore +" 평균 : "+ (totalScore/num));

		
	
	}
	
	
}
