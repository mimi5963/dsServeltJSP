package ch05.sec07;

public class MultidimensionalArrayByValueListExample {

	public static void main(String[] args) {
		int[][] scores={
			{80,90,96},
			{76,88}
		};
		
		System.out.println("1차원 배열의 길이 (반의수)"+scores.length);
		System.out.println("2차원 배열의 길이 (학생수)"+scores[0].length);
		System.out.println("2차원 배열의 길이 (학생수)"+scores[1].length);
		
		System.out.println(scores[0][1]);
		System.out.println(scores[0][2]);
		
		int sum1=0;
		for(int i=0;i<scores[1].length;i++) {
			sum1 += scores[1][i];
		}
		int sum2=0;
		for(int i=0;i<scores[0].length;i++) {
			sum2 += scores[0][i];
		}
		
		System.out.println("total = "+(sum1+sum2));
		System.out.println("total avg = "+(double)(sum1+sum2)/(scores[0].length+scores[1].length));
		
		int totalStudent=0;
		
	}

}
