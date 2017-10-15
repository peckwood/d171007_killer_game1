package app;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.function.Predicate;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.role.Player;
import app.role.PlayerImpl;

public class Game {
	
	@Autowired
	private List<Player> players;
	private int round = 1;
	private String gameLog = "";
	Scanner input  = new Scanner(System.in);
	
	@Test
	public void runGame(){
		GameSetup setup = new GameSetup();
		setup.setup();
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


	public void setPlayers(List<Player> players) {
		this.players = players;
	}


	public List<Player> getPlayers() {
		return players;
	}
	
	
	
}
