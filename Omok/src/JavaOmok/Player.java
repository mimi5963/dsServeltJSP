package JavaOmok;

import java.util.Scanner;

public class Player {
    String name;
    String stone;
    boolean isComputer = false;
    Scanner scanner = new Scanner(System.in);
    Player(String name, String stone) {
        this.name = name;
        this.stone = stone;
    }
    int[] Compute(Board board) {
    	
    	
    	
    	
    	
    	
		return null;
    	
    }
    int[] Input(Board board) {
    	if(isComputer) {
    		return Compute(board);
    	}
    	while(true) {
    		System.out.printf("어디에 둘까> ");
            String input = scanner.nextLine();
            String[] temp = new String[2];
            int garo=0; char sero=0;
            temp = input.split(" ");
            try {
            	garo = Integer.parseInt(temp[1]);
            	
            	
            	sero = temp[0].charAt(0);
            	if((int) sero < 65 ||(int) sero >90)
            		throw new Exception();
            	
            	
            	
            }
            catch(Exception e) {
            	System.out.println("제대로 된 위치를 입력해주십시오");
            	continue;
            }
            int[] value = {garo,sero-65};
            return value;
            
    	}
        
    }
}