package ch12.sec08;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DataTimeOperationExample {

	public static void main(String[] args) {
		
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy.mm.dd a HH:mm:ss");
		
		System.out.println("현시간 "+now.format(dtf));
		
		LocalDateTime result1 = now.plusYears(1);
		System.out.println("1년 후 "+result1.format(dtf));
		
		LocalDateTime result2 = now.minusMonths(2);
		System.out.println("2달전"+result2.format(dtf));
		
		LocalDateTime result3 = now.plusDays(7);
		System.out.println("일주일 뒤"+result3.format(dtf));
	}

}
