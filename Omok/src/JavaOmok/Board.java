package JavaOmok;

public class Board {
    int size;
    String[][] map;
    Board(int size) {
        this.size = size;
        map = new String[size][size];
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                map[row][col] = ".";
            }
        }
    }
    
    public void setMapMarker(int garo, int sero, String playerMarker) throws Exception {
    	if(map[garo][sero].equals("."))
    		map[garo][sero] = playerMarker;
    	else
    		throw new Exception();
    }
    
    public void print() {
    	
        for (int row = 0; row < size; row++) {
        	System.out.print(""+(char)(row +65));
            for (int col = 0; col < size; col++) {
                System.out.print(" " + map[row][col]);
            }
            System.out.println();
        }
        System.out.println("  0 1 2 3 4 5 6 7 8 9101112131415161718");
    }
    public void ScreenClear() {
    	try {
        	Process p =Runtime.getRuntime().exec("C:\\WINDOWS\\system32\\cmd.exe /c cls");
        	p.waitFor();
    	} 
    	catch(Exception e) {
    		for(int i =0; i<21;i++) {
        		System.out.println("\n");
    		}
    	}
    }
}