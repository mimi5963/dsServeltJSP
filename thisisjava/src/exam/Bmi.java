package exam;

public class Bmi {

	public static void main(String[] args) {
		double height = 180;
		double weight = 80;
		
		//메서드 호출 및 출력
		System.out.println(bmi(height,weight));
	}
	public static String bmi(double height, double weight) {
		
		double bim = (int)(weight/Math.pow((height/100),2)*10)/10.0;
		String result ="";
		if(bim >25) {
			result ="비만";
		}else if(bim>18.5) {
			result ="표준";
		}else
			result ="저체중";
		return result;
	}
}
