package app;

import static org.hamcrest.CoreMatchers.instanceOf;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.function.Predicate;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.role.NightOwl;
import app.role.Player;
import app.role.PlayerImpl;
@Component
public class Game {
	
	@Autowired
	private List<Player> players;
	private int round = 1;
	private String gameLog = "";
	Scanner input  = new Scanner(System.in);
	private final Logger JUDGE_LOOGER = LoggerFactory.getLogger("Judge Says");
	private final Logger GAME_ANNOUNCER = LoggerFactory.getLogger("Game Announcer");
	
	public void checkGameStatus(){
		System.out.println("checking game status");
		
		//goNightRound();
	}
	
	@Test
	public void runGame(){
		GameSetup setup = new GameSetup();
		setup.setup();
		System.out.println(setup);
/*		while(true){
			nightRound();
		}*/
	}
	
	private void goNightRound(){
		GAME_ANNOUNCER.info("天黑请闭眼");
		Predicate<Player> playerIsAvlive = player -> player.getStatus()!=Status.DEAD;
		Predicate<Player> playerIsNightOwl = player -> player instanceof NightOwl;
		players.stream()
		.filter(playerIsAvlive)
		.filter(playerIsNightOwl)
		.forEach(player -> ((NightOwl)player).doNightAction());
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
