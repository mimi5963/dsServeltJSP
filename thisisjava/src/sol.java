import java.util.Arrays;

public class sol {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] park ={"SOO","OOO","OOO"};
		String[] rou = {"E 2","S 2","W 1"};
		int[] result =solution(park,rou);
		System.out.println(Arrays.toString(result));
	}
	public static int[] solution(String[] park, String[] routes) {
        int[] answer;
        int[][] arr = new int[park.length][park[0].length()];
        
        //직사각형 바운더리 
        final int boundaryN = 0;
        final int boundaryW = 0;
        final int boundaryS = park.length-1;
        final int boundaryE = park[0].length()-1;
        
        int starty = 0;
        int startx = 0;
        //이동 arr 초기화
        for(int i=0; i<park.length;i++){
            for(int j=0; j<park[i].length();j++){
                if(park[i].charAt(j) == 'S'){
                    starty = i;
                    startx = j;
                }else if(park[i].charAt(j) == 'X'){
                    arr[i][j] = -1;
                }
            }
        }
        //이동시키기 
        for(String s: routes){
            String[] roots = s.split(" ");
            String direction = roots[0];
            int num = Integer.parseInt(roots[1]);
            int result = 0;
            if(direction.equals("W")){
                result = startx-num;
                if(result >= boundaryW && !isHorizenX(arr,starty,startx,result)){
                    startx = result;
                }
            }else if(direction.equals("E")){
                result = startx+num;
                if(result <= boundaryE && !isHorizenX(arr,starty,startx,result)){
                    startx = result;
                }
            }else if(direction.equals("N")){
                result = starty - num;
                if(result >= boundaryN && !isVerticalX(arr,starty,startx,result)){
                    starty = result;
                }
            }else{
                result = starty + num;
                if(result <= boundaryS && !isVerticalX(arr,starty,startx,result)){
                    starty = result;
                }
            }
        }
        
       
        answer = new int[]{starty,startx};
        return answer;
    }
    public static boolean isVerticalX(int[][]arr,int y,int x,int move){
        int maxY = y>move? y:move;
        int minY = y<move? y:move;
    	for(int i = minY; i<=maxY;i++){
            if(arr[i][x] == -1){
                return true;
            }
        }
        return false;
    }
    public static boolean isHorizenX(int[][] arr,int y, int x,int move){
    	int maxX = x > move? x:move;
    	int minX = x < move? x:move;
        for(int i = minX; i<=maxX;i++){
            if(arr[y][i] == -1){
                return true;
            }
        }
        return false;
    }
}
