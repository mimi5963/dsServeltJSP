package pseudoCote;

import java.util.Arrays;
import java.util.Comparator;

public class Soluter {

	public static void main(String[] args) {
		FirstTest first = new FirstTest();
		int[] ledger1 = {10000, -13000, -4000, -2000, 6500, -20000};
		int[] ledger2 = {-34152, -40000, -50000};
		System.out.println("First Example");
		System.out.println("==========================================");
		System.out.println(""+first.solution(5000,ledger1));
		System.out.println("==========================================");
		System.out.println(""+first.solution(34151,ledger2));
		System.out.println("==========================================");
		
		SecondTest second = new SecondTest();
		int[][] requests1 = {{2,3}, {1,7}, {2,4}, {3,5}};
		int[][] requests2 = {{1,9}, {3,6}, {2,5}};
		int[][] requests3 = {{3,1}, {2,5}, {2,10}, {3,8}, {1,2}};
		System.out.println("Second Example");
		System.out.println("==========================================");
		System.out.println(""+second.solution(10,requests1));
		System.out.println("==========================================");
		System.out.println(""+second.solution(8,requests2));
		System.out.println("==========================================");
		System.out.println(""+second.solution(20000,requests3));
		System.out.println("==========================================");
		
		
		
		
		ThirdTest third = new ThirdTest();
		
		
		int[] per1 = {8,23,24};
		int[][] pay1 = {{100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000},
						{100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000},
						{350000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000}};
		int[] est1 = {100000, 100000, 100000};
		

		int[] per2 = {24, 59, 59, 60};
		int[][] pay2 = {{50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000},
				{50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000},
				{350000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000},
				{50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000}};
		int[] est2 = {350000, 50000, 40000, 50000};
		
		int[] res1 = third.solution(per1,pay1,est1);
		int[] res2 = third.solution(per2,pay2,est2);
		
		
		System.out.println("Third Example");
		System.out.println("==========================================");
		System.out.println(""+res1[0] + "," +res1[1]);
		System.out.println("==========================================");
		System.out.println(""+res2[0]+","+res2[1]);
		System.out.println("==========================================");
		

		System.out.println("Fourth Example");
		FourthTest fourth = new FourthTest();
		
		int[] amnt1 = {1000000, 490000, 700000, 290000};
		int[] amnt2 = {30000, 70000, 10000};
		
				
		res1 = fourth.solution(4, amnt1);
		System.out.println("==========================================");
		res2 = fourth.solution(6, amnt2);
		StringBuilder strbulder = new StringBuilder();
		strbulder.append("{");
		for(int res : res1 ) {
			strbulder.append(res+",");
		}
		strbulder.append("}\n");
		strbulder.append("==========================================\n");
		strbulder.append("{");
		for(int res : res2 ) {
			strbulder.append(res+",");
		}
		strbulder.append("}");
		
		System.out.println(strbulder.toString());


	}

}
