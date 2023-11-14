package game;

import java.util.Random;

public class GameMain {

	public static void main(String[] args) {
		Player p1 = new Player("player 1", 2,100);
		Player p2 = new Player("player 2", 2,100);
		
		Character wa1 = new IceWarrier(new FireWarrier(new Warrier("워리어",100,10)));
		System.out.println(wa1.getDemage());
		Player[] players = {p1,p2};
		Random rand = new Random();
		while(allPlayersAlive(players)) {
			int attack = rand.nextInt(2);
			int attacked = rand.nextInt(2);
			players[attack].attack(players[attacked]);
		}

	}
	public static boolean allPlayersAlive(Player[] players) {
		for(int i = 0 ; i<players.length;i++ ) {
			if(players[i].isalive() == false) {
				return false;
			}
		}
			
		return true;
	}
}
