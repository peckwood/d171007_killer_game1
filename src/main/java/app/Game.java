package app;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.function.Predicate;

import org.junit.Test;

import app.role.Player;

public class Game {
	private List<Player> players;
	private int round;
	private String log;
	Scanner input  = new Scanner(System.in);
	
	@Test
	public void runGame(){
		GameSetup setup = new GameSetup();
		setup.setup("10 2 3 2 2");
		System.out.println(setup);
	}
	
	
	private void nightRound(){
		
	}
	
	private Player findPlayerByNumber(int playerNumber){
		Predicate<Player> predicate = player -> player.getNumber() == playerNumber;
		return players.stream()
		.filter(predicate)
		.findFirst()
		.get();
	}
	
	
	
}
