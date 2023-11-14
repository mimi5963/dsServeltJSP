package JavaOmok;

public class Omok {
    public static void main(String[] args) {
        Player user = new Player("사용자", "O");
        Player computer = new Player("컴퓨터", "X");
        computer.isComputer = false;
        Board board = new Board(19);
        play(board, user, computer);
    }
    private static void play(Board board, Player user, Player computer) {
        board.print();
    	System.out.println("자 판깔렸다 가즈아~~~");
        board.ScreenClear();
        boolean isgameover = true;
        int[] input = new int[2];
    	while(isgameover) {
    		//플레이어의 턴
            board.ScreenClear();
            while(true) {
            	try {
                    input = user.Input(board);
                    board.setMapMarker(input[1], input[0], user.stone);
            	}
            	catch (Exception e) {
            		System.out.println("이미 지정된 자리입니다. 다른 곳에 놔주세요");
            		Thread.sleep(1000);
            		continue;
            	}
            	finally {
            		break;
            	}
            }
    		board.print();
    		if(Calcurate(board,user)) {
    			isgameover = true;
    	    	System.out.println("와 축하합니다!");
        		System.out.println(user.name+"님의 승리!");
    			break;
    		}

            board.ScreenClear();
            while(true) {
            	try {
                    input = computer.Input(board);
                    board.setMapMarker(input[1], input[0], computer.stone);
            	}
            	catch (Exception e) {
            		System.out.println("이미 지정된 자리입니다. 다른 곳에 놔주세요");
            		Thread.sleep(1000);
            		continue;
            	}
            	finally {
            		break;
            	}
            }
            board.ScreenClear();
    		board.print();
    		if(Calcurate(board,computer)) {
    			isgameover = true;
    	    	System.out.println("와 축하합니다!");
        		System.out.println(computer.name+"님의 승리!");
    			break;
    		}
    	}
    }
    private static boolean Calcurate(Board board, Player user) {
    	String value =user.stone;
    	for(int i=0; i<board.size; i++) {
    		for(int j = 0; j< board.size; j++) {
    			if(board.map[i][j].equals(value)) {
    				//상
    				
    				int count = 1;
    				for(int k = 1; k <= 5; k++) {
    					if(i - k < 0) {
    						break;
    					}
    					if(!board.map[i-k][j].equals(value)) {
    						break;
    					}
    					else {
    						count++;
    					}
    				}
    				if(count >= 4) {
    					//성공!
    					return true;
    				}
    				
    				//왼쪽
    				count = 1;
    				for(int k = 1; k <= 5; k++) {
    					if(j - k < 0) {
    						break;
    					}
    					if(!board.map[i][j-k].equals(value)) {
    						break;
    					}
    					else {
    						count++;
    					}
    				}
    				if(count > 4) {
    					//성공!
    					return true;
    				}
    				//상좌
    				count = 1;
    				for(int k = 1; k < 5; k++) {
    					if(j - k < 0 || i - k < 0) {
    						break;
    					}
    					if(!board.map[i-k][j-k].equals(value)) {
    						break;
    					}
    					else {
    						count++;
    					}
    				}
    				if(count > 4) {
    					//성공!
    					return true;
    				}
    				//상우
    				count = 1;
    				for(int k = 1; k < 5; k++) {
    					if(j + k > board.size-1 || i - k < 0) {
    						break;
    					}
    					if(!board.map[i-k][j+k].equals(value)) {
    						break;
    					}
    					else {
    						count++;
    					}
    				}
    				if(count > 4) {
    					//성공!
    					return true;
    				}
    				
    			}
    		}
    	}
    	// 우승이면true 아니면 false
    	return false;
    	
    }
    
}