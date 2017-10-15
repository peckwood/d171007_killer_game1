package app.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import app.Game;
import app.GameSetup;
import app.aspect.Balance;
import app.role.Guardian;
import app.role.GuardianImpl;
import app.role.Killer;
import app.role.KillerImpl;
import app.role.Player;
import app.role.PlayerImpl;
import app.role.Role;
import app.team.EvilTeam;
import app.team.GoodTeam;

@Configuration
@ComponentScan("main.app")
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
	
	@Bean("guardian")
	public Player guaridan(){
		return new GuardianImpl();
	}
	
	@Bean("killer")
	public Player killer(){
		return new KillerImpl();
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
			Player killer, Player guardian){//, Seer seer, Witch witch, Civilian civilian
		Random random = new Random();
		List<Player> players = new ArrayList<>();
		
		for(int i=0;i<setup.getTotalCount();i++){
			int currentPlayerNumber = i+1;;
			System.out.println("setup " +setup);
			System.out.println("setup.getAllRoleList()" +setup.getAllRoleList());
			System.out.println();
			System.out.println();
			int currentRoleIndex= random.nextInt(setup.getAllRoleList().size());
			switch(setup.getAllRoleList().get(currentRoleIndex)){
			case KILLER:
				//Player killer = Player.createPlayer(Role.KILLER, currentPlayerNumber, evilTeam);
				killer.setNumber(currentPlayerNumber);
				killer.setTeam(evilTeam);
				players.add(killer);
				//players.add(player(Role.KILLER, currentPlayerNumber, evilTeam));
				break;
			case GUARDIAN:
				//Player guardian = Player.createPlayer(Role.GUARDIAN, currentPlayerNumber, goodTeam);
				guardian.setNumber(currentPlayerNumber);
				guardian.setTeam(goodTeam);
				players.add(guardian);
				//players.add(player(Role.GUARDIAN, currentPlayerNumber, goodTeam));
				break;
/*			case SEER:
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
				break;*/
			default:
				break;
			}
			setup.getAllRoleList().remove(currentRoleIndex);
		}
		System.out.println(players);
		return players;
	}
	
	@Bean
	public Game game(List<Player> players){
		Game game = new Game();
		game.setPlayers(players);
		return game;
	}

	
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
