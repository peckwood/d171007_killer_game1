package app.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import app.GameSetup;
import app.aspect.Balance;
import app.role.Player;
import app.team.EvilTeam;
import app.team.GoodTeam;

@Configuration
@ComponentScan("app")
@EnableAspectJAutoProxy
public class SpringConfiguration {
	
	@Bean
	public Balance balance(){
		return new Balance();
	}
	
/*	@Bean
	public Player player(Role playerRole, int playernumber, Team team){
		return Player.createPlayer(playerRole, playernumber, team);
	}*/
	
	@Bean
	public GoodTeam goodTeam(GameSetup gameSetup){
		return gameSetup.getGoodTeam();
	}
	@Bean
	public EvilTeam evilTeam(GameSetup gameSetup){
		return gameSetup.getEvilTeam();
	}
	
	@Bean
	public GameSetup gameSetup(Scanner scanner){
		GameSetup setup = new GameSetup();
/*		System.out.println("input the setup");
		setup.setSetupText(scanner.nextLine());
		System.out.println(setup.getSetupText());*/
		setup.setAllRolesList();
		setup.setupTeams();
		return setup;
	}
	
	
	@Bean
	public List<Player> players(GameSetup setup, GoodTeam goodTeam, EvilTeam evilTeam, 
			Player killer, Player guardian, Player seer, Player witch, Player civilian){//, Seer seer, Witch witch, Civilian civilian
		Random random = new Random();
		List<Player> players = new ArrayList<>();
		
		for(int i=0;i<setup.getTotalCount();i++){
			int currentPlayerNumber = i+1;;
			System.out.println("setup " +setup);
			System.out.println();
			int currentRoleIndex= random.nextInt(setup.getAllRoleList().size());
			switch(setup.getAllRoleList().get(currentRoleIndex)){
			case KILLER:
				killer.setNumber(currentPlayerNumber);
				killer.setTeam(evilTeam);
				players.add(killer);
				break;
			case GUARDIAN:
				guardian.setNumber(currentPlayerNumber);
				guardian.setTeam(goodTeam);
				players.add(guardian);
				break;
			case SEER:
				seer.setNumber(currentPlayerNumber);
				seer.setTeam(goodTeam);
				players.add(seer);
				//players.add(player(Role.SEER, currentPlayerNumber, goodTeam));
				break;
			case WITCH:
				witch.setNumber(currentPlayerNumber);
				witch.setTeam(goodTeam);
				players.add(witch);
				//players.add(player(Role.WITCH, currentPlayerNumber, goodTeam));
				break;

			case CIVILIAN:
				civilian.setNumber(currentPlayerNumber);
				civilian.setTeam(goodTeam);
				players.add(civilian);
				//players.add(player(Role.CIVILIAN, currentPlayerNumber, goodTeam));
				break;
			default:
				break;
			}
			setup.getAllRoleList().remove(currentRoleIndex);
		}
		System.out.println("playersList :" + players);
		System.out.println();
		return players;
	}
	
/*	@Bean
	public Game game(List<Player> players){
		Game game = new Game();
		game.setPlayers(players);
		return game;
	}*/

	
	@Bean
	public Scanner scanner(){
		Scanner input = new Scanner(System.in);
		return input;
	}
	
/*    @Bean(name = "tool")
    public ToolFactory toolFactory() {
        ToolFactory factory = new ToolFactory();
        factory.setFactoryId(7070);
        factory.setToolId(2);
        return factory;
    }
 
    @Bean
    public Tool tool() throws Exception {
        return toolFactory().getObject();
    }*/
}
